package com.techelevator;

public class Employee {

    public Employee (){}

    private int employeeId;
    private String firstName = "";
    private String lastName = "";

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    private String department;
    private double annualSalary;



    public int getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartment() {
        return department;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public String getFullName() {
        fullName = getLastName() + ", " + getFirstName();
        return fullName;
    }

    String fullName = lastName + ", " + firstName;


    public Employee(int employeeId, String firstName, String lastName, double annualSalary){
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.annualSalary = annualSalary;
    }


    public void raiseSalary(double percent){
        annualSalary = annualSalary * (1+(percent/100));
    }

}
