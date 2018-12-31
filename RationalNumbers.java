/*Project Info
	This code was used to create a class of Rational Numbers that has all the properties
	in the mathematical definition
*/

public class RationalNumbers {

	public static void main(String[] args) {//testing program provided by professor

        Rational a = new Rational(2, 4);
        Rational b = new Rational(2, 6);

        System.out.println(a + " + " + b + " = " + a.add(b));
        System.out.println(a + " - " + b + " = " + a.sub(b));
        System.out.println(a + " * " + b + " = " + a.mul(b));
        System.out.println(a + " / " + b + " = " + a.div(b));

        Rational[] arr = {new Rational(7, 1), new Rational(6, 1),
                          new Rational(5, 1), new Rational(4, 1),
                          new Rational(3, 1), new Rational(2, 1),
                          new Rational(1, 1), new Rational(1, 2),
                          new Rational(1, 3), new Rational(1, 4),
                          new Rational(1, 5), new Rational(1, 6),
                          new Rational(1, 7), new Rational(1, 8),
                          new Rational(1, 9), new Rational(0, 1)};

        selectSort(arr);

        for (Rational r : arr) {
            System.out.println(r);
        }

        Number n = new Rational(3, 2);

        System.out.println(n.doubleValue());
        System.out.println(n.floatValue());
        System.out.println(n.intValue());
        System.out.println(n.longValue());
    }

    public static <T extends Comparable<? super T>> void selectSort(T[] array) {

        T temp;
        int mini;

        for (int i = 0; i < array.length - 1; ++i) {

            mini = i;

            for (int j = i + 1; j < array.length; ++j) {
	            if (array[j].compareTo(array[mini]) < 0) {
	                mini = j;
	            }
            }

            if (i != mini) {
	            temp = array[i];
	            array[i] = array[mini];
	            array[mini] = temp;
            }
        }
    }//end of testing program
}
class Rational extends Number implements Comparable<Rational>{
	
	private int numerator;
	private int denominator;
	
	//number class mathods
	public double doubleValue(){
		return (double) this.numerator/this.denominator;
	}
	public float floatValue(){
		return (float) this.numerator/this.denominator;
	}
	public long longValue(){
		return (long) this.numerator/this.denominator;
	}
	public int intValue(){
		return (int) this.numerator/this.denominator;
	}
	
	//compare to method
	public int compareTo(Rational a){
		double d=(this.sub(a)).doubleValue();
		if(this.numerator==a.numerator & this.denominator==a.denominator){
			return 0;
		}
		else if(d<0){
			return -1;
		}
		else {return 1;}
	}
	
	
	
	//constructor
	public Rational(int numerator, int denominator){
		int a=gcd1(numerator,denominator);
		this.numerator=numerator/a;
		this.denominator=denominator/a;	
	}
	
	//gcd of two rational numbers
	public Rational gcd(Rational o){
		int a=gcd1(numerator,o.numerator);
		int b=lcm1(denominator,o.denominator);
		return new Rational(a,b);
	}
	
	//gcd of two integers
	private int gcd1(int m,int n){
		
		if(n>m){
			int temp=n;
			n=m;
			m=temp;
		}
		while(n!=0){
			int temp=n;
			n=m%n;
			m=temp;	
		}
		return m;
		/*if(n>m){
			return gcd1(n,m);
		}
		else if(n==0){
			return m;
		}
		else {
			return gcd1(n,m%n);
		}*/
	}
	
	//lcm of two integers
	private int lcm1(int c, int d){
		return c*d/gcd1(c,d);
	}
	
	
    //Addition of two rational numbers
	public Rational add(Rational o){
		int a=numerator*o.denominator+o.numerator*denominator;
		int b=denominator*o.denominator;
		int d=gcd1(a,b);
		
		return new Rational(a/d,b/d);
	}
	
	//Subtraction of two rational numbers
	public Rational sub(Rational o){
		int a=numerator*o.denominator-o.numerator*denominator;
		int b=denominator*o.denominator;
		int d=gcd1(a,b);
		
		return new Rational(a/d,b/d);
	}
	
	//Multiplication of two rational numbers
	public Rational mul(Rational o){
		int a=numerator*o.numerator;
		int b=denominator*o.denominator;
		int d=gcd1(a,b);
		
		return new Rational(a/d,b/d);
	
	}
	
	//Division of two rational numbers
	public Rational div(Rational o){
		int a=numerator*o.denominator;
		int b=denominator*o.numerator;
		int d=gcd1(a,b);
		
		return new Rational(a/d,b/d);
	}
	
	//to string method
	 public String toString() {

		    return  numerator + "/"+denominator;
	}
}
