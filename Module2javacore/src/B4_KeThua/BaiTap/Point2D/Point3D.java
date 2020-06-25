package B4_KeThua.BaiTap.Point2D;

public class Point3D extends Point2D {
    private float z;

    public Point3D(float z, float x, float y) {
        super(x, y);
        this.z = z;
    }

    public Point3D() {
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float[] setXYZ(float x, float y, float z) {
        float array3D[] = new float[3];
        array3D[0] = getX();
        array3D[1] = getY();
        array3D[2] = getZ();
        return array3D;
    }

    @Override
    public String toString() {
        return "(" + this.getX() + "," + this.getY() + "," + this.getZ() + ")";
    }
}
