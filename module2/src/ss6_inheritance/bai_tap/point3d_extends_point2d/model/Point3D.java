package ss6_inheritance.bai_tap.point3d_extends_point2d.model;

import ss6_inheritance.bai_tap.point3d_extends_point2d.model.Point2D;

import java.util.Arrays;

public class Point3D extends Point2D {
    private float z = 0.0f;

    public Point3D() {

    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        super.setXY(x, y);
        this.z = z;
    }

    public float[] getXYZ() {
        float[] position = new float[3];
        position[0] = super.getX();
        position[1] = super.getY();
        position[2] = this.z;
        return position;
    }

    @Override
    public String toString() {
        return "Point3D{" +
                Arrays.toString(this.getXYZ()) +
                '}';
    }
}
