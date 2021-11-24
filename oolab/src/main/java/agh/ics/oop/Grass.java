package agh.ics.oop;

public class Grass extends AbstractWorldMapElement{

    public Grass (Vector2d pos){
        this.position = pos;
    }

    public String toString(){
        return "*";
    }

}
