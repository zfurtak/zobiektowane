package agh.ics.oop;

public class Animal {
    private Vector2d position = new Vector2d(2,2);
    private MapDirection orient = MapDirection.NORTH;
    private int rozmiar = 5;
    public String toString(){
        return "[" + "(" + this.position.x + ", " + this.position.y + ")" + "; " + this.orient + "]";
    }
    public Vector2d getPosition() {
        return this.position;
    }
    public MapDirection getOrient() {
        return this.orient;
    }
    public void move(MoveDirection direction){
        switch (direction){
            case RIGHT -> this.orient = this.orient.next();
            case LEFT -> this.orient = this.orient.previous();
        }
        if (direction.equals(MoveDirection.FORWARD)){
            switch (this.orient) {
                case SOUTH -> this.position.y -= 1;
                case NORTH -> this.position.y += 1;
                case EAST -> this.position.x += 1;
                case WEST -> this.position.x -= 1;
            }
        } else if(direction.equals(MoveDirection.BACKWARD)){
            switch (this.orient) {
                case SOUTH -> this.position.y += 1;
                case NORTH -> this.position.y -= 1;
                case EAST -> this.position.x -= 1;
                case WEST -> this.position.x += 1;
            }
        }
        if (this.position.x >= rozmiar){ this.position.x -= 1;
        } else if (this.position.x < 0){
            this.position.x += 1;
        }
        if (this.position.y >= rozmiar){
            this.position.y -= 1;
        } else if (this.position.y < 0){
            this.position.y += 1;
        }

    }

}
