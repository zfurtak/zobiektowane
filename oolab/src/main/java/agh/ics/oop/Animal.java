package agh.ics.oop;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class Animal extends AbstractWorldMapElement{
    private MapDirection orient = MapDirection.NORTH;
    private final AbstractWorldMap map;



    public Animal(AbstractWorldMap map, Vector2d initialPosition) {
        this.position = initialPosition;
        this.map = map;
    }

    public String toString(){
        return this.orient.shortString();
    }

    public MapDirection getOrient() {
        return this.orient;
    }

    public void move(MoveDirection direction){
        switch (direction){
            case RIGHT -> this.orient = this.orient.next();
            case LEFT -> this.orient = this.orient.previous();
            case FORWARD -> {
                Vector2d newPosition = this.position.add(this.orient.toUnitVector());
                if (this.map.canMoveTo(newPosition)){
                    map.positionChanged(this.position, newPosition);
                    this.position = newPosition;
                }
            }
            case BACKWARD -> {
                Vector2d newPosition = this.position.subtract(this.orient.toUnitVector());
                if (this.map.canMoveTo(newPosition)){
                    this.position = newPosition;
                    map.positionChanged(this.position, newPosition);
                }
            }
        }
    }

}
