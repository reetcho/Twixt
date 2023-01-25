package Model;

import Model.Color;

public class Player {
    private String name;
    private Color color;

    public void setColor(Color color){
        this.color = color;
    }

    public void setName(String name){
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public String getName(){
        return name;
    }
}
