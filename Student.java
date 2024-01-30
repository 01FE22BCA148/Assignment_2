/**
 * The Student class in Java allows you to store and display a student's name and calculate their age
 * based on their date of birth.
 */
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Student {
    public String name;
    public String dob;

    public void displayName() {
        System.out.println("Student Name: " + name);
    }

    public void displayAge(String dob) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate birthDate = LocalDate.parse(dob, formatter);
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthDate, currentDate);
        int age = period.getYears();
        System.out.println("Age of student: " + age +"years");


    }

    public static void main(String[] args) {
        Student s=new Student();
        s.name = "Nauman A";
        s.displayName();
        s.displayAge("12-07-2003");

    }
}