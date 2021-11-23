package agh.ics.oop;

public interface IPositionChangeObserver {


    default void update(){

    }

    void positionChanged(Vector2d oldPosition, Vector2d newPosition);

}
