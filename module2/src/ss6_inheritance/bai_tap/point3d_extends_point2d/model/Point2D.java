package ss6_inheritance.bai_tap.point3d_extends_point2d.model;

import java.util.Arrays;

public class Point2D {
    private float x = 0.0f;
    private float y = 0.0f;
    public Point2D(){

    }
    public Point2D(float x, float y){
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    public void setXY(float x, float y){
        this.x = x;
        this.y = y;
    }
    public float[] getXY(){
        float[] position = new float[2];
        position[0] = this.x;
        position[1] = this.y;
        return position;
    }

    @Override
    public String toString() {
        return "Point2D{" +
                Arrays.toString(this.getXY())+
                '}';
    }
}
