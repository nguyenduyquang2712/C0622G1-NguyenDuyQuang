package ss5_accessmodifier_static.thuc_hanh;

public class Student {
    public static void main(String[] args) {
        A a = new A();
        a.p(10);
        a.p(10.0);
    }
}

class A extends B {
    public void p(int number) {
        System.out.println(number);
    }
}

class B {
    public void p(double number) {
        System.out.println(number * 2);
    }
    }

