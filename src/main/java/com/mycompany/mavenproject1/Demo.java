/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Quoc
 */
public class Demo {

    public static void main(String[] args) {
        List<Student> ls = new ArrayList<Student>();
        ls.add(new Student(1, "A", 8.8));
        ls.add(new Student(2, "B", 7.8));
        ls.add(new Student(3, "C", 9.8));
        ls.add(new Student(4, "D", 5.8));
        ls.add(new Student(5, "E", 8.1));
        System.out.println("==========");


//        ls.forEach(st -> System.out.println(st));
//        ls.sort((st1, st2) -> {
//            double t1 = st1.getPoint();
//            double t2 = st2.getPoint();
//            
//            if (t1 > t2)
//                return -1;
//            else if (t1 < t2)
//                return 1;
//            return 0;
//        });
//        System.out.println("==DS TANG THEO DIEM ==");
//        ls.forEach(st -> System.out.println(st));
//        
//        Student m = ls.stream().max((st1, st2) -> {
//            double t1 = st1.getPoint();
//            double t2 = st2.getPoint();
//            
//            if (t1 > t2)
//                return -1;
//            else if (t1 < t2)
//                return 1;
//            return 0;
//        }).get();
//        System.out.println(m);
//        IHello h = (String n, int y) -> {
//            System.out.printf("Hello %s - %d", n, y);
//        };
//        h.sayHello("A", 2022);
//        IHello h = new Hello();
//        h.sayHello("A", 2022);
//        Map<Integer, Student> ls = new HashMap<>();
//        ls.put(1, new Student(1, "A", 8.8));
//        ls.put(2, new Student(2, "B", 7.5));
//        ls.put(3, new Student(3, "C", 9.1));
//        
//        ls.keySet().forEach(x -> System.out.println(x));
//        ls.values().forEach(st -> Sy
    }
}

interface IHello {

    void sayHello(String name, int year);
}

class Hello implements IHello {

    public void sayHello(String name, int year) {
        System.out.printf("Hello %s - %d", name, year);
    }
}

class Student {

    private int id;
    private String name;
    private double point;

    public Student(int id, String name, double point) {
        this.id = id;
        this.name = name;
        this.point = point;
    }

    public String toString() {
        return String.format("%d - %s - %.1f\n", id, name, point);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPoint() {
        return point;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoint(double point) {
        this.point = point;
    }

}
