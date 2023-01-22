package com.trainingprojects.projectapp.projectms.repository;



import java.util.Optional;

import com.trainingprojects.projectapp.projectms.entity.Project;

public interface IProjectRepository {
	Project save(Project project);
	Optional<Project> findById(long id);
	

}
