import java.util.ArrayList; 
import java.util.Scanner;

// Req 08: main program to test 
public class CourseRegisterMain {
    private static final String ADMIN_USER = "Admin";
    private static final String ADMIN_PASS = "Admin001";

    public static void main(String[] args){
        Scanner in = new Scanner(System.in); 
        ArrayList<Course> courses = DataManager.loadCoursesFromCSV();
        ArrayList<Student> students = DataManager.loadStudents();
        
        if (courses == null) {
            courses = new ArrayList<Course>();
        }
        if (students == null) {
            students = new ArrayList<Student>();
        }

        // load courses from csv file 
     
    // what shows up on the terminal 
    while (true) { 
        System.out.println("______Login______"); 

        System.out.println("1. Admin");
        System.out.println("2. Student");
        System.out.println("3. Exit");
        String choice = in.nextLine().trim();
        
        if (choice.equals("3")) {
            DataManager.saveState(courses, students);
            System.out.println("Goodbye.");
            break;
        }

        if (choice.equals("1")) {
            System.out.print("Username: ");
            String user = in.nextLine().trim();
            System.out.print("Password: ");
            String pass = in.nextLine().trim();
            if (user.equals(ADMIN_USER) && pass.equals(ADMIN_PASS)) {
                Admin admin = new Admin(ADMIN_USER, ADMIN_PASS, "Admin", "User", courses, students);
                runAdminMenu(admin, in);
            } else {
                System.out.println("Invalid admin credentials.");
            }
        } else if (choice.equals("2")) {
            System.out.print("Username: ");
            String user = in.nextLine().trim();
            System.out.print("Password: ");
            String pass = in.nextLine().trim();
            Student student = findStudent(students, user, pass);
            if (student != null) {
                student.setCourses(courses);
                runStudentMenu(student, in);
            } else {
                System.out.println("Student not found. Admin must register you first (Courses Management -> Register a student).");
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }
    in.close();
    }

    public static Student findStudent(ArrayList<Student> students, String username, String password) {
        if (students == null) return null;
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            if (s.getUsername().equals(username) && s.checkPassword(password))
                return s;
        }
        return null;
    }

    public static void runAdminMenu(Admin admin, Scanner in) {
        while (true) {
            System.out.println("\n==== Admin Menu ====");
            System.out.println("1. Create a new course");
            System.out.println("2. Delete a course");
            System.out.println("3. Edit a course");
            System.out.println("4. Display course info");
            System.out.println("5. Register a student");
            System.out.println("6. View all courses");
            System.out.println("7. View full courses");
            System.out.println("8. Write full courses to file");
            System.out.println("9. View students in a course");
            System.out.println("10. View courses by student");
            System.out.println("11. Sort courses by enrollment");
            System.out.println("12. Exit");
            String choice = in.nextLine().trim();
            if (choice.equals("12")) break;
            if (choice.equals("1")) admin.createCourse();
            else if (choice.equals("2")) admin.deleteCourse();
            else if (choice.equals("3")) admin.editCourse();
            else if (choice.equals("4")) admin.displayCourseInfo();
            else if (choice.equals("5")) admin.registerStudent();
            else if (choice.equals("6")) admin.viewAllCourses();
            else if (choice.equals("7")) admin.viewFullCourses();
            else if (choice.equals("8")) admin.writeFullCoursesToFile();
            else if (choice.equals("9")) admin.viewStudentsInCourse();
            else if (choice.equals("10")) admin.viewCoursesByStudent();
            else if (choice.equals("11")) admin.sortCoursesByEnrollment();
            else System.out.println("Invalid choice.");
        }
    }

    public static void runStudentMenu(Student student, Scanner in) {
        while (true) {
            System.out.println("\n             Student Menu          ");
            System.out.println("1. View all courses");
            System.out.println("2. View courses that are not full");
            System.out.println("3. Register on a course");
            System.out.println("4. Withdraw from a course");
            System.out.println("5. View my courses");
            System.out.println("6. Exit");
            String choice = in.nextLine().trim();
            if (choice.equals("6")) break;
            if (choice.equals("1")) student.viewAllCourses();
            else if (choice.equals("2")) student.viewNotFullCourses();
            else if (choice.equals("3")) student.registerOnCourse();
            else if (choice.equals("4")) student.withdrawFromCourse();
            else if (choice.equals("5")) student.viewMyCourses();
            else System.out.println("Invalid choice.");
        }
    }
}
