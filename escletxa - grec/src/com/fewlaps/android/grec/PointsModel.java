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

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

import com.appunta.android.location.LocationFactory;
import com.appunta.android.point.Point;
import com.fewlaps.android.grec.point.VideoPoint;
import com.fewlaps.android.grec.point.VideoRenderer;

public class PointsModel {
	public static List<Point> getVideoPoints(Activity a) {
		List<Point> points = new ArrayList<Point>();

		points.add(new VideoPoint(7, LocationFactory.createLocation(9.238795325112867E-7, 3.8268343236508983E-7, 1), new VideoRenderer(a.getResources(), R.drawable.fondo1, a), "2", 1));
		points.add(new VideoPoint(15, LocationFactory.createLocation(3.826834323650899E-7, -9.238795325112867E-7, 1), new VideoRenderer(a.getResources(), R.drawable.fondo2, a), "10", 2));
		points.add(new VideoPoint(23, LocationFactory.createLocation(-9.238795325112865E-7, -3.826834323650903E-7, 1), new VideoRenderer(a.getResources(), R.drawable.fondo3, a), "18", 3));
		points.add(new VideoPoint(31, LocationFactory.createLocation(-3.8268343236509036E-7, 9.238795325112865E-7, 1), new VideoRenderer(a.getResources(), R.drawable.fondo4, a), "26", 4));

		return points;
	}
}
