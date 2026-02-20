import java.io.*; 
import java.util.ArrayList; 
import java.util.Scanner; 

public class DataManager {
    // reading course from csv 
    public static final String CSV_FILE = "data/MyUniversityCourses.csv"; 
    private static final String SERIAL_FILE = "registration_data.ser";
    
    public static ArrayList<Course> loadCoursesFromCSV() {
        ArrayList<Course> list = new ArrayList<Course>();
        try {
            Scanner fileIn = new Scanner(new File(CSV_FILE));
            if (fileIn.hasNextLine()) fileIn.nextLine();
            while (fileIn.hasNextLine()) {
                String line = fileIn.nextLine();
                if (line.trim().isEmpty()) continue;
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
                    }
                }
            }
            fileIn.close();
        } catch (FileNotFoundException e) {
            System.out.println("Warning: Could not find " + CSV_FILE + ". Starting with empty course list.");
        }
        return list;
    }

    public static ArrayList<Student> loadStudents() {
        return new ArrayList<Student>();
    }

    public static void saveState(ArrayList<Course> courses, ArrayList<Student> students) {
    }
}
