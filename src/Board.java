import java.util.List;

public class Board {
    private List<Hole> holes;

    public boolean insertPin(int row, int column, Player player){
        for(Hole h : holes){
            if(h.getRow() == row && h.getColumn() == column){
                if(!(player.getColor() == Color.RED && (row == 0 || row == 24)) && !(player.getColor() == Color.BLUE && (column == 0 || column == 24))){
                    h.setColor(player.getColor());
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        return false;
    }
}
