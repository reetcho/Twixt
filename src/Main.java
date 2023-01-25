import Model.Board;
import Model.Color;
import Model.Link;
import Model.Player;
import View.Cli;

public class Main {

    public static void main(String[] args ){
        Board board = new Board();
        Cli cli = new Cli();
        cli.initializeCli();
        cli.update(board);
    }
}
