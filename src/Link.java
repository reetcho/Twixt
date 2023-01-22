public class Link {
    private int row1, column1, row2, column2;
    private int Dx, Dy;

    public Link(int row1, int column1, int row2, int column2){
        this.row1 = row1;
        this.column1 = column1;
        this.row2 = row2;
        this.column2 = column2;

        Dy = row2 - row1;
        Dx = column2 - column1;
    }
}
