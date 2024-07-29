package MandlebrotSetGUI;

public class ComplexNumber {
	private double r;
	private double i;
	
	//default constructor
public ComplexNumber() {
		
}
	
	//constructor with two doubles, real and imaginary value
public ComplexNumber(double r, double i) {
	this.r = r;
	this.i = i;
}
	
	//constructor with ComplexNumber, takes real and imaginary values from passed in ComplexNumber
public ComplexNumber(ComplexNumber rhs) {
	this.r = rhs.r;
	this.i = rhs.i;		
}
	
	//sets value of THIS complex r
public void setReal(double r) {
	this.r = r;
}
	
	//sets value of THIS complex i
public void setImag(double i) {
	this.i = i;
		
}
	
	//returns the real part
public double getReal() {
	return r;
		
}
	
	//returns the imaginary part
public double getImag() {
	return i;
		
}
	
public ComplexNumber add(ComplexNumber rhs) {
	ComplexNumber c = new ComplexNumber(0,0);
	c.r = this.r + rhs.r;
	c.i = this.i + rhs.i;
	return c;
}
public ComplexNumber sub(ComplexNumber rhs) {
	ComplexNumber c = new ComplexNumber(0,0);
	c.r = this.r - rhs.r;
	c.i = this.i - rhs.i;
	return c;
}
public ComplexNumber mult(ComplexNumber rhs) {
	ComplexNumber c = new ComplexNumber(0,0);
	c.r = this.r * rhs.r - this.i * rhs.i;
	c.i = this.r * rhs.i + this.i * rhs.r;
	return c;
}
	
public ComplexNumber div(ComplexNumber rhs) throws IllegalArgumentException {
	ComplexNumber c = new ComplexNumber(0,0);
	if (rhs.r == 0 && rhs.i == 0) {
		System.out.print("Denominator cannot be 0" + "\n");
	} else {
		double denominator = Math.pow(rhs.r, 2) + Math.pow(rhs.i, 2);
		c.r = (this.r * rhs.r + this.i * rhs.i) / denominator;
		c.i = (this.i * rhs.r - this.r * rhs.i) / denominator;
		return c;
}
		return c;
}
	
public double mag() {
	return Math.sqrt(r*r + i*i);
}
public ComplexNumber conj() {
	return new ComplexNumber(r, -i);
}
	
public ComplexNumber sqrt() {
	ComplexNumber c = new ComplexNumber(0,0);
	if (i != 0) {
		c.r = Math.sqrt((r + Math.sqrt(r * r + i * i))/2);
		c.i = Math.sqrt((-r + Math.sqrt(r * r + i * i))/2);
	} else if (i == 0) {
		if (r >= 0) {
			c.r = Math.sqrt(r);
			c.i = 0;
		} else if (r < 0) {
			c.r = 0;
			c.i = Math.sqrt(-r);
	}
			
	}
		return c;
		
    }
	
	//to string, runs when you print the value of a ComplexNumber, System.out.print(ComplexNum);
	//if the imaginary number is 0 then just print the real number
	//other wise print the corresponding - or + if for the value
	@Override
	public String toString() {
		if (this.i == 0) {
			return this.r + "";
		} else if (this.i  > 0) {
			return this.r  + " + " + this.i + "i";
		} else {
			return this.r + " - " + -this.i + "i";
		}
		
	}
	
	//takes a ComplexNumber and compared it's r and i to the the r and i of this
	public boolean equals(ComplexNumber rhs) {
		if (this.r == rhs.r && i == rhs.i) {
			return true;
		} else {
			return false;
		}
		
		
	}
public static void main (String[] args) {
		ComplexNumber lhs = new ComplexNumber(1, 2);
		ComplexNumber rhs = new ComplexNumber(3, 4);
		
		ComplexNumber result;
		
		result = lhs.add(rhs);
		System.out.println("(" + lhs + ")" + " + (" + rhs + ") = " + result);
		
		result = lhs.sub(rhs);
		System.out.println("(" + lhs + ")" + " - (" + rhs + ") = " + result);

		result = lhs.mult(rhs);
		System.out.println("(" + lhs + ")" + " * (" + rhs + ") = " + result);
		
		result = lhs.div(rhs);
		System.out.println("(" + lhs + ")" + " / (" + rhs + ") = " + result);
		
		try {
			rhs = new ComplexNumber();
			result = lhs.div(rhs);
			System.out.println(lhs + " / " + rhs + " = " + result);
		}
		catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		
		
		System.out.println("|" + lhs + "| = " + lhs.mag());
		System.out.println("~(" + lhs + ") = " + lhs.conj());
		System.out.println("(" + lhs + ")^-2 = " + lhs.sqrt());
		lhs.setReal(-25);
		lhs.setImag(0);
		System.out.println("(" + lhs + ")^-2 = " + lhs.sqrt());
		System.out.println("(" + lhs + ") == (" + rhs + ") is " + lhs.equals(rhs));
		
		rhs.setReal(1);
		rhs.setImag(2);
		System.out.println("(" + lhs + ") == (" + rhs + ") is " + lhs.equals(rhs));

		System.out.println(lhs.getReal() + " " + lhs.getImag());

}
}


