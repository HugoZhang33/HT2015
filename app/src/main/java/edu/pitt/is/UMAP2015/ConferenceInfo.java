package edu.pitt.is.UMAP2015;

import data.Conference;
import data.DBAdapter;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;


/**
 * Activity for conference_general layout
 * "About"  item on HOME screen
 */
public class ConferenceInfo extends Activity {
	
	private DBAdapter db;
	private TextView tw1,tw2,tw3;
	private WebView wv;
	private Button googlemap;

	
	private final int MENU_HOME = Menu.FIRST;
	private final int MENU_TRACK = Menu.FIRST + 1;
	private final int MENU_SESSION = Menu.FIRST + 2;
	private final int MENU_STAR = Menu.FIRST + 3;
	private final int MENU_SCHEDULE = Menu.FIRST + 4;
	private final int MENU_RECOMMEND = Menu.FIRST+5;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(edu.pitt.is.UMAP2015.R.layout.conference_general);

		//Call local DB to get ConferenceInfo
		db = new DBAdapter(this);
		db.open();
		db.getConferenceInfo();
		db.close();
		
		tw1 = (TextView)this.findViewById(edu.pitt.is.UMAP2015.R.id.TextView01);
		tw1.setText(Conference.title);
		
		tw2 = (TextView)this.findViewById(edu.pitt.is.UMAP2015.R.id.TextView02);
		tw2.setText(Conference.startDate+" - "+Conference.endDate);
		
		tw3 = (TextView)this.findViewById(edu.pitt.is.UMAP2015.R.id.TextView04);
		tw3.setText(Conference.location);
		
		//tw4 = (TextView)this.findViewById(R.id.TextView14);
		//tw4.setText(Conference.location1);
		
		wv = (WebView)this.findViewById(edu.pitt.is.UMAP2015.R.id.WebView01);
		wv.getSettings().setJavaScriptEnabled(true);
		wv.loadData(Conference.description, "text/html", "utf-8");
		
		googlemap = (Button) findViewById(edu.pitt.is.UMAP2015.R.id.map);
		googlemap.setOnClickListener(new View.OnClickListener()
		{

			public void onClick(View v) {
				// TODO Auto-generated method stub
				//String location1 = "Hotel Holiday-Inn Montreal"+"420 Sherbrooke Street West Montreal, QC H3A 1B4";
				Intent map = new Intent(Intent.ACTION_VIEW, Uri
						.parse("https://maps.google.com/maps?q=Worthington%20Renaissance%20google%20map&um=1&ie=UTF-8&hl=en&sa=N&tab=wl"));
				startActivity(map);
				
				
			}
			
		}
	);

		/*googlemap2 = (Button) findViewById(R.id.map1);		
		googlemap2.setOnClickListener(new View.OnClickListener()
		{

			public void onClick(View v) {
				// TODO Auto-generated method stub
				String location2 = "Universit??? du Qu???bec ??? Montr???al"+"Workshops @45.50967,-73.570129";
				Intent map2 = new Intent(Intent.ACTION_VIEW, Uri
						.parse("http://maps.google.com/maps?q=" + location2));
				startActivity(map2);				
			}
			
		}
	);*/
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
			this.finish();
			Intent in = new Intent(ConferenceInfo.this, MainInterface.class);
			startActivity(in);
		}

		return super.onKeyDown(keyCode, event);
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, MENU_HOME, 0, "Home").setIcon(edu.pitt.is.UMAP2015.R.drawable.home);
		menu.add(0, MENU_TRACK, 0, "Proceedings").setIcon(edu.pitt.is.UMAP2015.R.drawable.proceedings);
		menu.add(0, MENU_SESSION, 0, "Schedule").setIcon(edu.pitt.is.UMAP2015.R.drawable.session);
		menu.add(0, MENU_STAR, 0, "My Favorite").setIcon(edu.pitt.is.UMAP2015.R.drawable.star);
		menu.add(0, MENU_SCHEDULE, 0, "My Schedule").setIcon(edu.pitt.is.UMAP2015.R.drawable.schedule);
		menu.add(0, MENU_RECOMMEND, 0, "Recommendation").setIcon(edu.pitt.is.UMAP2015.R.drawable.recommends);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		Intent itemintent = new Intent();
		switch (item.getItemId()) {
		case MENU_HOME:
			this.finish();
			itemintent.setClass(ConferenceInfo.this, MainInterface.class);
			startActivity(itemintent);
			return true;
		case MENU_SESSION:
			this.finish();
			itemintent.setClass(ConferenceInfo.this, ProgramByDay.class);
			startActivity(itemintent);
			return true;
		case MENU_STAR:
			this.finish();
			itemintent.setClass(ConferenceInfo.this, MyStaredPapers.class);
			startActivity(itemintent);
			return true;
		case MENU_TRACK:
			this.finish();
			itemintent.setClass(ConferenceInfo.this, Proceedings.class);
			startActivity(itemintent);
			return true;
		case MENU_SCHEDULE:
			this.finish();
			itemintent.setClass(ConferenceInfo.this, MyScheduledPapers.class);
			startActivity(itemintent);
			return true;
		case MENU_RECOMMEND:
			this.finish();
			itemintent.setClass(ConferenceInfo.this, MyRecommendedPapers.class);
			startActivity(itemintent);
			return true;
		}
		return false;
	}

}
