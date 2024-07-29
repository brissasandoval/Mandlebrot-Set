package MandlebrotSetGUI;

public class LinearInterpolation {
	
	private double[] xValue;
	private double[] yValue;
	
	
	//constructor in java to create instance of class (initalizing objects)
	public LinearInterpolation(double[] xValue, double[] yValue) {
		this.xValue = xValue;
		this.yValue = yValue;
	}
	
	
	//public double = accessible to any class, accessible without creating an object, returning a double value 
	//Class performs linear interpolation for x value 
	public double interpolate(double x) {
		if (x < xValue[0] || x > xValue[xValue.length -1]) {
			//if input value is outside of the range an exception is thrown
			throw new IllegalArgumentException("Value is outside of range.");
		}
		
		for(int i = 0; i < xValue.length - 1; i++) {
			if( x <= xValue [i + 1]) {
				double x0 = xValue[i];
				double x1 = xValue[i + 1];
				double y0 = yValue[i];
				double y1 = yValue[i + 1];
				return y0 + (y1 - y0) * (x - x0) / (x1 = x0);
				
			}
		}
		
		//edge case where x equals the last x-value 
		if( x == xValue[xValue.length - 1]) {
			return yValue[yValue.length - 1];
		}
		
		throw new IllegalArgumentException("Unable to interpolate value.");
		
	}
	
	
	
	public static void main(String[] args) {
		double[] xValue = {0, 1, 2, 3};
        double[] yValue = {1, 3, 2, 4};
        LinearInterpolation interpolator = new LinearInterpolation(xValue, yValue);
        double interpolatedValue = interpolator.interpolate(1.5);
        System.out.println(interpolatedValue);  // Output: 2.5
		
	}

}
