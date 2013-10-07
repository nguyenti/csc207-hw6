package edu.grinnell.csc207.nguyenti.ushahidi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

/**
 * 
 * @author tiffanynguyen
 * 
 *         Citations:
 *         http://stackoverflow.com/questions/5170794/click-listener-on-listview
 * 
 */

public class MainActivity extends Activity {
	
	public final static String INPUT = "edu.grinnell.csc207.nguyenti.ushahidi.MESSAGE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void getInstallation(View v) throws Exception {
		EditText text = (EditText) findViewById(R.id.editText1);
		String input = text.getText().toString();
		Intent intent = new Intent(this, Information.class);
		intent.putExtra(INPUT, input);
		startActivity(intent);
		/*try {
			//test if input is a valid Ushahidi URL
			@SuppressWarnings("unused")
			UshahidiClient webclient = new UshahidiWebClient(input);
			Intent intent = new Intent(this, Information.class);
			startActivity(intent);
		} catch (Exception e) {
			e.printStackTrace();
			AlertDialog error = new AlertDialog.Builder(this).create();
			error.setCancelable(false);
			error.setMessage("Invalid URL");
			//check
			error.setButton(1, "OK", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.dismiss();
				}
			});
			error.show();
		}*/
	}

	public void onClick(View v) {
		// MediaPlayer play = MediaPlayer.create(getApplicationContext(),
		// R.raw.lionrawr);
		// play.start();
	}

}
