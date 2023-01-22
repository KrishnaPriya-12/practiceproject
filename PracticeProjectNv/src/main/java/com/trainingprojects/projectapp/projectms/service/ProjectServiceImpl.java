package com.trainingprojects.projectapp.projectms.service;

import java.util.Optional;

import com.trainingprojects.projectapp.projectms.dto.CreateProjectRequest;
import com.trainingprojects.projectapp.projectms.dto.ProjectDetails;
import com.trainingprojects.projectapp.projectms.entity.Project;
import com.trainingprojects.projectapp.projectms.exceptions.InvalidArgumentException1;
import com.trainingprojects.projectapp.projectms.exceptions.ProjectNotFoundException;
import com.trainingprojects.projectapp.projectms.repository.IProjectRepository;
import com.trainingprojects.projectapp.projectms.repository.ProjectRepositoryImpl;
import com.trainingprojects.projectapp.projectms.util.Util1;



public class ProjectServiceImpl implements IProjectService {
	private IProjectRepository projectRepo = new ProjectRepositoryImpl();
    private Util1 util1 =new Util1();

    private long generatedId;

    long generateId() {
        return ++generatedId;
    }
    
    /**
     *  registers new project
     *
     * @param request request data
     * @return project details response object
     * @throws InvalidArgumentException1 if input is invalid
     */

    @Override
    public ProjectDetails registerProject(CreateProjectRequest request) throws InvalidArgumentException1 {
        util1.validateNotEmpty(request.getProjectName(), "projectName");
        util1.validateLength(request.getProjectName(), 3, 10, request.getProjectName());
        util1.validateDurationInDays(request.getDurationInDays());
        
        
        long newId = generateId();
        //int durationDays= generateDays();
        Project project = new Project();
        project.setId(newId);
        project.setProjectName(request.getProjectName());
        project.setDurationInDays(request.getDurationInDays());
        
        projectRepo.save(project);
        ProjectDetails desired = util1.toProjectDetails(project);
        return desired;

    }

    


	/**
     *  fetching employee and return its details as EmployeeDetails resposne object
     *
     * @param projectId
     * @return ProjectDetails response object
     * @throws InvalidArgumentException1 if id is not valid
     * @throws ProjectNotFoundException if employee is not found in store
     */
    @Override
    public ProjectDetails findDetailsById(long projectId) throws InvalidArgumentException1,ProjectNotFoundException {
        util1.validateId(projectId);
        Optional<Project> optional = projectRepo.findById(projectId);
        if (!optional.isPresent()) {
            throw new ProjectNotFoundException("project not found for id=" + projectId);
        }
        Project project = optional.get();
        ProjectDetails desired = util1.toProjectDetails(project);
        return desired;
    }

}
