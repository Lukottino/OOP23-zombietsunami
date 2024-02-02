package zombieTsunami.model;


public class EntityImpl {
    private int STREGHT;
    private int mapX, mapY;
    private int speed;
    private final int NUM=4;

    private enum Direction {
        UP, RIGHT,NONE
    };

    private Direction dir = Direction.RIGHT;
    public Direction getDir() {
        return dir;
    }
    protected void setDirUp() {
        this.dir = Direction.UP;
    }
    protected void setDirRight() {
        this.dir = Direction.RIGHT;
    }
    public int getX() {
        return mapX;
    }

    public void setX(int x) {
        this.mapX = x;
    }

    public int getY() {
        return mapY;
    }

    public void setY(int y) {
        this.mapY = y;
    }
    
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    public int getNumX() {
        return this.NUM;
    }
    
    public int getStrenght(){
        return this.STREGHT;
    }
    public void increaseStrenght(){
        this.STREGHT++;
    }
    public void setStrenght(int strenght){
        this.STREGHT=strenght;
    }
}

