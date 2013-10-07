package edu.grinnell.csc207.nguyenti.ushahidi;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import edu.grinnell.glimmer.ushahidi.UshahidiClient;
import edu.grinnell.glimmer.ushahidi.UshahidiIncident;
import edu.grinnell.glimmer.ushahidi.UshahidiUtils;
import edu.grinnell.glimmer.ushahidi.UshahidiWebClient;

public class Information extends Activity {
	
	static String[] incidents = new String[5];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_information);

		try {
			Intent intent = getIntent();
			String installation = intent.getStringExtra(MainActivity.INPUT);
			new CreateListAsync().execute(installation);
			listAdapter = new ArrayAdapter<String>(this, R.layout.simple_row,
					incidents);
			infoList.setAdapter(listAdapter);
			setContentView(infoList);
			Log.e("MyActivity", "post createList");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.e("MyActivity", "break createList");
		}
	}
	
	class CreateListAsync extends AsyncTask<String, Void, Void> {
		
		protected Void doInBackground(String...strings) {
			try {
				String input = strings[0];
				Log.e("", "Begin createList");
				// Grab the listView object from the xml
				infoList = (ListView) findViewById(R.id.listView1);
				Log.e("", "post input " + input);
				UshahidiClient webclient = UshahidiUtils.SAMPLE_CLIENT;
				Log.e("", "post webclient");
				String[] listIncident = new String[5];
				Log.e("Info", "pre-loop");
				UshahidiIncident incident;
				for (int i = 0; i < 5 && webclient.hasMoreIncidents(); i++) {
					incident = webclient.nextIncident();
					listIncident[i] = "Incident #: " + incident.getId() + "\n"
							+ "\tTitle: " + incident.getTitle();
				}
				Log.e("l", "Post-loop");
				Information.incidents = listIncident;
				return null;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
	}

	private ListView infoList;
	private ArrayAdapter<String> listAdapter;

//	public static ushahidiInfo incidentAsString(UshahidiIncident incident) {
//		String idNumber = "Incident #: " + incident.getId();
//		String title = "\tTitle: " + incident.getTitle() + "\n";
//		String description = "\tDescription: " + incident.getDescription();
//		String date = "\tDate: " + (incident.getDate().get(Calendar.MONTH) + 1)
//				+ "/" + incident.getDate().get(Calendar.DATE) + "/"
//				+ incident.getDate().get(Calendar.YEAR) + "\n";
//		String location = "\tLocation: " + incident.getLocation() + "\n";
//		String status = "\tStatus: (" + incident.getMode() + ", "
//				+ incident.getActive() + ", " + incident.getVerified() + ")";
//		ushahidiInfo data = new ushahidiInfo(idNumber, title, description,
//				date, location, status);
//		return data;
//	} // incidentAsString

	public void createList(String input) throws Exception {
		Log.e("", "Begin createList");
		// Grab the listView object from the xml
		infoList = (ListView) findViewById(R.id.listView1);
		Log.e("", "post input " + input);
		UshahidiClient webclient = new UshahidiWebClient(input);
		Log.e("", "post webclient");
		String[] listIncident = new String[5];
		Log.e("Info", "pre-loop");
		UshahidiIncident incident;
		for (int i = 0; i < 5 && webclient.hasMoreIncidents(); i++) {
			incident = webclient.nextIncident();
			listIncident[i] = "Incident #: " + incident.getId() + "\n"
					+ "\tTitle: " + incident.getTitle();
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
