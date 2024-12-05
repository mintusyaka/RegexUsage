package org.students_manager.generators;

import org.students_manager.entities.Student;
import org.text_logs_processing.entities.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudentsGenerator {

    public static List<Student> generate(int count) {
        List<Student> students = new ArrayList<Student>();

        for (int i = 0; i < count; i++) {
            Student student = new Student();

            student.setName(NameGenerator.generate());
            student.setGroup(GroupGenerator.generate());
            student.setYear(String.valueOf(new Random().nextInt(5) + 2019));
            student.setEmail(EmailGenerator.generate(student.getName(), student.getGroup(), student.getYear()));

            students.add(student);
        }

        return students;
    }
}
