import java.io.Serializable; 

public class User implements Serializable{
    private static final long serialVersionUID = 1L;

    // Requirement 2 & 7 
    private String username; 
    private String password; 
    private String firstName; 
    private String lastName; 

    public User(String username, String password, String firstName, String lastName){
        this.username = username;
        this.password = password; 
        this.firstName = firstName; 
        this.lastName = lastName;
    }
    // getters 
    public String getUsername(){return username;}
    public String getPassword(){ return password; }
    public String getFirstName( ) { return firstName; }
    public String getLastName( ) { return lastName; }


    // setters 
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setFirstName(String firstName) {this.firstName = firstName; }
    public void setLastName(String lastName) {this.lastName = lastName; }
    // full name
    public String getFullName() {
        return firstName + " " + lastName;
    }

    // Check if the given password matches//
    public boolean checkPassword(String inputPassword){
        return password != null && password.equals(inputPassword);
    }

}
