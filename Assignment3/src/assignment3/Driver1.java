package assignment3;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author zlatintsvetkov
 */
public class Driver1 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Scientist> alS = new ArrayList();
        ArrayList<Project> alP = new ArrayList();
        boolean flag = true;//check whether to repeat the menu
        boolean flag1 = false; //used in different cases to check conditions
        boolean flag2;
        
        while (flag) {
            System.out.println("Menu");
            System.out.print("1- Add Project 2- Add Scientist 3- Show full info 4- Show info based on scientist name\n"
                    + " 5- Delete Project 6- Delete Scientist 7- Exit. Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    scanner.nextLine();//necessary because nextLine gives us trouble when used next(anything other than Line) previously
                    System.out.print("Enter the project's number: ");
                    String pNo = scanner.nextLine();
                    flag1 = true;
                    while (flag1) {
                        //validating NOT NULL constraint
                        if (pNo.trim().isEmpty()) {
                            System.out.print("Invalid input. Project number cannot be null. Enter the project's number: ");
                            pNo = scanner.nextLine();
                            continue;
                        } //validating NO SPACES constraint
                        if (isContainingSpace(pNo)) {
                            System.out.print("Invalid input. Project number cannot contain spaces. Enter the project's number: ");
                            pNo = scanner.nextLine();
                            continue;
                        }
                        //validating UNIQUE constraint
                        if (alP.size() > 0) {
                            flag2 = true;//reamins true if pNo is unique
                            for (int i = 0; i < alP.size(); i++) {
                                if (alP.get(i).getPNo().equals(pNo)) {
                                    System.out.print("Invalid input. This project already exists. Enter the project's number: ");
                                    pNo = scanner.nextLine();
                                    flag2 = false;
                                    break;
                                }
                            }
                            if (!flag2) {
                                continue;
                            }
                        }
                        
                        flag1 = false;
                    }
                    
                    System.out.print("Enter the project's name: ");
                    String pName = scanner.nextLine();
                    while (pName.trim().equals("")) {
                        System.out.print("Invalid input. Project name cannot be null. Enter the project's name: ");
                        pName = scanner.nextLine();
                    }
                    Project p = new Project(pNo, pName);
                    alP.add(p);
                    break;
                case 2:
                    scanner.nextLine();//necessary because nextLine gives us trouble when used next(anything other than Line) previously
                    if (alP.size() == 0) {
                        System.out.println("No existing projects; cannnot add a scientist.");
                        break;//breaks out of case 2
                    }
                    System.out.print("Enter the scientist's number: ");
                    String sNo = scanner.nextLine();
                    flag1 = true;
                    //validating scientist number
                    while (flag1) {
                        //validating NOT NULL constraint
                        if (sNo.trim().isEmpty()) {
                            System.out.print("Invalid input. Scientist number cannot be null. Enter the scientist's number: ");
                            sNo = scanner.nextLine();
                            continue;
                        } //validating NO SPACES constraint
                        if (isContainingSpace(sNo)) {
                            System.out.print("Invalid input. Scientist number cannot contain spaces. Enter the scientist's number: ");
                            sNo = scanner.nextLine();
                            continue;
                        }
                        //validating UNIQUE constraint
                        if (alS.size() > 0) {
                            flag2 = true;//reamins true if sNo is unique
                            for (int i = 0; i < alS.size(); i++) {
                                if (alS.get(i).getSNo().equals(sNo)) {
                                    System.out.print("Invalid input. This project already exists. Enter the project's number: ");
                                    sNo = scanner.nextLine();
                                    flag2 = false;
                                    break;
                                }
                            }
                            if (!flag2) {
                                continue;
                            }
                        }
                        
                        flag1 = false;
                    }
                    System.out.print("Enter the scientist's full name: ");
                    String sName = scanner.nextLine();
                    //validating sName NOT NULL constraint
                    while (sName.trim().isEmpty()) {
                        System.out.print("Scientist cannot be nameless. Enter the scientist's full name: ");
                        sName = scanner.nextLine();
                    }
                    System.out.print("Number of projects taken: ");
                    String[] projectsTaken = new String[scanner.nextInt()];
                    //validating that scientist belongs to at least one project and maximum all the projects
                    flag1 = true;
                    while (flag1) {
                        if (projectsTaken.length == 0) {
                            System.out.print("Invalid. Scientist needs to belong to at least one project. Number of projects taken: ");
                            projectsTaken = new String[scanner.nextInt()];
                            continue;
                        }
                        if (projectsTaken.length > alP.size()) {
                            System.out.print("Invalid. Scientist cannot belong to more projects than existing. Number of projects taken: ");
                            projectsTaken = new String[scanner.nextInt()];
                            continue;
                        }
                        flag1 = false;
                    }
                    //initializing projectsTaken array. This is necessary for later comparing
                    for (int i = 0; i < projectsTaken.length; i++) {
                        projectsTaken[i] = "";
                    }
                    
                    scanner.nextLine();//necessary because nextLine gives us trouble when used next(anything other than Line) previously
                    for (int i = 0; i < projectsTaken.length; i++) {
                        System.out.print("Enter the project number: ");
                        projectsTaken[i] = scanner.nextLine();
                        //validating referential integrity
                        flag1 = true;//remains TRUE until inputed project is proven to follow referential integrity
                        while (flag1) {
                            for (int j = 0; j < alP.size(); j++) {
                                if (alP.get(j).getPNo().equals(projectsTaken[i])) {
                                    flag2 = true;//make false if 
                                    for (int k = 0; k < projectsTaken.length; k++) {
                                        if (projectsTaken[k].equals(projectsTaken[i]) && (i != k)) {
                                            flag2 = false;
                                            break;
                                        }
                                    }
                                    if (flag2) {
                                        flag1 = false;
                                        break;
                                    }
                                }
                            }
                            if (flag1) {
                                System.out.print("Invalid project number. Referencing non-existent project or already assigned project. Enter the project number: ");
                                projectsTaken[i] = scanner.nextLine();
                            }
                        }
                    }
                    Scientist s = new Scientist(sNo, sName, projectsTaken);
                    alS.add(s);
                    
                    break;
                case 3:
                    if (alS.size() == 0) {
                        System.out.println("Scientists' list is empty.");
                    } else {
                        System.out.println("Scientists");
                        for (int i = 0; i < alS.size(); i++) {
                            System.out.printf("\t%s ", alS.get(i));
                            System.out.println("");
                        }
                        
                    }
                    if (alP.size() == 0) {
                        System.out.println("Projects' list is empty.");
                    } else {
                        System.out.println("Projects");
                        for (int i = 0; i < alP.size(); i++) {
                            System.out.printf("\t%s ", alP.get(i));
                            System.out.println("");
                        }
                    }
                    break;
                case 4:
                    scanner.nextLine();//necessary because nextLine gives us trouble when used next(anything other than Line) previously
                    if (alS.size() == 0) {
                        System.out.println("There are no existing scientists.");
                        break;//breaks out of case 4
                    }
                    do {
                        System.out.print("Enter the scientist's name: ");
                        String searchName = scanner.nextLine();
                        flag2 = false;//turn TRUE when we find matching scientist
                        for (int i = 0; i < alS.size(); i++) {
                            if (searchName.equalsIgnoreCase(alS.get(i).getSName())) {
                                flag2 = true;
                                System.out.println(alS.get(i));
                            }
                        }
                        if (!flag2) {
                            System.out.println("No match for " + searchName);
                        }
                        System.out.print("Do you wish to search for another scientist (yes/no): ");
                        String searchChoice = scanner.nextLine().trim();
                        boolean flag3 = false;
                        //initialize flag1
                        while (!flag3) {
                            if (searchChoice.equalsIgnoreCase("yes")) {
                                flag3 = flag1 = true;
                            } else if (searchChoice.equalsIgnoreCase("no")) {
                                flag3 = true;
                                flag1 = false;
                            } else {
                                System.out.print("Invalid choice. Do you wish to search for another scientist (yes/no): ");
                                searchChoice = scanner.nextLine().trim();
                            }
                        }
                    } while (flag1);
                    
                    break;
                case 5:
                    if (alP.size() == 0) {
                        System.out.println("Project list is empty.");
                        break;
                    }
                    
                    scanner.nextLine();//necessary because nextLine gives us trouble when used next(anything other than Line) previously
                    System.out.print("Enter the project's number which you want to delete: ");
                    pNo = scanner.nextLine();
                    flag1 = false;//make true if we find a match
                    flag2 = false;//stays false if no scientist works on project (good)-- deletion anomaly
                    for (int i = 0; i < alP.size(); i++) {
                        if (alP.get(i).getPNo().equals(pNo)) {
                            flag1 = true;
                            if (alS.size() > 0) {
                                for (int j = 0; j < alS.size(); j++) {
                                    for (int k = 0; k < alS.get(j).getPNo().length; k++) {
                                        if (alP.get(i).getPNo().equals(alS.get(j).getPNo()[k])) {
                                            flag2 = true;
                                            break;
                                        }
                                    }
                                }
                            }
                            
                        }
                        System.out.println("Flag1: " + flag1 + " Flag2: " + flag2);
                        if (flag1 && !flag2) {
                            alP.remove(i);
                            System.out.println("Project removed.");
                            break;
                        }
                        
                    }
                    if (!flag1) {
                        System.out.println("Project not found.");
                    } else if (flag2) {
                        System.out.println("Deletion not possible. Integrity constraint violation.");
                    }
                    
                    break;
                case 6:
                    if (alS.size() == 0) {
                        System.out.println("Scientist list is empty.");
                        break;
                    }
                    scanner.nextLine();//necessary because nextLine gives us trouble when used next(anything other than Line) previously
                    System.out.print("Enter scientist's number who you want to delete: ");
                    sNo = scanner.nextLine();
                    flag1 = false;//make true if we find a match
                    for (int i = 0; i < alS.size(); i++) {
                        if (sNo.equals(alS.get(i).getSNo())) {
                            flag1 = true;
                            alS.remove(i);
                            System.out.println("Scientist removed");
                            break;
                        }
                    }
                    if (!flag1) {
                        System.out.println("Scientist not found.");
                    }
                    break;
                case 7:
                    System.out.println("bye bye");
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid input. Please try again");
                    break;
                
            }
            
        }
        
    }

    /**
     *
     * @param str
     * @return true if argument contains a space
     */
    public static boolean isContainingSpace(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                return true;
            }
        }
        return false;
    }
}
