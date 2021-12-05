package agh.ics.oop;

import java.util.LinkedHashMap;


abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    protected LinkedHashMap<Vector2d, AbstractWorldMapElement> natures = new LinkedHashMap<>();
    protected final MapBoundary boundaryMap = new MapBoundary();


    abstract Vector2d findingUpperCorner();

    abstract Vector2d findingLowerCorner();

    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(boundaryMap.findingLowerCorner(), boundaryMap.findingUpperCorner());
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
            boundaryMap.positionChanged(new Vector2d(0,0), animal.getPosition());
            animal.addObserver(this);
            animal.addObserver(boundaryMap);
            return true;
        }
        else{
            throw new IllegalArgumentException("Can't place animal on" + animal.getPosition());
        }
    }

    public boolean isOccupied(Vector2d position) {
        return natures.get(position) != null;
    }


    public Object objectAt(Vector2d position) {
        return natures.get(position);
    }
}
