package com.project.model;

import java.io.Serializable;

public class Student implements Serializable {

    private  static  final long serialVersionUID= -7408851479146003262L;
    private String id;
    private String name;
    private String school;

    public String getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSchool() {
        return school;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString(){
        return "Student [ id = "+id+", name = "+name+", school = "+school+" ]";
    }

}
