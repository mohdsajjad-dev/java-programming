import java.util.ArrayList;

public class StudentCourseRegistration {

    public static void main(String[] args) {

        // Create an ArrayList to store registered courses
        ArrayList<String> courses = new ArrayList<>();

        // Register courses
        courses.add("Java Programming");
        courses.add("Data Structures");
        courses.add("Database Management System");
        courses.add("Operating Systems");

        // Display registered courses using StringBuffer
        StringBuffer sb = new StringBuffer();

        sb.append("===== REGISTERED COURSES =====\n");

        for (int i = 0; i < courses.size(); i++) {
            sb.append((i + 1) + ". " + courses.get(i) + "\n");
        }

        System.out.println(sb);

        // Remove a course
        courses.remove("Database Management System");

        // Display updated course list
        sb.setLength(0);   // Clear StringBuffer

        sb.append("===== UPDATED COURSE LIST =====\n");

        for (int i = 0; i < courses.size(); i++) {
            sb.append((i + 1) + ". " + courses.get(i) + "\n");
        }

        System.out.println(sb);

        // Display total registered courses
        System.out.println("Total Registered Courses: " + courses.size());

        // Check whether the registration list is empty
        System.out.println("Is Registration List Empty? " + courses.isEmpty());
    }
}
