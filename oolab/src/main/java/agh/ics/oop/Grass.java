package agh.ics.oop;

public class Grass {
    private Vector2d grassPosition;

    public Grass (Vector2d pos){
        this.grassPosition = pos;
    }

    public Vector2d getPosition(){
        return this.grassPosition;
    }

    public boolean isAt(Vector2d pos) {
        return this.grassPosition.equals(pos);
    }

    public String toString(){
        return "*";
    }
}
