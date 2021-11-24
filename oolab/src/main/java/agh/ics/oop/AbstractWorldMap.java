package agh.ics.oop;

import java.util.LinkedHashMap;


abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    protected LinkedHashMap<Vector2d, AbstractWorldMapElement> natures = new LinkedHashMap<>();

    abstract Vector2d findingUpperCorner();

    abstract Vector2d findingLowerCorner();

    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(findingLowerCorner(), findingUpperCorner());
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        AbstractWorldMapElement jim = this.natures.get(oldPosition);
        this.natures.remove(oldPosition);
        this.natures.put(newPosition, jim);
    }

    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal);
    }



    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            this.natures.put(animal.getPosition(), animal);
            animal.addObserver(this);
            return true;
        }
        return false;
    }

    public boolean isOccupied(Vector2d position) {
        return natures.get(position) != null;
    }


    public Object objectAt(Vector2d position) {
        return natures.get(position);
    }
}
