package View;

import Model.Board;
import Model.Color;
import Model.Link;

import java.io.IOException;
import java.util.Scanner;

public class Cli {
    private final Scanner scanner;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public Cli(){
        scanner = new Scanner(System.in);
    }

    public static void clearCli(){
        //Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {ex.printStackTrace();}
    }

    public void initializeCli(){
        clearCli();
    }

    public String readInput(){
        String input;
        input = scanner.nextLine();
        return input;
    }

    public void update(Board board){
        //clearCli();
        for(int y = 23; y >= 0 ; y--){
            for(int x = 0; x<24; x++){
                if(board.getHoles()[x][y].getColor().equals(Color.B))
                    System.out.print(ANSI_BLUE+board.getHoles()[x][y].getColor() + "  "+ ANSI_RESET);
                else if(board.getHoles()[x][y].getColor().equals(Color.R))
                    System.out.print(ANSI_RED+board.getHoles()[x][y].getColor() + "  "+ ANSI_RESET);
                else
                    System.out.print(board.getHoles()[x][y].getColor() + "  ");
            }
            System.out.print("\n");
        }
        for(Link l: board.getLinks())
            l.printLink();
        askInsertPin(board);
    }

    public void askInsertPin(Board board){
        Color color = pinColor();
        if(color == null) {
            askInsertPin(board);
            return;
        }
        else{
            System.out.println("X:");
            int x = Coord();
            if(x == -1) {
                askInsertPin(board);
                return;
            }
            else{
                System.out.println("Y:");
                int y = Coord();
                if(y == -1){
                    askInsertPin(board);
                    return;
                }
                if(board.insertPin(x,y,color))
                    update(board);
                else
                    askInsertPin(board);
                return;
            }
        }

    }

    public Color pinColor(){
        System.out.println("Color:");
        String input = readInput();
        if(input.equals("r"))
            return Color.R;
        else if(input.equals("b"))
            return Color.B;
        else
            return null;

    }

    public int Coord(){
        int c = Integer.parseInt(readInput());
        if(c>=1 && c<=24)
            return c-1;
        else
            return -1;
    }



}
