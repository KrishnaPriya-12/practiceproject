package com.trainingprojects.projectapp.employeems.frontend;
import com.trainingprojects.projectapp.employeems.dto.CreateEmployeeRequest;
import com.trainingprojects.projectapp.employeems.dto.EmployeeDetails;
import com.trainingprojects.projectapp.employeems.exceptions.EmployeeNotFoundException;
import com.trainingprojects.projectapp.employeems.exceptions.InvalidArgumentException;
import com.trainingprojects.projectapp.employeems.service.EmployeeServiceImpl;
import com.trainingprojects.projectapp.employeems.service.IEmployeeService;

public class FrontEndUi {
    private IEmployeeService service=new EmployeeServiceImpl();

    public static void main(String args[]){
        FrontEndUi ui=new FrontEndUi();
        ui.runUI();
    }

    void runUI(){
        try {
            CreateEmployeeRequest request = new CreateEmployeeRequest();
            request.setFirstName("srushti");
            request.setLastName("patil");
            request.setDepartment("testing");
            System.out.println("****registering employee");
            EmployeeDetails registerResponse = service.registerEmployee(request);
            display(registerResponse);
            System.out.println("********fetch employee by id");
            long empId=registerResponse.getId();
            EmployeeDetails found=service.findDetailsById(empId);
            display(registerResponse);

        }catch (InvalidArgumentException | EmployeeNotFoundException e){
            System.out.println(e.getMessage());
        }

    }

    void display(EmployeeDetails result){
        System.out.println(result.getId()+"-"+result.getFirstName()+"-"+result.getLastName());
    }



}

