package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Student {

    private int id;
    private String firstName;
    private String lastName;
    private int[] marks;
    private double average;

    public Student(){
        this.setName();
    }

    private void setName(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter first name, please: ");
        this.firstName = input.nextLine();
        System.out.println("Enter last name, please: ");
        this.lastName = input.nextLine();
        this.setMarks();
    }

    private void setMarks(){
        Scanner input = new Scanner(System.in);
        System.out.println("How many marks has this student?");
        int number = input.nextInt();
        this.marks = new int[number];
        System.out.println("Initial all marks, please:");
        for(int i = 0; i < number; i++){
            System.out.print("1. ");
            Scanner in = new Scanner(System.in);
            this.marks[i] = in.nextInt();
        }
        this.setAverage();
    }

    public void setAverage(){
        this.average = (double)Arrays.stream(this.marks).sum() / this.marks.length;
    }

    public double getAverage(){
        return this.average;
    }

    public void printStudentInfo(){
        System.out.println("Id: " + this.id);
        System.out.println("First name: " + this.firstName);
        System.out.println("Last name: " + this.lastName);
        System.out.println("Average score: " + this.average);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
