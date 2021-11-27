package agh.ics.oop;

import java.util.LinkedHashMap;


public class GrassField extends AbstractWorldMap {
    private final int grassAmount;

    public GrassField(int x){
        this.grassAmount = x;
        placeGrass(this.grassAmount);

    }

    public void placeGrass(int amount) {
        int x, y;
        Vector2d grassPosition;
        for (int i = 0; i < amount; i++) {
            x = (int) (Math.random() * Math.sqrt(amount * 10));
            y = (int) (Math.random() * Math.sqrt(amount * 10));
            grassPosition = new Vector2d(x, y);
            while(isOccupied(grassPosition)) {
                x = (int) (Math.random() * Math.sqrt(amount * 10));
                y = (int) (Math.random() * Math.sqrt(amount * 10));
                grassPosition = new Vector2d(x, y);
            }
            Grass kepka = new Grass(grassPosition);
            natures.put(grassPosition, kepka);
        }
    }

    @Override
    public void positionChanged(Vector2d oldPos, Vector2d newPos){
        AbstractWorldMapElement newObject = natures.get(newPos);
        super.positionChanged(oldPos, newPos);
        if (newObject instanceof Grass)
            this.placeGrass(1);
    }


    Vector2d findingUpperCorner(){
        Vector2d rightUpCorner = new Vector2d((int) (-2*Math.pow(10,9)), (int) (-2*Math.pow(10,9)));

        for(Vector2d key : natures.keySet()){
            rightUpCorner = rightUpCorner.upperRight(key);
        }
        return rightUpCorner;
    }

    Vector2d findingLowerCorner(){
        Vector2d leftDownCorner = new Vector2d((int) (2*Math.pow(10,9)), (int) (2*Math.pow(10,9)));

        for(Vector2d key : natures.keySet()){
            leftDownCorner = leftDownCorner.lowerLeft(key);
        }
        return leftDownCorner;
    }
}

