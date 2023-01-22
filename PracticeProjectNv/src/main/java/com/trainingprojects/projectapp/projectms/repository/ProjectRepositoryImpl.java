package com.trainingprojects.projectapp.projectms.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.trainingprojects.projectapp.projectms.entity.Project;

public class ProjectRepositoryImpl implements IProjectRepository {
	private Map<Long, Project> store = new HashMap<>();

    /**
     * inserts or updates project 
     *
     * @param project
     * @return project
     */
    @Override
    public Project save(Project project) {
        store.put(project.getId(), project);
        return project;
    }

    @Override
    public Optional<Project> findById(long id) {
        if (!store.containsKey(id)) {
            Optional<Project> optional = Optional.empty();
            return optional;
        }
        Project project = store.get(id);
        Optional<Project> optional = Optional.of(project);
        return optional;
    }

}
