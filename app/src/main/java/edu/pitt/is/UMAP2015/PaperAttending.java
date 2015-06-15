package edu.pitt.is.UMAP2015;


import java.util.ArrayList;


import data.Conference;
import data.UserAttendingParse;
import data.UserBreif;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class PaperAttending extends Activity {

    private ArrayList<UserBreif> attendingList;
    private String paperID;
    private ListView list, listview;
    private TextView tv1, tv2;
    private MyListAdapter adapter;
    private UserAttendingParse uap;
    private ProgressDialog pd;
    private String activity, key;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(edu.pitt.is.UMAP2015.R.layout.mystaredpapers);

        Bundle b = getIntent().getExtras();
        if (b != null) {
            paperID = b.getString("id");
            activity = b.getString("activity");
            key = b.getString("key");
        }

        tv1 = (TextView) this.findViewById(edu.pitt.is.UMAP2015.R.id.TextView01);
        tv1.setText("People attending this presentation");
        tv2 = (TextView) this.findViewById(edu.pitt.is.UMAP2015.R.id.TextView02);
        tv2.setText("No attendant information available");


        list = (ListView) this.findViewById(edu.pitt.is.UMAP2015.R.id.ListView01); // real ListView

        //list.setOnScrollListener(this);
        if (isConnect(this)) {
            if (Conference.userSignin) {
                attendingList = null;
                attendingList = new ArrayList<UserBreif>();
                new AsyncAttendingList().execute(attendingList);

            } else {
                Toast.makeText(getApplicationContext(),
                        "Please log in first",
                        Toast.LENGTH_SHORT)
                        .show();
                CallSignin();
            }
        } else {
            new AlertDialog.Builder(this)
                    .setMessage("This porcess requires internet connection, please check your internet connection.")
                    .setPositiveButton("close",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialoginterface, int i) {
                                    dialoginterface.cancel();
                                }
                            })
                    .show();

        }


    }

    private void CallSignin() {
        this.finish();
        Intent in = new Intent(PaperAttending.this, Signin.class);
        in.putExtra("activity", "PaperAttending");
        startActivity(in);
    }

    public final class ViewHolder {
        public TextView firstCharHintTextView, username, status;
        public ImageView photo;
    }

    private class MyListAdapter extends BaseAdapter implements OnItemClickListener {
        private ArrayList<UserBreif> aul;

        public MyListAdapter(ArrayList<UserBreif> ul) {
            this.aul = ul;
        }

        public int getCount() {
            return aul.size();
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(edu.pitt.is.UMAP2015.R.layout.attending_list_item, null);
                holder = new ViewHolder();
                holder.firstCharHintTextView = (TextView) convertView.findViewById(edu.pitt.is.UMAP2015.R.id.text_first_char_hint);
                holder.username = (TextView) convertView.findViewById(edu.pitt.is.UMAP2015.R.id.username);
                holder.status = (TextView) convertView.findViewById(edu.pitt.is.UMAP2015.R.id.status);
                //holder.photo = (ImageView)convertView.findViewById(R.id.photo);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.username.setText(aul.get(position).getusername());
            holder.status.setVisibility(View.GONE);
                /*int idx = position - 1;
	 
	            char previewChar = idx >= 0 ? pList.get(idx).authors.charAt(0) : ' ';   
	            char currentChar = pList.get(position).authors.charAt(0); 
	    
	            char newPreviewChar = Character.toUpperCase(previewChar);  
	            char newCurrentChar = Character.toUpperCase(currentChar);  
	            if (newCurrentChar != newPreviewChar) {   
	                holder.firstCharHintTextView.setVisibility(View.VISIBLE);   
	                holder.firstCharHintTextView.setText(String.valueOf(newCurrentChar));   
	            } else {   
	               
	                holder.firstCharHintTextView.setVisibility(View.GONE);   
	            }*/
            return convertView;
        }

        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
                                long arg3) {
            // TODO Auto-generated method stub
            Intent in = new Intent(PaperAttending.this, UserDetail.class);
            in.putExtra("id", aul.get(pos).getid());
            startActivity(in);
        }

    }

    public void showDialog(String s) {
        pd = ProgressDialog.show(this, "Synchronization", s, true, false);
    }

    public void dismissDialog() {
        pd.dismiss();
    }

    private class AsyncAttendingList extends AsyncTask<ArrayList<UserBreif>, Void, Integer> {

        @Override
        protected void onPreExecute() {
            showDialog("Loading...");
        }

        @Override
        protected Integer doInBackground(ArrayList<UserBreif>... params) {
            // TODO Auto-generated method stub
            uap = new UserAttendingParse();
            attendingList = params[0];
            attendingList = uap.getIdList(paperID);
            return 1;
        }

        @Override
        protected void onPostExecute(Integer result) {
            int state = result.intValue();
            switch (state) {
                case 1:
                    dismissDialog();
                    Toast.makeText(getApplicationContext(),
                            "Done!",
                            Toast.LENGTH_SHORT)
                            .show();
                    if (attendingList.size() != 0) {
                        tv2.setVisibility(View.GONE);
                    } else
                        tv2.setVisibility(View.VISIBLE);
                    adapter = new MyListAdapter(attendingList);
                    list.setAdapter(adapter);
                    list.setOnItemClickListener(adapter);
                    break;
                default:
                    dismissDialog();
                    Toast.makeText(getApplicationContext(),
                            "Error!",
                            Toast.LENGTH_SHORT)
                            .show();
                    if (attendingList.size() != 0) {
                        tv2.setVisibility(View.GONE);
                    } else
                        tv2.setVisibility(View.VISIBLE);
                    adapter = new MyListAdapter(attendingList);
                    list.setAdapter(adapter);
                    list.setOnItemClickListener(adapter);
                    break;
            }
        }
    }

    // private String py[]={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","P","R","S","V","W","X","Y"};
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {

            // Do something.
            if (activity.compareToIgnoreCase("PaperInSession") == 0) {
                this.finish();
                String[] s = key.split("%");
                Intent in = new Intent(this, PaperInSession.class);
                in.putExtra("papersessionID", s[0]);
                in.putExtra("sessionName", s[1]);
                in.putExtra("bTime", s[2]);
                in.putExtra("eTime", s[3]);
                in.putExtra("date", s[4]);
                in.putExtra("room", s[5]);
                startActivity(in);
            } else if (activity.compareToIgnoreCase("MyRecommendedPapers") == 0) {
                this.finish();
                Intent in = new Intent(this, MyRecommendedPapers.class);
                startActivity(in);
            } else if (activity.compareToIgnoreCase("MyScheduledPapers") == 0) {
                this.finish();
                Intent in = new Intent(this, MyScheduledPapers.class);
                in.putExtra("day", key);
                startActivity(in);
            } else if (activity.compareToIgnoreCase("MyStaredPapers") == 0) {
                this.finish();
                Intent in = new Intent(this, MyStaredPapers.class);
                startActivity(in);
            } else if (activity.compareToIgnoreCase("ProceedingsByAuthor") == 0) {
                this.finish();
                Intent in = new Intent(this, Proceedings.class);
                in.putExtra("no", "1");
                startActivity(in);
            } else if (activity.compareToIgnoreCase("ProceedingsByName") == 0) {
                this.finish();
                Intent in = new Intent(this, Proceedings.class);
                in.putExtra("no", "2");
                startActivity(in);
            } else if (activity.compareToIgnoreCase("ProceedingsByType") == 0) {
                this.finish();
                Intent in = new Intent(this, Proceedings.class);
                in.putExtra("no", "3");
                startActivity(in);
            } else if (activity.compareToIgnoreCase("WorkshopDetail") == 0) {
                this.finish();
                String[] s = key.split("%");
                Intent in = new Intent(this, WorkshopDetail.class);
                in.putExtra("id", s[0]);
                in.putExtra("title", s[1]);
                in.putExtra("bTime", s[2]);
                in.putExtra("eTime", s[3]);
                in.putExtra("room", s[4]);
                in.putExtra("date", s[5]);
                in.putExtra("content", s[6]);
                in.putExtra("childsessionID", s[7]);
                startActivity(in);
            } else if (activity.compareToIgnoreCase("PosterDetail") == 0) {
                this.finish();
                String[] s = key.split(";");
                Intent in = new Intent(this, PosterDetail.class);
                in.putExtra("title", s[0]);
                in.putExtra("id", s[1]);
                in.putExtra("date", s[2]);
                in.putExtra("btime", s[3]);
                in.putExtra("etime", s[4]);
                in.putExtra("room", s[5]);
                startActivity(in);
            } else {
                return false;
            }
            return true;

        }

        return super.onKeyDown(keyCode, event);

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
}
