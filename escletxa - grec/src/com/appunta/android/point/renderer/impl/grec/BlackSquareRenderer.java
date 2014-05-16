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

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.appunta.android.orientation.Orientation;
import com.appunta.android.point.Point;
import com.appunta.android.point.renderer.PointRenderer;

/***
 * A simple Point renderer used as default by the compass
 * @author Sergi Martínez
 *
 */
public class BlackSquareRenderer implements PointRenderer {

	private static Paint p = null;
	private static Rect r = null;
	
	@Override
	public void drawPoint(Point point, Canvas canvas, Orientation orientation) {
		if (p==null){
			p =	new Paint();
			p.setColor(Color.BLACK);
			r = new Rect();
		}
		int x = new Float(point.getX()).intValue();
		r.set(x-200, 0, x+200, 1200);
		canvas.drawRect(r, p);
	}
}
