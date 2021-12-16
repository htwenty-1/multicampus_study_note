package cls;

import java.util.Arrays;
import java.util.Objects;

public class Point3D /* extends Object */ {
    int x, y, z;
    public Point3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point3D() {
        this(0,0,0);
    }

    @Override
    public boolean equals(Object obj) {
        Point3D p2 = (Point3D) obj;
        return x == p2.x && y == p2.y && z == p2.z;
    }

    @Override
    public String toString() {
        return "Point3D{" + "x=" + x + ", y=" + y + ", z=" + z + '}';       // cmd + n
    }
}
