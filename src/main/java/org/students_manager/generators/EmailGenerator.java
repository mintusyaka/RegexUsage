package org.students_manager.generators;

public class EmailGenerator {
    public static String generate(String name, String group, String year) {
        String[] parts = name.split(" ");
        String[] groupParts = group.split("-");
        if (parts.length >= 2) {
            String firstName = parts[0].toLowerCase();
            String lastName = parts[1].toLowerCase();
            String groupName = groupParts[0];

            StringBuilder emailBuilder = new StringBuilder();
            emailBuilder.append(firstName);
            emailBuilder.append(".");
            emailBuilder.append(lastName);
            emailBuilder.append(".");
            emailBuilder.append(groupName.toLowerCase());
            emailBuilder.append(".");
            emailBuilder.append(year);
            emailBuilder.append("@lpnu.ua");

            return emailBuilder.toString();
        }
        return null;
    }
}
