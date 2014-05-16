/*
   Copyright Fewlaps (@fewlaps)

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */

package com.fewlaps.android.grec;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import android.widget.VideoView;

import com.appunta.android.location.LocationFactory;
import com.appunta.android.orientation.Orientation;
import com.appunta.android.orientation.OrientationManager;
import com.appunta.android.orientation.OrientationManager.OnOrientationChangedListener;
import com.appunta.android.point.Point;
import com.appunta.android.ui.AppuntaView.OnPointPressedListener;
import com.appunta.android.ui.EyeView;
import com.appunta.android.ui.RadarView;
import com.fewlaps.android.grec.task.SleeperTask;

public class EscletxaActivity extends Activity implements OnOrientationChangedListener, OnPointPressedListener, OnPreparedListener {

	private EyeView ar;
	private OrientationManager compass;

	float x, y, z;
	private List<Point> points;

	public static final String PATH_1 = "rtsp://184.72.239.149/vod/mp4:BigBuckBunny_115k.mov";
	public static final String PATH_2 = "rtsp://184.72.239.149/vod/mp4:BigBuckBunny_115k.mov";
	public static final String PATH_3 = "rtsp://184.72.239.149/vod/mp4:BigBuckBunny_115k.mov";
	public static final String PATH_4 = "rtsp://184.72.239.149/vod/mp4:BigBuckBunny_115k.mov";

	public static VideoView mPreview1;
	public static VideoView mPreview2;
	public static VideoView mPreview3;
	public static VideoView mPreview4;
	public static View mPreview1top;
	public static View mPreview2top;
	public static View mPreview3top;
	public static View mPreview4top;
	public static float mVideoDimen;

	public WifiManager mWifiManager;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.ar);

		mVideoDimen = getResources().getDimension(R.dimen.video);

		compass = new OrientationManager(this);
		compass.setAxisMode(OrientationManager.MODE_AR);
		compass.setOnOrientationChangeListener(this);
		compass.startSensor(this);

		ar = (EyeView) findViewById(R.id.augmentedView1);
		ar.setMaxDistance(3);
		ar.setOnPointPressedListener(this);

		points = PointsModel.getVideoPoints(this);

		ar.setPoints(points);
		ar.setPosition(LocationFactory.createLocation(0, 0, 1));
		ar.setOnPointPressedListener(this);

	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);

	}

	@Override
	protected void onPause() {
		super.onPause();
		compass.stopSensor();

		finish();
	}

	public void startVideos() {
		mPreview1.setVideoURI(Uri.parse(PATH_1));
		mPreview1.setOnPreparedListener(this);

		mPreview2.setVideoURI(Uri.parse(PATH_2));
		mPreview2.setOnPreparedListener(this);

		mPreview3.setVideoURI(Uri.parse(PATH_3));
		mPreview3.setOnPreparedListener(this);

		mPreview4.setVideoURI(Uri.parse(PATH_4));
		mPreview4.setOnPreparedListener(this);
	}

	@Override
	protected void onResume() {
		super.onResume();

		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		findViewById(R.id.surface_1).setSystemUiVisibility(View.STATUS_BAR_HIDDEN);

		compass.startSensor(this);

		mPreview1top = findViewById(R.id.surface_1_top);
		mPreview2top = findViewById(R.id.surface_2_top);
		mPreview3top = findViewById(R.id.surface_3_top);
		mPreview4top = findViewById(R.id.surface_4_top);

		mPreview1 = (VideoView) findViewById(R.id.surface_1);
		mPreview2 = (VideoView) findViewById(R.id.surface_2);
		mPreview3 = (VideoView) findViewById(R.id.surface_3);
		mPreview4 = (VideoView) findViewById(R.id.surface_4);

		// Gestiona la connexió Wifi
		mWifiManager = (WifiManager) getBaseContext().getSystemService(Context.WIFI_SERVICE);
		if (!mWifiManager.isWifiEnabled()) {
			mWifiManager.setWifiEnabled(true);
		}

		SleeperTask task = new SleeperTask(this);
		task.execute();
	}

	long lastOrientationChanged = -1;

	@Override
	public void onOrientationChanged(Orientation orientation) {
		ar.setOrientation(orientation);
		ar.setPhoneRotation(OrientationManager.getPhoneRotation(this));
	}

	@Override
	public void onPointPressed(Point p) {
		Toast.makeText(this, p.getName(), Toast.LENGTH_SHORT).show();
		unselectAllPoints();
		p.setSelected(true);
	}

	private void unselectAllPoints() {
		for (Point point : points) {
			point.setSelected(false);
		}
	}

	@Override
	public void onPrepared(MediaPlayer mp) {
		mp.start();
	}
}
