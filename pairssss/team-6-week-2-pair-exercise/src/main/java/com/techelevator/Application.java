package com.techelevator;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

    List<Department> departments = new ArrayList<>(); {
    }

    Map<String, Project> projects = new HashMap<>();
    List<Employee> employees= new ArrayList<>();{}

    Map<Integer, String> departmentMap = new HashMap<>();

    /**
     * The main entry point in the application
     * @param args
     */
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    private void run() {
        // create some departments
        createDepartments();

        // print each department by name
        printDepartments();


        // create employees
        createEmployees();

        // give Angie a 10% raise, she is doing a great job!

        // print all employees
        printEmployees();

        // create the TEams project
        createTeamsProject();
        // create the Marketing Landing Page Project
        createLandingPageProject();

        // print each project name and the total number of employees on the project
        printProjectsReport();
    }

    /**
     * Create departments and add them to the collection of departments
     */
    public void createDepartments() {



        Department marketing = new Department(1, "Marketing");
        Department sales = new Department(2, "Sales");
        Department engineering = new Department(3,"Engineering");
        departments.add(0, marketing);
        departments.add(1, sales);
        departments.add(2, engineering);

        departmentMap.put(1, "Marketing");
        departmentMap.put(2,"Sales");
        departmentMap.put(3, "Engineering");



//        Department sales = new Department();



//        departments.add(new Department(0 ,"Marketing"));
//        departments.add(new Department(1, "Sales"));
//        departments.add(new Department(2, "Engineering"));


    }



    /**
     * Print out each department in the collection.
     */
    private void printDepartments() {
        System.out.println("------------- DEPARTMENTS ------------------------------");
//        String nameOfDepartment="";
//        for (int i = 0; i < departments.size(); i++) {
//            nameOfDepartment = departments.indexOf(department
//        }

        System.out.println(departmentMap.get(1));
        System.out.println(departmentMap.get(2));
        System.out.println(departmentMap.get(3));
    }

    /**
     * Create employees and add them to the collection of employees
     */
    public void createEmployees() {

        Employee dean = new Employee();
        dean.setFirstName("Dean");
        dean.setLastName("Johnson");
        dean.setEmail("djohnson@teams.com");
        dean.setDepartment(departments.get(2));
        dean.setHireDate("8/21/2020");
        dean.setEmployeeId(1);
        employees.add(0, dean);


        Employee angie = new Employee(2, "Angie", "Smith",
                "asmith@teams.com", departments.get(2),"8/21/2020");
        employees.add(1, angie);
        Employee margaret = new Employee(3, "Margaret", "Thompson",
                "mthompson@teams.com", departments.get(0), "8/21/2020");
        employees.add(2, margaret);


        angie.raiseSalary(10);
    }

    /**
     * Print out each employee in the collection.
     */
    private void printEmployees() {
        System.out.println("\n------------- EMPLOYEES ------------------------------");


        for (Employee employee: employees){
            System.out.print(employee.employeeId + " " + employee.firstName + ", " + employee.lastName + ", "+ employee.email + ", " + employee.salary
                    + ", " + employee.department.getName() + ", " + employee.hireDate );
            System.out.println();
        }


//        for (String key : keys) {
//	System.out.println(key + " is the key to lookup " + stateCodes.get(key));
//}
    }

    /**
     * Create the 'TEams' project.
     */
    private void createTeamsProject() {
    Project teamsProject = new Project("TEams", "Project Management Software",
            "10/10/2020", "11/10/2020");


    teamsProject.setTeamMembers(employees.subList(0,2));
       projects.put("TEams" ,teamsProject);
    }
    /**
     * Create the 'Marketing Landing Page' project.
     */
    private void createLandingPageProject() {

        Project landingPage = new Project("Marketing Landing Page",
                "Lead Capture Landing Page For Marketing", "10/10/2020", "10/17/2020");
        landingPage.setTeamMembers(employees.subList(2,3));
        projects.put("Marketing Landing Page", landingPage);
    }

    /**
     * Print out each project in the collection.
     */
    private void printProjectsReport() {
        System.out.println("\n------------- PROJECTS ------------------------------");
        int counter=0;
        for (Project p: projects.values()){
            System.out.println(p.name + " " +  p.teamMembers.size());
        }
    }

}
