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

package com.fewlaps.android.grec.point;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.widget.VideoView;

import com.appunta.android.orientation.Orientation;
import com.appunta.android.point.Point;
import com.appunta.android.point.renderer.PointRenderer;
import com.appunta.android.point.renderer.impl.DrawablePointRenderer;
import com.appunta.android.util.ScreenUtil;

/***
 * A VideoPoint renderer. It doesn't draw a point: It moves the VideoView that
 * is actually playing that video.
 * 
 * @author Roc Boronat
 */

public class VideoRenderer extends DrawablePointRenderer implements PointRenderer {

	private static int fake_in = 0;
	private static int fake_out = 0;
	private static float density = 0;

	public VideoRenderer(Resources res, int id, Activity a) {
		super(res, id);

		density = ScreenUtil.getDensity(a);
		fake_in = (int) (20 * density);
		fake_out = (int) (400 * density);

	}

	private static Paint p = null;
	private static Rect r = null;

	private static float fx = -1;
	private static float fy = -1;

	private static int ix = -1;
	private static int iy = -1;

	private static int width = -1;
	private static int height = -1;

	@Override
	public void drawPoint(Point point, Canvas canvas, Orientation orientation) {

		// Inicialitzem variables
		if (b == null) {
			b = BitmapFactory.decodeResource(res, id);

			width = b.getWidth();
			height = b.getHeight();

			p = new Paint();
			p.setColor(Color.BLACK);

			r = new Rect();
		}

		// Movem el video
		if (point instanceof VideoPoint) {
			VideoPoint vp = (VideoPoint) point;
			VideoView v = vp.getVideoView();
			View vt = vp.getVideoViewTop();

			fx = point.getX();
			fy = point.getY();

			fy = fy / 10;

			if (v != null && v.isPlaying()) {
				v.setX(fx + 80 / density);
				vt.setX(fx + 80 / density);
				v.setY(fy + 100 / density);
				vt.setY(fy + 100 / density);
			}

			ix = (int) fx;
			iy = (int) fy;

			// amunt
			r.set(ix - fake_out, iy - fake_out, ix + width + fake_out, iy + fake_in);
			canvas.drawRect(r, p);

			// avall
			r.set(ix - fake_out, iy + height - fake_in, ix + width + fake_out, iy + height + fake_out);
			canvas.drawRect(r, p);

			// esquerra
			r.set(ix - fake_out, iy - fake_out, ix + fake_in, iy + height + fake_out);
			canvas.drawRect(r, p);

			// dreta
			r.set(ix + width - fake_in, iy - fake_out, ix + width + fake_out, iy + height + fake_out);
			canvas.drawRect(r, p);

			canvas.drawBitmap(b, fx, fy, null);
		} else {
			// throw new Exception("VideoRenderer only works with VideoPoints");
			// //No cumpleix la firma...
			Log.e("VideoRenderer", "VideoRenderer only works with VideoPoints");
		}
	}
}
