package hypertext2014.com;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import data.Conference;
import data.DBAdapter;
import data.Paper;
import data.Session;
import data.UserScheduledToServer;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.TextView;

public class WorkshopDetail extends Activity implements Runnable{
	private String wtitle, wid,wbtime, wetime,room, date,content,childsessionID;
	private TextView tv,t1,t2,t3,t4,button;
	private WebView wv;
	private ExpandableListView lv;
	private DBAdapter db;
	private UserScheduledToServer us2s;
	private String paperStatus;
	private ProgressDialog pd;
	private ImageButton ib;
	private String paperID;
	private int Pos,pos;
	private MyListViewAdapter adapter;
	private ArrayList<ArrayList<Paper>> pList= new ArrayList<ArrayList<Paper>>();
	private ArrayList<Session> sList;
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

		setContentView(R.layout.workshopdetail);
		
		us2s = new UserScheduledToServer();

		Bundle b = getIntent().getExtras();
		if (b != null) {
			wid = b.getString("id");
			wtitle = b.getString("title");
			wbtime = b.getString("bTime");
			wetime = b.getString("eTime");
			room = b.getString("room");
			date = b.getString("date");
			content = b.getString("content");
			childsessionID = b.getString("childsessionID");
		}

		tv = (TextView) findViewById(R.id.TextView);
		tv.setText("Workshop");
		
		t1 = (TextView) findViewById(R.id.TextView01);
		t1.setText(wtitle);
		
		SimpleDateFormat sdfSource = new SimpleDateFormat("HH:mm");
    	SimpleDateFormat sdfDestination = new SimpleDateFormat("h:mm a");
    	Date beginDate, endDate;
    	String begTime, endTime;
    	try {
    	beginDate = sdfSource.parse(wbtime);
		endDate = sdfSource.parse(wetime);
		begTime = sdfDestination.format(beginDate);
		endTime = sdfDestination.format(endDate);
		t2 = (TextView)this.findViewById(R.id.TextView02);
		t2.setText(date+"\t"+begTime+"-"+endTime);
    	}catch (Exception e) {
    		System.out.println("Date Exception");
    	}

    	t3 = (TextView) findViewById(R.id.TextView03);
		t4 = (TextView) findViewById(R.id.TextView04);
		 if(room.compareToIgnoreCase("NULL")==0){
         	t3.setVisibility(View.GONE);
		 	t4.setVisibility(View.GONE);
		 }
         else{
         	t3.setVisibility(View.VISIBLE);	
         	t4.setVisibility(View.VISIBLE);	
         	t4.setText(room);
         }
	
		String[] sidlist = childsessionID.split(";");
		
		sList = getSessionData(sidlist);

		for(int i=0; i<sList.size();i++){
			pList.add(getPaperData(sList.get(i).ID));
		}

		HeaderView listheaderview = new HeaderView(this);
		listheaderview.setWebView(content);
		wv= (WebView) listheaderview.findViewById(R.id.WebView01);
		/*wv.getSettings().setJavaScriptEnabled(true);
		wv.loadData(content, "text/html", "utf-8");*/
		
