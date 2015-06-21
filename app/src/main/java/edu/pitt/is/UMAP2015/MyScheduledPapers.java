package edu.pitt.is.UMAP2015;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import data.Conference;
import data.DBAdapter;
import data.Paper;
import data.Session;
import data.UserScheduleParse;
import data.UserScheduledToServer;

public class MyScheduledPapers extends Activity implements Runnable {
    private int date;
    private DBAdapter db;
    private ArrayList<Session> sessions1, sessions2, sessions3, sessions4, sessions5, sessions6, sessions7, sessions8;
    private ArrayList<ArrayList<Paper>> p1, p2, p3, p4, p5, p6, p7, p8;
    private ExpandableListView day1lv, day2lv, day3lv, day4lv, day5lv, day6lv, day7lv, day8lv;
    private int sday;
    private FrameLayout fl;
    private ImageButton syncB;
    private ProgressDialog pd;
    private int threadid = 0;
    private String papersessionID, sessionName, sessionBTime, sessionETime, room;
    private UserScheduledToServer us2s;
    private String paperStatus;
    private ImageButton ib;
    private String paperID;
    private int Pos, pos;
    private String dayID;
    private TabHost host;
    private final int MENU_HOME = Menu.FIRST;
    private final int MENU_TRACK = Menu.FIRST + 1;
    private final int MENU_SESSION = Menu.FIRST + 2;
    private final int MENU_STAR = Menu.FIRST + 3;
    private final int MENU_RECOMMEND = Menu.FIRST + 4;
    private MyListViewAdapter adapter1, adapter2, adapter3, adapter4, adapter5;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(edu.pitt.is.UMAP2015.R.layout.scheduleexpandable);


        fl = (FrameLayout) findViewById(edu.pitt.is.UMAP2015.R.id.FrameLayout01);


