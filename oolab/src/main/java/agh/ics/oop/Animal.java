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
                case SOUTH -> this.position = this.position.subtract(new Vector2d(0,1));
                case NORTH -> this.position = this.position.add(new Vector2d(0, 1));
                case EAST -> this.position = this.position.add(new Vector2d(1,0));
                case WEST -> this.position = this.position.subtract(new Vector2d(1,0));
            }
        } else if(direction.equals(MoveDirection.BACKWARD)){
            switch (this.orient) {
                case SOUTH -> this.position = this.position.add(new Vector2d(0, 1));
                case NORTH -> this.position = this.position.subtract(new Vector2d(0,1));
                case EAST -> this.position = this.position.subtract(new Vector2d(1,0));
                case WEST -> this.position = this.position.add(new Vector2d(1,0));
            }
        }
        if (this.position.x >= rozmiar){ this.position = this.position.subtract(new Vector2d(1,0));
        } else if (this.position.x < 0){
            this.position = this.position.add(new Vector2d(1,0));
        }
        if (this.position.y >= rozmiar){
            this.position = this.position.subtract(new Vector2d(0,1));
        } else if (this.position.y < 0){
            this.position = this.position.add(new Vector2d(0, 1));
        }

    }

}
