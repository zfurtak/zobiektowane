package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {
    Animal Bob = new Animal();
    Animal Mike = new Animal();
    @Test
    void everythingTest(){
        String[] lista = new String[] {"f", "f", "r"};
        ArrayList<MoveDirection> kierunki = new ArrayList<MoveDirection>(OptionsParser.parse(lista));
        for(MoveDirection arg : kierunki){Bob.move(arg);}
        assertEquals(2, Bob.getPosition().x);
        assertEquals(4, Bob.getPosition().y);
        assertEquals(MapDirection.EAST, Bob.getOrient());

        String[] lista1 = new String[] {"b", "b", "b", "l", "f"};
        ArrayList<MoveDirection> kierunki1 = new ArrayList<MoveDirection>(OptionsParser.parse(lista1));
        for(MoveDirection arg : kierunki1){Mike.move(arg);}
        assertEquals(1, Mike.getPosition().x);
        assertEquals(0, Mike.getPosition().y);
        assertEquals(MapDirection.WEST, Mike.getOrient());

    }
}
