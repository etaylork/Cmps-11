import java.util.*;

class Lawn{

	public static void main(String args[]){

		Scanner sc = new Scanner(System.in);
		double l1,w1,l2,w2; 
		double lawn, rate; 
		int s,m,h; 

		System.out.print("Enter the length and width of the lot, in feet: ");
         l1 = sc.nextDouble();
         w1 = sc.nextDouble();
        System.out.print("Enter the length and width of the house, in feet: ");
         l2 = sc.nextDouble();
         w2 = sc.nextDouble();

        //find the area of the lawn 
        lawn = (l1*w1) - (l2*w2); 
        System.out.println("The lawn is " + lawn +" square feet.");

        //Mowing speed 
        System.out.print("Enter the mowing rate, in square feet per second: ");
        rate = sc.nextDouble();

        rate  = lawn/rate; 
        s = (int) Math.round(rate);
        m = s/60;
        s = s%60;
        h = m/60;
        m = m%60;

        System.out.println("the mowing time is " + h + (h== 1 ? " hour " : " hours ") + m + (m == 1 ? " minute " : " minutes ")
        + s + (s == 1 ? " second. " : " seconds. ")  ); 




   	}

}