package org.main;

import org.students_manager.entities.Student;
import org.students_manager.generators.StudentsGenerator;
import org.students_manager.serializers.StudentsTextWriter;
import org.text_logs_processing.entities.Order;
import org.text_logs_processing.generators.OrdersGenerator;
import org.text_logs_processing.serializers.OrdersTextWriter;

import java.util.List;

public class StudentsGeneratorApp {
    public static void main(String[] args) {
        List<Student> students = StudentsGenerator.generate(1000);

        try {
            StudentsTextWriter.write(students, "students.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<String> readResult;
        try {
            readResult = OrdersTextWriter.read("students.txt");
            for(String row: readResult) {
                System.out.println(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