        if (Conference.userSignin) {
            Bundle b = getIntent().getExtras();
            if (b != null) {
                if (b.getString("day") != null)
                    sday = Integer.parseInt(b.getString("day"));
                else
                    sday = 0;
            }
            us2s = new UserScheduledToServer();
            fl.setVisibility(View.VISIBLE);


            day1lv = (ExpandableListView) findViewById(edu.pitt.is.UMAP2015.R.id.day1);
            day2lv = (ExpandableListView) findViewById(edu.pitt.is.UMAP2015.R.id.day2);
            day3lv = (ExpandableListView) findViewById(edu.pitt.is.UMAP2015.R.id.day3);
            day4lv = (ExpandableListView) findViewById(edu.pitt.is.UMAP2015.R.id.day4);
            day5lv = (ExpandableListView) findViewById(edu.pitt.is.UMAP2015.R.id.day5);

            // Set up the tabs
            host = (TabHost) findViewById(edu.pitt.is.UMAP2015.R.id.tabdates);
            host.setup();

            // Set up the tabs
            host = (TabHost) findViewById(edu.pitt.is.UMAP2015.R.id.tabdates);
            host.setup();


            //1st day tab
            TabSpec day1 = host.newTabSpec("day1");
            day1.setIndicator("Mon, Jun.29");
            day1.setContent(edu.pitt.is.UMAP2015.R.id.day1);
            host.addTab(day1);

            //2nd day tab
            TabSpec day2 = host.newTabSpec("day2");
            day2.setIndicator("Tue, Jun.30");
            day2.setContent(edu.pitt.is.UMAP2015.R.id.day2);
            host.addTab(day2);

            // 3rd day tab
            TabSpec day3 = host.newTabSpec("day3");
            day3.setIndicator("Wed, July.1");
            day3.setContent(edu.pitt.is.UMAP2015.R.id.day3);
            host.addTab(day3);

            // 4th day tab
            TabSpec day4 = host.newTabSpec("day4");
            day4.setIndicator("Thu, July.2");
            day4.setContent(edu.pitt.is.UMAP2015.R.id.day4);
            host.addTab(day4);

            //5th day tab
             TabSpec day5 = host.newTabSpec("day5");
             day5.setIndicator("Fri, July.3");
             day5.setContent(edu.pitt.is.UMAP2015.R.id.day5);
             host.addTab(day5);

            reGene();
            Changetab(sday);

        } else {
            new AlertDialog.Builder(MyScheduledPapers.this)
                    .setMessage("My Schedule function requires login, do you want to sign in first?")
                    .setPositiveButton("yes",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialoginterface, int i) {
                                    dialoginterface.cancel();
                                    MyScheduledPapers.this.finish();
                                    try {
                                        CallSignin();
                                    } catch (Exception e) {
                                    }
                                }
                            })
                    .setNegativeButton("no",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                    Intent in = new Intent(MyScheduledPapers.this, MainInterface.class);
                                    startActivity(in);
                                }
                            }).show();
        }


        syncB = (ImageButton) findViewById(edu.pitt.is.UMAP2015.R.id.ImageButton01);

        syncB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isConnect(MyScheduledPapers.this)) {
                    try {

                        //Conference.userID = getUserID();
                        if (Conference.userID.compareTo("") != 0) {
                            Conference.userSignin = true;
                            threadid = 1;
                            callThread();
                        } else {
                            CallSignin();
                        }
                    } catch (Exception e) {
                        System.out.print(e);
                    }
                } else
                    new AlertDialog.Builder(MyScheduledPapers.this)
                            .setMessage("This porcess requires internet connection, please check your internet connection.")
                            .setPositiveButton("close",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialoginterface, int i) {
                                            dialoginterface.cancel();
                                        }
                                    })
                            .show();
            }
        });


    }

    public void reGene() {
        //1st day
        sessions1 = new ArrayList<Session>();
        sessions1 = getSession("1");
        p1 = new ArrayList<ArrayList<Paper>>();
        for (int i = 0; i < sessions1.size(); i++) {
            ArrayList<Paper> p = new ArrayList<Paper>();
            p = getPapersBySessionID(sessions1.get(i).ID);
            p1.add(p);
        }
        adapter1 = new MyListViewAdapter(sessions1, p1, "1");
        day1lv.setAdapter(adapter1);
        for (int i = 0; i < sessions1.size(); i++) {
            day1lv.expandGroup(i);
        }


        //2nd day
        sessions2 = new ArrayList<Session>();
        sessions2 = getSession("2");
        p2 = new ArrayList<ArrayList<Paper>>();
        for (int i = 0; i < sessions2.size(); i++) {
            ArrayList<Paper> p = new ArrayList<Paper>();
            p = getPapersBySessionID(sessions2.get(i).ID);
            p2.add(p);
        }
        adapter2 = new MyListViewAdapter(sessions2, p2, "2");
        day2lv.setAdapter(adapter2);
        for (int i = 0; i < sessions2.size(); i++) {
            day2lv.expandGroup(i);
        }


        //3rd day
        sessions3 = new ArrayList<Session>();
        sessions3 = getSession("3");
        p3 = new ArrayList<ArrayList<Paper>>();
        for (int i = 0; i < sessions3.size(); i++) {
            ArrayList<Paper> p = new ArrayList<Paper>();
            p = getPapersBySessionID(sessions3.get(i).ID);
            p3.add(p);
        }
        adapter3 = new MyListViewAdapter(sessions3, p3, "3");
        day3lv.setAdapter(adapter3);
        for (int i = 0; i < sessions3.size(); i++) {
            day3lv.expandGroup(i);
        }


        //4th day
        sessions4 = new ArrayList<Session>();
        sessions4 = getSession("4");
        p4 = new ArrayList<ArrayList<Paper>>();
        for (int i = 0; i < sessions4.size(); i++) {
            ArrayList<Paper> p = new ArrayList<Paper>();
            p = getPapersBySessionID(sessions4.get(i).ID);
            p4.add(p);
        }
        adapter4 = new MyListViewAdapter(sessions4, p4, "4");
        day4lv.setAdapter(adapter4);
        for (int i = 0; i < sessions4.size(); i++) {
            day4lv.expandGroup(i);
        }


        //5th day
        sessions5 = new ArrayList<Session>();
        sessions5 = getSession("5");
        p5 = new ArrayList<ArrayList<Paper>>();
        	for(int i=0; i<sessions5.size();i++){
        	ArrayList<Paper> p= new ArrayList<Paper>();
        	p=getPapersBySessionID(sessions5.get(i).ID);
        p5.add(p);
        }
        adapter5 = new MyListViewAdapter(sessions5,p5,"5");
        day5lv.setAdapter(adapter5);
        for(int i=0; i<sessions5.size();i++){
        day5lv.expandGroup(i);}

    }

    private void Changetab(int request) {
        switch (request) {
            case 1:
                host.setCurrentTabByTag("day1");
                break;
            case 2:
                host.setCurrentTabByTag("day2");
                break;
            case 3:
                host.setCurrentTabByTag("day3");
                break;
            case 4:
                host.setCurrentTabByTag("day4");
                break;
            case 5:
            	host.setCurrentTabByTag("day5");
                break;
            default:
                Calendar c = Calendar.getInstance();
                date = c.get(Calendar.DAY_OF_YEAR);

                /*******************/
                if (date < 189) {
                    host.setCurrentTabByTag("day1");
                }
                if (date == 189) {
                    host.setCurrentTabByTag("day1");
                    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
                    Date d = new Date(System.currentTimeMillis());
                    String s = formatter.format(d);
                    for (int i = 0; i < sessions1.size(); i++) {
                        if (s.compareTo(sessions1.get(i).beginTime) >= 0 && s.compareTo(sessions1.get(i).endTime) <= 0) {
                            day1lv.setSelectedGroup(i);
                            return;
                        }
                    }
                }
                if (date == 190) {
                    host.setCurrentTabByTag("day2");
                    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
                    Date d = new Date(System.currentTimeMillis());
                    String s = formatter.format(d);
                    for (int i = 0; i < sessions2.size(); i++) {
                        if (s.compareTo(sessions2.get(i).beginTime) >= 0 && s.compareTo(sessions2.get(i).endTime) <= 0) {
                            day2lv.setSelectedGroup(i);
                            return;
                        }
                    }
                }
                /*******************/
                if (date == 191) {
                    host.setCurrentTabByTag("day3");
                    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
                    Date d = new Date(System.currentTimeMillis());
                    String s = formatter.format(d);
                    for (int i = 0; i < sessions3.size(); i++) {
                        if (s.compareTo(sessions3.get(i).beginTime) >= 0 && s.compareTo(sessions3.get(i).endTime) <= 0) {
                            day3lv.setSelectedGroup(i);
                            return;
                        }
                    }
                }
                if (date == 192) {
                    host.setCurrentTabByTag("day4");
                    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
                    Date d = new Date(System.currentTimeMillis());
                    String s = formatter.format(d);
                    for (int i = 0; i < sessions4.size(); i++) {
                        if (s.compareTo(sessions4.get(i).beginTime) >= 0 && s.compareTo(sessions4.get(i).endTime) <= 0) {
                            day4lv.setSelectedGroup(i);
                            return;
                        }
                    }
                }
                if (date == 193) {
                    host.setCurrentTabByTag("day5");
                    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
                    Date d = new Date(System.currentTimeMillis());
                    String s = formatter.format(d);
                    for (int i = 0; i < sessions5.size(); i++) {
                        if (s.compareTo(sessions5.get(i).beginTime) >= 0 && s.compareTo(sessions5.get(i).endTime) <= 0) {
                            day5lv.setSelectedGroup(i);
                            return;
                        }
                    }
                }
                if (date > 193) {
                    host.setCurrentTabByTag("day5");
                }
                break;
        }

    }

    private void CallSignin() {
        //this.finish();
        Intent in = new Intent(MyScheduledPapers.this, Signin.class);
        in.putExtra("activity", "MyScheduledPapers");
        startActivity(in);
    }

    public void synchronizeScheduledPaper() {
        ArrayList<String> pidList = new ArrayList<String>();
        UserScheduleParse usp = new UserScheduleParse();

        pidList = usp.getData();
        if (pidList.size() == 0) {
            showToast("Fail to connect to server or have no schedule history yet, please try again.");
        } else {
            db = new DBAdapter(this);
            db.open();
            db.updatePaperScheduleToDefault();
            db.deleteUserScheduled();

            for (int i = 0; i < pidList.size(); i++) {
                db.insertMyScheduledPaper(pidList.get(i));
                db.updatePaperBySchedule(pidList.get(i), "yes");
            }

            db.close();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, MENU_HOME, 0, "Home").setIcon(edu.pitt.is.UMAP2015.R.drawable.home);
        menu.add(0, MENU_TRACK, 0, "Proceedings").setIcon(edu.pitt.is.UMAP2015.R.drawable.proceedings);
        menu.add(0, MENU_SESSION, 0, "Schedule").setIcon(edu.pitt.is.UMAP2015.R.drawable.session);
        menu.add(0, MENU_STAR, 0, "My Favorite").setIcon(edu.pitt.is.UMAP2015.R.drawable.star);
        menu.add(0, MENU_RECOMMEND, 0, "Recommendation").setIcon(edu.pitt.is.UMAP2015.R.drawable.recommends);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent itemintent = new Intent();
        switch (item.getItemId()) {
            case MENU_HOME:
                this.finish();
                itemintent.setClass(MyScheduledPapers.this, MainInterface.class);
                startActivity(itemintent);
                return true;
            case MENU_SESSION:
                this.finish();
                itemintent.setClass(MyScheduledPapers.this, ProgramByDay.class);
                startActivity(itemintent);
                return true;
            case MENU_STAR:
                this.finish();
                itemintent.setClass(MyScheduledPapers.this, MyStaredPapers.class);
                startActivity(itemintent);
                return true;
            case MENU_TRACK:
                this.finish();
                itemintent.setClass(MyScheduledPapers.this, Proceedings.class);
                startActivity(itemintent);
                return true;
            case MENU_RECOMMEND:
                this.finish();
                itemintent.setClass(MyScheduledPapers.this, MyRecommendedPapers.class);
                startActivity(itemintent);
                return true;
        }
        return false;
    }

    public final class ViewHolder {
        TextView firstCharHintTextView, title, location;
        TextView t1, t2, t3, type;
        ImageButton star, schedule;

    }

    private ArrayList<Session> getSession(String dayid) {
        // TODO Auto-generated method stub
        ArrayList<Session> s = new ArrayList<Session>();
        db = new DBAdapter(this);
        db.open();
        s = db.getSessionByScheduledPapers(dayid);
        db.close();
        return s;
    }

    private ArrayList<Paper> getPapersBySessionID(String sessionID) {
        ArrayList<Paper> pList = new ArrayList<Paper>();
        // get data at local
        db = new DBAdapter(this);
        db.open();
        pList = db.getPapersScheduledBySessionID(sessionID);
        db.close();

        return pList;
    }

    public void showToast(final String s) {
        handler.post(new Runnable() {

            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), s,
                        Toast.LENGTH_LONG).show();

            }
        });
    }

    public static boolean isConnect(Context context) {

        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {

            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (info != null) {

                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }

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

    public String getUserID() {
        String id = "";
            /*
			db = new DBAdapter(this);
			db.open();
			id = db.getUserID();
			db.close();
			*/
        try {
            SharedPreferences getUserID = getSharedPreferences("userinfo", 0);
            id = getUserID.getString("userID", "");
        } catch (Exception e) {
        }

        return id;
    }

    private class MyListViewAdapter extends BaseExpandableListAdapter implements
            OnClickListener {
        private ArrayList<Session> parents;
        private ArrayList<ArrayList<Paper>> childs;
        private String day;

        public MyListViewAdapter(ArrayList<Session> parent, ArrayList<ArrayList<Paper>> child, String i) {
            this.parents = parent;
            this.childs = child;
            this.day = i;
        }

        @Override
        public Object getChild(int parentPos, int childPos) {
            // TODO Auto-generated method stub
            return childs.get(parentPos).get(childPos);

        }

        @Override
        public long getChildId(int parentPos, int childPos) {
            // TODO Auto-generated method stub
            return childPos;
        }

        @Override
        public View getChildView(int parentPos, int childPos, boolean islastchild, View convertView,
                                 ViewGroup parent) {
            // TODO Auto-generated method stub
            ViewHolder vh = null;
            SimpleDateFormat sdfSource = new SimpleDateFormat("HH:mm");
            SimpleDateFormat sdfDestination = new SimpleDateFormat("h:mm a");
            Date beginDate, endDate;
            String begTime, endTime;
            if (convertView == null) {
                LayoutInflater li = getLayoutInflater();
                convertView = li.inflate(edu.pitt.is.UMAP2015.R.layout.paperitem, null);
                vh = new ViewHolder();
                vh.t1 = (TextView) convertView.findViewById(edu.pitt.is.UMAP2015.R.id.time);
                vh.t2 = (TextView) convertView.findViewById(edu.pitt.is.UMAP2015.R.id.title);
                vh.t2.setOnClickListener(this);
                vh.t3 = (TextView) convertView.findViewById(edu.pitt.is.UMAP2015.R.id.author);
                vh.type = (TextView) convertView.findViewById(edu.pitt.is.UMAP2015.R.id.type);
                vh.schedule = (ImageButton) convertView
                        .findViewById(edu.pitt.is.UMAP2015.R.id.ImageButton01);
                vh.star = (ImageButton) convertView
                        .findViewById(edu.pitt.is.UMAP2015.R.id.ImageButton02);

                convertView.setTag(vh);
            } else {
                vh = (ViewHolder) convertView.getTag();
            }
            try {
                beginDate = sdfSource.parse(childs.get(parentPos).get(childPos).exactbeginTime);
                endDate = sdfSource.parse(childs.get(parentPos).get(childPos).exactendTime);
                begTime = sdfDestination.format(beginDate);
                endTime = sdfDestination.format(endDate);
                vh.t1.setText(childs.get(parentPos).get(childPos).date + "\t" + begTime + " - " + endTime);
            } catch (Exception e) {
                System.out.println("Date Exception");
            }
            if (childs.get(parentPos).get(childPos).scheduled.compareTo("yes") == 0)
                vh.schedule.setImageResource(edu.pitt.is.UMAP2015.R.drawable.yes_schedule);
            else
                vh.schedule.setImageResource(edu.pitt.is.UMAP2015.R.drawable.no_schedule);
            vh.schedule.setFocusable(false);
            vh.schedule.setOnClickListener(this);
            vh.schedule.setTag(childs.get(parentPos).get(childPos).id + ";" + parentPos + ";" + childPos + ";" + this.day);

            if (childs.get(parentPos).get(childPos).starred.compareTo("yes") == 0)
                vh.star.setImageResource(edu.pitt.is.UMAP2015.R.drawable.yes_star);
            else
                vh.star.setImageResource(edu.pitt.is.UMAP2015.R.drawable.no_star);
            vh.star.setFocusable(false);
            vh.star.setOnClickListener(this);
            vh.star.setTag(childs.get(parentPos).get(childPos).presentationID + ";" + parentPos + ";" + childPos);

            if (childs.get(parentPos).get(childPos).recommended.compareTo("yes") == 0)
                vh.t2.setText(Html.fromHtml(childs.get(parentPos).get(childPos).title + "<font color=\"#ff0000\"> &lt;Recommended&gt; </font>"));
            else
                vh.t2.setText(childs.get(parentPos).get(childPos).title);
            vh.t2.setTag(parentPos + ";" + childPos + ";" + this.day);
            vh.t3.setText(childs.get(parentPos).get(childPos).authors);
            vh.type.setText(childs.get(parentPos).get(childPos).type);
            return convertView;
        }

        @Override
        public int getChildrenCount(int parentPos) {
            // TODO Auto-generated method stub
            return childs.get(parentPos).size();

        }

        @Override
        public Object getGroup(int parentPos) {
            // TODO Auto-generated method stub
            return parents.get(parentPos);

        }

        @Override
        public int getGroupCount() {
            // TODO Auto-generated method stub
            return parents.size();
        }

        @Override
        public long getGroupId(int parentPos) {
            // TODO Auto-generated method stub
            return parentPos;
        }

        @Override
        public View getGroupView(int parentPos, boolean isExpanded, View convertView,
                                 ViewGroup parent) {
            ViewHolder holder = null;
            SimpleDateFormat sdfSource = new SimpleDateFormat("HH:mm");
            SimpleDateFormat sdfDestination = new SimpleDateFormat("h:mm a");
            Date beginDate, endDate;
            String begTime, endTime;
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(edu.pitt.is.UMAP2015.R.layout.sessionitem, null);
                holder = new ViewHolder();
                holder.firstCharHintTextView = (TextView) convertView.findViewById(edu.pitt.is.UMAP2015.R.id.text_first_char_hint);
                holder.title = (TextView) convertView.findViewById(edu.pitt.is.UMAP2015.R.id.title);
                holder.location = (TextView) convertView.findViewById(edu.pitt.is.UMAP2015.R.id.location);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.title.setText(parents.get(parentPos).name);

            if (parents.get(parentPos).room.compareToIgnoreCase("NULL") == 0)
                holder.location.setVisibility(View.GONE);
            else {
                holder.location.setVisibility(View.VISIBLE);
                holder.location.setText("At " + parents.get(parentPos).room);
            }

            int idx = parentPos - 1;

            String previewb = idx >= 0 ? parents.get(idx).beginTime : "";
            String currentb = parents.get(parentPos).beginTime;
            String previewe = idx >= 0 ? parents.get(idx).endTime : "";
            String currente = parents.get(parentPos).endTime;

            if (currentb.compareTo(previewb) == 0 && currente.compareTo(previewe) == 0) {
                holder.firstCharHintTextView.setVisibility(View.GONE);
            } else {

                holder.firstCharHintTextView.setVisibility(View.VISIBLE);
                try {
                    beginDate = sdfSource.parse(parents.get(parentPos).beginTime);
                    endDate = sdfSource.parse(parents.get(parentPos).endTime);
                    begTime = sdfDestination.format(beginDate);
                    endTime = sdfDestination.format(endDate);
                    holder.firstCharHintTextView.setText(begTime + " - " + endTime);
                } catch (Exception e) {
                    System.out.println("Date Exception");
                }
            }
            return convertView;
        }

        @Override
        public boolean hasStableIds() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean isChildSelectable(int arg0, int arg1) {
            // TODO Auto-generated method stub
            return true;
        }

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            TextView tv;
            switch (v.getId()) {
                case edu.pitt.is.UMAP2015.R.id.ImageButton01:
                    ib = (ImageButton) v;
                    String s = ib.getTag().toString();
                    String st[] = s.split(";");
                    paperID = st[0];
                    Pos = Integer.parseInt(st[1]);
                    pos = Integer.parseInt(st[2]);
                    dayID = st[3];
                    Conference.userID = getUserID();
                    if (Conference.userSignin) {
                        paperStatus = "";
                        if (getPaperScheduled(paperID).compareTo("yes") == 0) {
                            threadid = 2;
                        } else {
                            threadid = 3;
                        }
                        callThread();

                    } else {
                        CallSignin();
                    }
                    break;
                case edu.pitt.is.UMAP2015.R.id.ImageButton02:
                    ib = (ImageButton) v;
                    String s1 = ib.getTag().toString();
                    String st1[] = s1.split(";");
                    paperID = st1[0];
                    Pos = Integer.parseInt(st1[1]);
                    pos = Integer.parseInt(st1[2]);

                    if (getPaperStarred(paperID).compareTo("no") == 0) {
                        ib.setImageResource(edu.pitt.is.UMAP2015.R.drawable.yes_star);
                        updateUserPaperStatus(paperID, "yes", "star");
                        insertMyStarredPaper(paperID);
                        childs.get(Pos).get(pos).starred = "yes";
                        this.notifyDataSetChanged();

                    } else {
                        ib.setImageResource(edu.pitt.is.UMAP2015.R.drawable.no_star);
                        updateUserPaperStatus(paperID, "no", "star");
                        deleteMyStarredPaper(paperID);
                        childs.get(Pos).get(pos).starred = "no";
                        this.notifyDataSetChanged();

                    }

                    break;
                case edu.pitt.is.UMAP2015.R.id.title:
                    int idx, idxs;
                    tv = (TextView) v;
                    String s2 = tv.getTag().toString();
                    String st2[] = s2.split(";");
                    idx = Integer.parseInt(st2[0]);
                    idxs = Integer.parseInt(st2[1]);
                    String day = st2[2];
                    MyScheduledPapers.this.finish();
                    Intent in = new Intent(MyScheduledPapers.this, PaperDetail.class);
                    in.putExtra("id", childs.get(idx).get(idxs).id);
                    in.putExtra("title", childs.get(idx).get(idxs).title);
                    in.putExtra("authors", childs.get(idx).get(idxs).authors);
                    in.putExtra("date", childs.get(idx).get(idxs).date);
                    in.putExtra("abstract", childs.get(idx).get(idxs).paperAbstract);
                    in.putExtra("contentlink", childs.get(idx).get(idxs).contentlink);

                    //in.putExtra("sessionName", sessionName);
                    in.putExtra("room", childs.get(idx).get(idxs).room);
                    in.putExtra("bTime", childs.get(idx).get(idxs).exactbeginTime);
                    in.putExtra("eTime", childs.get(idx).get(idxs).exactendTime);
                    in.putExtra("presentationID", childs.get(idx).get(idxs).presentationID);
                    in.putExtra("activity", "MyScheduledPapers");
                    in.putExtra("key", day);
                    startActivity(in);
                    break;
                default:
                    break;
            }
        }


    }

    public void callThread() {

        pd = ProgressDialog.show(this, "Synchronization", "Please Wait...",
                true, false);
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {

        if (threadid == 1) {
            synchronizeScheduledPaper();

        }
        else if (threadid == 2) {
            paperStatus = us2s.DeleteScheduledPaper2Sever(paperID);
				/*if(paperStatus != "yes" && paperStatus !="no"){
					showToast("Fail to connect to sever, please try again.");
				}*/
        } else if (threadid == 3){
            paperStatus = us2s.addScheduledPaper2Sever(paperID);
				/*if(paperStatus != "yes" && paperStatus !="no"){
					showToast("Fail to connect to sever, please try again.");
				}*/
        }


        handler.sendEmptyMessage(0);
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            pd.dismiss();

            // update interface here
            if (threadid == 1) {
                reGene();
            } else {
                if (paperStatus.compareTo("yes") == 0) {
                    ib.setImageResource(edu.pitt.is.UMAP2015.R.drawable.yes_schedule);
                    updateUserPaperStatus(paperID, "yes", "schedule");
                    insertMyScheduledPaper(paperID);
                    /*******************/
                    if (dayID == "1") {
                        sessions1 = new ArrayList<Session>();
                        sessions1 = getSession("1");
                        p1 = new ArrayList<ArrayList<Paper>>();
                        for (int i = 0; i < sessions1.size(); i++) {
                            ArrayList<Paper> p = new ArrayList<Paper>();
                            p = getPapersBySessionID(sessions1.get(i).ID);
                            p1.add(p);
                        }
                        adapter1.notifyDataSetChanged();
                    } else if (dayID == "2") {
                        sessions2 = new ArrayList<Session>();
                        sessions2 = getSession("2");
                        p2 = new ArrayList<ArrayList<Paper>>();
                        for (int i = 0; i < sessions2.size(); i++) {
                            ArrayList<Paper> p = new ArrayList<Paper>();
                            p = getPapersBySessionID(sessions2.get(i).ID);
                            p2.add(p);
                        }
                        adapter2.notifyDataSetChanged();
                    } else if (dayID == "3") {
                        sessions3 = new ArrayList<Session>();
                        sessions3 = getSession("3");
                        p3 = new ArrayList<ArrayList<Paper>>();
                        for (int i = 0; i < sessions3.size(); i++) {
                            ArrayList<Paper> p = new ArrayList<Paper>();
                            p = getPapersBySessionID(sessions3.get(i).ID);
                            p3.add(p);
                        }
                        adapter3.notifyDataSetChanged();
                    } else if (dayID == "4") {
                        //4th day
                        sessions4 = new ArrayList<Session>();
                        sessions4 = getSession("4");
                        p4 = new ArrayList<ArrayList<Paper>>();
                        for (int i = 0; i < sessions4.size(); i++) {
                            ArrayList<Paper> p = new ArrayList<Paper>();
                            p = getPapersBySessionID(sessions4.get(i).ID);
                            p4.add(p);
                        }

                        adapter4.notifyDataSetChanged();
                    } else if (dayID == "5") {
                        sessions5 = new ArrayList<Session>();
                        sessions5 = getSession("5");
                        p5 = new ArrayList<ArrayList<Paper>>();
                        for (int i = 0; i < sessions5.size(); i++) {
                            ArrayList<Paper> p = new ArrayList<Paper>();
                            p = getPapersBySessionID(sessions5.get(i).ID);
                            p5.add(p);
                        }
                        adapter5.notifyDataSetChanged();
                    }
                    /*******************/
                    reGene();
                }
                else if (paperStatus.compareTo("no") == 0) {
                    ib.setImageResource(edu.pitt.is.UMAP2015.R.drawable.no_schedule);
                    updateUserPaperStatus(paperID, "no", "schedule");
                    deleteMyScheduledPaper(paperID);
                    /*******************/
                    if (dayID == "1") {
                        sessions1 = new ArrayList<Session>();
                        sessions1 = getSession("1");
                        p1 = new ArrayList<ArrayList<Paper>>();
                        for (int i = 0; i < sessions1.size(); i++) {
                            ArrayList<Paper> p = new ArrayList<Paper>();
                            p = getPapersBySessionID(sessions1.get(i).ID);
                            p1.add(p);
                        }
                        adapter1.notifyDataSetChanged();
                    } else if (dayID == "2") {
                        sessions2 = new ArrayList<Session>();
                        sessions2 = getSession("2");
                        p2 = new ArrayList<ArrayList<Paper>>();
                        for (int i = 0; i < sessions2.size(); i++) {
                            ArrayList<Paper> p = new ArrayList<Paper>();
                            p = getPapersBySessionID(sessions2.get(i).ID);
                            p2.add(p);
                        }
                        adapter2.notifyDataSetChanged();
                    } else if (dayID == "3") {
                        sessions3 = new ArrayList<Session>();
                        sessions3 = getSession("3");
                        p3 = new ArrayList<ArrayList<Paper>>();
                        for (int i = 0; i < sessions3.size(); i++) {
                            ArrayList<Paper> p = new ArrayList<Paper>();
                            p = getPapersBySessionID(sessions3.get(i).ID);
                            p3.add(p);
                        }
                        adapter3.notifyDataSetChanged();
                    } else if (dayID == "4") {
                        //4th day
                        sessions4 = new ArrayList<Session>();
                        sessions4 = getSession("4");
                        p4 = new ArrayList<ArrayList<Paper>>();
                        for (int i = 0; i < sessions4.size(); i++) {
                            ArrayList<Paper> p = new ArrayList<Paper>();
                            p = getPapersBySessionID(sessions4.get(i).ID);
                            p4.add(p);
                        }

                        adapter4.notifyDataSetChanged();
                    } else if (dayID == "5") {
                        sessions5 = new ArrayList<Session>();
                        sessions5 = getSession("5");
                        p5 = new ArrayList<ArrayList<Paper>>();
                        for (int i = 0; i < sessions5.size(); i++) {
                            ArrayList<Paper> p = new ArrayList<Paper>();
                            p = getPapersBySessionID(sessions5.get(i).ID);
                            p5.add(p);
                        }
                        adapter5.notifyDataSetChanged();
                    }
                    /*******************/
                    reGene();
                }
            }
        }
    };
}
