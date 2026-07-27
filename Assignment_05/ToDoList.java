import java.util.ArrayList;

public class ToDoList {

    public static void main(String[] args) {

        // Create an ArrayList to store tasks
        ArrayList<String> tasks = new ArrayList<>();

        // Add tasks
        tasks.add("Complete Java Assignment");
        tasks.add("Study Collections");
        tasks.add("Practice DSA");
        tasks.add("Submit Lab Record");

        // Display all tasks using StringBuffer
        StringBuffer sb = new StringBuffer();

        sb.append("===== TO-DO LIST =====\n");

        for (int i = 0; i < tasks.size(); i++) {
            sb.append((i + 1) + ". " + tasks.get(i) + "\n");
        }

        System.out.println(sb);

        // Remove one task
        tasks.remove("Practice DSA");

        // Display updated list
        sb.setLength(0); // Clear StringBuffer

        sb.append("===== UPDATED TO-DO LIST =====\n");

        for (int i = 0; i < tasks.size(); i++) {
            sb.append((i + 1) + ". " + tasks.get(i) + "\n");
        }

        System.out.println(sb);

        // Display total number of tasks
        System.out.println("Total Tasks: " + tasks.size());

        // Check if list is empty
        System.out.println("Is To-Do List Empty? " + tasks.isEmpty());
    }
}
