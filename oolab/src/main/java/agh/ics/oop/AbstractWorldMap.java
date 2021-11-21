package agh.ics.oop;

import java.util.ArrayList;

abstract class AbstractWorldMap implements IWorldMap{
    protected ArrayList<Animal> animals = new ArrayList<Animal>();

    abstract Vector2d findingUpperCorner();

    abstract Vector2d findingLowerCorner();

    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(findingLowerCorner(), findingUpperCorner());
    }

    public boolean canMoveTo(Vector2d position) {
        if(objectAt(position) instanceof Animal)
            return false;
        return true;
    }


    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            this.animals.add(animal);
            return true;
        }
        return false;
    }

    public boolean isOccupied(Vector2d position) {
        for (Animal animal : this.animals) {
            if (animal.isAt(position)) {
                return true;
            }
        }
        return false;
    }

    public Object objectAt(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.isAt(position)){
                return animal;
            }
        }
        return null;
    }
}
