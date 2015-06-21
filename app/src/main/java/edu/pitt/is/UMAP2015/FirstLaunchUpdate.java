package edu.pitt.is.UMAP2015;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import data.CheckDBUpdate;
import data.Conference;
import data.ConferenceInfoParser;
import data.DBAdapter;
import data.Keynote;
import data.KeynoteWorkshopParser;
import data.LoadPaperFromDB;
import data.LoadSessionFromDB;
import data.Paper;
import data.PaperContent;
import data.PaperContentParse;
import data.Poster;
import data.Session;
import data.Workshop;

public class FirstLaunchUpdate extends Activity {


    private ProgressDialog pd;
    private DBAdapter db;
    private TextView session, keynote, presentation, paper, success, sync;
    private AlertDialog ad;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.first_launch_update);
        db = new DBAdapter(this);

        new AsyncUpdate().execute();
    }

    public void showDialog(String s) {
        pd = ProgressDialog.show(this, "Synchronization", s, true, false);
    }

    public void dismissDialog() {
        pd.dismiss();
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

    private class AsyncUpdate extends AsyncTask<Void, Integer, Integer> {
        protected void onPreExcute() {
        }

        @Override
        protected Integer doInBackground(Void... arg0) {
            // TODO Auto-generated method stub
            int state = 0;

            // get timestamp
            String timestamp = new CheckDBUpdate().getTimestamp();

            ConferenceInfoParser.getConferenceInfo("134");
            db.open();
            db.deleteConference();
            long errorr = db.insertConference(Conference.id, Conference.title, Conference.startDate,
                    Conference.endDate, Conference.location, Conference.description, timestamp);
            if (errorr == -1)
                System.out.println("Insertion ConferenceInfo Failed");
            db.close();

            //execute update
            if (true) {
                ArrayList<Session> sList = new ArrayList<Session>();
                ArrayList<Paper> pList = new ArrayList<Paper>();
                ArrayList<PaperContent> pcList = new ArrayList<PaperContent>();
                ArrayList<Keynote> knList = new ArrayList<Keynote>();
                ArrayList<Workshop> wsList = new ArrayList<Workshop>();
                ArrayList<Poster> poList = new ArrayList<Poster>();

                //Update keynote and workshop info
                publishProgress(14);
                KeynoteWorkshopParser knp = new KeynoteWorkshopParser();
                knp.getData();

                knList = knp.getKenotes();
                wsList = knp.getWorkshops();
                poList = knp.getPosters();
                if (knList.size() != 0 && wsList.size() != 0) {
                    publishProgress(12);
                } else {
                    publishProgress(13);
                }

                //Update session info
                publishProgress(6);
                LoadSessionFromDB sdbr = new LoadSessionFromDB();
                sList = sdbr.getSessionData();
                if (sList.size() != 0) {
                    publishProgress(0);
                } else {
                    publishProgress(1);
                }

                //Update presentation info
                publishProgress(7);
                LoadPaperFromDB pdbr = new LoadPaperFromDB();
                pList = pdbr.getPaperData();
                if (pList.size() != 0) {
                    publishProgress(2);
                } else {
                    publishProgress(3);
                }

                //Update paper content info
                publishProgress(8);
                PaperContentParse pcp = new PaperContentParse();
                pcList = pcp.getData();
                if (pcList.size() != 0) {
                    publishProgress(4);
                } else {
                    publishProgress(5);
                }

                if (wsList.size() != 0 && knList.size() != 0 && sList.size() != 0 && pList.size() != 0 && pcList.size() != 0) {
                    try {
                        db.open();
                        db.deleteKeynote();
                        db.deleteWorkshopDes();
                        db.deletePoster();
                        db.deleteSession();
                        db.deletePaper();
                        db.deletePaperContent();

                        for (int i = 0; i < wsList.size(); i++) {
                            long error = db.insertWorkshopDes(wsList.get(i));
                            if (error == -1)
                                System.out.println("error occured");
                        }

                        for (int i = 0; i < knList.size(); i++) {
                            long error = db.insertKeynote(knList.get(i));
                            if (error == -1)
                                System.out.println("error occured");
                        }

                        for (int i = 0; i < poList.size(); i++) {
                            long error = db.insertPoster(poList.get(i));
                            if (error == -1)
                                System.out.println("error occured");
                        }

                        for (int i = 0; i < sList.size(); i++) {
                            long error = db.insertSession(sList.get(i));
                            if (error == -1)
                                System.out.println("Insertion Failed session");
                        }
                        for (int i = 0; i < pList.size(); i++) {
                            long error = db.insertPaper(pList.get(i));
                            if (error == -1)
                                System.out.println("Insertion Failed session");
                        }
                        for (int i = 0; i < pcList.size(); i++) {
                            if (pcList.get(i).authors == null || pcList.get(i).authors == "") {
                                pcList.get(i).authors = "No author information available";
                            }
                            if (pcList.get(i).type == null || pcList.get(i).type == "") {
                                pcList.get(i).type = "No type information available";
                            }
                            if (pcList.get(i).title == null || pcList.get(i).title == "") {
                                pcList.get(i).title = "No title information available";
                            }
                            if (pcList.get(i).paperAbstract == null || pcList.get(i).paperAbstract == "") {
                                pcList.get(i).paperAbstract = "No abstract information available";
                            }
                            long error = db.insertPaperContent(pcList.get(i));
                            if (error == -1)
                                System.out.println("Insert paper content error occured");
                        }
                        db.close();
                    } catch (Exception e) {
                        System.out.print(e.getMessage());
                    }
                    state += 1;//success
                } else {
                    state = 2;//error
                }
            } else {
                state = 0;
            }

            return state;
        }

        protected void onProgressUpdate(Integer... progress) {
            session = (TextView) findViewById(edu.pitt.is.UMAP2015.R.id.sessionupdate);
            presentation = (TextView) findViewById(edu.pitt.is.UMAP2015.R.id.presentationupdate);
            paper = (TextView) findViewById(edu.pitt.is.UMAP2015.R.id.paperupdate);
//            sync = (TextView) findViewById(edu.pitt.is.UMAP2015.R.id.papersync);
            keynote = (TextView) findViewById(edu.pitt.is.UMAP2015.R.id.keynoteupdate);
            int command = progress[0];
            switch (command) {
                case 0:
                    session.setCompoundDrawablesWithIntrinsicBounds(edu.pitt.is.UMAP2015.R.drawable.accept, 0, 0, 0);
                    session.setText("Update introduction,keynote,workshop information: success!");
                    break;
                case 1:
                    session.setCompoundDrawablesWithIntrinsicBounds(edu.pitt.is.UMAP2015.R.drawable.error, 0, 0, 0);
                    session.setText("Fail to update introduction,keynote,workshop information");
                    break;
                case 2:
                    presentation.setCompoundDrawablesWithIntrinsicBounds(edu.pitt.is.UMAP2015.R.drawable.accept, 0, 0, 0);
                    presentation.setText("Update presentation information: success!");
                    break;
                case 3:
                    presentation.setCompoundDrawablesWithIntrinsicBounds(edu.pitt.is.UMAP2015.R.drawable.error, 0, 0, 0);
                    presentation.setText("Fail to update presentation information");
                    break;
                case 4:
                    paper.setCompoundDrawablesWithIntrinsicBounds(edu.pitt.is.UMAP2015.R.drawable.accept, 0, 0, 0);
                    paper.setText("Update paper information: success!");
                    break;
                case 5:
                    paper.setCompoundDrawablesWithIntrinsicBounds(edu.pitt.is.UMAP2015.R.drawable.error, 0, 0, 0);
                    paper.setText("Fail to update paper information");
                    break;
                case 6:
                    session.setCompoundDrawablesWithIntrinsicBounds(edu.pitt.is.UMAP2015.R.drawable.db_refresh, 0, 0, 0);
                    session.setText("Updating introduction,keynote,workshop information ...");
                    break;
                case 7:
                    presentation.setCompoundDrawablesWithIntrinsicBounds(edu.pitt.is.UMAP2015.R.drawable.db_refresh, 0, 0, 0);
                    presentation.setText("Updating presentation information ...");
                    break;
                case 8:
                    paper.setCompoundDrawablesWithIntrinsicBounds(edu.pitt.is.UMAP2015.R.drawable.db_refresh, 0, 0, 0);
                    paper.setText("Updating paper information ...");
                    break;
                case 12:
                    keynote.setCompoundDrawablesWithIntrinsicBounds(edu.pitt.is.UMAP2015.R.drawable.accept, 0, 0, 0);
                    keynote.setText("Update keynote & workshop information: success!");
                    break;
                case 13:
                    keynote.setCompoundDrawablesWithIntrinsicBounds(edu.pitt.is.UMAP2015.R.drawable.error, 0, 0, 0);
                    keynote.setText("Fail to update keynote & workshop information");
                    break;
                case 14:
                    keynote.setCompoundDrawablesWithIntrinsicBounds(edu.pitt.is.UMAP2015.R.drawable.db_refresh, 0, 0, 0);
                    keynote.setText("Updating keynote & workshop information ...");
                    break;
                default:
                    break;

            }

        }

        protected void onPostExecute(Integer state) {
            success = (TextView) findViewById(edu.pitt.is.UMAP2015.R.id.success);
            switch (state) {
                case 1:
                    Toast.makeText(getApplicationContext(),
                            "UMAP 2015 has Updated!",
                            Toast.LENGTH_LONG)
                            .show();

                    success.setText("Update Success!");
                    finish();
                    Intent intent = new Intent(FirstLaunchUpdate.this, MainInterface.class);
                    startActivity(intent);
                    break;
                case 2:
                    Toast.makeText(getApplicationContext(),
                            "Server error, please try again.",
                            Toast.LENGTH_LONG)
                            .show();

                    success.setText("Update Fail!");
                    break;
                case 0:
                    Toast.makeText(getApplicationContext(),
                            "Is the latest data, server last update was on " + Conference.timstamp,
                            Toast.LENGTH_LONG)
                            .show();

                    success.setText("No need to update.");
                    break;
                default:
                    break;
            }
        }
    }
}
