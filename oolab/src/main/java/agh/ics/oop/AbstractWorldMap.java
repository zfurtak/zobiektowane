package agh.ics.oop;

import java.util.LinkedHashMap;


abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    protected LinkedHashMap<Vector2d, Animal> animals = new LinkedHashMap<>();

    abstract Vector2d findingUpperCorner();

    abstract Vector2d findingLowerCorner();

    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(findingLowerCorner(), findingUpperCorner());
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal jim = this.animals.get(oldPosition);
        this.animals.remove(oldPosition);
        this.animals.put(newPosition, jim);
    }

    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal);
    }


    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            this.animals.put(animal.getPosition(), animal);
            return true;
        }
        return false;
    }

    public boolean isOccupied(Vector2d position) {
        return animals.get(position) != null;
    }

    public Object objectAt(Vector2d position) {
        return animals.get(position);
    }
}
