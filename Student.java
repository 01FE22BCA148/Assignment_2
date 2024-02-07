import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student extends StudentCourse {
    public String name;
    public String dob;
    public List<String> subjects;

    public Student() {
        subjects = new ArrayList<>();
    }

    public void displayName() {
        System.out.println("Student Name: " + name);
    }

    public void displayAge(String dob) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate birthDate = LocalDate.parse(dob, formatter);
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthDate, currentDate);
        int age = period.getYears();
        System.out.println("Age of student: " + age + " years");
    }

    public void addSubject(String subject) {
        subjects.add(subject);
        System.out.println("Subject added: " + subject);
    }

    public void removeSubject(String subject) {
        if (subjects.remove(subject)) {
            System.out.println("Subject removed: " + subject);
        } else {
            System.out.println("Subject not found: " + subject);
        }
    }

    public static void main(String[] args) {
        Student s = new Student();
        StudentCourse s1 = new StudentCourse();
        s.name = "Nauman A";
        s.displayName();
        s.displayAge("12-07-2003");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Do you want to add or remove a subject? (add/remove)");
        String action = scanner.next();

        if ("add".equalsIgnoreCase(action)) {
            System.out.println("Enter the subject to add:");
            String newSubject = scanner.next();
            s.addSubject(newSubject);
        } else if ("remove".equalsIgnoreCase(action)) {
            System.out.println("Enter the subject to remove:");
            String subjectToRemove = scanner.next();
            s.removeSubject(subjectToRemove);
        } else {
            System.out.println("Invalid action.");
        }

        s1.displayStudentCourses();
        s1.displayStudentMarks();

        // Commit and push changes to a separate branch in a GitHub repository
        // (Assuming you are using Git and have a remote repository on GitHub)
        // git checkout -b feature/subject-changes
        // git add .
        // git commit -m "Update subjects for student"
        // git push origin feature/subject-changes
    }
}
