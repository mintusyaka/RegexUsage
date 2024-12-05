package org.students_manager.entities;

public class Student {
    public String name;
    public String email;
    public String group;
    public String year;

    public Student() {}

    public Student(String name, String email, String group, String year) {
        this.name = name;
        this.email = email;
        this.group = group;
        this.year = year;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getGroup() {
        return group;
    }
    public void setGroup(String group) {
        this.group = group;
    }

    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Email: " + email + ", Group: " + group + ", Year: " + year + ";\n";
    }
}
