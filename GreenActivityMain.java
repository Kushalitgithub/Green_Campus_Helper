
//Importing the Scanner class to read user input
import java.util.Scanner;
//Importing arraylist to store the activities
import java.util.ArrayList;

public class GreenActivityMain {
    /* Declaring static to access variables of arraylist without creating objects */
    static ArrayList<NormalUser> Users = new ArrayList<>();
    static ArrayList<Admin> admins = new ArrayList<>();
    static ArrayList<GreenActivity> activities = new ArrayList<>();
    /* Static scanner to access without creating object */
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        /* Implementong try catch block to handle risky code and exceptions */
        try {
            /* While true loops runs until user choose option exit */
            while (true) {
                System.out.println("Green Activity Tracker");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");

                /* Taking userinput */

                int choice = sc.nextInt();
                switch (choice) {
                    /* Block of code to register the user */
                    case 1:
                        System.out.println("Enter your First name: ");
                        String name = sc.next();
                        System.out.println("Enter your email: ");
                        String email = sc.next();
                        System.out.println("Enter your password: ");
                        String password = sc.next();
                        /* Logic for role selection */
                        System.out.println("Choose your role: 1. Admin 2. Normal User");
                        int roleChoice = sc.nextInt();

                        if (roleChoice == 1) {
                            Admin admin = new Admin();
                            admin.setAdminDetails(admins.size() + 1, name, email, password);
                            admins.add(admin);
                            System.out.println("Admin registered successfully!");

                        } else if (roleChoice == 2) {
                            NormalUser user = new NormalUser();
                            user.setUserDetails(Users.size() + 1, name, email, password);
                            Users.add(user);
                            System.out.println("Normal User registered successfully!");
                        }

                        else {
                            System.out.println("Invalid input!!!");
                        }
                        break;

                    case 2:// Call the login method

                        System.out.println("Enter your email: ");
                        String loginEmail = sc.next();
                        System.out.println("Enter your password: ");
                        String loginPassword = sc.next();
                        /*
                         * declaring boolean false to check the condition if it remains false till last
                         * then it prints invalid input
                         */
                        // Inside case 2: login

                        boolean isThere = false;

                        // Check Admins
                        for (Admin a : admins) {
                            if (a.getEmail().equals(loginEmail) && a.getPassword().equals(loginPassword)) {
                                isThere = true;
                                a.login();

                                // Admin menu loop
                                boolean adminLoggedIn = true;
                                while (adminLoggedIn) {
                                    System.out.println("What would you like to do?");
                                    System.out.println("1. View activities");
                                    System.out.println("2. Generate report");
                                    System.out.println("3. Logout");
                                    int adminChoice = sc.nextInt();

                                    switch (adminChoice) {
                                        case 1:
                                            a.viewAllActivities();
                                            break;
                                        case 2:
                                            System.out.println("Generating report...");
                                            a.generateReport();
                                            break;
                                        case 3:
                                            System.out.println("Logging out...");
                                            a.logout();
                                            adminLoggedIn = false; // exit admin menu loop
                                            break;
                                        default:
                                            System.out.println("Invalid input");
                                    }
                                }
                            }
                        }

                        // Check Normal Users
                        for (NormalUser u : Users) {
                            if (u.getEmail().equals(loginEmail) && u.getPassword().equals(loginPassword)) {
                                isThere = true;
                                u.login();

                                // Normal User menu loop
                                boolean userLoggedIn = true;
                                /* Loop that euns until user choose logout */
                                while (userLoggedIn) {
                                    System.out.println("What would you like to do?");
                                    System.out.println("1. Log Green Activity");
                                    System.out.println("2. View My Activities");
                                    System.out.println("3. Logout");

                                    int userChoice = sc.nextInt();
                                    /* takes userChoice */
                                    switch (userChoice) {
                                        case 1:
                                            System.out.println("Logging activity...");
                                            System.out.println("Choose Activity");
                                            System.out.println("1. Walking or Cycling");
                                            System.out.println("2. Saving Electricity");
                                            System.out.println("3. Using Reusable Materials");

                                            int actChoice = sc.nextInt();
                                            /*
                                             * Takes input from user and pass the value to the GreenActivity class"s
                                             * ,method
                                             */
                                            String actType = GreenActivity.getActivityType(actChoice);
                                            int pts = GreenActivity.getPoints(actChoice);
                                            /* new java.util.Date() returns the current time */
                                            GreenActivity act = new GreenActivity(activities.size() + 1, actType, pts,
                                                    new java.util.Date());
                                            /* store the logged activities to log activity and activities arraylist */
                                            u.logActivity(act);
                                            activities.add(act);
                                            break;
                                        case 2:
                                            u.viewActivities();
                                            break;
                                        case 3:
                                            System.out.println("Logging out...");
                                            u.logout();
                                            userLoggedIn = false; // exit user menu loop
                                            break;
                                        default:
                                            System.out.println("Invalid input");
                                    }
                                }
                            }
                        }
                        /* when bolean is false so this condition runs */
                        if (!isThere) {
                            System.out.println("Invalid email or password!");
                        }

                        break;
                    case 3:
                        /* Exiting the application */
                        System.out.println("Exiting Application..");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid input!");
                        break;
                }
            }
            /* catch block handles the exceptions */
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}