//Project 2
//Afreen Hameed  
//CS113H
/*Project Info
	This code was used to approximate the value of pi by using the probability that a random number in a square,
	lies in the circle that the square encloses. This probabilty is equal to the area of the circle from which 
	we calculate the value of pi.
	This experiment can be repeated for increased accuracy.
*/


import java.util.Scanner;
import java.util.Random;
public class PiCalc {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the number of times the experiment should repeat");
		double n=scan.nextDouble();
		scan.close();
		
		Random generator=new Random();

		
		Double count=0.0000000;
		for(int i=0;i<n;i++){
			double x=generator.nextDouble();
			double y=generator.nextDouble();
			if (Math.sqrt((0.5-x)*(0.5-x)+(0.5-y)*(0.5-y))<=0.5){
				count++;
			}
			
			
		}

		System.out.println("The approximate value of pi is "+ count/n*4+" and the actual value is "+Math.PI);
		
		


	}

}
