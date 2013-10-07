package edu.grinnell.csc207.nguyenti.ushahidi;

public class ushahidiInfo {

	protected String idNum;
	protected String tit;
	protected String desc;
	protected String dat;
	protected String loc;
	protected String stat;

	public ushahidiInfo(String id, String title, String description, String date,
			String location, String status) {
		idNum = id;
		tit = title;
		desc = description;
		dat = date;
		loc = location;
		stat = status;
	}

}
