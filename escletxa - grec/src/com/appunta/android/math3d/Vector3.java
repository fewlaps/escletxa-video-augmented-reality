/*
   Copyright Sergi Mart�nez (@sergiandreplace)

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

package com.appunta.android.math3d;

/**
 * A two-dimensions vector
 * @author Sergi Mart�nez
 *
 */
public class Vector3 {
	public double x;
	public double y;
	public double z;
	
	public Vector3() {
		
	}
	
	/**
	 * Constructor with pre-filled values
	 * @param x X-axis coordinate
	 * @param y Y-axis coordinate
	 * @param z Z-axis coordinate
	 */
	public Vector3(double x, double y, double z) {
		this.x=x;
		this.y=y;
		this.z=z;
	}
	

}
