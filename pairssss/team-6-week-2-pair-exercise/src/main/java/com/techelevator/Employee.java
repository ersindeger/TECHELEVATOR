package com.techelevator;

public class Employee {

    long employeeId = 0;
    String firstName = "";
    String lastName = "";
    String email = "";
    double salary = 60000.00;
    Department department = new Department (0,"");
    String hireDate = "";


    public Employee (long employeeId, String firstName, String lastName,
                     String email, Department department, String hireDate ) {
        //created a class with constructor called EMPLOYEE and with all those parameters inside ( )

        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.department = department;
        this.hireDate = hireDate;

    }

    public Employee() {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.department = department;
        this.hireDate = hireDate;
    }
    //this is a class of EMPLOYEE with no arguments.

    public String getFullName(){
        return (lastName + ", " + firstName);
    }

    public void raiseSalary(double percent){
        double x = percent;
        salary = ( salary*(1 + (0.01)*x) );
    }  // raiseSALARY is a method here... not a variable.




    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }
}
