package com.atck.service;

import com.atck.bean.Teacher;
import com.atck.dao.TeacherDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService
{
    @Autowired
    private TeacherDAO teacherDAO;

    public Teacher getTeacherById(Integer id)
    {
        return teacherDAO.getTeacherById(id);
    }

    public List<Teacher> getAllTeacher()
    {
        return teacherDAO.getTeachers();
    }
}
