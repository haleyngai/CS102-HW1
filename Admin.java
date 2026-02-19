import java.util.ArrayList;
import java.io.IOException;
import java.io.FileWriter;
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
    @Override
    public void createCourse() {
    	if (courses == null) {
    		System.out.println("Error: Courses list not initialized.");
    		return;
    	}
    	Scanner scanner=new Scanner(System.in);
    	System.out.println("\n==== Create New Course ====");
    	System.out.print("Course Name:");
    	String name=scanner.nextLine();
    	
    	System.out.print("Course ID: ");
    	String id=scanner.nextLine();
    	
    	System.out.print("Maximum Students: ");
    	int max=scanner.nextInt();
    	scanner.nextLine();
    	
    	System.out.print("Instructor: ");
    	String instructor = scanner.nextLine();
    	
    	System.out.print("Section Number: ");
    	int section=scanner.nextInt();
    	scanner.nextLine();
    	
    	System.out.print("Location: ");
    	String location=scanner.nextLine();
    	
    	//Create new course and added to lists
    	Course newCourse=new Course(name,id,max,instructor,section,location);
    	courses.add(newCourse);
    	
    	System.out.println("Course created");
    }
    @Override
    public void deleteCourse() {
    	if (courses == null || courses.isEmpty()) {
    		System.out.println("No courses available to delete.");
    		return;
    	}
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
    @Override
    public void editCourse() {
    	if (courses == null || courses.isEmpty()) {
    		System.out.println("No courses available to edit.");
    		return;
    	}
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
    	String choice=scanner.nextLine();
    	
    	switch(choice) {
    	case"1":
    		System.out.println("New Maximum Students is: ");
    		target.setmaxStudents(scanner.nextInt());
    		scanner.nextLine();
    		break;
    	case"2":
    		System.out.println("The New Instructor is: ");
    		scanner.nextLine();
    		target.setinstructor(scanner.nextLine());
    		break;
    	case"3":
    		System.out.println("The New Section Number is: ");
    		target.setSectionNumber(scanner.nextInt());
    		scanner.nextLine();
    		break;
    	case"4":
    		System.out.println("The New Location is: ");
    		scanner.nextLine();
    		target.setCourseLocation(scanner.nextLine());
    		break;
    	default:
    		System.out.println("Invalid Choice");
    		return;
    	
    	}
    	System.out.println("Course Information Updated");
    	
    }
    @Override
    public void displayCourseInfo() {
    	if (courses == null || courses.isEmpty()) {
    		System.out.println("No courses available.");
    		return;
    	}
    	Scanner scanner=new Scanner(System.in);
    	
    	System.out.print("Enter Course ID: ");
    	String courseId=scanner.nextLine();
    	
    	for(Course c:courses) {
    		if(c.getCourseId().equals(courseId)) {
    			System.out.println("===== Course Information =====");
    			System.out.println("Course Name: " + c.getCourseName());
                System.out.println("Course ID: " + c.getCourseId());
                System.out.println("Section: " + c.getSectionNumber());
                System.out.println("Instructor: " + c.getInstructor());
                System.out.println("Location: " + c.getCourseLocation());
                System.out.println("Enrollment: " + c.getCurrentStudents() + "/" + c.getMaxStudents());
                System.out.println("==============================");
                return;
    		}
    	}
    	System.out.println("Course Not Found");
    }
    @Override
    public void registerStudent() {
    	if (students == null) {
    		System.out.println("Error");
    		return;
    	}
    	Scanner scanner=new Scanner(System.in);
    	System.out.println("===== Register New Students =====");
    	System.out.print("Username: ");
    	String username=scanner.nextLine();
    	System.out.print("Password: ");
    	String password=scanner.nextLine();
    	System.out.print("First Name: ");
    	String firstName=scanner.nextLine();
    	System.out.print("Last Name: ");
    	String lastName=scanner.nextLine();
    	
    	Student newStudent=new Student(username,password,firstName,lastName);
    	
    	students.add(newStudent);
    	System.out.println("Student Registered");
    	
    }
    @Override
    public void viewAllCourses() {
    	if(courses == null || courses.isEmpty()) {
    		System.out.println("No Course is Available");
    		return;
    	}
    	for(Course c: courses) {
    		System.out.println(
    				"Name: "+c.getCourseName()+
    				"| ID: "+c.getCourseId()+
    				"| Section: "+c.getSectionNumber()+
    				"| Enrollment: "+c.getCurrentStudents()+"/"+c.getMaxStudents());
    	}
    	System.out.println("===================================");
    }
    @Override
    public void viewFullCourses() {
    	if (courses == null || courses.isEmpty()) {
    		System.out.println("No courses available.");
    		return;
    	}
    	System.out.println("===== Full Courses =====");
    	boolean found=false;
    	
    	//find full courses
    	for(Course c:courses) {
    		if(c.getCurrentStudents()>=c.getMaxStudents()) {
    			System.out.println(
    					c.getCourseName()+" | "+
    					c.getCourseId()+" | "+
    					c.getSectionNumber()+" | "+
    					c.getCurrentStudents()+" | "+
    					c.getMaxStudents()+" | ");
    			found=true;
    		
    		}
    	}
    	if(!found) {
    		System.out.println("No Full Course is found");
    	}
    	System.out.println("====================================");
    	
    }
    @Override
    public void writeFullCoursesToFile() {
    	if (courses == null || courses.isEmpty()) {
    		System.out.println("No courses available.");
    		return;
    	}
    	try {
    		FileWriter writer=new FileWriter("FullCourses.txt");
    		writer.write("===== Full Courses =====\n");
    		
    		boolean found=false;
    		//check if it is full
            for (Course c : courses) {
                if (c.getCurrentStudents() >= c.getMaxStudents()) {
                    writer.write("Course: " + c.getCourseName() + "\n");
                    writer.write("ID: " + c.getCourseId() + "\n");
                    writer.write("Section: " + c.getSectionNumber() + "\n");
                    writer.write("Enrollment: " + c.getCurrentStudents() + "/" + c.getMaxStudents() + "\n");
                    writer.write("Instructor: " + c.getInstructor() + "\n");
                    writer.write("Location: " + c.getCourseLocation() + "\n");
                    writer.write("--------------------------------------------\n");
                    found = true;
                }
            }
            if(!found) {
            	writer.write("No full Courses is found");
            }
            
            writer.close();
            
    	}catch (IOException e) {
    		System.out.println("Error writeing a file: "+e.getMessage());
    	}
    }
    @Override
    public void viewStudentsInCourse() {
    	if (courses == null || courses.isEmpty()) {
    		System.out.println("No courses available.");
    		return;
    	}
    	Scanner scanner=new Scanner(System.in);
    	
    	System.out.print("Enter Course ID: ");
    	String courseID=scanner.nextLine();
    	System.out.print("Enter Section Number: ");
    	int section=scanner.nextInt();
    	scanner.nextLine();
    	
    	for(Course c:courses) {
    		if(c.getCourseId().equals(courseID)&& c.getSectionNumber()==(section)) {
    			System.out.println("===== Students in "+ c.getCourseName()+" =====");
    			
    			ArrayList<String> studentNames=c.getStudentNames();
    			if(studentNames.isEmpty()) {
    				System.out.println("There is no students in this course");
    			}else {
    				for(int i=0;i<studentNames.size();i++) {
    					System.out.println((i+1)+": "+studentNames.get(i));
    				}
    			}
    			System.out.println("===========================================");
    			return;
    		}
    	}
    	System.out.println("Course is not found");
    	
    }
    @Override
    public void viewCoursesByStudent() {
    	if (courses == null || courses.isEmpty()) {
    		System.out.println("No courses available.");
    		return;
    	}
    	Scanner scanner=new Scanner(System.in);
    	System.out.print("Enter Student First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Student Last Name: ");
        String lastName = scanner.nextLine();
        
        String fullName = firstName + " " + lastName;
        
        System.out.println("===== Courses for " + fullName + " =====");
        boolean found = false;
        
      
        for (Course c : courses) {
            if (c.getStudentNames().contains(fullName)) {
                System.out.println(
                    c.getCourseName()+" | "+
                    c.getCourseId()+" | "+
                    c.getSectionNumber());
                found = true;
            }
        }
        if(!found) {
        	System.out.println("This student has not registered any courses yet.");
        }
        System.out.println("========================================================");
    }
    @Override
    public void sortCoursesByEnrollment() {
    	if (courses == null || courses.isEmpty()) {
    		System.out.println("No courses available.");
    		return;
    	}
        ArrayList<Course> sortedCourses = new ArrayList<>(courses);
        
        //if current course students is less than the next, switch them
        for (int i = 0; i < sortedCourses.size() - 1; i++) {
            for (int j = 0; j < sortedCourses.size() - i - 1; j++) {
                if (sortedCourses.get(j).getCurrentStudents() < sortedCourses.get(j + 1).getCurrentStudents()) {
                    Course temp = sortedCourses.get(j);
                    sortedCourses.set(j, sortedCourses.get(j + 1));
                    sortedCourses.set(j + 1, temp);
                }
            }
        }
        
        
        System.out.println("===== Courses Sorted by Enrollment =====");

        for (Course c : sortedCourses) {

            System.out.println(
                c.getCourseName() + " | " +
                c.getCourseId() + " | Section: " +
                c.getSectionNumber() + " | Enrollment: " +
                c.getCurrentStudents() + "/" +
                c.getMaxStudents()
            );
        }

        System.out.println("===============================================================\n");
    }
}

