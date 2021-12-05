package agh.ics.oop;

import java.util.*;

public class MapBoundary implements IPositionChangeObserver{
    SortedSet<Vector2d> xCoord = new TreeSet((Comparator<Vector2d>) (v1, v2) -> {
        if(v1.x == v2.x)
            return v1.y - v2.y;
        return v1.x - v2.x;
    });

    SortedSet<Vector2d> yCoord = new TreeSet((Comparator<Vector2d>) (v1, v2) -> {
        if(v1.y == v2.y)
            return v1.x - v2.x;
        return v1.y - v2.y;
    });

    @Override
    public void positionChanged(Vector2d oldPos, Vector2d newPos){
        if (!xCoord.isEmpty()){
            xCoord.remove(oldPos);
            yCoord.remove(oldPos);
        }
        xCoord.add(newPos);
        yCoord.add(newPos);
    }

    Vector2d findingUpperCorner() {
        if (xCoord.isEmpty())
            return new Vector2d(0, 0);
        return new Vector2d(xCoord.last().x, yCoord.last().y);
    }

    Vector2d findingLowerCorner(){
        if(xCoord.isEmpty())
            return new Vector2d(0, 0);
        return new Vector2d (xCoord.first().x, yCoord.first().y);
    }
}
