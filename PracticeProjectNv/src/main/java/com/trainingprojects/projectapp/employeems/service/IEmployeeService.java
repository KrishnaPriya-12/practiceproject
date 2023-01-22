package com.trainingprojects.projectapp.employeems.service;

import com.trainingprojects.projectapp.employeems.dto.CreateEmployeeRequest;
import com.trainingprojects.projectapp.employeems.dto.EmployeeDetails;
import com.trainingprojects.projectapp.employeems.exceptions.EmployeeNotFoundException;
import com.trainingprojects.projectapp.employeems.exceptions.InvalidArgumentException;

public interface IEmployeeService {
    //Employee Details is a response dto, CreateEmployeeRequest is request dto
    EmployeeDetails registerEmployee(CreateEmployeeRequest request)throws InvalidArgumentException;
    /*
    //update employee name
    EmployeeDetails updateName(UpdateNameRequest request)
    */
    //fetches project details
    EmployeeDetails findDetailsById( long employeeId) throws InvalidArgumentException, EmployeeNotFoundException;

}
