package com.atck.spring.collectiontype;

public class Course
{
    private String course;

    public void setCourse(String course)
    {
        this.course = course;
    }

    @Override
    public String toString()
    {
        return "Course{" + "course='" + course + '\'' + '}';
    }
}
