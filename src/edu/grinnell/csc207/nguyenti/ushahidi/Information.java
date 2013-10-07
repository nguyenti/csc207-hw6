package edu.grinnell.csc207.nguyenti.ushahidi;

import java.util.Calendar;

import edu.grinnell.glimmer.ushahidi.UshahidiClient;
import edu.grinnell.glimmer.ushahidi.UshahidiIncident;
import edu.grinnell.glimmer.ushahidi.UshahidiWebClient;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class Information extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_information);

		try {
			createList();
			Log.e("MyActivity", "post createList");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.e("MyActivity", "break createList");
		}
	}

	private ListView infoList;
	private ArrayAdapter<String> listAdapter;
	private ushahidiInfo info;

	public static ushahidiInfo incidentAsString(UshahidiIncident incident) {
		String idNumber = "Incident #: " + incident.getId();
		String title = "\tTitle: " + incident.getTitle() + "\n";
		String description = "\tDescription: " + incident.getDescription();
		String date = "\tDate: " + (incident.getDate().get(Calendar.MONTH) + 1)
				+ "/" + incident.getDate().get(Calendar.DATE) + "/"
				+ incident.getDate().get(Calendar.YEAR) + "\n";
		String location = "\tLocation: " + incident.getLocation() + "\n";
		String status = "\tStatus: (" + incident.getMode() + ", "
				+ incident.getActive() + ", " + incident.getVerified() + ")";
		ushahidiInfo data = new ushahidiInfo(idNumber, title, description,
				date, location, status);
		return data;
	} // incidentAsString

	public void createList() throws Exception {
		Log.e("", "Begin createList");
		// Grab the listView object from the xml
		infoList = (ListView) findViewById(R.id.listView1);
		final EditText text = (EditText) findViewById(R.id.editText1);
		Log.e("", "edittext");
		String input = text.getText().toString();
		Log.e("", "post input" + input);
		UshahidiClient webclient = new UshahidiWebClient(input);
		Log.e("", "post webclient");
		String[] listIncident = new String[5];
		Log.e("Info", "pre-loop");
		for (int i = 0; i < 5 && webclient.hasMoreIncidents(); i++) {
			listIncident[i] = incidentAsString(webclient.nextIncident()).tit
					+ "\n" + incidentAsString(webclient.nextIncident()).idNum;
		}
		Log.e("l", "Post-loop");
		// Fill the ArrayAdapter with our String array
		listAdapter = new ArrayAdapter<String>(this, R.layout.simple_row,
				listIncident);

		// Get the information from the ArrayAdapter into our list
		infoList.setAdapter(listAdapter);
	} // createList

	public void getInfo(View v) {
		Intent intent = new Intent(this, Information.class);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.information, menu);
		return true;
	}

}
