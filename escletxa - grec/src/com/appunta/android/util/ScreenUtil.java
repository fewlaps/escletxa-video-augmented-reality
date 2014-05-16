package com.appunta.android.util;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.util.Log;

public class ScreenUtil {

	// Asus EEE: DisplayMetrics{density=1.0, width=1280, height=752,
	// scaledDensity=1.0, xdpi=160.15764, ydpi=160.0}
	// HTC Tattoo: DisplayMetrics{density=0.75, width=240, height=320,
	// scaledDensity=0.75, xdpi=145.14285, ydpi=145.14285}
	// HTC Hero: DisplayMetrics{density=1.0, width=320, height=480,
	// scaledDensity=1.0, xdpi=180.62222, ydpi=179.29411}
	// SGS: DisplayMetrics{density=1.5, width=480, height=800,
	// scaledDensity=1.5, xdpi=234.46153, ydpi=236.27907}

	public static boolean esTamanyTablet(Activity a) {
		DisplayMetrics metrics = new DisplayMetrics();
		a.getWindowManager().getDefaultDisplay().getMetrics(metrics);

		Log.i("RBLS", metrics.toString());

		if (metrics.widthPixels / metrics.density >= 1280 || metrics.heightPixels / metrics.density >= 1280) {
			return true;
		} else {
			return false;
		}
	}

	private static float density = -1;

	public static float getDensity(Activity a) {
		if (density == -1) {
			DisplayMetrics metrics = new DisplayMetrics();
			a.getWindowManager().getDefaultDisplay().getMetrics(metrics);
			density = metrics.density;
		}
		return density;
	}

	private static int width = -1;

	public static int getWidth(Activity a) {
		if (width != -1) {
			return width;
		}
		DisplayMetrics metrics = new DisplayMetrics();
		a.getWindowManager().getDefaultDisplay().getMetrics(metrics);
		width = metrics.widthPixels;
		return metrics.widthPixels;
	}

	private static int height = -1;

	public static int getHeight(Activity a) {
		if (height != -1) {
			return height;
		}
		DisplayMetrics metrics = new DisplayMetrics();
		a.getWindowManager().getDefaultDisplay().getMetrics(metrics);
		height = metrics.heightPixels;
		return metrics.heightPixels;

	}
}
