package agh.ics.oop;

import agh.ics.oop.gui.App;

import javax.swing.*;
import java.util.ArrayList;

public class SimulationEngine implements IEngine, Runnable{
    private MoveDirection[] moves;
    private final ArrayList<Animal> animals;
    private final AbstractWorldMap map;
    private final int moveDelay;

    public SimulationEngine(AbstractWorldMap map, Vector2d[] animalPositions, int moveDelay){
        this.animals = new ArrayList<>();
        this.map = map;
        this.moveDelay = moveDelay;
        for (Vector2d position : animalPositions){
            Animal animal = new Animal(map, position);
            this.animals.add(animal);
            map.place(animal);
        }
    }

    public void getMoves(MoveDirection[] newMoves){
        this.moves = newMoves;
    }

    @Override
    public void run() {
        int movesLength = this.moves.length;
        int animalsSize = this.animals.size();
        for (int i = 0; i < movesLength; i++){
            int animalID = i % animalsSize;
            Animal animal = this.animals.get(animalID);
            animal.move(this.moves[i]);
            try {
                Thread.sleep(this.moveDelay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
