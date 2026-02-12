import java.util.ArrayList;

public class Admin extends User implements AdminInterface {

    private static final long serialVersionUID = 1L;

    private ArrayList<Course> courses;
    private ArrayList<Student> students;

    public Admin(String username, String password, String firstName, String lastName,
                 ArrayList<Course> courses, ArrayList<Student> students) {
        super(username, password, firstName, lastName);
        this.courses = courses;
        this.students = students;
    }
}