package org.example;


import java.util.*;

class Student {
    String name;
    double grade;

    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class StudentGradeAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Student Grade Analyzer ---");
            System.out.println("1. Add Student");
            System.out.println("2. Show Report");
            System.out.println("3. Sort by Grade");
            System.out.println("4. Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 1) {
                System.out.print("Student name: ");
                String name = scanner.nextLine();

                System.out.print("Grade: ");
                double grade = scanner.nextDouble();

                students.add(new Student(name, grade));
                System.out.println("Student added.");

            } else if (choice == 2) {
                if (students.isEmpty()) {
                    System.out.println("No students yet.");
                    continue;
                }

                double total = 0;
                double max = students.get(0).grade;
                double min = students.get(0).grade;

                for (Student s : students) {
                    total += s.grade;
                    if (s.grade > max) max = s.grade;
                    if (s.grade < min) min = s.grade;
                }

                double avg = total / students.size();

                System.out.println("\n--- Report ---");
                System.out.println("Total Students: " + students.size());
                System.out.println("Average Grade: " + avg);
                System.out.println("Highest Grade: " + max);
                System.out.println("Lowest Grade: " + min);

            } else if (choice == 3) {
                students.sort((a, b) -> Double.compare(b.grade, a.grade));
                System.out.println("Sorted by grade (highest to lowest).");

                for (Student s : students) {
                    System.out.println(s.name + " - " + s.grade);
                }

            } else if (choice == 4) {
                System.out.println("Goodbye.");
                break;

            } else {
                System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
