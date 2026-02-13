import java.util.ArrayList; 
// req 06: interface for student with method signature
public interface StudentInterface {
  
	void viewAllCourses();
	void viewFullCourses();
	void registerOnCourse(String student);
	void sortCoursesByEnrollment(String firstName, String lastName);

    ArrayList<Course> getCourses();
	
}
