/*Abstarct class doesnt allow user to make a obkject od User class */
abstract class User {

    /* Encapsulating the variable */
    private int userId;
    private String name;
    private String email;
    private String password;
    private String role;

    // Setter methods for User class

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // getter methods for the user class
    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    /* Login and logout method that runs when login is sucessufully done */
    public void login() {
        System.out.println("Login successful as " + getRole() + ": " + getName());
    }

    public void logout() {
        System.out.println("Loggedout successfully " + getRole() + ": " + getName());
    }

    public void displayRole() {
        System.out.println("Role: " + role);
    }
}