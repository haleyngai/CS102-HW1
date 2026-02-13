import java.util.ArrayList;
import java.util.Scanner;

// Requirement 07: Students inheriting from user and 
// Requirement 11: Storing a list of students
public class Student extends User implements StudentInterface{
    
    private ArrayList<Course> courses; 

    public Student(String username, String password, String firstName, String lastName, ArrayList<Course> courses){
        super(username, password, firstName, lastName);
        this.courses = courses; 
    }

    public void setCourses(ArrayList<Course> courses){
        this.courses = courses;
    }

    @Override 
    public void viewAllCourses(){
        if (courses == null || courses.isEmpty()){
            System.out.println("No courses available.");
            return; 
        }
        for (Course c : courses){
            System.out.println(c);
        }
    }

    @Override
    public void viewNotFullCourses(){
        if (courses == null || courses.isEmpty()){
            System.out.println("No courses available.");
            return; 
        }
        for (Course c : courses){
            if (!c.isFull()){
                System.out.println(c);
            }
        }
    }

    // register, withdraw, view, getCourse
    @Override
    public void registerOnCourse() {
        if (courses == null || courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine().trim();
        System.out.print("Enter section number: ");
        try {
            int sectionNumber = Integer.parseInt(scanner.nextLine().trim());
            String studentFullName = getFirstName() + " " + getLastName();
            
            for (Course c : courses) {
                if (c.getCourseName().equals(courseName) && c.getSectionNumber() == sectionNumber) {
                    if (c.addStudent(studentFullName)) {
                        System.out.println("Successfully registered in " + courseName + " Section " + sectionNumber);
                    } else {
                        System.out.println("Could not register: course is full or you are already registered.");
                    }
                    return;
                }
            }
            System.out.println("Course not found with that name and section.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid section number. Please enter a valid number.");
        }
    }

    @Override
    public void withdrawFromCourse(){
        if (courses == null || courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine().trim();
        System.out.print("Enter section number: ");
        try {
            int sectionNumber = Integer.parseInt(scanner.nextLine().trim());
            String studentFullName = getFirstName() + " " + getLastName();
        
            for (Course c: courses){
                if(c.getCourseName().equals(courseName) && c.getSectionNumber() == sectionNumber){
                    if(c.removeStudent(studentFullName)){
                        System.out.println("Successfully withdrawn from course: " + courseName + " Section " + sectionNumber);
                        return;
                    } else {
                        System.out.println("Could not withdraw: you are not registered in this course.");
                        return;
                    }
                }
            }
            System.out.println("Could not withdraw: course not found.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid section number. Please enter a valid number.");
        }
    }

    @Override 
    public void viewMyCourses(){
        if (courses == null || courses.isEmpty()){
            System.out.println("You are not registered in any courses.");
            return; 
        }
        String studentFullName = getFirstName() + " " + getLastName();
        boolean found = false; 
        for(Course c : courses){
            if (c.getStudentNames().contains(studentFullName)){
                System.out.println(c);
                found = true; 
            }
        }
        if (!found){
            System.out.println("You are not registered in any course.");
        }
    }

    @Override 
    public ArrayList<Course> getCourses(){
        return courses;
    }
}