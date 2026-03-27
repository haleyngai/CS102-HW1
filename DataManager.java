import java.io.*; 
import java.util.ArrayList; 
import java.util.Scanner; 

public class DataManager {
    // reading course from csv 
    public static final String CSV_FILE = "data/MyUniversityCourses.csv"; 
    //create binary file to store data
    private static final String USER_FILE = "users.ser";
    private static final String COURSE_FILE = "courses.ser";
    //since course information such as max students can be changed by Admin
    //course should also do serializaiton so I changed some of Hayley's code
   public static ArrayList<Course> loadCourses() {
       //read course information from binary file
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(COURSE_FILE));
            ArrayList<Course> courses = (ArrayList<Course>) in.readObject();
            in.close();
            System.out.println("Courses loaded from serialized file.");
            return courses;
        // throw exceptions if there isn't data stored in the file, since for the first time 
        // we run the program, we havent store any data and it hasnt created a binary file yet.
        } catch (FileNotFoundException e) {
            System.out.println("No saved course data found. Loading from CSV.");
            return loadCoursesFromCSV();

        } catch (IOException e) {
            System.out.println("Error reading course data. Loading from CSV.");
            e.printStackTrace();
            return loadCoursesFromCSV();

        } catch (ClassNotFoundException e) {
            System.out.println("Course class not found. Loading from CSV.");
            e.printStackTrace();
            return loadCoursesFromCSV();
        }
    }
    //serialization implementation for course
    public static void saveCourses(ArrayList<Course> courses) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(COURSE_FILE));
            out.writeObject(courses);
            out.close();
            System.out.println("Courses saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving course data.");
            e.printStackTrace();
        }
    }
    // load initial courses from csv
    //this is the part hayley did before and i just move it down here cuz serialization go first
    public static ArrayList<Course> loadCoursesFromCSV() {
        ArrayList<Course> list = new ArrayList<Course>();

        try {
            Scanner fileIn = new Scanner(new File(CSV_FILE));

            if (fileIn.hasNextLine()) {
                fileIn.nextLine(); // skip header
            }

            while (fileIn.hasNextLine()) {
                String line = fileIn.nextLine();

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split(",");

                if (parts.length >= 8) {
                    try {
                        String courseName = parts[0].trim();
                        String courseId = parts[1].trim();
                        int maxStudents = Integer.parseInt(parts[2].trim());
                        String instructor = parts[5].trim();
                        int sectionNumber = Integer.parseInt(parts[6].trim());
                        String courseLocation = parts[7].trim();

                        Course c = new Course(courseName, courseId, maxStudents, instructor, sectionNumber, courseLocation);
                        list.add(c);

                    } catch (NumberFormatException e) {
                        System.out.println("Skipping invalid course line: " + line);
                    }
                }
            }

            fileIn.close();

        } catch (FileNotFoundException e) {
            System.out.println("Warning: Could not find " + CSV_FILE + ". Starting with empty course list.");
        }

        return list;
    }

    //read the serialized file for users both students and admin inherits from user so we only nedd
    //to ride this method here and both student and admin could use it.
   public static ArrayList<User> loadUsers() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(USER_FILE));
            ArrayList<User> users = (ArrayList<User>) in.readObject();
            in.close();
            return users;
        } catch (Exception e) {
            return new ArrayList<User>();
        }
    }
    //serialized the data
    public static void saveUsers(ArrayList<User> users) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(USER_FILE));
            out.writeObject(users);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
