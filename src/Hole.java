import java.util.List;

public class Hole {
    private int row;
    private int column;
    private Color color;
    private List<Hole> links;

    public Hole(int row, int column)
    {
        this.row = row;
        this.column = column;
        this.color = Color.NEUTRAL;
    }

    public int getRow(){
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public boolean checkIfLinkable(){
        if
    }
}
