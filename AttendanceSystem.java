package atm;

import java.util.*;

class Student {
    private String name;
    private int id;
    private boolean isPresent;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.isPresent = false;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void markAttendance() {
        isPresent = true;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Present: " + isPresent;
    }
}

class AttendanceSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        // Add some students to the system
        students.add(new Student("John", 101));
        students.add(new Student("Alice", 102));
        students.add(new Student("Bob", 103));
        students.add(new Student("Eva", 104));

        int choice;
        do {
            System.out.println("Attendance Management System");
            System.out.println("1. Mark Attendance");
            System.out.println("2. View Attendance");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    markAttendance(students, scanner);
                    break;
                case 2:
                    viewAttendance(students);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);

        scanner.close();
    }

    public static void markAttendance(ArrayList<Student> students, Scanner scanner) {
        System.out.println("Marking Attendance:");
        for (Student student : students) {
            System.out.print("Is " + student.getName() + " present? (Y/N): ");
            String input = scanner.next();
            if (input.equalsIgnoreCase("Y")) {
                student.markAttendance();
            }
        }
    }

    public static void viewAttendance(ArrayList<Student> students) {
        System.out.println("Attendance Report:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

