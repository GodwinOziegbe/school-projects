package application;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;
import java.util.Random;

public class SalesControl implements PropertyChangeListener {

	private Date date = new Date();

	@Override
	public void propertyChange(PropertyChangeEvent salesEvt) {
		String activityValue = ((String) salesEvt.getNewValue());
		String activityName = ((String) salesEvt.getPropertyName());
		String activityDate = ((String) date.toLocaleString());
		String activityId = createActivityId();
		ActivityListSetup.getInstance().storeList(activityName, activityValue, activityDate, activityId);

	}

	public String createActivityId() {
		String result = "";
		for (int i = 0; i < 10; i++) {
			result += new Random().nextInt(10);
		}

		return result;
	}

}
