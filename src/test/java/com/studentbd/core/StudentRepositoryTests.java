package com.studentbd.core;
import com.studentbd.core.repos.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class StudentRepositoryTests {
    @Autowired
    private StudentRepository rep;

    @Test
    public void addNew() {
        Student s = new Student();
        rep.save(s);
    }
    @Test
    public void showData() {
        Iterable<Student> ss = rep.findAll();
        System.out.println("My print");
        ss.forEach(e -> System.out.println(e.getSurname()));
    }

    @Test
    public void customQuery() {
        addNew();
        addNew();
        addNew();
        addNew();
        showData();

        System.out.println(rep.findBySurnameLike("M%"));

    }

    @Test
    public void CountValues() {
        Student s = new Student();
        rep.save(s);
        List<Long> fibbs = generateFibbs();
        System.out.println(fibbs.toString());
        System.out.println("Current val");
        System.out.println(fibbs.indexOf(s.getId()));
    }

    @Test
    public void testFibbs() {
        List<Long> fibbs = getNotFibbs();
        System.out.println(fibbs);
    }

    private List<Long> generateFibbs() {
        List<Long> fibbs = new ArrayList<>();
        fibbs.add((long)0);
        fibbs.add((long)1);
        for(int i = 0; i < 10; i++)
        {
            fibbs.add(fibbs.get(fibbs.size() - 1) + fibbs.get(fibbs.size() - 2));
        }
        fibbs.remove(0);
        fibbs.remove(0);
        return fibbs;
    }
    private List<Long> getNotFibbs() {
        List<Long> fibbs = generateFibbs();
        List<Long> notFibbs = new ArrayList<>();
        for(int i = 1; i < 101; i++) {
            notFibbs.add((long)i);
        }
        for(int i = 0; i < fibbs.size(); i++) {
            if(notFibbs.indexOf(fibbs.get(i)) != -1)
                notFibbs.remove(notFibbs.indexOf(fibbs.get(i)));
        }
        return notFibbs;
    }
}
