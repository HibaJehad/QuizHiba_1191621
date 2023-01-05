package com.example.myapplication;

public class Employee {

    private String NameEmplyee;
    private int salary;

    public Employee(String nameEmplyee, int salary) {
        NameEmplyee = nameEmplyee;
        this.salary = salary;
    }

    public String getNameEmplyee() {
        return NameEmplyee;
    }

    public void setNameEmplyee(String nameEmplyee) {
        NameEmplyee = nameEmplyee;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
