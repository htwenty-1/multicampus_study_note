package main;

import cls.Point3D;

public class Main {

    public static void main(String[] args) {

        Point3D p1 = new Point3D(1,2,3);
        Point3D p2 = new Point3D(1,2,3);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println("p1==p2?"+(p1==p2));                 // 인스턴스 비교
        System.out.println("p1.equals(p2)?"+(p1.equals(p2)));   // 값 자체 비교


        // Object obj = new Point3D();
        // Point3D pd3 = (Point3D) obj;

    }
}
