package com.studentbd.core;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name= "student", schema = "studentdb")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String surname, _group, sex;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private Boolean _deleted;


    public Student() {
        List<String> gSurname = Arrays.asList("Amaan Hollis", "Sneha Shaffer", "Marilyn Mcmillan", "Dominykas Taylor", "Franciszek Petersen", "Aman Slater", "Carrie-Ann Barajas",
                "Hailie Krueger", "Ivor Shea", "Evie-Mai Hudson", "Donnell Vaughn", "Lilly-Mai Leech", "Aiysha Leon", "Trixie Sexton", " Kajetan Thornton", " Merryn Daly",
                " Alfie Forster",  "Giulia Allison", "Magnus Easton", "Wil Cherry", "Lainey Christensen", "Monica Humphries", "Jayde Olsen", "Mildred Escobar", "Lennox Conner",
                "Leonie Mcloughlin", "Judith Dunn", "Drew Mcneil", "Margie Villalobos", "Momina Monaghan", "Enzo Flynn", "Dave Roche", "Rabia Whyte", "Alice Huang", "Cruz Henry",
                "Kajol Aguilar", "Cooper Best", "Amira Lucero", "Aliyah Stubbs", "Mohamad Bender", "Kacie Newton", "Homer Estes", "Cherish Doyle", "Chad Barnes", "Leoni Hutchinson",
                "Vinay Ramsay", "Avery Woodard", "Suman Stott", "Denise Graves", "Mai Leonard", "Amelia-Lily Davidson", "Joseff Bone", "Szymon Colon", "Raja Burns", "Beatriz Wilkerson",
                "Rodrigo Simon", "Tobi Castillo", "Edna Morrow", "Ishan Hodge", "Harlan Parrish", "Kenan Jacobson", "Aleisha Kirkland", "Ameen Sherman", "Stefania Mosley", "Isobelle East",
                "Lyndsey Kirk", "Giovanni Hilton", "Nusaybah Gonzales", "Sukhmani Mathis", "Caitlin Hale", "Najma Chester", "Cydney Salas", "Kristen Cohen", "Alia Mooney", "Theresa Byrd",
                "Roza Cline", "Katrina Osborn", "Laaibah Hills", "Deniz Young", "Viaan Boyd", "Anayah Odonnell", "Rhona William", "Maira Maldonado", "Milly Carson", "Faizah Irwin",
                "Mariyam Cornish", "Isabella-Rose Tomlinson", "Leyton Greenwood", "Tori Sellers", "Theodor Shepard", "Zahraa Silva", "Erin Lovell", "Ronnie Hyde", "Luella Langley",
                "Evie-Mae Ventura", "Jenson Workman", "Owain Whittington", "Samir Rodriquez", "Milo Mayo", "Haley Weaver");
        List<String> gGroup = Arrays.asList("PI-18", "PI-19", "PI-20", "SE-18", "SE-19", "SE-20", "MERN-18", "MERN-19", "MERN-20");
        List<String> gSex = Arrays.asList("Male", "Female");
        int randomSurname = ThreadLocalRandom.current().nextInt(0, gSurname.size());
        int randomGroup = ThreadLocalRandom.current().nextInt(0, gGroup.size());
        int randomSex = ThreadLocalRandom.current().nextInt(0, 2);
        int randomAge = ThreadLocalRandom.current().nextInt(8, 90);
        surname = gSurname.get(randomSurname);
        _group = gGroup.get(randomGroup);
        sex = gSex.get(randomSex);
        age = randomAge;
        _deleted = false;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Boolean get_deleted() {
        return _deleted;
    }

    public void set_deleted(Boolean _deleted) {
        this._deleted = _deleted;
    }

    public Long getId() {
        return id;
    }

    public String get_group() {
        return _group;
    }

    public void set_group(String _group) {
        this._group = _group;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
}
