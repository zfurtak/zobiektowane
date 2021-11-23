package agh.ics.oop;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class Animal{
    private Vector2d position;
    private MapDirection orient = MapDirection.NORTH;
    private final AbstractWorldMap map;
    private final List<IPositionChangeObserver> observers = new ArrayList<>();

    public Animal(AbstractWorldMap map) {
        this.map = map;
    }

    public Animal(AbstractWorldMap map, Vector2d initialPosition) {
        this.position = initialPosition;
        this.map = map;
    }


    public String toString(){
        return this.orient.shortString();
    }
    public Vector2d getPosition() {
        return this.position;
    }

    public MapDirection getOrient() {
        return this.orient;
    }

    public boolean isAt(Vector2d pos) {
        return this.position.equals(pos);
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
    public void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }

    void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }

    public void notifyObservers(){
        for(IPositionChangeObserver observer: this.observers){
            observer.update();
        }
    }

    public void update(){
        System.out.println(map);
    }
}
