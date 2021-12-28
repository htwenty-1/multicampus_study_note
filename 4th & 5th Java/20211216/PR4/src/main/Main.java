package main;

import cls.DanceRobot;
import cls.DrawRobot;
import cls.Robot;
import cls.SingRobot;

public class Main {

    public static void main(String[] args) {
	    Robot[] arr = { new DanceRobot(), new DrawRobot(), new SingRobot() };
        for (int i = 0; i < arr.length; i++) {
            action(arr[i]);
        }
    }

    public static void action(Robot robot) {
        if(robot instanceof DanceRobot) {
            DanceRobot dr = (DanceRobot) robot;
            dr.dance();
        } else if (robot instanceof SingRobot) {
            ((SingRobot) robot).sing();
        } else if (robot instanceof DrawRobot) {
            ((DrawRobot) robot).draw();
        }
    }

    /* 또 다른 방법
    public static void main(String[] args) {
	    Object[] arr = { new DanceRobot(), new DrawRobot(), new SingRobot() };
        for (int i = 0; i < arr.length; i++) {
            action(arr[i]);
        }
    }

    public static void action(Object robot) {
        if(robot instanceof DanceRobot) {
            DanceRobot dr = (DanceRobot) robot;
            dr.dance();
        } else if (robot instanceof SingRobot) {
            ((SingRobot) robot).sing();
        } else if (robot instanceof DrawRobot) {
            ((DrawRobot) robot).draw();
        }
    }
    */
}
