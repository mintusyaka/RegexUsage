package org.students_manager.generators;

import java.util.Random;

public class NameGenerator {
    public static String generate() {
        String[] names = {
                "James", "Oliver", "Benjamin", "Lucas", "Mason",
                "Ethan", "Alexander", "Henry", "Sebastian", "Jack",
                "Samuel", "David", "Joseph", "Michael", "Matthew",
                "Daniel", "William", "Max", "Andrew", "Aiden",
                "Elijah", "Caleb", "Luke", "Nathaniel", "John",
                "Isaac", "Gabriel", "Jacob", "Christopher", "Ryan",
                "Tyler", "Joshua", "Austin", "Zachary", "Dylan",
                "Owen", "Liam", "Adam", "Eli", "Grayson",
                "Leo", "Charles", "Ryan", "Jaxon", "Jordan",
                "Connor", "Cameron", "Maverick", "Hunter", "Calvin"
        };

        String[] surnames = {
                "Smith", "Johnson", "Williams", "Brown", "Jones",
                "Miller", "Davis", "García", "Rodriguez", "Martínez",
                "Hernández", "Lopez", "Gonzalez", "Wilson", "Anderson",
                "Thomas", "Taylor", "Moore", "Jackson", "Martin",
                "Lee", "Perez", "White", "Harris", "Sánchez",
                "Clark", "Lewis", "Roberts", "Walker", "Young",
                "King", "Scott", "Green", "Adams", "Baker",
                "Nelson", "Carter", "Mitchell", "Perez", "Evans",
                "Collins", "Stewart", "Morris", "Rogers", "Reed",
                "Cook", "Morgan", "Bell", "Murphy", "Bailey"
        };

        Random random = new Random();

        StringBuilder nameBuilder = new StringBuilder();

        nameBuilder.append(names[random.nextInt(names.length)]);
        nameBuilder.append(" ");
        nameBuilder.append(surnames[random.nextInt(surnames.length)]);

        return nameBuilder.toString();
    }
}
