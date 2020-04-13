package B4_KeThua.BaiTap.Point;

public class MoveablePoint extends Point {
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    public MoveablePoint(float x,float y,float xSpeed,float ySpeed){
        super(x,y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint() {
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed,float ySpeed){
        this.xSpeed =xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed(){
        float arraySpeed[] = new float[2];
        arraySpeed[0] = getxSpeed();
        arraySpeed[1] = getySpeed();
        return arraySpeed;
    }

    @Override
    public String toString() {
        return "(" + this.getX() + "," + this.getY() + ")" + "speed = (" + getxSpeed() + "," + getySpeed() +")";
    }

    public float moveX(){
        return getX() + xSpeed;
    }
    public float moveY(){
        return getY() + ySpeed;
    }
}
