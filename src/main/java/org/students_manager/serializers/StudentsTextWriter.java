package org.students_manager.serializers;

import org.students_manager.entities.Student;
import org.text_logs_processing.entities.Order;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class StudentsTextWriter {
    public static void write(List<Student> students, String filename) throws Exception {
        try(FileWriter ordersWriter = new FileWriter(filename, false))
        {
            for(Student student : students)
            {
                ordersWriter.write(student.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> read(String filename) throws Exception {
        return Files.readAllLines(Paths.get(filename));
    }
}
