package agh.ics.oop;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Objects;

import static java.lang.System.out;

public class World2 {
    public static void main(String[] args){
        out.println("Start");
        Vector2d position1 = new Vector2d(1,2);
        Vector2d position2 = new Vector2d(-2,1);
        position1.princik(position1);
        position1.princik(position2);
        position1.princik(position1.add(position2));
        //System.out.print("("+position1.x+", "+position1.y+") ");
        out.println("Stop");

    }
}

class Vector2d {
    public int x;
    public int y;
    public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
    }
    public String to_String(){ return "(" + this.x + "," + this.y + ")";}
    public void princik(Vector2d vector){
        out.println("("+vector.x+", "+vector.y+")");
    }
    public boolean precedes(Vector2d vec){ return vec.x >= this.x && vec.y >= this.y; }
    public boolean follows(Vector2d vec){ return vec.x <= this.x && vec.y <= this.y; }
    public Vector2d upperRight(Vector2d vec){
        int a = this.x;
        int b = this.y;
        if(vec.x >= this.x)
            a = vec.x;
        if (vec.y >= this.y)
            b = vec.y;
        return new Vector2d(a, b);
    }
    public Vector2d lowerLeft(Vector2d vec){
        int a = this.x;
        int b = this.y;
        if(vec.x <= this.x)
            a = vec.x;
        if (vec.y <= this.y)
            b = vec.y;
        return new Vector2d(a, b);
    }
    public Vector2d add(Vector2d vec){
        return new Vector2d(this.x+vec.x, this.y+vec.y);
    }
    public Vector2d subtract(Vector2d vec){
        return new Vector2d(this.x-vec.x, this.y-vec.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2d vector2d = (Vector2d) o;
        return x == vector2d.x && y == vector2d.y;
    }
    public Vector2d opposite(){
        return new Vector2d((-1)*this.x, (-1)*this.y);
    }


}

