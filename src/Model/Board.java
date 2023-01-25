package Model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private Hole[][] holes;
    private List<Link> links;

    public Board(){
        holes = new Hole[24][24];
        for(int i=0; i<24; i++){
            for(int j=0; j<24; j++){
                holes[i][j] = new Hole();
            }
        }
        links = new ArrayList<Link>();
    }

    public Hole[][] getHoles() {
        return holes;
    }

    public List<Link> getLinks(){
        return links;
    }

    public void insertFirstPin(int x, int y) throws IllegalStateException{
        if(x == 0 || x ==23 || y == 0 || y == 23)
            throw new IllegalArgumentException();
        holes[x][y].setColor(Color.R);
    }

    public boolean insertPin(int x, int y, Color c){
        if((c == Color.B && (x == 0 || x == 23)) || (c == Color.R && (y == 0 || y == 23)) || holes[x][y].getColor() != Color.N)
            return false;
        holes[x][y].setColor(c);
        linkPins(x,y);
        return true;
    }

    public boolean checkIfLinkCross(int x1,int y1, int x2, int y2) throws RuntimeException{
        int a,b;
        System.out.println("x1:"+x1+"y1:"+y1 + "x2:"+x2+"y2:"+y2);
        for(Link l: links){
            a = (x1-x2)*(l.getY1()-y1) - (y1-y2)*(l.getX1()-x1);
            b = (x1-x2)*(l.getY2()-y1) - (y1-y2)*(l.getX2()-x1);

            System.out.println("a:"+a+" b:"+b);

            if((a>0 && b<0) || (a<0 && b>0)){
                return false;
            }
        }

        links.add(new Link(x1,y1,x2,y2, holes[x1][y1].getColor()));
        return true;
    }

    public void linkPins(int x, int y){

        if(x+2<24 && y+1<24 && holes[x][y].getColor().equals(holes[x+2][y+1].getColor()))
            checkIfLinkCross(x,y,x+2,y+1);

        if(x+1<24 && y+2<24 && holes[x][y].getColor().equals(holes[x+1][y+2].getColor()))
            checkIfLinkCross(x,y,x+1,y+2);

        if(x-1>=0 && y+2<24 && holes[x][y].getColor().equals(holes[x-1][y+2].getColor())) {
            System.out.println("x-1 y+2");
            checkIfLinkCross(x, y, x - 1, y + 2);
        }
        if(x-2>=0 && y+1<24 && holes[x][y].getColor().equals(holes[x-2][y+1].getColor()))
            checkIfLinkCross(x,y,x-2,y+1);

        if(x-2>=0 && y-1>=0 && holes[x][y].getColor().equals(holes[x-2][y-1].getColor()))
            checkIfLinkCross(x,y,x-2,y-1);

        if(x-1>=0 && y-2>=0 && holes[x][y].getColor().equals(holes[x-1][y-2].getColor())) {
            System.out.println("x-1 y-2");
            checkIfLinkCross(x, y, x - 1, y - 2);
        }
        if(x+1<24 && y-2>=0 && holes[x][y].getColor().equals(holes[x+1][y-2].getColor()))
            checkIfLinkCross(x,y,x+1,y-2);

        if(x+2<24 && y-1>=0 && holes[x][y].getColor().equals(holes[x+2][y-1].getColor()))
            checkIfLinkCross(x,y,x+2,y-1);
    }
}
