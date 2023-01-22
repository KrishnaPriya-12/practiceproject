package com.trainingprojects.projectapp.projectms.dto;

public class CreateProjectRequest {
	private String projectName;
	private int durationInDays;
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public int getDurationInDays() {
		return durationInDays;
	}
	public void setDurationInDays(int durationInDays) {
		this.durationInDays = durationInDays;
	}
	

}
