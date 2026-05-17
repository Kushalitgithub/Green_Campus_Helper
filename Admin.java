import java.util.ArrayList;

/*Admin is the subclass that extends user and implements Reportable */
public class Admin extends User implements Reportable {
    private static ArrayList<GreenActivity> allActivities = new ArrayList<>();

    // empty constructor
    public Admin() {
    }

    // setter method to initialize admin details
    public void setAdminDetails(int userId, String name, String email, String password) {
        setUserId(userId);
        setName(name);
        setEmail(email);
        setPassword(password);
        setRole("Admin");
    }

    /*
     * this method accepts the parameter of array list of normal user
     * whose varibale is users
     */
    public void viewUserActivities(ArrayList<NormalUser> users) {
        // code to view user activities
        /* For each loop to print the activity of current noraml user from users */
        for (NormalUser user : users) {
            System.out.println("Activities for user: " + user.getName());
            // Assuming NormalUser has a method getActivities() that returns a list of
            /* To print the activity of normal user */
            for (GreenActivity activity : user.getActivities()) {
                System.out.println(activity);
            }
        }
    }

    /* Method to print all the activities that is logged by multiple users */
    public void viewAllActivities() {
        if (allActivities.isEmpty()) {
            System.out.println("No activities have been logged yet.");
            return;
        }
        System.out.println("All user activities:");
        for (GreenActivity g : allActivities) {
            System.out.println(g.getActivityType() + " - " + g.getDate() + " Points: " + g.getPoints());
        }
    }

    /*
     * Implementing polymorphism to reuse the the method from the Reportable class
     */
    @Override
    public void generateReport() {
        System.out.println("Want to generate report? (y/n)");
        if (GreenActivityMain.sc.next().equalsIgnoreCase("y")) {
            System.out.println("Generating sustainability report...");
            // use the global list for the report
            viewAllActivities();
            System.out.println("Total activities logged: " + allActivities.size());
        } else {
            System.out.println("Report generation cancelled.");
        }
    }

    /*
     * Adding activities to allActivities arraylist from the user input and
     * parameter reciev value
     * from GreenActivity class
     */
    public static void addActivity(GreenActivity activity) {
        allActivities.add(activity);
    }

}
