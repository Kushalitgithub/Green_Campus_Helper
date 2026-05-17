import java.util.ArrayList;

public class NormalUser extends User {
    // constructor to initialize the normal user object
    private ArrayList<GreenActivity> activities = new ArrayList<>();

    public NormalUser() {
        // empty constructor
    }

    public void setUserDetails(int userId, String name, String email, String password) {
        setUserId(userId);
        setName(name);
        setEmail(email);
        setPassword(password);
        setRole("Normal User");
    }

    /* This method reciev the object of GreenActivity Class as a parameter */
    public void logActivity(GreenActivity activity) {
        /*
         * add the recieved value to arraylist of GreenActivity and Admin allActivities
         */
        activities.add(activity);
        Admin.addActivity(activity); // Assuming Admin has a static list to store all activities
        System.out.println("Activity logged successfully.");
    }

    public void viewActivities() {
        /* Code to view all the activities of normal user */
        System.out.println("Your Activities:");
        for (GreenActivity activity : activities) {
            System.out.println("Activity: " + activity.getActivityType() + ", Points: " + activity.getPoints());
        }
    }

    /* getter method to return the value of activities */
    public ArrayList<GreenActivity> getActivities() {
        return activities;
    }
}
