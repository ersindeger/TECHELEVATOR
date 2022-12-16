package com.techelevator.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Department {

    int departmentId;
    String name;

    public Department (int departmentId, String name) {
        this.departmentId = departmentId;
        this.name = name ;

    }

    Map<Integer, String> departmentMap = new HashMap<>();

    public Map<Integer, String> getDepartmentMap() {
        return departmentMap;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
