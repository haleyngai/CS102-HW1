import java.util.ArrayList;

public class CourseManager {
    // stored a list of course objects here 
    private final ArrayList<Course> courses; 

    //constructor
    public CourseManager(ArrayList<Course> courses){
        this.courses = courses;
    }

    // Req 03. Course Management 
    public void createCourse(Course c){
        if (courses == null) return; 
        courses.add(c);
        System.out.println("Course created: " + c.getCourseName()); 

    }

    public void deleteCourse(String courseId){
        if (courses == null) return;
        for (int i=0; i<courses.size(); i++){
            if (courses.get(i).getCourseId().equals(courseId)){
                courses.remove(i);
                System.out.println("Course deleted: " + courseId); 
                return; 
            }
        }
        System.out.println("Cannot find course: "+ courseId); 
    }
    // req 03.4 haley
    public void editCourse(String courseId, int maxStudents, String instructor, int section, String location){
        if (courses == null) return; 
        for (Course c: courses) {
            if (c.getCourseId().equals(courseId)){
                c.setmaxStudents(maxStudents); 
                c.setinstructor(instructor); 
                c.setSectionNumber(section);
                c.setCourseLocation(location);
                System.out.println("Course updated: " + courseId);
                return; 
            }
        }
        System.out.println("Course not found: " + courseId); 

    }

    public void dispayCourse(String courseId){

    }


    
}
