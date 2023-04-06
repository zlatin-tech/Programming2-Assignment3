/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment3;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author zlatintsvetkov
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Scientist> als = new ArrayList();
        ArrayList<Project> alp = new ArrayList();

        boolean flag = true;
        while (flag) {
            System.out.println("Menu");
            System.out.print("1- Add Project 2- Add Scientist 3- Show full info 4- Show info based on scientist name\n"
                    + " 5- Delete Project 6- Delete Scientist 7- Exit. Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    scanner.nextLine(); //necessary because nextLine gives us trouble when used next(anything other than Line) previously
                    System.out.print("Enter the project number: ");
                    String projectNo = scanner.nextLine();
                    boolean flag1;
                    do {

                        //validate whether it's null
                        while (projectNo.trim().equals("")) {
                            System.out.print("Project number cannot be null. Enter the project number: ");
                            projectNo = scanner.nextLine();
                        }

                        //validate whether it's unique
                        flag1 = false;
                        for (int i = 0, s = alp.size(); i < s; i++) {
                            if (alp.get(i).getPNo().equals(projectNo)) {
                                flag1 = true;
                                break;
                            }
                        }
                        if (flag1) {
                            System.out.print("Duplicate value. Enter the project number: ");
                            projectNo = scanner.nextLine();
                        }
                    } while (flag1);

                    System.out.print("Enter the project name: ");
                    String projectName = scanner.nextLine();
                    Project project = new Project(projectNo, projectName);
                    alp.add(project);
                    break;
                case 2:
                    //check if any projects exist even
                    if (alp.size() == 0) {
                        System.out.println("There are no existing projects. Scientist cannot be created. ");
                        break;
                    }
                    scanner.nextLine(); //necessary because nextLine gives us trouble when used next(anything other than Line) previously
                    System.out.print("Enter the Scientist's number: ");
                    String scientistNo = scanner.nextLine();

                    do {

                        //validate whether it's null
                        while (scientistNo.trim().equals("")) {
                            System.out.print("Scientist number cannot be null. Enter the scientist's number: ");
                            scientistNo = scanner.nextLine();
                        }

                        //validate whether it's unique
                        flag1 = false;
                        for (int i = 0, s = als.size(); i < s; i++) {
                            if (als.get(i).getSNo().equals(scientistNo)) {
                                flag1 = true;
                                break;
                            }
                        }
                        if (flag1) {
                            System.out.print("Duplicate value. Enter the scientist's number: ");
                            scientistNo = scanner.nextLine();
                        }
                    } while (flag1);
                    System.out.print("Enter the scientist's name: ");
                    String scientistName = scanner.nextLine();
                    System.out.print("Enter the number of projects taken: ");
                    String[] pNo = new String[scanner.nextInt()];
                    scanner.nextLine();//necessary because nextLine gives us trouble when used next(anything other than Line) previously
                    for (int i = 0; i < pNo.length; i++) {
                        System.out.print("Enter the project number: ");
                        pNo[i] = scanner.nextLine();
                        flag1 = false; // make it true if we find a match/referenced primary key
                        while (!flag1) {
                            for (int j = 0, s = alp.size(); j < s; j++) {
                                flag = true;
                                break;
                            }
                            if (!flag1) {
                                System.out.print("Not valid. Enter the project number: ");
                                pNo[i] = scanner.nextLine();
                            }
                        }
                    }
                    break;
                case 3:
                    
                    
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.out.println("Bye bye");
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }

        }

    }

}
