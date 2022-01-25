package com.studentbd.core.service;

import com.studentbd.core.Student;
import com.studentbd.core.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private StudentRepository db;

    public StudentRepository getStudentRepository() {
        return db;
    }

    @Autowired
    public void setStudentRepository(StudentRepository db) {
        this.db = db;
    }

    @Transactional
    public List<Student> listAll() {
        return (List<Student>) db.findAll();
    }

    @Transactional
    public void generate() {
        List<Student> s = new ArrayList<>();
        for(int i = 0; i < 100; i++)
            s.add(new Student());
        db.saveAll(s);
    }

    @Transactional
    public void softDeleteNotFibbs() {
        List<Integer> notFibbs = getNotFibbs();
        for(int i = 0; i < notFibbs.size(); i++) {
            Student s = new Student();
            s.setId((long)notFibbs.get(i));
            s.set_deleted(true);
            db.save(s);
        }
    }

    private List<Integer> generateFibbs() {
        List<Integer> fibbs = new ArrayList<>();
        fibbs.add(0);
        fibbs.add(1);
        for(int i = 0; i < db.count() / 10; i++)
        {
            fibbs.add(fibbs.get(fibbs.size() - 1) + fibbs.get(fibbs.size() - 2));
        }
        fibbs.remove(0);
        fibbs.remove(0);
        return fibbs;
    }
    private List<Integer> getNotFibbs() {
        List<Integer> fibbs = generateFibbs();
        List<Integer> notFibbs = new ArrayList<>();
        for(int i = 1; i < db.count() + 1; i++) {
            notFibbs.add(i);
        }
        for(int i = 0; i < fibbs.size(); i++) {
            if(notFibbs.indexOf(fibbs.get(i)) != -1)
                notFibbs.remove(notFibbs.indexOf(fibbs.get(i)));
        }
        return notFibbs;
    }

}
