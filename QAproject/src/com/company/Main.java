package com.company;

import java.util.Scanner;

public class Main {

    private static Group[] groups;

    public static void main(String[] args) {

        boolean quit = false;
        boolean firstVisited = false;

        while (!quit){ // If the flag of quit variable is false program will continue

            if(!firstVisited)
                System.out.println("1. Create new group and students with marks for the group");
            else System.out.println();
            System.out.print("2. Calculate the average mark of the student\n" +
                    "3. Calculate the average mark of the group\n" +
                    "4. View all groups information\n" +
                    "5. Quit\n");

            System.out.println("\nWhat do you want to do, man?\n");

            Scanner input = new Scanner(System.in);
            int option = input.nextInt();

            switch(option){
                case 1:
                    System.out.println("How many groups you want to create, man?");
                    int number = input.nextInt();
                    groups = new Group[number];
                    number = groups.length;
                    System.out.println("Initial all groups, please:");
                    for(int i = 0; i < number; i++){
                        Group group = new Group();
                        group.setId(i + 1);
                        groups[i] = group;
                    }
                    firstVisited = true;
                    break;
                case 2:
                    System.out.println("Enter group id, please:");
                    int grId = input.nextInt();
                    System.out.println("Enter student id, please:");
                    int stId = input.nextInt();
                    for(int i = 0; i < groups.length; i++){
                        if(groups[i].getId() == grId){
                            for(int j = 0; j < groups[i].getStudents().length; j++){
                                if(groups[i].getStudents()[j].getId() == stId)
                                    groups[i].getStudents()[j].printStudentInfo();
                            }
                        }
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Enter id of the group, please:");
                        int groupId = input.nextInt();
                        boolean flag = false;
                        System.out.println();
                        System.out.println("-----------------------------------------------------------------------------\n");
                        for(int i = 0; i < groups.length; i++){
                            if(groups[i].getId() == groupId){
                                groups[i].printGroupShortInfoemation();
                                flag = true;
                                break;
                            }
                        }
                        if(!flag)
                            System.out.print("There are no group with such id...");
                        System.out.println();
                        System.out.println("-----------------------------------------------------------------------------\n");
                    } catch (NullPointerException e){
                        System.out.println("There are no something groups still...\n");
                    }
                    break;
                case 4:
                    try {
                        System.out.println("View all groups information: \n");
                        System.out.println();
                        System.out.println("---------------------------------------------------\n");
                        for(int i = 0; i < groups.length; i++){
                            groups[i].printGroupInformation();
                            System.out.println();
                            System.out.println("---------------------------------------------------\n");
                        }
                    } catch (NullPointerException e){
                        System.out.println("There are no something groups...\n");
                    }
                    break;
                case 5:
                    quit = true;
                    break;
                default:
                    System.out.println("\nYou have written the incorrect data! Check your option, please.\n");
                    break;
            }

        }

    }
}
