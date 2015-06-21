package edu.pitt.is.UMAP2015;


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

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import data.Authorization;
import data.Conference;
import data.DBAdapter;
import data.UserScheduleParse;
import data.UserScheduledToServer;

public class Signup extends Activity implements Runnable{
	
	private EditText nameText, emailText, passwordText, rePasswordText, citeULikeText;
	private Button registerButton, signinButton;
	private String name, email, password, rPassword;
	private String citeULike ="null";
	private boolean registerOK = false;
	private ProgressDialog pd;
	private Authorization au;
	private String activityName="";
	private String papersessionID, sessionName, sessionBTime, sessionETime,
	sessionDate,paperID="";
	private String paperTitle,paperbTime, papereTime, paperAbstract, paperAuthors, room="";
	private String workshopID, workshopTitle, content, workshopDate,childsessionID="";
	private String trackID, trackName="";
	private DBAdapter db;
	private String date="";
	private String presentationID="";
	private String contentID="";
	private String wbtime="";
	private String wetime="";

	private static final int ERRORDIALOG = 1; // Signup error
	private static final int PERRORDIALOG = 2; // password not match
	private static final int NERRORDIALOG = 3; // no name
	private static final int EERRORDIALOG = 4; // no email
	private static final int NPERRORDIALOG = 5; // no password

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(edu.pitt.is.UMAP2015.R.layout.registration);
		
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
			} else if (activityName.compareTo("PaperInSchedule") == 0){
				papersessionID = b.getString("papersessionID");
				sessionName = b.getString("sessionName");
				sessionBTime = b.getString("bTime");
				sessionETime = b.getString("eTime");
				sessionDate = b.getString("date");
				paperID = b.getString("paperID");
			}
			else if (activityName.compareTo("PaperInfo") == 0){
				paperID = b.getString("paperID");
				paperTitle = b.getString("title");
				paperbTime = b.getString("bTime");
				papereTime = b.getString("eTime");
				paperAbstract = b.getString("abstract");
				paperAuthors = b.getString("authors");
				date = b.getString("date");
				room = b.getString("room");
				presentationID =b.getString("presentationID");
			}
			else if (activityName.compareTo("PaperSimilar") == 0){
				paperID = b.getString("paperID");
				contentID=b.getString("id");
				paperTitle = b.getString("title");
				paperbTime = b.getString("bTime");
				papereTime = b.getString("eTime");
				paperAbstract = b.getString("abstract");
				paperAuthors = b.getString("authors");
				date = b.getString("date");
				room = b.getString("room");
				presentationID =b.getString("presentationID");
			}
			else if(activityName.compareTo("MyStaredPapers") == 0)
			{
				paperID = b.getString("paperID");
			}
			else if(activityName.compareTo("MyRecommendedPapers") == 0)
			{
				paperID = b.getString("paperID");
			}
			else if(activityName.compareTo("ProceedingsByAuthor") == 0)
			{
				paperID = b.getString("paperID");
			}
			else if(activityName.compareTo("ProceedingsByName") == 0)
			{
				paperID = b.getString("paperID");
			}
			else if(activityName.compareTo("ProceedingsByType") == 0)
			{
				paperID = b.getString("paperID");
			}
			else if(activityName.compareTo("WorkshopDetail")== 0){
				paperID = b.getString("paperID");
				workshopID = b.getString("id");
				workshopTitle = b.getString("title");
				workshopDate = b.getString("date");
				room = b.getString("room");
				wbtime = b.getString("bTime");
				wetime = b.getString("eTtime");
				content= b.getString("content");
				childsessionID=b.getString(childsessionID);
				
			}
			else if(activityName.compareTo("PosterDetail")== 0){
				paperID = b.getString("paperID");
				workshopID = b.getString("id");
				workshopTitle = b.getString("title");
				workshopDate = b.getString("date");
				room = b.getString("room");
				wbtime = b.getString("bTime");
				wetime = b.getString("eTime");			
			}
			else{
				
			}
		}
		
		nameText = (EditText) findViewById(edu.pitt.is.UMAP2015.R.id.NameText);
		emailText = (EditText) findViewById(edu.pitt.is.UMAP2015.R.id.REmailText);
		passwordText = (EditText) findViewById(edu.pitt.is.UMAP2015.R.id.RPasswordText);
		rePasswordText = (EditText) findViewById(edu.pitt.is.UMAP2015.R.id.RePasswordText);
		citeULikeText = (EditText) findViewById(edu.pitt.is.UMAP2015.R.id.CiteULikeUser);
		registerButton = (Button) findViewById(edu.pitt.is.UMAP2015.R.id.RegisterButton);
		signinButton = (Button) findViewById(edu.pitt.is.UMAP2015.R.id.SigninButton);

		registerButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				register();
			}
		});

		signinButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				toSignIn();
			}
		});
		
	}
	
	private void updatePaperStatus(String id)
	{
		UserScheduledToServer us2s = new UserScheduledToServer();
		String paperStatus = us2s.addScheduledPaper2Sever(id);
		if(paperStatus.compareTo("no")==0)
			paperStatus = us2s.addScheduledPaper2Sever(id);
	}
	
	public void run() {
		/* add authorization method below
		 * 
		 * 
		 * 
		 */
		postToServer();
		handler.sendEmptyMessage(0);
	}
	
	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			pd.dismiss();
			showSignupResult();
		}
	};

	private boolean checkEmail(String mail) {
		String regex = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(mail);
		return m.find();
	}
	
	private void register() {
		name = nameText.getText().toString();
		email = emailText.getText().toString();
		password = passwordText.getText().toString();
		rPassword = rePasswordText.getText().toString();
		citeULike = citeULikeText.getText().toString();

		if (name.compareTo("") == 0) {
			showDialog(NERRORDIALOG);
		} else if (!checkEmail(email)) {
			showDialog(EERRORDIALOG);
		}
		else if(password.compareTo("")==0)
		{
			showDialog(NPERRORDIALOG);
		}
		else if (password.compareTo(rPassword) != 0) {
			showDialog(PERRORDIALOG);
		} else {
			pd = ProgressDialog.show(this, "Signing up", "Please Wait...",
					true, false);
			Thread thread = new Thread(this);
			thread.start();
		}
	}

	private void toSignIn() {
		Intent signinIntent = new Intent();
		signinIntent.setClass(Signup.this, Signin.class);
		startActivity(signinIntent);
	}

	private void syncDB()
	{
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
	
	private void postToServer() {
		// add authorization method below
		au = new Authorization();
		au.signUp(name, email, password, rPassword, citeULike);
	    registerOK = au.isSignUp;
	}

	private void showSignupResult() {
		if (!registerOK) {
			showDialog(ERRORDIALOG);
		} else {
			/***
    		 * after successfully register, a file should be created to store email and password
    		 * then call authorization to login
    		 */
			
			
			SharedPreferences userinfo = getSharedPreferences("userinfo",0);
    		userinfo.edit().putString("userID", au.userID).commit();
    		Conference.userSignin  = true;
    		Conference.userID = au.userID;
			
			
			/*
			db = new DBAdapter(this);
			db.open();
			db.insertUser(au.userID);
			db.close();
			Conference.userSignin  = true;
			Conference.userID = au.userID;
    		*/
    		
    		
    		//Intent in = new Intent(Signup.this, MainInterface.class); 
    		Intent in;
    		
    		if (activityName.compareTo("PaperInSession") == 0)
			{
				updatePaperStatus(paperID);
				syncDB();
				in = new Intent(Signup.this, PaperInSession.class);
				in.putExtra("papersessionID", papersessionID);
				in.putExtra("sessionName", sessionName);
				in.putExtra("bTime", sessionBTime);
				in.putExtra("eTime", sessionETime);
				in.putExtra("date", sessionDate);
				//in.putExtra("firstLogin", "yes");
				
			}
			else if(activityName.compareTo("PaperSimilar") == 0)
			{
				updatePaperStatus(paperID);
				syncDB();
				in = new Intent(Signup.this, PaperDetail.class);
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
			}
			else if(activityName.compareTo("PaperInfo") == 0)
			{
				updatePaperStatus(paperID);
				syncDB();
				in = new Intent(Signup.this, PaperDetail.class);
				in.putExtra("id", paperID);
				in.putExtra("title", paperTitle);
				in.putExtra("bTime", paperbTime);
				in.putExtra("eTime", papereTime);
				in.putExtra("abstract", paperAbstract);
				in.putExtra("authors", paperAuthors);
				in.putExtra("room", room);
				in.putExtra("date", date);
				in.putExtra("presentationID", presentationID);
			}
		
			else if(activityName.compareTo("ProceedingsByAuthor") == 0)
			{
				updatePaperStatus(paperID);
				syncDB();
				in = new Intent(Signup.this, Proceedings.class);
				in.putExtra("no", "1");
			}
			else if(activityName.compareTo("ProceedingsByName") == 0)
			{
				updatePaperStatus(paperID);
				syncDB();
				in = new Intent(Signup.this, Proceedings.class);
				in.putExtra("no", "2");
			}
			else if(activityName.compareTo("ProceedingsByType") == 0)
			{
				updatePaperStatus(paperID);
				syncDB();
				in = new Intent(Signup.this, Proceedings.class);
				in.putExtra("no", "2");
			}
			else if(activityName.compareTo("WorkshopDetail") == 0){
				updatePaperStatus(paperID);
				syncDB();
				in = new Intent(Signup.this, WorkshopDetail.class);
				in.putExtra("paperID", paperID);
				in.putExtra("id", workshopID);
				in.putExtra("title", workshopTitle);
				in.putExtra("date", workshopDate);
				in.putExtra("room", room);
				in.putExtra("bTime", wbtime);
				in.putExtra("eTime", wetime);
				in.putExtra("content", content);
				in.putExtra("childsessionID", childsessionID);
			}
			else if(activityName.compareTo("PosterDetail") == 0){
				updatePaperStatus(paperID);
				syncDB();
				in = new Intent(Signup.this, PosterDetail.class);
				in.putExtra("paperID", paperID);
				in.putExtra("id", workshopID);
				in.putExtra("title", workshopTitle);
				in.putExtra("date", workshopDate);
				in.putExtra("room", room);
				in.putExtra("bTime", wbtime);
				in.putExtra("eTime", wetime);
			}
			else if(activityName.compareTo("MyStaredPapers") == 0){
				updatePaperStatus(paperID);
				syncDB();
				in = new Intent(Signup.this, MyStaredPapers.class);
			}
			else if(activityName.compareTo("MyRecommendedPapers") == 0){
				updatePaperStatus(paperID);
				syncDB();
				in = new Intent(Signup.this, MyRecommendedPapers.class);
			}
			else
			{
				updatePaperStatus(paperID);
				syncDB();
				in = new Intent(Signup.this, MainInterface.class);
			}
			
			startActivity(in);
			this.finish();
		}
	}
	
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case ERRORDIALOG:
			return errorDialog(Signup.this);
		case PERRORDIALOG:
			return pErrorDialog(Signup.this);
		case NERRORDIALOG:
			return nErrorDialog(Signup.this);
		case EERRORDIALOG:
			return eErrorDialog(Signup.this);
		case NPERRORDIALOG:
			return npErrorDialog(Signup.this);
		}
		return null;
	}

	protected void onPrepareDialog(int id, Dialog dialog) {

	}

	private Dialog errorDialog(Context context) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setIcon(edu.pitt.is.UMAP2015.R.drawable.alert_dialog_icon);
		builder.setTitle("Signup");
		builder.setMessage("Signup Error");
		builder.setPositiveButton("ok", null);
		return builder.create();
	}

	private Dialog pErrorDialog(Context context) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setIcon(edu.pitt.is.UMAP2015.R.drawable.alert_dialog_icon);
		builder.setTitle("Signup");
		builder.setMessage("Passwords do not match");
		builder.setPositiveButton("ok", null);
		return builder.create();
	}
	private Dialog npErrorDialog(Context context) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setIcon(edu.pitt.is.UMAP2015.R.drawable.alert_dialog_icon);
		builder.setTitle("Signup");
		builder.setMessage("Please input a password");
		builder.setPositiveButton("ok", null);
		return builder.create();
	}

	private Dialog nErrorDialog(Context context) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setIcon(edu.pitt.is.UMAP2015.R.drawable.alert_dialog_icon);
		builder.setTitle("Signup");
		builder.setMessage("Please input a valid screen name");
		builder.setPositiveButton("ok", null);
		return builder.create();
	}

	private Dialog eErrorDialog(Context context) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setIcon(edu.pitt.is.UMAP2015.R.drawable.alert_dialog_icon);
		builder.setTitle("Signup");
		builder.setMessage("Please input a valid email address");
		builder.setPositiveButton("ok", null);
		return builder.create();
	}
		
		
	}


