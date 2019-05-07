import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class MultiThreadRespond implements Runnable{

    private ServerSocket server;
    private int port ;
    private ObjectOutputStream socketOutput;
    private ObjectInputStream socketInput;

    private int left = 7;

    public MultiThreadRespond(int port){
        this.port = port;
        try{
            server = new ServerSocket(port);
        }catch(Exception e){
        }
    }
    @Override
    public void run(){
        String  [] Word = { "predator", "kingsman", "alien", "aquaman", "avengers", "cinderella","annabelle", "chucky", "incredibles", "conjuring", "frozen", "juon" };
        String rand_word;
        char[] hidden_word;
        String user_guess = "";
        int wrong_guess = 0;
        char[] missed = new char[7];
        boolean letter_found = false, solved = false;
        rand_word = Word[ (int)(Math.random() * Word.length) ].toLowerCase();
        hidden_word = new char[rand_word.length()];
        int win = 0;
        int lose = 0;

        for (int i = 0; i < rand_word.length(); i++) {
            if (rand_word.charAt(i) == ' ') {
                hidden_word[i] = ' ';
            } else {
                hidden_word[i] = '_';
            }
        }

        StringBuilder res_hidden_word = new StringBuilder();
        int  res_miss_count = wrong_guess;
        StringBuilder res_missed = new StringBuilder();

        System.out.println("Start Games : " + rand_word);
        while(true){
            try{
                Socket socket = server.accept();
                socketInput = new ObjectInputStream(socket.getInputStream());
                socketOutput = new ObjectOutputStream(socket.getOutputStream());
                boolean running = true;
                while (running){

                    System.out.print("\nWord: ");
                    res_hidden_word.delete(0,  res_hidden_word.length());
                    for (int i = 0; i < rand_word.length(); i++) {
                        System.out.print(hidden_word[i] + " ");
                        res_hidden_word.append(hidden_word[i]).append(" ");
                    }
            
                    String action =  (String) socketInput.readObject();
                    System.out.println(action);
                    if (action.equals("start") || action.equals(" ")){
                        res_miss_count = wrong_guess;
                        socketOutput.writeObject(res_hidden_word + "@" + res_miss_count + "@" + res_missed + "@" + win + "@" + lose );
                    }else if (action.equals("End Game") && lose == 1) {
                        socketOutput.writeObject(rand_word);
                    }else if (action.equals("exit")) {
                        socketOutput.close();
                        socketInput.close();
                        socket.close();
                    }else if (action.substring(0,5).equals("send:")){
                        user_guess = action.substring(5,6);
                        System.out.print("\nGuess: " + user_guess);
                        letter_found = false;
                        for (int i = 0; i < rand_word.length(); i++) {
                            if (user_guess.toLowerCase().charAt(0) == rand_word.toLowerCase().charAt(i)) {
                                hidden_word[i] = rand_word.charAt(i);
                                letter_found = true;
                            }
                        }
                        if (!letter_found) {
                            missed[wrong_guess] = user_guess.charAt(0);
                            wrong_guess++;
                        }
                        int hidden_count = 0;
                        for (int i = 0; i < rand_word.length(); i++) {
                            if ('_' == hidden_word[i])
                                hidden_count++;
                        }
                        if (hidden_count > 0) {
                            solved = false;
                        } else{
                            solved = true;
                        }
                    }
                    if (wrong_guess >= left){
                        lose = 1;
                    }
                    if (solved){
                        win = 1;
                    }
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
}
