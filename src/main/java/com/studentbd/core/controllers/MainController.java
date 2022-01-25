package com.studentbd.core.controllers;

import com.studentbd.core.Student;
import com.studentbd.core.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    private StudentService service;

    public StudentService getStudentService() {
        return service;
    }

    @Autowired
    public void setStudentService(StudentService s) {
        this.service = s;
    }

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("title", "Main page");
        return "homepage";
    }

    @GetMapping("/students")
    public String students(Model model) {
        List<Student> students = service.listAll();

        model.addAttribute("students", students);
        model.addAttribute("title", "Main page");
        return "showData";
    }

    @GetMapping("/generate")
    public String generate(Model model) {
        service.generate();
        model.addAttribute("title", "Main page");
        return "generateData";
    }

    @GetMapping("/firstTask")
    public String task1(Model model) {
        service.softDeleteNotFibbs();
        model.addAttribute("title", "Main page");
        return "firstTask";
    }
}
