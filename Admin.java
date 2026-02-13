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
    	
    	System.out.print("Section Number: ");
    	int section=scanner.nextInt();
    	
    	System.out.print("Location: ");
    	String location=scanner.nextLine();
    	
    	//Create new course and added to lists
    	Course newCourse=new Course(name,id,max,instructor,section,location);
    	courses.add(newCourse);
    	
    	System.out.println("Course created");
    }
    public void deleteCourse() {
    	Scanner scanner=new Scanner(System.in);
    	
    	System.out.print("Enter Course Id to Delete: ");
    	String courseID=scanner.nextLine();
    	
    	//find the course and delete
    	for(int i=0;i<courses.size();i++) {
    		if(courses.get(i).getCourseId().equals(courseID)) {
    			courses.remove(i);
    			System.out.println(courseID+" is deleted");
    			return;
    		}
    	}
    	System.out.println(courseID+" is not found");
    }
    
    public void editCourse() {
    	Scanner scanner=new Scanner(System.in);
    	System.out.println("Enter Course Id to edit: ");
    	String courseID=scanner.nextLine();
    	
    	Course target=null;
    	for(Course c: courses) {
    		if(c.getCourseId().equals(courseID)) {
    			target=c;
    			break;
    		}
    	}
    	
    	if(target==null) {
    		System.out.println("Course not found");
    		return;
    	}
    	
    	System.out.println("What do you want to edit?");
    	System.out.println("1: Maximum Students\n2: Instructor\n3: Section Number\n4: Location");
    	System.out.println("What do you want to edit?");
    	String choice=scanner.nextLine();
    	
    	switch(choice) {
    	case"1":
    		System.out.println("New Maximum Students is: ");
    		target.setmaxStudents(scanner.nextInt());
    		break;
    	case"2":
    		System.out.println("The New Instructor is: ");
    		target.setinstructor(scanner.nextLine());
    		break;
    	case"3":
    		System.out.println("The New Section Number is: ");
    		target.setSectionNumber(scanner.nextInt());
    		break;
    	case"4":
    		System.out.println("The New Location is: ");
    		target.setCourseLocation(scanner.nextLine());
    		break;
    	default:
    		System.out.println("Invalid Choice");
    		return;
    	
    	}
    	System.out.println("Course Information Updated");
    	
    }
    public void 
    
    
}