package com.fewlaps.android.grec.task;

import android.os.AsyncTask;

import com.fewlaps.android.grec.EscletxaActivity;

public class SleeperTask extends AsyncTask<Void, Void, Void> {
	
	EscletxaActivity activity;
	
	public SleeperTask(EscletxaActivity activity){
		this.activity = activity;
	}
	
	protected Void doInBackground(Void... nothing) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		return null;
	}

	protected void onPostExecute(Void nothing) {
		activity.startVideos();
	}
}