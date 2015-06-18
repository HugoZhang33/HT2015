package edu.pitt.is.UMAP2015;


import java.util.ArrayList;


import data.CheckDBUpdate;
import data.Conference;
import data.ConferenceInfoParser;
import data.DBAdapter;
import data.Keynote;
import data.Paper;
import data.PaperContent;
import data.Poster;
import data.Session;
import data.UserScheduleParse;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class iConference2012 extends Activity {
    private Handler mHandler = new Handler();
    private TextView status;
    private ImageView imageview;
    private DBAdapter db;

    public int alpha = 255;
    public int b = 0;
    private Handler handler = new Handler();


    /**
     * Called when the activity is first created.
     */



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(edu.pitt.is.UMAP2015.R.layout.main);

        imageview = (ImageView) this.findViewById(edu.pitt.is.UMAP2015.R.id.Logo);
        imageview.setAlpha(alpha);
        status = (TextView) this.findViewById(edu.pitt.is.UMAP2015.R.id.status);

        //new AsyncDB().doInBackground();
        //updateApp();
        new Thread(new Runnable() {
            public void run() {
                initApp(); // Run at first time, load data
                while (b < 2) {
                    try {
                        if (b == 0) {
                            Thread.sleep(100);
                            b = 1;
                        } else {
                            Thread.sleep(10);
                        }

                        updateApp();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();

        mHandler = new Handler() {
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                imageview.setAlpha(alpha);
                //status.invalidate();
            }
        };

    }

    public void updateApp() {
        alpha -= 5;
        if (alpha <= 0) {
            b = 2;
            finish();
            Intent in = new Intent(this, MainInterface.class);
            startActivity(in);
        }

        mHandler.sendMessage(mHandler.obtainMessage());
    }

    public void initApp() {

        boolean isFirst = true;
        try {
            SharedPreferences firstRun = getSharedPreferences("dataLoaded", 0);
            if (firstRun.getString("dataLoaded", "").compareTo("") != 0) {
                isFirst = false;
            }
        } catch (Exception e) {
            isFirst = true;
        }

        if (isFirst) {

            status.setVisibility(View.VISIBLE);

            SharedPreferences firstRun = getSharedPreferences("dataLoaded", 0);
            firstRun.edit().putString("dataLoaded", "created").commit();

            ArrayList<Keynote> kList = new ArrayList<Keynote>();
//            ArrayList<Workshop> wListDes = new ArrayList<Workshop>();
            ArrayList<Poster> poList = new ArrayList<Poster>();
            ArrayList<Paper> pList = new ArrayList<Paper>();
            ArrayList<Session> sList = new ArrayList<Session>();
            ArrayList<PaperContent> pcList = new ArrayList<PaperContent>();

            db = new DBAdapter(this);

            //ConferenceDataLoad cdl = new ConferenceDataLoad();

            //check internet access
            /*if(isConnect(this)){

			CheckDBUpdate cdbu = new CheckDBUpdate();
			cdbu.compare();
			
			LoadPaperFromDB lpdb = new LoadPaperFromDB();
			pList = lpdb.getPaperData();
			
			LoadSessionFromDB lsdb = new LoadSessionFromDB();
			sList = lsdb.getSessionData();
			
			PaperContentParse pcp = new PaperContentParse();
			pcList = pcp.getData();
			}
			else{*/
            //status.setText("Can not downlaod data from server, please check internet connection.");
            //pList = cdl.loadPapers();
            //sList = cdl.loadSessions();
            //pcList = cdl.loadPaperContents();
            //}

            //cdl.loadConferenceInfo();
            //kList = cdl.loadKeynote();
            //wListDes = cdl.loadWorkshopsDes();
            //poList = cdl.loadPoster();

            try {
                ConferenceInfoParser.getConferenceInfo("134");
                db.open();
                db.insertConference(Conference.id, Conference.title,
                        Conference.startDate, Conference.endDate,
                        Conference.location, Conference.description, Conference.timstamp);
                for (int i = 0; i < kList.size(); i++) {
                    long error = db.insertKeynote(kList.get(i));
                    if (error == -1)
                        System.out.println("error occured");
                }

                for (int i = 0; i < sList.size(); i++) {
                    long error = db.insertSession(sList.get(i));
                    if (error == -1)
                        System.out.println("error occured");
                }

                for (int i = 0; i < pList.size(); i++) {
                    long error = db.insertPaper(pList.get(i));
                    if (error == -1)
                        System.out.println("error occured");
                }
                for (int i = 0; i < pcList.size(); i++) {
                    if (pcList.get(i).authors == null || pcList.get(i).authors == "") {
                        pcList.get(i).authors = "No author information available";
                    }
                    long error = db.insertPaperContent(pcList.get(i));
                    if (error == -1)
                        System.out.println("error occured");
                }
//                for (int i = 0; i < wListDes.size(); i++) {
//                    long error = db.insertWorkshopDes(wListDes.get(i));
//                    if (error == -1)
//                        System.out.println("error occured");
//                }
                for (int i = 0; i < poList.size(); i++) {
                    long error = db.insertPoster(poList.get(i));
                    if (error == -1)
                        System.out.println("error occured");
                }
                db.close();
            } catch (Exception e) {
                System.out.print(e.getMessage());
            } finally {
                db.close();
            }
        }
		/*else{

			if(isConnect(this)){
			boolean needUpdate;
			CheckDBUpdate cdbu = new CheckDBUpdate();
			needUpdate = cdbu.compare();
			if (needUpdate){
				
			ArrayList<Session> sList = new ArrayList<Session>();
			ArrayList<Paper> pList = new ArrayList<Paper>();
			ArrayList<PaperContent> pcList = new ArrayList<PaperContent>();
			
			LoadSessionFromDB ls=new LoadSessionFromDB();
			sList = ls.getSessionData();
			LoadPaperFromDB lp=new LoadPaperFromDB();
			pList = lp.getPaperData();
			
			PaperContentParse pcp = new PaperContentParse();
			pcList = pcp.getData();
			
			try{
			db= new DBAdapter(this);
			db.open();
			db.daleteSession();
			db.daletePaper();
			db.daletePaperContent();
			
			for (int i = 0; i < sList.size(); i++) {
				long error = db.insertSession(sList.get(i));
				if (error == -1)
					System.out.println("error occured");
			}
			for (int i = 0; i < pList.size(); i++) {
				long error = db.insertPaper(pList.get(i));
				if (error == -1)
					System.out.println("error occured");
			}
			for (int i = 0; i < pcList.size(); i++) {
				long error = db.insertPaperContent(pcList.get(i));
				if (error == -1)
					System.out.println("error occured");
			}
			}
			catch (Exception e) {
				System.out.print(e.getMessage());
			}
		}
			}
			else{
			}
		}*/
        if (isConnect(this)) {
            SharedPreferences getUserID = getSharedPreferences("userinfo", 0);
            String userID = getUserID.getString("userID", "");

            if (userID.compareTo("") != 0) {
                Conference.userSignin = true;
                Conference.userID = userID;

                //Conference.userID = "17";

                ArrayList<String> pidList = new ArrayList<String>();
                //ArrayList<String> pidRList = new ArrayList<String>();

                UserScheduleParse usp = new UserScheduleParse();
                //RecommendParse rp = new RecommendParse();
                pidList = usp.getData();
                //pidRList = rp.getRecom();
                if (pidList.size() == 0) {
                    showToast("Fail to connect server when update personal schedule,please update in 'My Schedule'");
                    //TextView status1 = (TextView) findViewById(R.id.status1);
                    //status1.setVisibility(View.VISIBLE);
                } else {
                    try {
			
			/*
			db= new DBAdapter(this);
			db.open();
			String userID = db.getUserID();
			db.close();
			*/
			
			
			/*SharedPreferences getUserID = getSharedPreferences("userinfo", 0);
			String userID = getUserID.getString("userID", "");
			
			if (userID.compareTo("") != 0) {
				Conference.userSignin = true;
				Conference.userID = userID;
				
				//Conference.userID = "17";
				
				ArrayList<String> pidList = new ArrayList<String>();
				//ArrayList<String> pidRList = new ArrayList<String>();
				
				UserScheduleParse usp = new UserScheduleParse();
				//RecommendParse rp = new RecommendParse();
				pidList = usp.getData();
				//pidRList = rp.getRecom();*/

                        db = new DBAdapter(this);
                        db.open();
                        db.updatePaperScheduleToDefault();
                        //db.updatePaperRecommendToDefault();
                        db.deleteUserScheduled();
                        //db.daleteUserRecommended();

                        for (int i = 0; i < pidList.size(); i++) {
                            db.insertMyScheduledPaper(pidList.get(i).toString());
                            db.updatePaperBySchedule(pidList.get(i).toString(), "yes");
                        }
				/*for(int i =0;i<pidRList.size();i++)
				{
					db.insertMyRecommendedPaper(pidRList.get(i).toString());
					db.updatePaperByRecommend(pidRList.get(i).toString(), "yes");
				}*/

                        db.close();

                    } catch (Exception e) {
                    }
                }
            } else {
                showToast("Not signin when update personal schedule, please update in 'My Schedule'");
                //TextView status2 = (TextView) findViewById(R.id.status2);
                //status2.setVisibility(View.VISIBLE);
            }
        } else {
            showToast("No internet connection when update personal schedule, please check your internet connection");
            //TextView status3 = (TextView) findViewById(R.id.status3);
            //status3.setVisibility(View.VISIBLE);
        }
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

    public void showToast(final String s) {
        handler.post(new Runnable() {

            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), s,
                        Toast.LENGTH_LONG).show();

            }
        });
    }
}