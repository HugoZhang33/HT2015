package edu.pitt.is.UMAP2015;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import data.Conference;
import data.DBAdapter;
import data.Paper;
import data.UserScheduledToServer;

public class PosterDetail extends Activity implements Runnable, OnClickListener {
    private String wtitle, wid, content, date, btime, etime, room, authors, presentationID, contentLink;
    private TextView t1, t2, t3, t4, bv;
    private WebView wv;
    private ImageButton b1, b2, b, b3;
    private DBAdapter db;
    private UserScheduledToServer us2s;
    private String paperStatus;
    private ProgressDialog pd;
    private String paperID;

    private ArrayList<Paper> pList = new ArrayList<Paper>();

    private final int MENU_HOME = Menu.FIRST;
    private final int MENU_TRACK = Menu.FIRST + 1;
    private final int MENU_SESSION = Menu.FIRST + 2;
    private final int MENU_STAR = Menu.FIRST + 3;
    private final int MENU_SCHEDULE = Menu.FIRST + 4;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.paperdetail);

        Bundle b = getIntent().getExtras();
        if (b != null) {
            wtitle = b.getString("title");
            wid = b.getString("id");
            date = b.getString("date");
            btime = b.getString("bTime");
            etime = b.getString("eTime");
            room = b.getString("room");

        }

        db = new DBAdapter(this);
        Paper poster = db.open().getPaperByID(wid);
        authors = poster.authors;
        content = poster.paperAbstract;
        presentationID = poster.presentationID;
        contentLink = poster.contentlink;
        pList.add(poster);
        db.close();



        us2s = new UserScheduledToServer();
        t1 = (TextView) findViewById(edu.pitt.is.UMAP2015.R.id.TextView01);
        t1.setText(wtitle);


        b1 = (ImageButton) findViewById(edu.pitt.is.UMAP2015.R.id.ImageButton01);
        if (getPaperScheduled(wid).compareTo("yes") == 0)
            b1.setImageResource(edu.pitt.is.UMAP2015.R.drawable.yes_schedule);
        else
            b1.setImageResource(edu.pitt.is.UMAP2015.R.drawable.no_schedule);
        b1.setTag(wid);
        b1.setOnClickListener(this);

        b2 = (ImageButton) findViewById(edu.pitt.is.UMAP2015.R.id.ImageButton02);
        if (getPaperStarred(presentationID).compareTo("yes") == 0)
            b2.setImageResource(edu.pitt.is.UMAP2015.R.drawable.yes_star);
        else
            b2.setImageResource(edu.pitt.is.UMAP2015.R.drawable.no_star);
        b2.setTag(presentationID);
        b2.setOnClickListener(this);

        b3 = (ImageButton) findViewById(edu.pitt.is.UMAP2015.R.id.ImageButton03);
        b3.setOnClickListener(this);

        t2 = (TextView) findViewById(edu.pitt.is.UMAP2015.R.id.TextView06);
        //t2.setBackgroundResource(tbColor);
        t2.setText(authors);
        t3 = (TextView) findViewById(edu.pitt.is.UMAP2015.R.id.TextView02);
        t3.setText(date + " " + btime + "-" + etime);
        t4 = (TextView) findViewById(edu.pitt.is.UMAP2015.R.id.TextView04);
        if (room == null || "null".compareToIgnoreCase(room) == 0 || "".compareTo(room) == 0)
            t4.setText("N/A");
        else {
            t4.setText(room);
        }

        t4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Uri geoLocation = Uri.parse("geo:0,0?").buildUpon()
                        .appendQueryParameter("q", room)
                        .build();

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(geoLocation);

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Log.d("Debug", "Couldn't call " + room + ", no receiving apps installed!");
                }
            }

        });


        bv = (TextView) findViewById(edu.pitt.is.UMAP2015.R.id.PaperButton);
        //bv.setOnClickListener(this);


        if(contentLink != null && !"null".equals(contentLink)) {
            bv.setText(contentLink);
            bv.setOnClickListener(new TextView.OnClickListener() {
                public void onClick(View v) {
                /*
	        	Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse(pContent));
				it.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
				startActivity(it);**/

                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    Uri data = Uri.parse(contentLink);
                    intent.setData(data);
                    startActivity(intent);
                }
            });
        } else {
            bv.setText("N/A");
        }


        wv = (WebView) findViewById(edu.pitt.is.UMAP2015.R.id.WebView01);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadData(content, "text/html", "utf-8");

    }

    public void onClick(View v) {
        // TODO Auto-generated method stub
        TextView tv;
        int index;
        paperID = "";

        switch (v.getId()) {
            case edu.pitt.is.UMAP2015.R.id.ImageButton01:
                b = (ImageButton) v;
                paperID = b.getTag().toString();

                Conference.userID = getUserID();
                if (Conference.userSignin) {
                    paperStatus = "";
                    callThread();
                } else {
                    CallSignin();
                }
                break;

            case edu.pitt.is.UMAP2015.R.id.ImageButton02:
                b = (ImageButton) v;

                paperID = b.getTag().toString();


                if (getPaperStarred(paperID).compareTo("no") == 0) {
                    b.setImageResource(edu.pitt.is.UMAP2015.R.drawable.yes_star);
                    updateUserPaperStatus(paperID, "yes", "star");
                    insertMyStarredPaper(paperID);

                } else {
                    b.setImageResource(edu.pitt.is.UMAP2015.R.drawable.no_star);
                    updateUserPaperStatus(paperID, "no", "star");
                    deleteMyStarredPaper(paperID);


                }

                break;
            case edu.pitt.is.UMAP2015.R.id.ImageButton03:
                Intent connectSocN = new Intent(Intent.ACTION_SEND);
                connectSocN.setType("text/plain");
                connectSocN.putExtra(android.content.Intent.EXTRA_SUBJECT, "iConference 2013");
                connectSocN.putExtra(Intent.EXTRA_TEXT, "The iConference is an annual gathering of a broad spectrum of scholars and researchers from around the world who share a common concern about critical information issues in contemporary society. The iConference pushes the boundaries of information studies, explores core concepts and ideas, and creates new technological and conceptual configurations???all situated in interdisciplinary discourses.<br/>The iConference series is presented by the iSchools organization, a worldwide collective of Information Schools dedicated to advancing the information field, and preparing students to meet the information challenges of the 21st Century. <br/>iConference 2013 is hosted by the University of North Texas College of Information. Presenting Sponsors include Microsoft Research. Additional sponsorships are available; visit our sponsorship page to learn more about sponsorship opportunities.\n" +
                        "This paper will be presented on iConf:\n" + wtitle + "\n" + "http://halley.exp.sis.pitt.edu/cn3/presentation2.php?conferenceID=98&presentationID=" + presentationID);
                startActivity(Intent.createChooser(connectSocN, "Share"));
                break;
            default:
                break;
        }
    }

    private void CallSignin() {
        Intent in = new Intent(PosterDetail.this, Signin.class);
        in.putExtra("activity", "PaperInfo");
        in.putExtra("paperID", wid);
        in.putExtra("title", wtitle);
        in.putExtra("bTime", btime);
        in.putExtra("eTime", etime);
        in.putExtra("authors", authors);
        in.putExtra("Abstract", content);
        in.putExtra("contentlink", contentLink);
        in.putExtra("room", room);
        in.putExtra("date", date);
        in.putExtra("presentationID", presentationID);
        startActivity(in);
    }

    public String getUserID() {
        String id = "";

        try {
            SharedPreferences getUserID = getSharedPreferences("userinfo", 0);
            id = getUserID.getString("userID", "");
        } catch (Exception e) {
        }

        if (id.compareTo("") != 0)
            Conference.userSignin = true;
        return id;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, MENU_HOME, 0, "Home").setIcon(edu.pitt.is.UMAP2015.R.drawable.home);
        menu.add(0, MENU_TRACK, 0, "Proceedings").setIcon(edu.pitt.is.UMAP2015.R.drawable.proceedings);
        menu.add(0, MENU_SESSION, 0, "Schedule").setIcon(edu.pitt.is.UMAP2015.R.drawable.session);
        menu.add(0, MENU_STAR, 0, "My favourite").setIcon(edu.pitt.is.UMAP2015.R.drawable.star);
        menu.add(0, MENU_SCHEDULE, 0, "My Schedule").setIcon(edu.pitt.is.UMAP2015.R.drawable.schedule);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent itemintent = new Intent();
        switch (item.getItemId()) {
            case MENU_HOME:
                this.finish();
                itemintent.setClass(PosterDetail.this, MainInterface.class);
                startActivity(itemintent);
                return true;
            case MENU_SESSION:
                this.finish();
                itemintent.setClass(PosterDetail.this, ProgramByDay.class);
                startActivity(itemintent);
                return true;
            case MENU_STAR:
                this.finish();
                itemintent.setClass(PosterDetail.this, MyStaredPapers.class);
                startActivity(itemintent);
                return true;
            case MENU_TRACK:
                this.finish();
                itemintent.setClass(PosterDetail.this, Proceedings.class);
                startActivity(itemintent);
                return true;
            case MENU_SCHEDULE:
                this.finish();
                itemintent.setClass(PosterDetail.this, MyScheduledPapers.class);
                startActivity(itemintent);
                return true;
        }
        return false;
    }

