import java.util.Date;

public class GreenActivity {
    /* Encapsulated variables */
    private int activityId;
    private String activityType;
    private int points;
    private Date logTime;

    /* Creating a constructor to set tha values in private variables */
    public GreenActivity(int activityId, String activityType, int points, Date logTime) {
        this.activityId = activityId;
        this.activityType = activityType;
        this.points = points;
        this.logTime = logTime;
    }

    /* Getter method to return the value to the function */
    public String getActivityType() {
        return activityType;
    }

    public int getPoints() {
        return points;
    }

    public Date getDate() {
        return logTime;
    }

    /*
     * Parametwr choice gets value from the userinput from the main file after login
     */
    static String getActivityType(int choice) {
        /* Choice is a parameter whose value is assigned through the Main class */
        switch (choice) {
            case 1:
                return "Walking or Cycling";
            case 2:
                return "Saving Electricity";
            case 3:
                return "Using Reusable Materials";
            default:
                return "Invalid";
        }
    }

    /*
     * From Main class the value of choice is passed and the points is returned
     * choice gets value form the user
     */

    static int getPoints(int choice) {
        switch (choice) {
            case 1:
                return 10;
            case 2:
                return 8;
            case 3:
                return 6;
            default:
                return 0;
        }
    }
}