package ss6_inheritance.bai_tap.MovablePoint_extends_point.controller;

import ss6_inheritance.bai_tap.MovablePoint_extends_point.model.MovablePoint;

public class MovablePointTest {
    public static void main(String[] args) {
        MovablePoint movablePoint = new MovablePoint(3,4,4,4);
        System.out.println(movablePoint);
        movablePoint.move();
        System.out.println(movablePoint);
    }
}
