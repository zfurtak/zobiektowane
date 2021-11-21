package agh.ics.oop;

import java.util.ArrayList;

public class SimulationEngine implements IEngine{
    private final MoveDirection[] moves;
    private final ArrayList<Animal> animals;
    private final IWorldMap map;

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] animalPositions){
        this.moves = moves;
        this.animals = new ArrayList<>();
        this.map = map;
        for (Vector2d position : animalPositions){
            Animal animal = new Animal(map, position);
            this.animals.add(animal);
            map.place(animal);
        }
    }

    @Override
    public void run() {
        int movesLength = this.moves.length;
        int animalsSize = this.animals.size();
        for (int i = 0; i < movesLength; i++){
            int animalID = i % animalsSize;
            Animal animal = (Animal) this.animals.get(animalID);
            animal.move(this.moves[i]);
            //System.out.println(map);
        }
    }
}
