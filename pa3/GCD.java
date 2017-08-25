import java.util.*;

class GCD{

  // method that finds the Greatest Common Demoniator of 2 integers 
  static int findGCD(int x, int z){
  	int r = x%z; // get the remainder 
  	int result = 0;
  	while(r != 0){
  		x = z;
  	    z = r;
  	    result = r;
  	    r = x%z;

  	}
  	 return result; 
  	} 
  


  public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	Scanner sc2 = new Scanner(System.in);

    // Loop until you get a positive integer
	System.out.print("Enter a positive integer: ");
	while(!sc.hasNextInt()){
		System.out.print("Please enter a positive integer: ");
		sc.next(); // goes to the next thing you put in the sc object 
 	}
 	// second loop until you get a positive integer
    System.out.print("Enter another positive integer: ");
    while(!sc2.hasNextInt()){
    	System.out.print("Please enter a positive integer: ");
    	sc2.next();
    }

    int a = sc.nextInt();
    int b = sc2.nextInt();

   if(a > b)
     System.out.println("The GCD of "+ a + " and " + b + " is " + findGCD(a,b));
   else
   	  System.out.println("The GCD of "+ a + " and " + b + " is " + findGCD(b,a));


    
 }
}