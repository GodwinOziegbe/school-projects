package landskidstavling;

import javafx.scene.text.Text;

public class Timers {

	int min = 0, sec = 0, milli = 0;

	String printMinutes, printSeconds, printMilliSeconds, time;

	int timeInSeconds = 0;

	public void changetime(Text text) {

		if (milli == 1000) {
			timeInSeconds++;
			sec++;
			milli = 0;
		}
		if (sec == 60) {
			min++;
			sec = 0;
		}
		if (min < 10) {
			printMinutes = "0" + min + ":";
		} else {
			printMinutes = "" + min + ":";
		}

		if (sec < 10) {
			printSeconds = "0" + sec + ",";
		} else {
			printSeconds = "" + sec + ",";
		}

		if (milli < 10) {
			printMilliSeconds = "00" + milli++;
		} else if (milli < 100) {
			printMilliSeconds = "0" + milli++;
		} else {
			printMilliSeconds = "" + milli++;
		}

		text.setText(printMinutes + printSeconds + printMilliSeconds);

		if (sec < 10) {
			printSeconds = "0" + sec + ".";
		} else {
			printSeconds = "" + sec + ".";
		}
		time = "       " + printMinutes + printSeconds + printMilliSeconds;

	}

}
