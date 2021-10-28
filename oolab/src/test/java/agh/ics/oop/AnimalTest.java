package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {
    Animal Bob = new Animal();
    Animal Mike = new Animal();

    @Test
    void orientTest(){
        Bob.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.EAST, Bob.getOrient());
        Bob.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.SOUTH, Bob.getOrient());
        Mike.move(MoveDirection.LEFT);
        assertEquals(MapDirection.WEST, Mike.getOrient());
    }
    @Test
    void positionTest(){
        Bob.move(MoveDirection.FORWARD);
        Bob.move(MoveDirection.FORWARD);
        assertEquals(2, Bob.getPosition().x);
        assertEquals(4, Bob.getPosition().y);
        Mike.move(MoveDirection.RIGHT);
        Mike.move(MoveDirection.FORWARD);
        Mike.move(MoveDirection.FORWARD);
        assertEquals(4, Mike.getPosition().x);
        assertEquals(2, Mike.getPosition().y);
    }
    @Test
    void edgeTest(){
        Bob.move(MoveDirection.FORWARD);
        Bob.move(MoveDirection.FORWARD);
        Bob.move(MoveDirection.FORWARD);
        Bob.move(MoveDirection.FORWARD);
        assertEquals(4, Bob.getPosition().y);
        Mike.move(MoveDirection.BACKWARD);
        Mike.move(MoveDirection.BACKWARD);
        Mike.move(MoveDirection.BACKWARD);
        Mike.move(MoveDirection.BACKWARD);
        assertEquals(0, Mike.getPosition().y);
    }
    @Test void stringTest(){
        String[] lista = new String[] {"f", "f", "r"};
        ArrayList<MoveDirection> kierunki = new ArrayList<MoveDirection>(OptionsParser.parse(lista));
        ArrayList<MoveDirection> testowa = new ArrayList<MoveDirection>();
        testowa.add(MoveDirection.FORWARD);
        testowa.add(MoveDirection.FORWARD);
        testowa.add(MoveDirection.RIGHT);
        assertEquals(testowa, kierunki);
    }
}
