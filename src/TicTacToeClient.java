import java.io.*;
import java.net.*;
import java.util.*;


public class TicTacToeClient {
    static String[] board;
    static String turn;


    // CheckWinner method will
    // decide the combination
    // of three box given below.
    static String checkWinner()
    {
        for (int a = 0; a < 8; a++) {
            String line = null;

            switch (a) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
            //For X winner
            if (line.equals("XXX")) {
                return "X";
            }

            // For O winner
            else if (line.equals("OOO")) {
                return "O";
            }
        }

        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(board).contains(
                    String.valueOf(a + 1))) {
                break;
            }
            else if (a == 8) {
                return "draw";
            }
        }

        // To enter the X Or O at the exact place on board.

        return null;
    }



    // To print out the board.


    static void printBoard()
    {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | "
                + board[1] + " | " + board[2]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | "
                + board[4] + " | " + board[5]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | "
                + board[7] + " | " + board[8]
                + " |");
        System.out.println("|---|---|---|");
    }
    public static void main(String[] args) {
        try{
            Socket s = new Socket("localhost",4444);

            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str1="",str2="";
// start
            Scanner in = new Scanner(System.in);
            board = new String[9];
            turn = "X";
            String winner = null;
            int Turn=0;
            for (int a = 0; a < 9; a++) {
                board[a] = String.valueOf(a + 1);
            }

            System.out.println("Welcome to 3x3 Tic Tac Toe.");
            printBoard();

            System.out.println(
                    "Waiting for server's turn: ");



            while(!(str2.equals("stop"))){
                while (winner == null) {
                    int numInput;

                    // Exception handling.
                    // numInput will take input from user like from 1 to 9.
                    // If it is not in range from 1 to 9.
                    // then it will show you an error "Invalid input."
                    try {
                        if(Turn%2==1)
                        {
                            str2 = br.readLine();
                            dout.writeUTF(str2);
                            dout.flush();
                            System.out.println("You Chose "+str2);

                            numInput=Integer.parseInt(str2);
                        }
                        else{
                            str1 =dis.readUTF();
                            System.out.println("Server Choose "+str1);

                            numInput=Integer.parseInt(str1);
                        }
                        Turn+=1;
                        //numInput = in.nextInt();
                        // str1 =dis.readUTF();
                        if (!(numInput > 0 && numInput <= 9)) {
                            System.out.println(
                                    "Invalid input; re-enter slot number:");
                            continue;
                        }
                    }
                    catch (InputMismatchException e) {
                        System.out.println(
                                "Invalid input; re-enter slot number:");
                        continue;
                    }

                    // This game has two player x and O.
                    // Here is the logic to decide the turn.
                    if (board[numInput - 1].equals(
                            String.valueOf(numInput))) {
                        board[numInput - 1] = turn;

                        if (turn.equals("X")) {
                            turn = "O";
                        }
                        else {
                            turn = "X";
                        }

                        printBoard();
                        winner = checkWinner();
                    }
                    else {
                        System.out.println(
                                "Slot already taken; re-enter slot number:");
                    }


                }
                //

                // If no one win or lose from both player x and O.
                // then here is the logic to print "draw".
                if (winner.equalsIgnoreCase("draw")) {
                    System.out.println(
                            "It's a draw! Thanks for playing.");
                    break;
                }

                // For winner -to display Congratulations! message.
                else {
                    if(winner.equals("O"))
                    System.out.println(
                            "Congratulations! " + winner
                                    + "'s have won! Thanks for playing.");
                    else System.out.println(
                            "Oops! " + winner
                                    + "'s have won! Better luck next time.");
                    break;
                }


                // str2 =br.readLine();
                // dout.writeUTF(str2);
                //dout.flush();

            }
            dis.close();
            s.close();

        }catch(IOException e){

            System.out.println(e);
        }



    }
}
