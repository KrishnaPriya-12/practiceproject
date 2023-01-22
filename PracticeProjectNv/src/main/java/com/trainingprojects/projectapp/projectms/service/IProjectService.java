package com.trainingprojects.projectapp.projectms.service;

import com.trainingprojects.projectapp.projectms.dto.CreateProjectRequest;
import com.trainingprojects.projectapp.projectms.dto.ProjectDetails;
import com.trainingprojects.projectapp.projectms.exceptions.InvalidArgumentException1;
import com.trainingprojects.projectapp.projectms.exceptions.ProjectNotFoundException;

public interface IProjectService {
	ProjectDetails registerProject(CreateProjectRequest request)throws InvalidArgumentException1;
	
	ProjectDetails findDetailsById( long projectId) throws InvalidArgumentException1, ProjectNotFoundException;

}
