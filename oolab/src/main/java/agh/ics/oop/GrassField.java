package agh.ics.oop;

import java.util.ArrayList;

public class GrassField extends AbstractWorldMap{
    private final int grassAmount;
    private final ArrayList<Grass> grasses;

    public GrassField(int x){
        this.grassAmount = x;
        this.grasses = new ArrayList<>();
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
            grasses.add(kepka);
        }
    }

    Vector2d findingUpperCorner(){
        Vector2d rightUpCorner = new Vector2d((int) (-2*Math.pow(10,9)), (int) (-2*Math.pow(10,9)));

        for(Animal animal:this.animals){
            Vector2d pos = animal.getPosition();
            rightUpCorner = rightUpCorner.upperRight(pos);
        }
        for(Grass grass:this.grasses){
            Vector2d pos = grass.getPosition();
            rightUpCorner = rightUpCorner.upperRight(pos);
        }
        return rightUpCorner;
    }

    Vector2d findingLowerCorner(){
        Vector2d leftDownCorner = new Vector2d((int) (2*Math.pow(10,9)), (int) (2*Math.pow(10,9)));

        for(Animal animal:this.animals){
            Vector2d pos = animal.getPosition();
            leftDownCorner = leftDownCorner.lowerLeft(pos);
        }
        for(Grass grass:this.grasses){
            Vector2d pos = grass.getPosition();
            leftDownCorner = leftDownCorner.lowerLeft(pos);
        }
        return leftDownCorner;
    }
    @Override
    public Object objectAt(Vector2d position){
        Object x = super.objectAt(position);
        if (x != null)
            return x;
        for (Grass grass: this.grasses){
            if(grass.isAt(position))
                return grass;
        }
        return null;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        boolean x = super.isOccupied(position);
        if(x)
            return x;
        for(Grass grass: this.grasses){
            if(grass.isAt(position))
                return true;
        }
        return false;
    }




}

