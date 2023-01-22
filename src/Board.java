import java.util.List;

public class Board {
    private Hole[][] holes;

    public boolean insertFirstPin(int row, int column){
        if(row == 0 || row ==24 || column == 0 || column == 24)
            return false;
        holes[row][column].setColor(Color.RED);
        return true;
    }

    public boolean insertPin(int row, int column, Player player){
        if((row==0 && column == 0) ||(row==0 && column==24) || (row==24 && column==0) || (row==24 && column==24))
            return false;
        if((player.getColor() == Color.BLUE && (row == 0 || row == 24)) || (player.getColor() == Color.RED && (column == 0 || column == 24)))
            return false;

        holes[row][column].setColor(player.getColor());
        holes[row][column].checkIfLinkable();

        return true;
    }

    public void linkPins(int row, int column){
        if()
    }

    public Board(){
        this.holes = new Hole[24][24];

    }
}
