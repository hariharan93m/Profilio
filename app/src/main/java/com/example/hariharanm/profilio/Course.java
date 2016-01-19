package com.example.hariharanm.profilio;

/**
 * Created by hariharanm on 9/1/2015.
 */
public class Course {

    private String Name;
    private String description;
    private String url;
    private int courseNumber;

    public Course(String Name, String description, String url,int courseNumber) {
        this.Name = Name;
        this.description = description;
        this.url = url;
        this.courseNumber = courseNumber;
    }

    public String getName() {
        return Name;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public int getCourseNumber() {
        return courseNumber;
    }


    @Override
    public String toString() {
        return Name;
    }
}
