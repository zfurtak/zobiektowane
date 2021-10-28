package agh.ics.oop;

import java.util.ArrayList;

public class OptionsParser {
    public static ArrayList<MoveDirection> parse(String[] args) {
        ArrayList<MoveDirection> kierunki = new ArrayList<MoveDirection>();
        for (String arg : args)
            switch (arg) {
                case "forward", "f" -> kierunki.add(MoveDirection.FORWARD);
                case "backward", "b" -> kierunki.add(MoveDirection.BACKWARD);
                case "right", "r" -> kierunki.add(MoveDirection.RIGHT);
                case "left", "l" -> kierunki.add(MoveDirection.LEFT);
            }
        return kierunki;
    }
}
