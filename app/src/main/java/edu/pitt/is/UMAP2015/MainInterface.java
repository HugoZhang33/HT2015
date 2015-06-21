package edu.pitt.is.UMAP2015;


import data.CheckDBUpdate;
import data.Conference;
import data.DBAdapter;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainInterface extends Activity {

    private ImageButton syncB;
    //private ImageButton syncC;
    private DBAdapter db;
    private ProgressDialog pd;
    private Spinner spinner2;
    private ArrayAdapter adapter2;

    private void checkUpdate() {
        CheckDBUpdate checkDBUpdate = new CheckDBUpdate();
        syncB = (ImageButton) findViewById(edu.pitt.is.UMAP2015.R.id.ImageButton01);
        if (checkDBUpdate.check()) {
            syncB.setImageResource(R.drawable.need_update);
        } else {
            syncB.setImageResource(R.drawable.update);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkUpdate();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(edu.pitt.is.UMAP2015.R.layout.main_interface);
        //setContentView(R.layout.spinner);

//        spinner2 = (Spinner) findViewById(R.id.spinner1);

        db = new DBAdapter(this);
//        adapter2 = ArrayAdapter.createFromResource(this, R.array.conference_array, android.R.layout.simple_spinner_item);

        db.open().getConferenceInfo();

        syncB = (ImageButton) findViewById(edu.pitt.is.UMAP2015.R.id.ImageButton01);
        //syncC = (ImageButton) findViewById(R.id.button1);
        syncB.setOnClickListener(new View.OnClickListener() {
                                     public void onClick(View view) {
                                         Intent in = new Intent(MainInterface.this, UpdateOption.class);
                                         startActivity(in);
                                     }
                                 }
        );


        //Row 1
        GridView gv1 = (GridView) findViewById(edu.pitt.is.UMAP2015.R.id.GridView01);
//        Integer[] i1 = {edu.pitt.is.UMAP2015.R.drawable.about, edu.pitt.is.UMAP2015.R.drawable.keynote, edu.pitt.is.UMAP2015.R.drawable.sessionbig, edu.pitt.is.UMAP2015.R.drawable.proceeding};
        Integer[] i1 = {R.drawable.about, R.drawable.keynote, R.drawable.poster, R.drawable.workshop, R.drawable.sessionbig, R.drawable.proceeding};
        String[] t1 = {"About", "Keynotes", "Poster", "Workshop", "Schedule", "Proceedings"};
        gv1.setAdapter(new ImageViewAdapter(this, i1, t1));

        gv1.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView av, View v, int index, long arg) {
                Intent in;
                switch (index) {
                    // Conference General
                    case 0:
                        in = new Intent(MainInterface.this, ConferenceInfo.class);
                        startActivity(in);
                        break;
                    // Keynotes
                    case 1:
                        in = new Intent(MainInterface.this, KeyNote.class);
                        startActivity(in);
                        break;
                    // Poster
                    case 2:
                        in = new Intent(MainInterface.this, Posters.class);
                        startActivity(in);
                        break;
                    // Workshop
                    case 3:
                        in = new Intent(MainInterface.this, Workshops.class);
                        startActivity(in);
                        break;
                    // Schedule
                    case 4:
                        in = new Intent(MainInterface.this, ProgramByDay.class);
                        startActivity(in);
                        break;
                    // Proceedings
                    case 5:
                        in = new Intent(MainInterface.this, Proceedings.class);
                        startActivity(in);
                        break;
                    default:
                        break;
                }
            }
        });

        //Row 2
        GridView gv4 = (GridView) findViewById(edu.pitt.is.UMAP2015.R.id.GridView04);

        if (Conference.userID.compareTo("") != 0) {
            Integer[] i4 = {edu.pitt.is.UMAP2015.R.drawable.starbig, edu.pitt.is.UMAP2015.R.drawable.schedulebig, edu.pitt.is.UMAP2015.R.drawable.logout};
            String[] t4 = {"Favorite", "Schedule", "Log Out"};
            gv4.setAdapter(new ImageViewAdapter(this, i4, t4));

            gv4.setOnItemClickListener(new OnItemClickListener() {
                public void onItemClick(AdapterView av, View v, int index, long arg) {
                    Intent in;
                    switch (index) {
                        // Starred Papers
                        case 0:
                            in = new Intent(MainInterface.this, MyStaredPapers.class);
                            startActivity(in);
                            break;
                        // Sessions
                        case 1:
                            in = new Intent(MainInterface.this, MyScheduledPapers.class);
                            startActivity(in);
                            break;

                        case 2:
                            Conference.userID = "";
                            Conference.userSignin = false;
                            SharedPreferences userinfo = getSharedPreferences("userinfo", 0);
                            SharedPreferences.Editor editor = userinfo.edit();
                            editor.putString("userID", "");
                            //
                            editor.putBoolean("userSignin", false);
                            editor.commit();
                            CharSequence msg = "You've signed out successfully.";
                            int dur = Toast.LENGTH_SHORT;
                            Toast t = Toast.makeText(getApplicationContext(), msg, dur);
                            t.show();
                            finish();//
                            startActivity(getIntent());//
                            break;
                        default:
                            break;

                    }
                }
            });

        } else {
            Integer[] i4 = {edu.pitt.is.UMAP2015.R.drawable.starbig, edu.pitt.is.UMAP2015.R.drawable.schedulebig, edu.pitt.is.UMAP2015.R.drawable.login};
            String[] t4 = {"Favorite", "Schedule", "Log In"};
            gv4.setAdapter(new ImageViewAdapter(this, i4, t4));

            gv4.setOnItemClickListener(new OnItemClickListener() {
                public void onItemClick(AdapterView av, View v, int index, long arg) {
                    Intent in;
                    switch (index) {
                        // Starred Papers
                        case 0:
                            in = new Intent(MainInterface.this, MyStaredPapers.class);
                            startActivity(in);
                            break;
                        // Sessions
                        case 1:
                            in = new Intent(MainInterface.this, MyScheduledPapers.class);
                            startActivity(in);
                            break;

                        case 2:
                            CallSignin();
                            break;
                        default:
                            break;
                    }
                }
            });
        }
        checkUpdate();
    }

    private void CallSignin() {
        this.finish();
        Intent in = new Intent(MainInterface.this, Signin.class);
        in.putExtra("activity", "MainInterface");
        startActivity(in);
    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    // Fires after the OnStop() state
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            finish();
            Intent home = new Intent(Intent.ACTION_MAIN);
            home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            home.addCategory(Intent.CATEGORY_HOME);
            startActivity(home);
        }

        return super.onKeyDown(keyCode, event);
    }

    private class ImageViewAdapter extends BaseAdapter {
        private Context mContext;
        private Integer[] mThumbIds;
        private String[] mText;

        public ImageViewAdapter(Context c, Integer[] i, String[] t) {
            mContext = c;
            mThumbIds = i;
            mText = t;
        }

        public int getCount() {
            return mThumbIds.length;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View v;
            if (convertView == null) {
                LayoutInflater li = getLayoutInflater();
                v = li.inflate(edu.pitt.is.UMAP2015.R.layout.imagetext, null);
                TextView tv = (TextView) v.findViewById(edu.pitt.is.UMAP2015.R.id.TextView01);
                tv.setText(mText[position]);
                ImageView iv = (ImageView) v.findViewById(edu.pitt.is.UMAP2015.R.id.ImageView01);
                iv.setImageResource(mThumbIds[position]);
            } else {
                v = convertView;
            }

            return v;
        }
    }
}