		button = (TextView) listheaderview.findViewById(R.id.expandbutton);
		button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				if(wv.getVisibility()== View.GONE){
				wv.setVisibility(View.VISIBLE);
				button.setCompoundDrawablesWithIntrinsicBounds(R.drawable.bullet_arrow_down, 0, 0, 0);
				}
				else if(wv.getVisibility() == View.VISIBLE){
					wv.setVisibility(View.GONE);
					button.setCompoundDrawablesWithIntrinsicBounds(R.drawable.bullet_arrow_up,0,0,0);
				}
			}});
		lv = (ExpandableListView) findViewById(R.id.ListView01);
		lv.addHeaderView(listheaderview);
		adapter = new MyListViewAdapter(sList, pList);
		lv.setAdapter(adapter);
		for(int i=0; i<sList.size();i++){
			lv.expandGroup(i);}
	}
	public ArrayList<Session> getSessionData(String[] s){
		ArrayList<Session> sessions= new ArrayList<Session>();
		db = new DBAdapter(this);
		
		db.open();
		sessions = db.getSessionByidList(s);
		db.close();
		
		return sessions;
	}
	public ArrayList<Paper> getPaperData(String sessionID){
		ArrayList<Paper> papers = new ArrayList<Paper>();
		// get data at local
		db = new DBAdapter(this);
		db.open();
		papers = db.getPapersBysessionID(sessionID);
		db.close();

		return papers;
	}

	public String getUserID()
	{
		String id = "";
		
		try
		{
			SharedPreferences getUserID = getSharedPreferences("userinfo", 0);
			id = getUserID.getString("userID", "");
		}
		catch(Exception e){}
		
		if(id.compareTo("")!=0)
			Conference.userSignin = true;
		return id;
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
			itemintent.setClass(WorkshopDetail.this, MainInterface.class);
			startActivity(itemintent);
			return true;
		case MENU_SESSION:
			this.finish();
			itemintent.setClass(WorkshopDetail.this, ProgramByDay.class);
			startActivity(itemintent);
			return true;
		case MENU_STAR:
			this.finish();
			itemintent.setClass(WorkshopDetail.this, MyStaredPapers.class);
			startActivity(itemintent);
			return true;
		case MENU_TRACK:
			this.finish();
			itemintent.setClass(WorkshopDetail.this, Proceedings.class);
			startActivity(itemintent);
			return true;
		case MENU_SCHEDULE:
			this.finish();
			itemintent.setClass(WorkshopDetail.this, MyScheduledPapers.class);
			startActivity(itemintent);
			return true;
		}
		return false;
	}



	private void CallSignin() {
		Intent in = new Intent(WorkshopDetail.this, Signin.class);
		in.putExtra("activity", "WorkshopDetail");
		in.putExtra("id", wid);
		in.putExtra("wtitle", wtitle);
		in.putExtra("paperID", paperID);
		in.putExtra("wbtime", wbtime);
		in.putExtra("wetime", wetime);
		in.putExtra("date", date);
		in.putExtra("room", room);
		in.putExtra("content", content);
		in.putExtra("childsessionID", childsessionID);
		startActivity(in);
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

	public final  class ViewHolder {   
        TextView firstCharHintTextView, title, location;
    	TextView t1, t2, t3,type;
    	ImageButton star, schedule;
  
    } 

	private class MyListViewAdapter extends BaseExpandableListAdapter implements
	OnClickListener{
		private ArrayList<Session> parents;
		private ArrayList<ArrayList<Paper>> childs;
		
	public MyListViewAdapter(ArrayList<Session> parent, ArrayList<ArrayList<Paper>> child){
		this.parents=parent;
		this.childs=child;
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
			convertView = li.inflate(R.layout.paperitem, null);
			vh = new ViewHolder();
			vh.t1 = (TextView) convertView.findViewById(R.id.time);
			vh.t2 = (TextView) convertView.findViewById(R.id.title);
			vh.t2.setOnClickListener(this);				
			vh.t3 = (TextView) convertView.findViewById(R.id.author);
			vh.type = (TextView) convertView.findViewById(R.id.type);
			vh.schedule = (ImageButton) convertView
					.findViewById(R.id.ImageButton01);
			vh.star = (ImageButton) convertView
					.findViewById(R.id.ImageButton02);

			convertView.setTag(vh);
		} else {
			vh = (ViewHolder) convertView.getTag();
		}
		try {
			beginDate = sdfSource.parse(childs.get(parentPos).get(childPos).exactbeginTime);
			endDate = sdfSource.parse(childs.get(parentPos).get(childPos).exactendTime);
			begTime = sdfDestination.format(beginDate);
			endTime = sdfDestination.format(endDate);
			vh.t1.setText(childs.get(parentPos).get(childPos).date+"\t"+begTime + " - " + endTime);
		} catch (Exception e) {
			System.out.println("Date Exception");
		}
		if (childs.get(parentPos).get(childPos).scheduled.compareTo("yes") == 0)
			vh.schedule.setImageResource(R.drawable.yes_schedule);
		else
			vh.schedule.setImageResource(R.drawable.no_schedule);
		vh.schedule.setFocusable(false);
		vh.schedule.setOnClickListener(this);
		vh.schedule.setTag(childs.get(parentPos).get(childPos).id+";"+parentPos+";"+childPos);
		
		if (childs.get(parentPos).get(childPos).starred.compareTo("yes") == 0)
			vh.star.setImageResource(R.drawable.yes_star);
		else
			vh.star.setImageResource(R.drawable.no_star);
		vh.star.setFocusable(false);
		vh.star.setOnClickListener(this);
		vh.star.setTag(childs.get(parentPos).get(childPos).presentationID+";"+parentPos+";"+childPos);
		
		if (childs.get(parentPos).get(childPos).recommended.compareTo("yes") == 0)
			vh.t2.setText(Html.fromHtml(childs.get(parentPos).get(childPos).title+"<font color=\"#ff0000\"> &lt;Recommended&gt; </font>"));
			else
				vh.t2.setText(childs.get(parentPos).get(childPos).title);
		vh.t2.setTag(parentPos+";"+childPos);
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
            convertView = getLayoutInflater().inflate(R.layout.sessionitem, null);   
            holder = new ViewHolder();   
            holder.firstCharHintTextView = (TextView) convertView.findViewById(R.id.text_first_char_hint);            
            holder.title = (TextView) convertView.findViewById(R.id.title);	
            holder.location = (TextView) convertView.findViewById(R.id.location);
	
            convertView.setTag(holder);
        } else {   
            holder = (ViewHolder) convertView.getTag();   
        }   
        
        holder.title.setText(parents.get(parentPos).name);
        
        if(parents.get(parentPos).room.compareToIgnoreCase("NULL")==0)
        	holder.location.setVisibility(View.GONE);
        else{
        	holder.location.setVisibility(View.VISIBLE);	
        holder.location.setText("At "+parents.get(parentPos).room);
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
		case R.id.ImageButton01:
			ib = (ImageButton) v;
			String s = ib.getTag().toString();
			String st[] = s.split(";");
			paperID = st[0];
			Pos= Integer.parseInt(st[1]);
			pos= Integer.parseInt(st[2]);
			Conference.userID = getUserID();
			if (Conference.userSignin) {
				paperStatus = "";
				callThread();
			} else {
				CallSignin();
			}
			break;
		case R.id.ImageButton02:
			ib = (ImageButton) v;
			String s1 = ib.getTag().toString();
			String st1[] = s1.split(";");
			paperID = st1[0];
			Pos = Integer.parseInt(st1[1]);
			pos = Integer.parseInt(st1[2]);
			
			if (getPaperStarred(paperID).compareTo("no") == 0) {
				ib.setImageResource(R.drawable.yes_star);
				updateUserPaperStatus(paperID, "yes", "star");
				insertMyStarredPaper(paperID);
				childs.get(Pos).get(pos).starred= "yes";
				this.notifyDataSetChanged();
				
			} else {
				ib.setImageResource(R.drawable.no_star);
				updateUserPaperStatus(paperID, "no", "star");
				deleteMyStarredPaper(paperID);
				childs.get(Pos).get(pos).starred= "no";
				this.notifyDataSetChanged();
				
			}
			
			break;
		case R.id.title:
			int idx,idxs;
			tv = (TextView) v;
			String s2 = tv.getTag().toString();
			String st2[] = s2.split(";");
			idx= Integer.parseInt(st2[0]);
			idxs= Integer.parseInt(st2[1]);
			
			WorkshopDetail.this.finish();
			Intent in = new Intent(WorkshopDetail.this, PaperDetail.class);
			in.putExtra("id", childs.get(idx).get(idxs).id);
			in.putExtra("title", childs.get(idx).get(idxs).title);
			in.putExtra("authors", childs.get(idx).get(idxs).authors);
			in.putExtra("date", childs.get(idx).get(idxs).date);
			in.putExtra("abstract", childs.get(idx).get(idxs).paperAbstract);
			in.putExtra("room", room);
			in.putExtra("contentlink",childs.get(idx).get(idxs).contentlink);
			in.putExtra("bTime", childs.get(idx).get(idxs).exactbeginTime);
			in.putExtra("eTime", childs.get(idx).get(idxs).exactendTime);
			in.putExtra("presentationID", childs.get(idx).get(idxs).presentationID);
			in.putExtra("activity","WorkshopDetail");
			in.putExtra("key",wid+"%"+wtitle+"%"+wbtime+"%"+wetime+"%"+room+"%"+date+"%"+content+"%"+childsessionID);
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
		public void run() {


			if(getPaperScheduled(paperID).compareTo("yes") == 0){
				paperStatus = us2s.DeleteScheduledPaper2Sever(paperID);
			}
			else {
				paperStatus = us2s.addScheduledPaper2Sever(paperID);
			}			
			handler.sendEmptyMessage(0);
		}

		private Handler handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				pd.dismiss();

					if (paperStatus.compareTo("yes") == 0) {
						ib.setImageResource(R.drawable.yes_schedule);
						updateUserPaperStatus(paperID, "yes", "schedule");
						insertMyScheduledPaper(paperID);

					}
					if (paperStatus.compareTo("no") == 0) {
						ib.setImageResource(R.drawable.no_schedule);
						updateUserPaperStatus(paperID, "no", "schedule");
						deleteMyScheduledPaper(paperID);
					}
				}
		};
 
}
