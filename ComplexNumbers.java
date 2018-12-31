//Project 5
//Afreen Hameed
//CS113 H02

/*
This code implements a class of Complex numbers which has the properties from the mathematical definition
*/
public class ComplexNumbers {

  public static void main(String[] args) {

    Complex a = new Complex(2.0, 3.0);
    Complex b = new Complex(1.0, 2.0);

    System.out.println(a + " + " + b + " = " + a.add(b));
    System.out.println(a + " - " + b + " = " + a.sub(b));
    System.out.println(a + " * " + b + " = " + a.mul(b));
    System.out.println(a + " / " + b + " = " + a.div(b));
  }
}

class Complex {

  public Complex(double a, double b) {

    real = a;
    imag = b;
  }

  public Complex add(Complex o) {

    return new Complex(real + o.real, imag + o.imag);
  }

  private Complex conjugate() {

    return new Complex(real, -imag);
  }

  public Complex div(Complex o) {

    Complex top = mul(o.conjugate());
    Complex bot = o.mul(o.conjugate());

    return new Complex(top.real / bot.real, top.imag / bot.real);
  }

  public Complex mul(Complex o) {

    return new Complex(real * o.real - imag * o.imag, real * o.imag + imag * o.real);
  }

  public Complex sub(Complex o) {

    return new Complex(real - o.real, imag - o.imag);
  }

  public String toString() {

    return "(" + real + (imag < 0.0 ? " - " : " + ") + (imag < 0.0 ? -imag : imag) + "i)";
  }

  private double real;
  private double imag;
}
