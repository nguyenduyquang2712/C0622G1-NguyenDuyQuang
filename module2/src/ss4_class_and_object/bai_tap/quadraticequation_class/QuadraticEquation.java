package ss4_class_and_object.bai_tap.quadraticequation_class;

public class QuadraticEquation {
    private double constantA;
    private double constantB;
    private double constantC;
    public QuadraticEquation() {
        this.constantA = 0;
        this.constantB = 0;
        this.constantC = 0;
    }

    public double getConstantA() {
        return this.constantA;
    }

    public double getConstantB() {
        return constantB;
    }

    public double getConstantC() {
        return constantC;
    }

    public void setConstantA(double a) {
        this.constantA = a;
    }

    public void setConstantB(double b) {
        this.constantB = b;
    }

    public void setConstantC(double c) {
        this.constantC = c;
    }

    public double getDiscriminant() {
        double delta;
        delta = this.getConstantB() * this.getConstantB() - 4 * this.getConstantA() * this.getConstantC();
        return delta;
    }

    public double getRoot1() {
        double root1;
        root1 = (-this.getConstantB() + Math.pow(this.getDiscriminant(), 0.5)) / (2 * this.getConstantA());
        return root1;
    }

    public double getRoot2() {
        double root2;
        root2 = (-this.getConstantB() - Math.pow(this.getDiscriminant(), 0.5)) / (2 * this.getConstantA());
        return root2;
    }
}
