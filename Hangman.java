import java.util.Scanner;
public class Hangman {

	private static String[] words = {"predator", "kingsman", "alien", "aquaman", "avengers", "cinderella", 
									"annabelle", "chucky", "incredibles", "conjuring", "frozen", "juon" };
	private static String word = words[(int) (Math.random() * words.length)];
	private static String asterisk = new String(new char[word.length()]).replace("\0", "-");
	private static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(".                                                      +-------+"); 
		System.out.println(".                                                      |      \\|"); 
		System.out.println(".                   -----------------                          |"); 
		System.out.println(".                 -=[ H A N G M A N ]=-                        |");
		System.out.println(".                 ^^^^^^^^^^^^^^^^^^^^^                        |");
		System.out.println(".                                                              |");
		System.out.println(".                                                              |");
		System.out.println(".                                                             /|\\ ");
		System.out.println(".                                                            / | \\ ");
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^"); 
		System.out.println("Lives Left : 7"); 
		System.out.println("Topic : Movie");
		System.out.println("Start!!!");
		System.out.println();

		while (count < 7 && asterisk.contains("-")) {
			System.out.print("Word : ");
			System.out.println(asterisk);
			System.out.print("Guess : ");
			String guess = sc.next();
			hang(guess);
			System.out.println();
		}

		sc.close();
	}

	public static void hang(String guess) {
		String newasterisk = "";
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == guess.charAt(0)) {
				newasterisk += guess.charAt(0);
			} else if (asterisk.charAt(i) != '-') {
				newasterisk += word.charAt(i);
			} else {
				newasterisk += "-";
			}
		}

		if (asterisk.equals(newasterisk)) {
			count++;
			hangmanImage();
		} else {
			asterisk = newasterisk;
		}
		if (asterisk.equals(word)) {
			System.out.println();
			System.out.println("The word was " + word);
			System.out.println();
			System.out.println("***    ***   ***     **      **    **       **   ******   ***     *              ");
			System.out.println(" **    **   ** **    **      **    **       **   ******   ***     *");
			System.out.println("  **  **   **   **   **      **    **   *   **     **     ** *    *");
			System.out.println("   ****   **     **  **      **    **   *   **     **     **  *   *  ");
			System.out.println("    **    **     **  ***    ***	   **   *   **     **     **   *  *   ");
			System.out.println("    **     **   **    ********      ** * * **	   **	  **    * *   ");
			System.out.println("    **      ** **      ******        * * * *	 ******	  **     **       ");
			System.out.println("    **       ***        ****          *   *      ******   **      *         ");
		}
	}

	public static void hangmanImage() {
		if (count == 1) {
			System.out.println("Wrong guess, try again");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("    |  ");
			System.out.println("   /|\\");
			System.out.println("  / | \\");
			System.out.println("^^^^^^^^^");
		}
		if (count == 2) {
			System.out.println("Wrong guess, try again");
			System.out.println();
			System.out.println("    +");
			System.out.println("    |");
			System.out.println("    |");
			System.out.println("    |");
			System.out.println("    |");
			System.out.println("    |");
			System.out.println("    |");
			System.out.println("    |");
			System.out.println("    |");
			System.out.println("   /|\\ ");
			System.out.println("  / | \\ ");
			System.out.println("^^^^^^^^^");
		}
		if (count == 3) {
			System.out.println("Wrong guess, try again");
			System.out.println();
			System.out.println("    +-------------+");
			System.out.println("    |/            |");
			System.out.println("    |             |");
			System.out.println("    |");
			System.out.println("    |");
			System.out.println("    |");
			System.out.println("    |");
			System.out.println("    |");
			System.out.println("    |");
			System.out.println("   /|\\ ");
			System.out.println("  / | \\ ");
			System.out.println("^^^^^^^^^");
		}
		if (count == 4) {
			System.out.println("Wrong guess, try again");
			System.out.println();
			System.out.println("    +-------------+");
			System.out.println("    |/            |");
			System.out.println("    |             |");
			System.out.println("    |             O");
			System.out.println("    |");
			System.out.println("    | ");
			System.out.println("    | ");
			System.out.println("    | ");
			System.out.println("    |  ");
			System.out.println("   /|\\ ");
			System.out.println("  / | \\ ");
			System.out.println("^^^^^^^^^");
		}
		if (count == 5) {
			System.out.println("Wrong guess, try again");
			System.out.println();
			System.out.println("    +-------------+");
			System.out.println("    |/            |");
			System.out.println("    |             |");
			System.out.println("    |             O");
			System.out.println("    |	          |");
			System.out.println("    |             |");
			System.out.println("    |             |");
			System.out.println("    |  ");
			System.out.println("    |  ");
			System.out.println("   /|\\ ");
			System.out.println("  / | \\ ");
			System.out.println("^^^^^^^^^");
		}
		if (count == 6) {
			System.out.println("Wrong guess, try again");
			System.out.println();
			System.out.println("    +-------------+");
			System.out.println("    |/            |");
			System.out.println("    |             |");
			System.out.println("    |             O");
			System.out.println("    |	          |");
			System.out.println("    |             |");
			System.out.println("    |             |");
			System.out.println("    |            / \\");
			System.out.println("    |          _/   \\_");
			System.out.println("   /|\\ ");
			System.out.println("  / | \\ ");
			System.out.println("^^^^^^^^^");
		}
		if (count == 7) {
			System.out.println("GAME OVER!");

			System.out.println("    +-------------+");
			System.out.println("    |/            |");
			System.out.println("    |             |");
			System.out.println("    |             O");
			System.out.println("    |	     >----|----<");
			System.out.println("    |             |");
			System.out.println("    |             |");
			System.out.println("    |            / \\");
			System.out.println("    |          _/   \\_");
			System.out.println("   /|\\ ");
			System.out.println("  / | \\ ");
			System.out.println("^^^^^^^^^");
			System.out.println();
			System.out.println("The word was " + word);
			
			System.out.println();
		System.out.println("   *****    ***   *     * ******     ***    **  ** ****** *****");
		System.out.println("  **   **  ** **  **   ** **       **   **  **  ** **	  **  **");
		System.out.println("  **      **   ** *** *** **      **     ** **  ** **	  **  **");
		System.out.println("  **  *** ******* ** * ** ****    **     ** **  ** ****	  ***** ");
		System.out.println("  **   ** **   ** **   ** **      **     ** **  ** **	  ****");
		System.out.println("  **   ** **   ** **   ** **       **   **   ****  **	  ** **");
		System.out.println("   *****  **   ** **   ** ******     ***      **   ****** **  **");
		System.out.println();
		}
	}
}