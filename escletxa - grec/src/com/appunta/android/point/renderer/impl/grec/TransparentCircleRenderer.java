/*
   Copyright Sergi Martínez (@sergiandreplace)

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

package com.appunta.android.point.renderer.impl.grec;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.appunta.android.orientation.Orientation;
import com.appunta.android.point.Point;
import com.appunta.android.point.renderer.PointRenderer;
import com.appunta.android.point.renderer.impl.DrawablePointRenderer;

/***
 * A simple Point renderer used as default by the compass
 * @author Sergi Martínez
 *
 */
public class TransparentCircleRenderer extends DrawablePointRenderer implements PointRenderer {

	public TransparentCircleRenderer(Resources res, int id) {
		super(res, id);
	}

	private static Paint p = null;
	private static Rect r = null;
	
	@Override
	public void drawPoint(Point point, Canvas canvas, Orientation orientation) {
		if (b==null) {
			
			//Initialize drawing objects
			
			b=BitmapFactory.decodeResource(res, id);
			xOff = b.getWidth()/2;
			yOff = b.getHeight()/2;
			
			p =	new Paint();
			p.setColor(Color.BLACK);
			r = new Rect();
		}
		
		float x = point.getX()-xOff;
		float y = point.getY()-yOff;
		
		canvas.drawBitmap(b, x, y, null);
		
//		r.set(new Float(x-400).intValue(), 0, new Float(x+b.getWidth()+400).intValue(), new Float(y+20).intValue());
//		canvas.drawRect(r, p);
//		
//		r.set(new Float(x-400).intValue(), new Float(y+b.getHeight()-20).intValue(), new Float(x+b.getWidth()+400).intValue(), new Float(y+b.getHeight()+200).intValue());
//		canvas.drawRect(r, p);
//		
//		r.set(new Float(x-400).intValue(), new Float(y-20).intValue(), new Float(x+20).intValue(), new Float(y+b.getHeight()+200).intValue());
//		canvas.drawRect(r, p);
//		
//		r.set(new Float(x+b.getWidth()-20).intValue(), new Float(y-20).intValue(), new Float(x+b.getWidth()+400).intValue(), new Float(y+b.getHeight()+200).intValue());
//		canvas.drawRect(r, p);
	}
}
