import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
public class Client {

    private static int left = 7;
    private static int INIT_PORT = 8765;
    private static String HOST = "127.0.0.1";
    private static int wrong_guess = 0;
    private static Socket socket = null;
    private static ObjectOutputStream socketOutput = null;
    private static ObjectInputStream socketInput = null;
    private static String hidden_word = "";
    private static int win = 0;
    private static int lose = 0;
	
    private static void getStatus(){
        try {
            socketOutput.writeObject(" ");
            String input = (String) socketInput.readObject();
            String[] res = input.split("@");  

            hidden_word = res[0];
            wrong_guess = Integer.parseInt(res[1]);
            win = Integer.parseInt(res[3]);
            lose = Integer.parseInt(res[4]);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String getAnswer(){
        try {
            socketOutput.writeObject("End Game");
            String input = (String) socketInput.readObject();
            return input;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }
    private static void sendUserInput(String s){
        try {
            socketOutput.writeObject("send:"+s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main( String[] args ) {
        Scanner keyboard;

        System.out.println("Connect to server " + HOST + ":" + INIT_PORT);
        try {
            // init socket with init port
            socket = new Socket(HOST, INIT_PORT);
            // send "start" to get new port
            socketOutput = new ObjectOutputStream(socket.getOutputStream());
            socketOutput.writeObject("start");

            // get new port to change connection
            socketInput = new ObjectInputStream(socket.getInputStream());
            String newPort = (String) socketInput.readObject();
            System.out.println("new Port: " + newPort);
            keyboard = new Scanner(System.in);

            //// switch to new port
            socket = new Socket(HOST, Integer.parseInt(newPort));
            socketOutput = new ObjectOutputStream(socket.getOutputStream());
            socketInput = new ObjectInputStream(socket.getInputStream());

            // get initial game status
            getStatus();

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
			
            while (win == 0 && lose ==0) {
			if (wrong_guess == 1) {
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
			if (wrong_guess == 2) {
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
			if (wrong_guess == 3) {
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
			if (wrong_guess == 4) {
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
			if (wrong_guess == 5) {
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
			if (wrong_guess == 6) {
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
				System.out.println("______________________________________\n");
                System.out.println("Lives Left : " + (left - wrong_guess));
                System.out.println("Word:\t" + hidden_word);
                System.out.print("Guess: ");
                sendUserInput(keyboard.nextLine());
                getStatus();
            }
            if (win==1){
                System.out.println( "The word was..." + hidden_word );
				System.out.println("***    ***   ***     **      **    **       **   ******   ***     *");
				System.out.println(" **    **   ** **    **      **    **       **   ******   ***     *");
				System.out.println("  **  **   **   **   **      **    **   *   **     **     ** *    *");
				System.out.println("   ****   **     **  **      **    **   *   **     **     **  *   *");
				System.out.println("    **    **     **  ***    ***	   **   *   **     **     **   *  *");
				System.out.println("    **     **   **    ********      ** * * **	   **	  **    * *");
				System.out.println("    **      ** **      ******        * * * *	 ******	  **     **");
				System.out.println("    **       ***        ****          *   *      ******   **      *");
            }
            else if (lose ==1) {
                String answer = getAnswer();
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
                System.out.println("The word was..." + answer);
				System.out.println("   *****    ***   *     * ******     ***    **  ** ****** *****  ");
				System.out.println("  **   **  ** **  **   ** **       **   **  **  ** **	  **  ** ");
				System.out.println("  **      **   ** *** *** **      **     ** **  ** **	  **  ** ");
				System.out.println("  **  *** ******* ** * ** ****    **     ** **  ** ****	  *****  ");
				System.out.println("  **   ** **   ** **   ** **      **     ** **  ** **	  ****   ");
				System.out.println("  **   ** **   ** **   ** **       **   **   ****  **	  ** **  ");
				System.out.println("   *****  **   ** **   ** ******     ***      **   ****** **  ** ");
            }
            socketOutput.writeObject("exit");
            socketOutput.close();
            socketInput.close();
            socket.close();
        }
         catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
