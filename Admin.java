import java.util.ArrayList;
import java.util.Scanner;

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
    public void createCourse() {
    	Scanner scanner=new Scanner(System.in);
    	System.out.println("/n==== Create New Course ====");
    	System.out.print("Course Name:");
    	String name=scanner.nextLine();
    	
    	System.out.print("Course ID: ");
    	String id=scanner.nextLine();
    	
    	System.out.print("Maximum Students: ");
    	int max=scanner.nextInt();
    	
    	System.out.print("Instructor: ");
    	String instructor = scanner.nextLine();
    	
    	
    }
}