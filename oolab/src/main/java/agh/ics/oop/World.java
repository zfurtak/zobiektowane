package agh.ics.oop;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Objects;

import static java.lang.System.out;

public class World {
    public static void main(String[] args){
        out.println("Start");
        MoveDirection[] directions = OptionsParser.parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        out.println("Stop");
    }

    public static MoveDirection[] toEnum(String [] args) {
        int size = args.length;
        MoveDirection[] kierunki = new MoveDirection[size];
        int i = 0;
        for (String arg : args) {
            switch (arg) {
                case "f" -> kierunki[i] = MoveDirection.FORWARD;
                case "r" -> kierunki[i] = MoveDirection.RIGHT;
                case "l" -> kierunki[i] = MoveDirection.LEFT;
                case "b" -> kierunki[i] = MoveDirection.BACKWARD;
            }
            i++;
        }
            return kierunki;
    }
        public static void run (MoveDirection[] kierunki){
            for (MoveDirection arg : kierunki) {
                switch (arg) {
                    case FORWARD -> out.println("Do przodu");
                    case RIGHT -> out.println("Na prawo");
                    case LEFT -> out.println("Na lewo");
                    case BACKWARD -> out.println("Do tyłu");
                }
            }

        }

    }