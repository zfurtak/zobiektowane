package agh.ics.oop;
import java.util.ArrayList;
import java.util.Enumeration;

import static java.lang.System.out;

public class World {
    public static void main(String[] args){
        out.println("Start");
        run(toEnum(args));
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
