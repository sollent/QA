package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Group {

    private int id;
    private Student[] students;
    private double averageMark;

    public Group(){
        setStudents();
    }

    private void setStudents(){
        Scanner input = new Scanner(System.in);
        System.out.println("How many student will be contain the group?");
        int number = input.nextInt();
        this.students = new Student[number];
        System.out.println("Initial all students, please:");
        for(int i = 0; i < number; i++){
            Student student = new Student();
            student.setId(i + 1);
            this.students[i] = student;
        }
        this.setAverageMark();
    }

    public void printGroupInformation(){
        System.out.println("Group id: " + this.id);
        System.out.println("\nAll students:\n");
        for(int i = 0; i < this.students.length; i++){
            this.students[i].printStudentInfo();
            System.out.println();
        }
        System.out.println("Average score of the group: " + this.averageMark);
    }

    public void printGroupShortInfoemation(){
        System.out.println("Group id: " + this.id);
        System.out.println("Count of students: " + this.students.length);
        System.out.println("Average score of the group: " + this.averageMark);
    }

    public void setAverageMark(){
        double[] averageScores = new double[this.students.length];
        for(int i = 0; i < this.students.length; i++){
            double averageStudentScore = this.students[i].getAverage();
            averageScores[i] = averageStudentScore;
        }
        this.averageMark = Arrays.stream(averageScores).sum() / this.students.length;
    }

    public double getAverageMark(){
        return this.averageMark;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Student[] getStudents(){
        return this.students;
    }
}
