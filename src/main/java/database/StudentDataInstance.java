package database;

import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;
import io.jsondb.annotation.Secret;

@Document(collection = "students", schemaVersion = "1.0")
public class StudentDataInstance {

    @Id
    private String email;

    @Secret
    private String name;

    private String degree; // рівень: бакалавр, магістр, ...

    private String direction; // напрям підготовки
    private String speciality; // спеціальність

    private int year;
    private String group;
    private boolean[] marks; // відмітки "виконано"

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public boolean[] getMarks() {
        return marks;
    }

    public void setMarks(boolean[] marks) {
        this.marks = marks;
    }
}
