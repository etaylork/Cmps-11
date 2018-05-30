
// A simple Guessing game where you have three tries to win
// prints out if you win or not, and if you lose will display the random number 

import java.util.*;

class Guess {

	// function to do the logic
	static void choices(int r, int g) {

		if (g < r)
			System.out.println("Your guess is too low.");
		else if (g > r)
			System.out.println("Your guess is too high.");
		else {
			System.out.println("You win!");
			System.exit(0);
		}

	}

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int rand = (int) (Math.random() * 10 + 1);
		int guess = 0;
		System.out.println("\nI'm thinking of an integer in the range of 1 to 10. You have three guesses");

		// First Guess
		System.out.print("\nEnter your first guess: ");
		guess = sc.nextInt();
		choices(rand, guess);

		// Second Guess
		System.out.print("\nEnter your second guess: ");
		guess = sc.nextInt();
		choices(rand, guess);

		System.out.println("\nEnter your third guess: ");
		guess = sc.nextInt();
		if (rand == guess)
			System.out.println("You win!\n");
		else
			System.out.println("\nyou lose. the number was " + rand + ".\n");
	}
}