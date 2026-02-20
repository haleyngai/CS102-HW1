import java.util.ArrayList;
public class Course {
    private String courseName;
    private String courseId; 
    private int maxStudents;
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
    public int getCurrentStudents() { return studentNames.size(); }
    public ArrayList<String> getStudentNames() { return studentNames; }
    public String getInstructor() { return instructor; }
    public int getSectionNumber() { return sectionNumber; }
    public String getCourseLocation() { return courseLocation; }

    // setters
    public void setinstructor(String instructor){ this.instructor = instructor; }
    public void setmaxStudents(int maxStudents){ this.maxStudents = maxStudents; }
    public void setSectionNumber(int sectionNumber){this.sectionNumber = sectionNumber;}
    public void setCourseLocation(String courseLocation) { this.courseLocation = courseLocation;}

    public boolean isFull() {
        return studentNames.size() >= maxStudents;
    }

    public boolean addStudent(String name) {
        if (isFull() || studentNames.contains(name)) return false;
        studentNames.add(name);
        return true;
    }

    public boolean removeStudent(String name) {
        return studentNames.remove(name);
    }

    public String toString() {
        return courseName + " | " + courseId + " | Section " + sectionNumber + " | " + studentNames.size() + "/" + maxStudents + " | " + instructor + " | " + courseLocation;
    }
    
}
