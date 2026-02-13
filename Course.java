import java.util.ArrayList;
import java.io.Serializable;
public class Course {
    private String courseName;
    private String courseId; 
    private int maxStudents;
    private int currentStudents;
    private ArrayList<String> studentNames; 
    private String instructor; 
    private int sectionNumber;
    private String courseLocation; 

    public Course(String courseName, String courseId, int maxStudents,
                String instructor, int sectionNumber, String courseLocation){

                this.courseName = courseName; 
                this.courseId = courseId; 
                this.maxStudents = maxStudents; 
                this.studentNames = new ArrayList<>();
                this.instructor = instructor; 
                this.sectionNumber = sectionNumber; 
                this.courseLocation = courseLocation; 
                }

    // getters            
    public String getCourseName() { return courseName; }
    public String getCourseId() { return courseId; }
    public int getMaxStudents() { return maxStudents; }
    public int getCurrentStudents() { return currentStudents; }
    public ArrayList<String> getStudentNames() { return studentNames; }
    public String getInstructor() { return instructor; }
    public int getSectionNumber() { return sectionNumber; }
    public String getCourseLocation() { return courseLocation; }

    // setters
    public void setinstructor(String instructor){ this.instructor = instructor; }
    public void setmaxStudents(int maxStudents){ this.maxStudents = maxStudents; }
    public void setSectionNumber(int sectionNumber){this.sectionNumber = sectionNumber;}
    public void setCourseLocation(String courseLocation) { this.courseLocation = courseLocation;}
    
}
