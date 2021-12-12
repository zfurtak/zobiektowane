package agh.ics.oop;

public class Grass extends AbstractWorldMapElement{

    public Grass (Vector2d pos){
        this.position = pos;
    }

    @Override
    public String getPath() {
        return "src/main/resources/grass.png";
    }

    /*public String toString(){
       return "*";
    }*/

}
