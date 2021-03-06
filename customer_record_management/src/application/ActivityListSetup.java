package application;

import java.util.ArrayList;

public class ActivityListSetup {
	private static ActivityListSetup instance = new ActivityListSetup();
	public ActivityListSetup() {
	}
	public static ActivityListSetup getInstance() {
		return instance;
	}
	ArrayList<Activity>activityList = new ArrayList<Activity>();
	
	public void storeList(String name,String value, String date, String Id) {
	Activity activity = new Activity();
	activity.setActivityName(name);
	activity.setActivityValue(value);
	activity.setActivityDate(date);
	activity.setActivityId(Id);
	activityList.add(activity);
	}
	
	public ArrayList<Activity> getList() {
		
		return activityList;
		
	}
	
}
