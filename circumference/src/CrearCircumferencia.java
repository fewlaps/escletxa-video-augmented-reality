public class CrearCircumferencia {

	public static void main(String[] args) {
		double pi = 3.141592653589793238462643;
		double radi = 0.000001;
		int n = 32;
		for (int i=0; i<n; i++){
			double x = radi * Math.sin(i*2*pi/n);
			double y = radi * Math.cos(i*2*pi/n);
			System.out.println("points.add(new SimplePoint("+(i+1)+", LocationFactory.createLocation("+x+","+y+",1), renderer, \""+(i+1)+"\"));");
		}
	}
}
