package ss6_inheritance.thuc_hanh.Example;

class Faculty extends Employee {
    public Faculty() {
        System.out.println("Faculty performing its tasks");
    }
//    public Faculty(int a) {
//        System.out.println(a);
//    }

    public static void main(String[] args) {
        new Faculty();
    }
}

class Employee extends Person {

//    public Employee() {
//        this("Employee overloading its tasks");
//        System.out.println("Employee performing its tasks!");
//    }

//    public Employee() {
//    }
}

class Person {
//    public Person(String s) {
//        System.out.println(s);
//    }
//
//    public Person() {
//
//    }
}