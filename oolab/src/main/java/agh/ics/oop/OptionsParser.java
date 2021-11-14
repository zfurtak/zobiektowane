package agh.ics.oop;

import java.util.ArrayList;

public class OptionsParser {
    public static MoveDirection[] parse(String[] args) {
        int length = 0;
        for (String arg : args){
            switch (arg){
                case "f", "b", "r", "l", "forward", "backward", "right", "left" -> length ++;
            };
        }
        MoveDirection[] result = new MoveDirection[length];
        int ind = 0;
        for (String arg : args) {
            switch (arg) {
                case "forward", "f" -> {
                    result[ind] = (MoveDirection.FORWARD); ind++; }
                case "right", "r" -> {
                    result[ind] = (MoveDirection.RIGHT); ind++; }
                case "backward", "b" -> {
                    result[ind] = (MoveDirection.BACKWARD); ind++; }
                case "left", "l" -> {
                    result[ind] = (MoveDirection.LEFT); ind++; }
            }
        }
        return result;
    }
}
