package agh.ics.oop;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Objects;

import static java.lang.System.out;

public class World {
    public static void main(String[] args){
        out.println("Start");
        MoveDirection[] directions =new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        out.println("Stop");
    }
    public static ArrayList<Direction> toEnum(String [] args){
        ArrayList<Direction> lista = new ArrayList<Direction>();
        for(String arg : args)
            switch (arg) {
                case "f" -> lista.add(Direction.FORWARD);
                case "r" -> lista.add(Direction.RIGHT);
                case "l" -> lista.add(Direction.LEFT);
                case "b" -> lista.add(Direction.BACKWARD);
            }
        return lista;
    }
    public static void run(ArrayList<Direction> args){
        for(Direction arg : args)
            switch (arg) {
                case FORWARD -> out.println("Do przodu");
                case RIGHT -> out.println("Na prawo");
                case LEFT -> out.println("Na lewo");
                case BACKWARD -> out.println("Do tyłu");
            }
    }

}

