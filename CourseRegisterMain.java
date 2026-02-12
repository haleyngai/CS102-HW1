import java.util.ArrayList; 
import java.util.Scanner;

// Req 08: main program to test 
public class CourseRegisterMain {
    private static final String ADMIN_USER = "Admin";
    private static final String ADMIN_PASS = "haley102";

    public static void main(String[] args){
        Scanner in = new Scanner(System.in); 
        ArrayList<Course> courses;
        ArrayList<Student> students; 

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

    }}
    }
}
