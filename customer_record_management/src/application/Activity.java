package application;

public class Activity {
private String activityName;
private String activityValue;
private String activityDate;
private String activityId;
public String getActivityId() {
	return activityId;
}
public void setActivityId(String activityId) {
	this.activityId = activityId;
}
public Activity() {
	
}
public String getActivityName() {
	return activityName;
}
public void setActivityName(String name) {
	this.activityName = name;
}
public String getActivityValue() {
	return activityValue;
}
public void setActivityValue(String value) {
	this.activityValue = value;
}
public String getActivityDate() {
	return activityDate;
}
public void setActivityDate(String date) {
	this.activityDate = date;
}
}
