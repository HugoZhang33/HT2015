package hypertext2014.com;


import java.util.ArrayList;


import data.Authorization;
import data.Conference;
import data.DBAdapter;
import data.UserScheduleParse;
import data.UserScheduledToServer;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Signin extends Activity implements Runnable {

    private EditText emailText, passwordText;
    private Button loginButton, signupButton;
    private String email, password;
    private boolean loginOK = false;
    private ProgressDialog pd;
    private Authorization au;
    private String activityName;
    private String paperID = "";
    private String papersessionID, sessionName, sessionBTime, sessionETime,
            sessionDate = "";
    private String contentID = "";
    private String presentationID, paperTitle, paperbTime, papereTime, paperAbstract, paperAuthors, date, room = "";
    private String workshopID, workshopTitle, content, workshopDate, wbtime, wetime, childsessionID = "";
    private TextView tw4;
    private DBAdapter db;

    private static final int ERRORDIALOG = 1;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.login);

        Bundle b = getIntent().getExtras();
        if (b != null) {

            activityName = b.getString("activity");
            if (activityName.compareTo("PaperInSession") == 0) {
                papersessionID = b.getString("papersessionID");
                sessionName = b.getString("sessionName");
                sessionBTime = b.getString("bTime");
                sessionETime = b.getString("eTime");
                sessionDate = b.getString("date");
                paperID = b.getString("paperID");
            } else if (activityName.compareTo("PaperInSession") == 0) {
                papersessionID = b.getString("papersessionID");
                sessionName = b.getString("sessionName");
                sessionBTime = b.getString("bTime");
                sessionETime = b.getString("eTime");
                sessionDate = b.getString("date");
                room = b.getString("room");
                paperID = b.getString("paperID");
            } else if (activityName.compareTo("PaperInfo") == 0) {
                paperID = b.getString("paperID");
                paperTitle = b.getString("title");
                paperbTime = b.getString("bTime");
                papereTime = b.getString("eTime");
                paperAbstract = b.getString("Abstract");
                paperAuthors = b.getString("authors");
                date = b.getString("date");
                room = b.getString("room");
                presentationID = b.getString("presentationID");
            } else if (activityName.compareTo("PaperSimilar") == 0) {
                paperID = b.getString("paperID");
                contentID = b.getString("id");
                paperTitle = b.getString("title");
                paperbTime = b.getString("bTime");
                papereTime = b.getString("eTime");
                paperAbstract = b.getString("Abstract");
                paperAuthors = b.getString("authors");
                date = b.getString("date");
                room = b.getString("room");
                presentationID = b.getString("presentationID");
            } else if (activityName.compareTo("MyStaredPapers") == 0) {
                paperID = b.getString("paperID");
            } else if (activityName.compareTo("MyRecommendedPapers") == 0) {
                paperID = b.getString("paperID");
            } else if (activityName.compareTo("ProceedingsByAuthor") == 0) {
                paperID = b.getString("paperID");
            } else if (activityName.compareTo("ProceedingsByName") == 0) {
                paperID = b.getString("paperID");
            } else if (activityName.compareTo("ProceedingsByType") == 0) {
                paperID = b.getString("paperID");
            } else if (activityName.compareTo("WorkshopDetail") == 0) {
                paperID = b.getString("paperID");
                workshopID = b.getString("id");
                workshopTitle = b.getString("wtitle");
                workshopDate = b.getString("date");
                room = b.getString("room");
                wbtime = b.getString("wbtime");
                wetime = b.getString("wetime");
                content = b.getString("content");
                childsessionID = b.getString("childsessionID");

            } else if (activityName.compareTo("PosterDetail") == 0) {
                paperID = b.getString("paperID");
                workshopID = b.getString("id");
                workshopTitle = b.getString("wtitle");
                workshopDate = b.getString("date");
                room = b.getString("room");
                wbtime = b.getString("wbtime");
                wetime = b.getString("wetime");
            } else {

            }
        }

        emailText = (EditText) findViewById(R.id.EmailText);
        passwordText = (EditText) findViewById(R.id.PasswordText);
        loginButton = (Button) findViewById(R.id.LoginButton);
        signupButton = (Button) findViewById(R.id.SignupButton);

		/*tw4 = (TextView)this.findViewById(R.id.TextView04);
		tw4.setText(Html.fromHtml("<a href=\"http://asist2010planner.appspot.com\">ASIST Web 2.0</a>"));*/

        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                login();
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                toSignUp();
            }
        });

    }

    public void run() {
        // add authorization method below
        validate();
        handler.sendEmptyMessage(0);
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            pd.dismiss();
            showLoginResult();
        }
    };

    private void login() {
        pd = ProgressDialog.show(this, "Logging in", "Please Wait...", true,
                false);
        Thread thread = new Thread(this);
        thread.start();
    }

    private void validate() {
        email = emailText.getText().toString();
        password = passwordText.getText().toString();
        au = new Authorization();
        au.login(email, password);
        loginOK = au.isLoginOK;
    }

    private void syncDB() {
        ArrayList<String> pidList = new ArrayList<String>();
        UserScheduleParse usp = new UserScheduleParse();
        pidList = usp.getData();
        db = new DBAdapter(this);
        db.open();
        db.updatePaperScheduleToDefault();
        db.deleteUserScheduled();

        for (int i = 0; i < pidList.size(); i++) {
            db.insertMyScheduledPaper(pidList.get(i).toString());
            db.updatePaperBySchedule(pidList.get(i).toString(), "yes");
        }

        db.close();
    }

    private void updatePaperStatus(String id) {
        UserScheduledToServer us2s = new UserScheduledToServer();
        String paperStatus = us2s.addScheduledPaper2Sever(id);
        if (paperStatus.compareTo("no") == 0)
            paperStatus = us2s.addScheduledPaper2Sever(id);
    }

    private void showLoginResult() {
        if (!loginOK) {
            showDialog(ERRORDIALOG);
        } else {
            /***
             * after successfully login, a file should be created to store email
             * and password
             */


            SharedPreferences userinfo = getSharedPreferences("userinfo", 0);
            SharedPreferences.Editor editor = userinfo.edit();
            editor.putString("userID", au.userID);
            editor.commit();

            Conference.userSignin = true;
            Conference.userID = au.userID;
            System.out.println("*******************User ID" + au.userID);
			
			
			/*
			db = new DBAdapter(this);
			db.open();
			db.insertUser(au.userID);
			db.close();
			Conference.userSignin  = true;
			Conference.userID = au.userID;
			*/

            //Intent in = new Intent(Signin.this, MainInterface.class);
            Intent in;

            if (activityName.compareTo("PaperInSession") == 0) {
                updatePaperStatus(paperID);
                syncDB();
                in = new Intent(Signin.this, PaperInSession.class);
                in.putExtra("papersessionID", papersessionID);
                in.putExtra("sessionName", sessionName);
                in.putExtra("bTime", sessionBTime);
                in.putExtra("eTime", sessionETime);
                in.putExtra("date", sessionDate);
                in.putExtra("room", room);
                //in.putExtra("firstLogin", "yes");

            } else if (activityName.compareTo("PaperSimilar") == 0) {
                updatePaperStatus(paperID);
                syncDB();
                in = new Intent(Signin.this, PaperDetail.class);
                in.putExtra("id", contentID);
                in.putExtra("title", paperTitle);
                in.putExtra("bTime", paperbTime);
                in.putExtra("eTime", papereTime);
                in.putExtra("abstract", paperAbstract);
                in.putExtra("authors", paperAuthors);
                in.putExtra("room", room);
                in.putExtra("date", date);
                in.putExtra("presentationID", presentationID);
                //in.putExtra("firstLogin", "yes");
            } else if (activityName.compareTo("PaperInfo") == 0) {
                updatePaperStatus(paperID);
                syncDB();
                in = new Intent(Signin.this, PaperDetail.class);
                in.putExtra("id", paperID);
                in.putExtra("title", paperTitle);
                in.putExtra("bTime", paperbTime);
                in.putExtra("eTime", papereTime);
                in.putExtra("abstract", paperAbstract);
                in.putExtra("authors", paperAuthors);
                in.putExtra("room", room);
                in.putExtra("date", date);
                in.putExtra("presentationID", presentationID);
            } else if (activityName.compareTo("ProceedingsByAuthor") == 0) {
                updatePaperStatus(paperID);
                syncDB();
                in = new Intent(Signin.this, Proceedings.class);
                in.putExtra("no", "1");
            } else if (activityName.compareTo("ProceedingsByName") == 0) {
                updatePaperStatus(paperID);
                syncDB();
                in = new Intent(Signin.this, Proceedings.class);
                in.putExtra("no", "2");
            } else if (activityName.compareTo("ProceedingsByType") == 0) {
                updatePaperStatus(paperID);
                syncDB();
                in = new Intent(Signin.this, Proceedings.class);
                in.putExtra("no", "2");
            } else if (activityName.compareTo("WorkshopDetail") == 0) {
                updatePaperStatus(paperID);
                syncDB();
                in = new Intent(Signin.this, WorkshopDetail.class);
                in.putExtra("paperID", paperID);
                in.putExtra("id", workshopID);
                in.putExtra("title", workshopTitle);
                in.putExtra("date", workshopDate);
                in.putExtra("room", room);
                in.putExtra("bTime", wbtime);
                in.putExtra("eTime", wetime);
                in.putExtra("content", content);
                in.putExtra("childsessionID", childsessionID);
            } else if (activityName.compareTo("PosterDetail") == 0) {
                updatePaperStatus(paperID);
                syncDB();
                in = new Intent(Signin.this, PosterDetail.class);
                in.putExtra("paperID", paperID);
                in.putExtra("id", workshopID);
                in.putExtra("title", workshopTitle);
                in.putExtra("date", workshopDate);
                in.putExtra("room", room);
                in.putExtra("bTime", wbtime);
                in.putExtra("eTime", wetime);
            } else if (activityName.compareTo("MyStaredPapers") == 0) {
                updatePaperStatus(paperID);
                syncDB();
                in = new Intent(Signin.this, MyStaredPapers.class);
            } else if (activityName.compareTo("MyRecommendedPapers") == 0) {
                updatePaperStatus(paperID);
                syncDB();
                in = new Intent(Signin.this, MyRecommendedPapers.class);
            } else {
                updatePaperStatus(paperID);
                syncDB();
                in = new Intent(Signin.this, MainInterface.class);
            }

            startActivity(in);
            this.finish();
        }
    }

    private void toSignUp() {
        Intent in = new Intent();
        in.setClass(Signin.this, Signup.class);

        in.putExtra("activity", activityName);
        in.putExtra("paperID", paperID);
        if (activityName.compareTo("PaperInSession") == 0) {
            in.putExtra("papersessionID", papersessionID);
            in.putExtra("sessionName", sessionName);
            in.putExtra("bTime", sessionBTime);
            in.putExtra("eTime", sessionETime);
            in.putExtra("date", sessionDate);
        } else if (activityName.compareTo("PaperInfo") == 0) {
            in.putExtra("title", paperTitle);
            in.putExtra("bTime", paperbTime);
            in.putExtra("eTime", papereTime);
            in.putExtra("abstract", paperAbstract);
            in.putExtra("authors", paperAuthors);
            in.putExtra("room", room);
            in.putExtra("date", date);
            in.putExtra("presentationID", presentationID);
        } else if (activityName.compareTo("PaperSimilar") == 0) {
            in.putExtra("id", contentID);
            in.putExtra("title", paperTitle);
            in.putExtra("bTime", paperbTime);
            in.putExtra("eTime", papereTime);
            in.putExtra("abstract", paperAbstract);
            in.putExtra("authors", paperAuthors);
            in.putExtra("room", room);
            in.putExtra("date", date);
            in.putExtra("presentationID", presentationID);
        } else if (activityName.compareTo("MyStaredPapers") == 0) {
        } else if (activityName.compareTo("MyRecommendedPapers") == 0) {
        } else if (activityName.compareTo("PaperInSchedule") == 0) {
            in.putExtra("papersessionID", papersessionID);
            in.putExtra("sessionName", sessionName);
            in.putExtra("bTime", sessionBTime);
            in.putExtra("eTime", sessionETime);
            in.putExtra("date", sessionDate);
        } else if (activityName.compareTo("ProceedingsByAuthor") == 0) {

        } else if (activityName.compareTo("ProceedingsByName") == 0) {

        } else if (activityName.compareTo("ProceedingsByType") == 0) {

        } else if (activityName.compareTo("WorkshopDetail") == 0) {

            in.putExtra("id", workshopID);
            in.putExtra("title", workshopTitle);
            in.putExtra("date", workshopDate);
            in.putExtra("room", room);
            in.putExtra("bTime", wbtime);
            in.putExtra("eTime", wetime);
            in.putExtra("content", content);
            in.putExtra("childsessionID", childsessionID);
        } else if (activityName.compareTo("PosterDetail") == 0) {

            in.putExtra("paperID", paperID);
            in.putExtra("id", workshopID);
            in.putExtra("title", workshopTitle);
            in.putExtra("date", workshopDate);
            in.putExtra("room", room);
            in.putExtra("bTime", wbtime);
            in.putExtra("eTime", wetime);
        } else {

        }
        startActivity(in);
    }

    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case ERRORDIALOG:
                return errorDialog(Signin.this, au.errorMessage);
        }
        return null;
    }

    protected void onPrepareDialog(int id, Dialog dialog) {

    }

    private Dialog errorDialog(Context context, String error) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setIcon(R.drawable.alert_dialog_icon);
        builder.setTitle("Login: Please recheck userid or passwd");
        builder.setMessage(error);
        builder.setPositiveButton("ok", null);
        return builder.create();
    }

}
