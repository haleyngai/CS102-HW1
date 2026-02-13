public interface AdminInterface {
	//Requirement 3 Course Management
	void createCourse();
	void deleteCourse();
	void editCourse();
	void displayCourseInfo();
	void registerStudent();
	
	
	//Report method
	void viewAllCourses();
	void viewFullCourses();
	void writeFullCoursesToFile();
	void viewStudentsInCourse();//check students in course
	void viewCoursesByStudent();// check students' courses
	void sortCoursesByEnrollment();
	
    
}
