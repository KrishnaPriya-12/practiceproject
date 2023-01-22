package com.trainingprojects.projectapp.projectms.util;

import com.trainingprojects.projectapp.projectms.dto.ProjectDetails;
import com.trainingprojects.projectapp.projectms.entity.Project;
import com.trainingprojects.projectapp.projectms.exceptions.InvalidArgumentException1;

public class Util1 {
	public ProjectDetails toProjectDetails(Project project) {
        ProjectDetails desired = new ProjectDetails();
        desired.setProjectName(project.getProjectName());
        desired.setId(project.getId());
        return desired;

    }

    public void validateId(long arg) throws InvalidArgumentException1 {
        if (arg <= 0) {
            throw new InvalidArgumentException1("id can't be smaller or equal to zero");
        }
    }
    public void validateDurationInDays(int arg) throws InvalidArgumentException1 {
        if (arg <= 0) {
            throw new InvalidArgumentException1("durationInDays can't be smaller or equal to zero");
        }
    }

    public void validateNotEmpty(String arg, String fieldName) throws InvalidArgumentException1 {
        if (arg == null || arg.trim().isEmpty()) {
            throw new InvalidArgumentException1(fieldName + " can't be null or empty");
        }
    }

   public void validateLength(String arg, int min, int max, String fieldName) throws InvalidArgumentException1 {
        if (arg.length() < 3 || arg.length() > 10) {
            throw new InvalidArgumentException1(fieldName + " should be between 3 and 10");
        }
    }

}
