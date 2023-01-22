package com.trainingprojects.projectapp.projectms.frontend;

import com.trainingprojects.projectapp.projectms.dto.CreateProjectRequest;
import com.trainingprojects.projectapp.projectms.dto.ProjectDetails;
import com.trainingprojects.projectapp.projectms.exceptions.InvalidArgumentException1;
import com.trainingprojects.projectapp.projectms.exceptions.ProjectNotFoundException;
import com.trainingprojects.projectapp.projectms.service.IProjectService;
import com.trainingprojects.projectapp.projectms.service.ProjectServiceImpl;

public class FrontEndUi {
	private IProjectService service1=new ProjectServiceImpl();

    public static void main(String args[]){
        FrontEndUi ui=new FrontEndUi();
        ui.runUI();
    }

    void runUI(){
        try {
            CreateProjectRequest request = new CreateProjectRequest();
            request.setProjectName("EmpApp");
            request.setDurationInDays(8);
            System.out.println("****Add Project");
            ProjectDetails registerResponse1 = service1.registerProject(request);
            
            display(registerResponse1);
            System.out.println("********fetch project by id");
            long projectId=registerResponse1.getId();
            ProjectDetails found=service1.findDetailsById(projectId);
            display(registerResponse1);
            
            

        }catch (InvalidArgumentException1 | ProjectNotFoundException e){
            System.out.println(e.getMessage());
        }

    }

    void display(ProjectDetails result){
        System.out.println(result.getId()+"-"+result.getProjectName()+"-"+result.getDurationInDays());
    }

}
