import java.util.ArrayList; 
// req 06: interface for student with method signature
public interface StudentInterface {
  
	void viewAllCourses();
	void viewNotFullCourses();
	void registerOnCourse();
	void withdrawFromCourse();
	void viewMyCourses();
    ArrayList<Course> getCourses();
	
}
