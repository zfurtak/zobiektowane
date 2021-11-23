package agh.ics.oop;

import java.util.LinkedHashMap;


public class GrassField extends AbstractWorldMap {
    private final int grassAmount;
    private final LinkedHashMap<Vector2d, Grass> grasses;

    public GrassField(int x){
        this.grassAmount = x;
        grasses = new LinkedHashMap<>();
        placeGrass();

    }


    public void placeGrass() {
        int x, y;
        Vector2d grassPosition;
        for (int i = 0; i < this.grassAmount; i++) {
            x = (int) (Math.random() * Math.sqrt(this.grassAmount * 10));
            y = (int) (Math.random() * Math.sqrt(this.grassAmount * 10));
            grassPosition = new Vector2d(x, y);
            while(objectAt(grassPosition) instanceof Grass) {
                x = (int) (Math.random() * Math.sqrt(this.grassAmount * 10));
                y = (int) (Math.random() * Math.sqrt(this.grassAmount * 10));
                grassPosition = new Vector2d(x, y);
            }
            Grass kepka = new Grass(grassPosition);
            grasses.put(grassPosition, kepka);
        }
    }

    Vector2d findingUpperCorner(){
        Vector2d rightUpCorner = new Vector2d((int) (-2*Math.pow(10,9)), (int) (-2*Math.pow(10,9)));

        for(Vector2d key : animals.keySet()){
            rightUpCorner = rightUpCorner.upperRight(key);
        }
        for(Vector2d key : grasses.keySet()){
            rightUpCorner = rightUpCorner.upperRight(key);
        }
        return rightUpCorner;
    }

    Vector2d findingLowerCorner(){
        Vector2d leftDownCorner = new Vector2d((int) (2*Math.pow(10,9)), (int) (2*Math.pow(10,9)));

        for(Vector2d key : animals.keySet()){
            leftDownCorner = leftDownCorner.lowerLeft(key);
        }
        for(Vector2d key : grasses.keySet()){
            leftDownCorner = leftDownCorner.lowerLeft(key);
        }
        return leftDownCorner;
    }
    @Override
    public Object objectAt(Vector2d position){
        Object x = super.objectAt(position);
        if (x != null)
            return x;
        return grasses.get(position);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        boolean x = super.isOccupied(position);
        if(x)
            return true;
        return grasses.get(position) != null;
    }




}

