
//----------------------------
//Elijah Taylor-Kuni
// Queens.java
// Cmps11
// A java program that finds all the solutions for the n-Queens Problem
// By finding all the permutations of a set and seeing which permutations 
// are a solution to the n-Queens problems
//-------------------------------

import java.util.*;

class Queens {

	// Find all the permutations specified by the number given by the user
	static void nextPermutation(int[] A) {
		int pivot = 0;
		int successor = 0;

		for (int i = A.length - 1; i > 1; i--) {
			if (A[i - 1] < A[i]) {
				pivot = i - 1;
				break;
			}
		}

		if (pivot == 0) {
			reverse1(A);
			return;
		}

		for (int i = A.length - 1; i > 1; i--) {
			if (A[i] > A[pivot]) {
				successor = i;
				break;
			}
		}

		swap(A, pivot, successor);

		// reverse the rest of the array
		int j = A.length - 1;
		int i = pivot + 1;
		while (i <= j) {
			swap(A, i, j);
			i++;
			j--;
		}
	}

	// Testing to see if a permutation is a solution to
	// the n x n Queens problem
	static boolean isSolution(int[] A) {
		int n = A.length;
		int horizontal = 0;
		int vertical = 0;
		for (int i = 1; i <= A.length - 2; i++) {
			for (int j = i + 1; j < A.length; j++) {

				// change the horizontal distance to positive if it is negative
				// can't have a negative distance
				horizontal = (n - A[i]) - (n - A[j]);
				if (horizontal < 0) {
					horizontal *= -1;
				}
				vertical = (n - i) - (n - j);
				if (horizontal == vertical) {
					return false;
				}

			}
		}
		return true;
	}

	// reverses an array
	static void reverse1(int[] T) {
		int i = 1, j = T.length - 1;
		while (i < j) {
			swap(T, i, j);
			i++;
			j--;
		}
	}

	// prints out an array by project specifications
	static void printArray(int[] P) {
		System.out.print("(");
		for (int i = 1; i < P.length; i++) {
			if (i == (P.length - 1))
				System.out.print(P[i]);
			else
				System.out.print(P[i] + " , ");
		}
		System.out.print(")");
		System.out.println();
	}

	// swaps two elements in an array
	static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	// logic to see if command line argument is an Int
	static boolean isInt(String s) {
		boolean parsable = true;
		try {
			int x = Integer.parseInt(s);
		} catch (Exception ex) {
			parsable = false;
		}

		return parsable;
	}

	public static void main(String[] args) {

		// logic to make sure correct parameters are being passed in
		// from command line
		int x = 0;
		if (args.length == 0) {
			System.out.println("Usage: Queens [-v] number");
			System.out.println("Option: -v verbose output, print all solutions");
			return;
		} else if (args.length == 1) {
			if (isInt(args[0]) == false) {
				System.out.println("Usage: Queens [-v] number");
				System.out.println("Option: -v verbose output, print all solutions");
				return;
			}
			x = Integer.parseInt(args[0]);
		} else if (args.length > 1) {
			if (args[0].equals("-v") == false || isInt(args[1]) != true) {
				System.out.println("Usage: Queens [-v] number");
				System.out.println("Option: -v verbose output, print all solutions");
				return;
			}
			x = Integer.parseInt(args[1]);
		}

		int[] P = new int[x + 1];
		int permutation = 1;
		int solutions = 0;
		for (int i = 0; i < P.length; i++) {
			P[i] = i;
			if (i != 0) {
				permutation *= i;
			}
		}

		// tells how many solutions are for the n x n Queens problem
		if (args.length == 1) {
			for (int i = 0; i < permutation; i++) {
				nextPermutation(P);
				if (isSolution(P)) {
					solutions += 1;
				}
			}
			System.out.println(x + "-Queens has " + solutions + " solutions");

			// -v mode shows both permutations and solutions
		} else if (args.length == 2) {
			for (int i = 0; i < permutation; i++) {
				nextPermutation(P);
				if (isSolution(P)) {
					solutions += 1;
					printArray(P);
				}
			}
			System.out.println(x + "-Queens has " + solutions + " solutions");
		}

	}

}