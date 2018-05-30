
//--------------------------------
// Elijah Taylor-Kuni
// Cmps 11 Tantalo 
// Pa4 
// A program that uses the bisection method to find the roots of a polynomial 
// given between a range from [a,b]
//--------------------------------
import java.util.*;

class Roots {

	// method that computes the polynomial given an x
	static double poly(double[] C, double x) {
		double sum = 0;
		for (int i = 0; i < C.length; i++) {
			sum += C[i] * Math.pow(x, i);
		}
		return sum;
	}

	// method that computes the derrivative of a polynomial
	static double[] diff(double[] C) {
		double[] D = new double[C.length - 1];
		for (int i = 0; i < D.length; i++) {
			D[i] = C[i + 1] * (i + 1);
			// System.out.println(D[i]);
		}
		return D;
	}

	// bisection Method used to find the roots of a polynomial using sub intervals
	static double findRoot(double[] C, double a, double b, double tolerance) {

		double mid = (a + b) / 2;
		double width = b - a;

		while (width > tolerance) {
			if (poly(C, a) * poly(C, mid) <= 0) {
				b = mid;
			} else if (poly(C, b) * poly(C, mid) <= 0) {
				a = mid;
			}
			width = b - a;
			mid = (a + b) / 2;
		}
		return mid;
	}

	public static void main(String[] args) {
		double resolution = Math.pow(10, -2);
		double tolerance = Math.pow(10, -12);
		double threshold = Math.pow(10, -3);
		int deg;
		double left, right;

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the degree: ");
		deg = sc.nextInt() + 1;
		System.out.print("enter the " + deg + " coefficients: ");
		double[] coef = new double[deg];
		for (int i = 0; i < coef.length; i++) {
			coef[i] = sc.nextDouble();

		}

		double[] D = diff(coef);

		System.out.print("Enter the left and right endpoints: ");
		left = sc.nextDouble();
		right = sc.nextDouble();
		System.out.println();

		int counter = 0;
		double a = left;
		double b = left + resolution;
		while (a < right) {
			if (poly(coef, a) * poly(coef, b) <= 0) {
				double odd = findRoot(coef, a, b, tolerance);
				System.out.printf("Odd root found at: %.10f%n", odd);
				counter += 1;
			} else if (poly(D, a) * poly(D, b) <= 0) {
				double even = findRoot(D, a, b, tolerance);
				if (Math.abs(poly(coef, even)) < threshold) {
					System.out.printf("Even root found at: %.10f%n", even);
					counter += 1;
				}
			}
			a = b;
			b = a + resolution;
		}

		if (counter == 0) {
			System.out.println("\nNo Roots were found in the specified range");
		}

	}
}