package com.atck.spring.collectiontype;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student
{
    private String[] course;
    private List<String> list;
    private Map<String,String> map;
    private Set<String> set;

    private List<Course> courses;

    public void setCourses(List<Course> courses)
    {
        this.courses = courses;
    }

    public void setSet(Set<String> set)
    {
        this.set = set;
    }

    public void setList(List<String> list)
    {
        this.list = list;
    }

    public void setMap(Map<String, String> map)
    {
        this.map = map;
    }

    public void setCourse(String[] course)
    {
        this.course = course;
    }

    @Override
    public String toString()
    {
        return "Student{" + "course=" + Arrays.toString(course) + ", list=" + list + ", map=" + map + ", set=" + set + ", courses=" + courses + '}';
    }
}
