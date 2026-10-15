//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import database.user;
import service.ProjectService;
import service.userservice;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ProjectService projectService =
                new ProjectService();

        Scanner sc = new Scanner(System.in);

        userservice userService =
                new userservice();

        int choice;

        do {

            System.out.println();
            System.out.println("================================");
            System.out.println("      FREELANCERS HUB");
            System.out.println("================================");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.println("================================");

            System.out.print("Enter Choice : ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    userService.registerUser();
                    break;

                case 2:
                    userService.loginUser();
                    break;

                case 3:
                    System.out.println("Thank You");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }


        } while (choice != 3);
        userservice userService1 = new userservice();
       // userservice userservice1 = null;
        user user = userservice.loginUser();

        if (user != null) {

            if (user.getRole().equalsIgnoreCase("CLIENT")) {

                clientMenu();

            } else if (user.getRole().equalsIgnoreCase("FREELANCER")) {

                freelancerMenu();
            }


        }

    }

    public static void clientMenu() {
        System.out.println("1. Post Project");
        System.out.println("2. View My Projects");
        System.out.println("3. View Applications");
        System.out.println("4. Accept Application");
        System.out.println("5. Reject Application");
        System.out.println("6. Give Rating");
        System.out.println("7. Logout");
    }

    public static void freelancerMenu() {


            System.out.println("===== FREELANCER MENU =====");
            System.out.println("1. View All Projects");
            System.out.println("2. Apply Project");
            System.out.println("3. View Ratings");
            System.out.println("4. Logout");
    }
    public static void adminMenu() {

        System.out.println("\n===== ADMIN MENU =====");
        System.out.println("1. View Users");
        System.out.println("2. View Projects");
        System.out.println("3. View Applications");
        System.out.println("4. Delete User");
        System.out.println("5. Delete Project");
        System.out.println("6. Generate Report");
        System.out.println("7. Logout");
    }
}