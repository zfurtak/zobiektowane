package agh.ics.oop;

import java.util.ArrayList;

public class RectangularMap implements IWorldMap{
    private final Vector2d right_up_corner;
    private final Vector2d left_down_corner = new Vector2d(0,0);
    private ArrayList<Animal> animals;

    public RectangularMap(int width, int heigth){
        this.right_up_corner = new Vector2d(width-1, heigth -1);
    }

    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(this.left_down_corner, this.right_up_corner);
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        if (!position.precedes(right_up_corner) || !position.follows(left_down_corner)) {
            return false;
        }
        return !this.isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            this.animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal : this.animals) {
            if (animal.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.getPosition().equals(position)) {
                return animal;
            }
        }
        return null;
    }
}