//    private void CallSignin() {
//        Intent in = new Intent(PosterDetail.this, Signin.class);
//        in.putExtra("activity", "PosterDetail");
//        in.putExtra("id", wid);
//        in.putExtra("wtitle", wtitle);
//        in.putExtra("paperID", paperID);
//        in.putExtra("date", date);
//        in.putExtra("room", room);
//        in.putExtra("wbtime", btime);
//        in.putExtra("wetime", etime);
//        startActivity(in);
//    }

    public void updateUserPaperStatus(String paperID, String status,
                                      String which) {
        db = new DBAdapter(this);
        db.open();
        if (which.compareTo("schedule") == 0)
            db.updatePaperBySchedule(paperID, status);
        else
            db.updatePaperByStar(paperID, status);
        db.close();
    }

    public String getPaperScheduled(String paperID) {
        String status;
        db = new DBAdapter(this);
        db.open();

        status = db.getPaperScheduledStatus(paperID);

        db.close();

        return status;
    }

    public String getPaperStarred(String paperID) {
        String status;
        db = new DBAdapter(this);
        db.open();

        status = db.getPaperStarredStatus(paperID);

        db.close();

        return status;
    }

    public void insertMyScheduledPaper(String paperID) {
        db = new DBAdapter(this);
        db.open();
        db.insertMyScheduledPaper(paperID);
        db.close();
    }

    public void deleteMyScheduledPaper(String paperID) {
        db = new DBAdapter(this);
        db.open();
        db.deleteMyScheduledPaper(paperID);
        db.close();
    }

    public void insertMyStarredPaper(String paperID) {
        db = new DBAdapter(this);
        db.open();
        db.insertMyStarredPaper(paperID);
        db.close();
    }

    public void deleteMyStarredPaper(String paperID) {
        db = new DBAdapter(this);
        db.open();
        db.deleteMyStarredPaper(paperID);
        db.close();
    }

    public void run() {
        // TODO Auto-generated method stub
        if (getPaperScheduled(paperID).compareTo("yes") == 0)
            paperStatus = us2s.DeleteScheduledPaper2Sever(paperID);
        else if (getPaperScheduled(paperID).compareTo("no") == 0)
            paperStatus = us2s.addScheduledPaper2Sever(paperID);
        handler.sendEmptyMessage(0);
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            pd.dismiss();
            // update interface here

            if (paperStatus.compareTo("yes") == 0) {
                b1.setImageResource(edu.pitt.is.UMAP2015.R.drawable.yes_schedule);
                updateUserPaperStatus(paperID, "yes", "schedule");
                insertMyScheduledPaper(paperID);
//                pList.get(pos).scheduled = "yes";
//                adapter.notifyDataSetChanged();

            }
            if (paperStatus.compareTo("no") == 0) {
                b1.setImageResource(edu.pitt.is.UMAP2015.R.drawable.no_schedule);
                updateUserPaperStatus(paperID, "no", "schedule");
                deleteMyScheduledPaper(paperID);
//                pList.get(pos).scheduled = "no";
//                adapter.notifyDataSetChanged();

            }

        }
    };

    public void callThread() {

        pd = ProgressDialog.show(this, "Synchronization", "Please Wait...",
                true, false);
        Thread thread = new Thread(this);
        thread.start();

    }

}
