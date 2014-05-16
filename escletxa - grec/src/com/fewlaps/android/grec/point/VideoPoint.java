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

import android.location.Location;
import android.view.View;
import android.widget.VideoView;

import com.appunta.android.point.Point;
import com.appunta.android.point.impl.SimplePoint;
import com.appunta.android.point.renderer.PointRenderer;
import com.fewlaps.android.grec.EscletxaActivity;

/***
 * A single point representing a place, it contains information on where it's
 * located in space, in screen, it's id and name and the name of the renderer to
 * use to draw it. It also has an URI to a Video located on the Internet.
 * 
 * @author Roc Boronat
 * @date 2012/06/27
 *
 */
public class VideoPoint extends SimplePoint implements Point {

	private int video;
	
	public VideoPoint(int id, Location location, PointRenderer renderer, String name, int video) {
		super(id, location, renderer, name);
		setVideo(video);
	}

	public VideoView getVideoView() {
		int v = getVideo();
		if (v==1){
			return EscletxaActivity.mPreview1;
		} else if (v==2){
			return EscletxaActivity.mPreview2;
		}else if (v==3){
			return EscletxaActivity.mPreview3;
		} else if (v==4){
			return EscletxaActivity.mPreview4;
		}
		return null;
	}
	
	public View getVideoViewTop() {
		int v = getVideo();
		if (v==1){
			return EscletxaActivity.mPreview1top;
		} else if (v==2){
			return EscletxaActivity.mPreview2top;
		}else if (v==3){
			return EscletxaActivity.mPreview3top;
		} else if (v==4){
			return EscletxaActivity.mPreview4top;
		}
		return null;
	}

	public int getVideo() {
		return video;
	}
	public void setVideo(int video) {
		this.video = video;
	}
}
