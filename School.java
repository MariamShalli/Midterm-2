import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class School {
    private String name;
    private String address;
    private List<Teacher> teachers;

    // Constructor
    public School(String name, String address) {
        this.name = name;
        this.address = address;
        this.teachers = new ArrayList<>();
    }

    // Method to add a teacher
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    // Method to remove a teacher
    public void removeTeacher(Teacher teacher) {
        teachers.remove(teacher);
    }

    // Method to save the state to a CSV file
    public void saveState() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("state.csv"))) {
            for (Teacher teacher : teachers) {
                writer.println(teacher.getName() + "," + teacher.getAge() + "," + teacher.getSubject() + "," + teacher.getAddress());
            }
            System.out.println("State saved to state.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to restore the state from a CSV file
    public void restoreState() {
        teachers.clear(); // Clear the current list of teachers
        try (BufferedReader reader = new BufferedReader(new FileReader("state.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String name = parts[0];
                    int age = Integer.parseInt(parts[1]);
                    String subject = parts[2];
                    String address = parts[3];
                    teachers.add(new Teacher(name, age, subject, address));
                }
            }
            System.out.println("State restored from state.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Getters and setters

    @Override
    public String toString() {
        return "School{" + "name='" + name + '\'' + ", address='" + address + '\'' + ", teachers=" + teachers + '}';
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create a School object
        School school = new School("Greenwood High", "123 Main St");
        Teacher teacher1 = new Teacher("Alice Johnson", 30, "Math", "123 Elm St");
        Teacher teacher2 = new Teacher("Bob Smith", 45, "English", "456 Oak St");
        school.addTeacher(teacher1);
        school.addTeacher(teacher2);

        // Save the state to a CSV file
        school.saveState();

        // Remove a teacher (just for demonstration)
        school.removeTeacher(teacher1);

        // Restore the state from the CSV file
        school.restoreState();

        // Display the restored school
        System.out.println("Restored:");
        System.out.println(school);
    }
}