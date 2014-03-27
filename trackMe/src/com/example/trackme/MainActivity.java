package com.example.trackme;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		GPSTracker gpsTracker = new GPSTracker(this);
		if (gpsTracker.canGetLocation) {
			TextView tv = (TextView) findViewById(R.id.lat);
			String lat = String.valueOf(gpsTracker.getLatitude());
			String lon = String.valueOf(gpsTracker.getLongitude());
			String disp = lat + ":" + lon;
			
			tv.setText(disp);

		} else {
			// can't get location
			// GPS or Network is not enabled
			// Ask user to enable GPS/network in settings
			gpsTracker.showSettingsAlert();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
