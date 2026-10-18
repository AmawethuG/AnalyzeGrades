package src.main.java.org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDatabase {

    private static final String URL = "jdbc:sqlite:data/gradeflow.db";

    public StudentDatabase() {
        createTable();
    }

    private void createTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS students (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    grade REAL NOT NULL
                )
                """;

        try (Connection connection = DriverManager.getConnection(URL);
             Statement statement = connection.createStatement()) {

            statement.execute(sql);
            System.out.println("Database ready.");

        } catch (SQLException e) {
            throw new RuntimeException("Could not create database table.", e);
        }
    }

    public void addStudent(String name, double grade) {
        String sql = "INSERT INTO students (name, grade) VALUES (?, ?)";

        try (Connection connection = DriverManager.getConnection(URL);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, name);
            statement.setDouble(2, grade);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Could not save student.", e);
        }
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT name, grade FROM students";

        try (Connection connection = DriverManager.getConnection(URL);
             Statement statement = connection.createStatement();
             ResultSet results = statement.executeQuery(sql)) {

            while (results.next()) {
                String name = results.getString("name");
                double grade = results.getDouble("grade");

                students.add(new Student(name, grade));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Could not load students.", e);
        }

        return students;
    }
}

