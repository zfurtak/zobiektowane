package agh.ics.oop;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Objects;

import static java.lang.System.*;

public class World {
    public static void main(String[] args){
        try {
            out.println("Start");
            MoveDirection[] directions = OptionsParser.parse(args);
            AbstractWorldMap map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(1, 1), new Vector2d(3, 4)};
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
            out.println(map);
            out.println("Stop");
        }
        catch(IllegalArgumentException exception){
            exception.printStackTrace();
            out.println("koniec kropka");
            exit(1);
        }
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