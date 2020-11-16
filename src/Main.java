import java.awt.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean gameOver = false;
        boolean gameWin = false;
        boolean errored = false;

        Scanner sc = new Scanner(System.in);

        MineField field = new MineField();

        int x = 0, y = 0;
        int score = 0;
        String action;

        System.out.println("How many bombs?");
        try {
            int bombAmount = Integer.parseInt(sc.nextLine());
            if (bombAmount < (8 * 10)) ;
            field.setMaxBombs(bombAmount);
        }
        catch (NumberFormatException e) {
            System.out.println("Error defaulted to 8");
        }

        field.reset();

        while (!gameOver) {

            field.printField();
            System.out.println("Used flags: " + field.getUsedflags() + "/" + field.getmaxBombs());
            System.out.println("x;y;action ([1-8];[1-10];[reveal/flag])/(exit)");

            String[] playersTurn = sc.nextLine().split(";");
            for (int i = 0; i < playersTurn.length; i++) {
                if (playersTurn[i].toLowerCase().equals("exit")) {
                    gameOver = true;
                    break;
                }
            }

            try {
                x = Integer.parseInt(playersTurn[0]) - 1;
                y = Integer.parseInt(playersTurn[1]) - 1;
            } catch (NumberFormatException nfe) {
                System.out.println("Coordiantes are numbers :)");
                errored = true;

            }
            if (!errored) {
                action = playersTurn[2];
                if (x < 0 || y < 0 || x >= 8 || y >= 10) {

                    System.out.println("Incorrect Coordinates (correct:  [1-8];[0-10])");
                } else if (!action.toLowerCase().equals("reveal") && !action.toLowerCase().equals("flag")) {
                    System.out.println("Incorrect action (correct: enter reveal or flag)");
                } else {
                    gameOver = field.action(x, y, action);
                    gameWin = field.winCheck();
                    field.update();
                    score++;
                }
            }

            errored = false;

            if (gameOver || gameWin) {

                field.gameOver();
                field.printField();

                if (gameOver)
                    System.out.println("Game over");

                else if (gameWin)
                    System.out.println("You Win! | Score: " + score);

                System.out.println("Play again? (Y/N)");
                String answer = sc.nextLine();
                if (answer.toLowerCase().equals("y")) {
                    gameOver = false;
                    field.reset();
                    score = 0;
                }

            }


        }

    }


}

