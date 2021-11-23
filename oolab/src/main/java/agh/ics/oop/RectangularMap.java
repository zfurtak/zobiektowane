package agh.ics.oop;

import java.util.ArrayList;

public class RectangularMap extends AbstractWorldMap{
    private final Vector2d rightUpCorner;
    private final Vector2d leftDownCorner = new Vector2d(0,0);

    public RectangularMap(int width, int heigth){
        this.rightUpCorner = new Vector2d(width-1, heigth -1);
    }


    @Override
    public boolean canMoveTo(Vector2d position1){
        boolean x = super.canMoveTo(position1);
        return x && position1.precedes(rightUpCorner) && position1.follows(leftDownCorner);
    }

    @Override
    Vector2d findingUpperCorner() {
        return rightUpCorner;
    }

    @Override
    Vector2d findingLowerCorner() {
        return leftDownCorner;
    }
}
