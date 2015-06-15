package hypertext2014.com;



import java.util.ArrayList;


import data.DBAdapter;
import data.Workshop;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class Workshops extends Activity {
	private ArrayList<Workshop> wList;
	private DBAdapter db;
	private ListView lv;
	private TextView t1;
	
	private final int MENU_HOME = Menu.FIRST;
	private final int MENU_TRACK = Menu.FIRST + 1;
	private final int MENU_SESSION = Menu.FIRST + 2;
	private final int MENU_STAR = Menu.FIRST + 3;
	private final int MENU_SCHEDULE = Menu.FIRST + 4;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.track);
		
		t1 = (TextView) findViewById(R.id.TextView01);
		t1.setText("Workshops");
		
		ListViewAdapter adapter;
		db = new DBAdapter(this);
		db.open();
		
		wList = new ArrayList<Workshop>();	
		wList = db.getWorkshopsDes();

		db.close();
		
		adapter = new ListViewAdapter(wList);
		
		lv = (ListView) findViewById(R.id.ListView01);
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView av, View v, int pos, long arg) {
				
				Intent in = new Intent(Workshops.this, WorkshopDetail.class);
				//in.putExtra("day_id", buttonNum);
				in.putExtra("id", wList.get(pos).ID);
				in.putExtra("title", wList.get(pos).name);
				in.putExtra("date", wList.get(pos).date);
				in.putExtra("bTime", wList.get(pos).beginTime);
				in.putExtra("eTime", wList.get(pos).endTime);
				in.putExtra("room", wList.get(pos).room);
				in.putExtra("content", wList.get(pos).content);
				in.putExtra("childsessionID", wList.get(pos).childsessionID);
				startActivity(in);
				
				
			}
		});
		
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
			this.finish();
			Intent in = new Intent(Workshops.this, MainInterface.class);
			startActivity(in);
		}

		return super.onKeyDown(keyCode, event);
	}
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, MENU_HOME, 0, "Home").setIcon(R.drawable.home);
		menu.add(0, MENU_TRACK, 0, "Proceedings").setIcon(R.drawable.proceedings);
		menu.add(0, MENU_SESSION, 0, "Schedule").setIcon(R.drawable.session);
		menu.add(0, MENU_STAR, 0, "My Favorite").setIcon(R.drawable.star);
		menu.add(0, MENU_SCHEDULE, 0, "My Schedule").setIcon(R.drawable.schedule);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		Intent itemintent = new Intent();
		switch (item.getItemId()) {
		case MENU_HOME:
			this.finish();
			itemintent.setClass(Workshops.this, MainInterface.class);
			startActivity(itemintent);
			return true;
		case MENU_SESSION:
			this.finish();
			itemintent.setClass(Workshops.this, ProgramByDay.class);
			startActivity(itemintent);
			return true;
		case MENU_STAR:
			this.finish();
			itemintent.setClass(Workshops.this, MyStaredPapers.class);
			startActivity(itemintent);
			return true;
		case MENU_TRACK:
			this.finish();
			itemintent.setClass(Workshops.this, Proceedings.class);
			startActivity(itemintent);
			return true;
		case MENU_SCHEDULE:
			this.finish();
			itemintent.setClass(Workshops.this, MyScheduledPapers.class);
			startActivity(itemintent);
			return true;
		}
		return false;
	}
	
	static class ViewHolder
	{
		TextView t1,t2,t3,firstCharHintTextView;
	}
	private class ListViewAdapter extends BaseAdapter {
		ArrayList<Workshop> wList;
		public ListViewAdapter(ArrayList w) {
			this.wList = w;
		}

		public int getCount() {
			return wList.size();
		}

		public Object getItem(int position) {
			return position;
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder v = null;
			if (convertView == null) {
				LayoutInflater li = getLayoutInflater();
				convertView = li.inflate(R.layout.sessionitem, null);
				v = new ViewHolder();
				v.t1= (TextView)convertView.findViewById(R.id.title);
				v.t3 = (TextView)convertView.findViewById(R.id.location);
				v.firstCharHintTextView =(TextView)convertView.findViewById(R.id.text_first_char_hint);
				convertView.setTag(v);
			}
			else {
				v = (ViewHolder) convertView.getTag();
			}
			v.t1.setText(wList.get(position).name);
			if(wList.get(position).room.compareToIgnoreCase("NULL")==0)
            	v.t3.setVisibility(View.GONE);
            else{
            	v.t3.setVisibility(View.VISIBLE);	
            	v.t3.setText("At "+wList.get(position).room);
            }
			
			int idx = position - 1;   
			 
            String preview = idx >= 0 ? wList.get(idx).date : "";   
            String current = wList.get(position).date;
      
            if (current.compareTo(preview) == 0) {
            	v.firstCharHintTextView.setVisibility(View.GONE);   
            } else {   
               
            	v.firstCharHintTextView.setVisibility(View.VISIBLE);
            	v.firstCharHintTextView.setText(wList.get(position).date); 
            }
			return convertView;
		}
	}
}
