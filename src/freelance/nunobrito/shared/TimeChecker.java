package freelance.nunobrito.shared;

import java.util.Date;

import com.google.gwt.i18n.client.DateTimeFormat;

public class TimeChecker {

	private Date date;
	private Date now = new Date();
	private int numHoursDiff;
	private int numDayDiff;
	private int numMinutesDiff;
	private int numSecondsDiff;

	public TimeChecker(Date date) {
		this.date = date;
	}

	private String secondsLeft(long value) {
		return value + " second(s) ";
	}

	private String minutesLeft(long value) {
		return value + " minute(s) ";
	}

	private String hoursLeft(long value) {
		return value + " hours(s) ";
	}

	private String daysLeft(long value) {
		return value + " day(s) ";
	}

	private String justNow() {
		return "Just Now";
	}

	private String secondsAgo(long value) {
		return value + " second(s) ago";
	}

	private String minutesAgo(long value) {
		return value + " minute(s) ago";
	}

	private String hoursAgo(long value) {
		return value + " hour(s) ago";
	}

	private String daysAgo(long value) {
		return value + " day(s) ago";
	}

	private String yesterday(Date date) {
		return "Yesterday at " + date.toString();
	}

	private String tommorow(Date date2) {
		return "Tommorrow at " + date.toString();
	}

	public String getTimeLeft() {
		long tDate = date.getTime();
		long tNow = now.getTime();

		numDayDiff = (int) (tDate / 86400000.0 - tNow / 86400000.0);
		numHoursDiff = (int) (tDate / 3600000.0 - tNow / 3600000.0);
		numMinutesDiff = (int) (tDate / 60000.0 - tNow / 60000.0);
		numSecondsDiff = (int) (tDate / 1000.0 - tNow / 1000.0);
		if (numSecondsDiff < 60) {
			if (numSecondsDiff <= 0) {
				return "Times up";
			}
			return secondsLeft(numSecondsDiff);
		}
		else {
			if (numMinutesDiff < 60) {
				return minutesLeft(numMinutesDiff) + " " + secondsLeft(numSecondsDiff % 60) + "Left";
			}
			else {
				if (numHoursDiff < 24) {

					return hoursLeft(numHoursDiff) + " " + minutesLeft(numMinutesDiff % 60) + " " + secondsLeft(numSecondsDiff % 60) + "Left";
				}
				else {
					if (numDayDiff < 7) {
						if (numDayDiff == 1) {
							return tommorow(date);
						}
						else {
							return daysLeft(numDayDiff) + hoursLeft(numHoursDiff % 24) + " " + minutesLeft(numMinutesDiff % 60) + " " + secondsLeft(numSecondsDiff % 60) + "Left";
						}
					}
					else {
						return String.valueOf(DateTimeFormat.getFormat("dd MMMM, yyyy HH:MM:SS").format(date));
					}
				}
			}
		}
	}

	public String getTimePassed() {
		long tDate = date.getTime();
		long tNow = now.getTime();

		long numDayDiff = tNow / 86400000 - tDate / 86400000;
		long numHoursDiff = tNow / 3600000 - tDate / 3600000;
		long numMinutesDiff = tNow / 60000 - tDate / 60000;
		long numSecondsDiff = tNow / 1000 - tDate / 1000;

		if (date.equals(now)) {
			return justNow();
		}
		else if (numSecondsDiff < 60) {
			return secondsAgo(numSecondsDiff);
		}
		else {
			if (numMinutesDiff < 60) {
				return minutesAgo(numMinutesDiff);
			}
			else {
				if (numHoursDiff < 24) {
					return hoursAgo(numHoursDiff);
				}
				else {
					if (numDayDiff < 7) {
						if (numDayDiff == 1) {
							return yesterday(date);
						}
						else {
							return daysAgo(numDayDiff);
						}
					}
					else {
						// return date.toString();
						return String.valueOf(DateTimeFormat.getFormat("dd MMMM, yyyy HH:MM:SS").format(date));
					}
				}
			}
		}
	}

}
