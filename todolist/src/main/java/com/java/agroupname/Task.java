package com.java.agroupname;

import java.util.UUID;

public class Task {
  private UUID id;
  private String title; // Refers to the content of the task
  private String location; // Refers to where is this Task located (Which list of tasks)

  public Task(String inputTitle, String inputLocation) {
    id = UUID.randomUUID();

    title = inputTitle;
    location = inputLocation;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String inputTitle) {
    title = inputTitle;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String inputLocation) {
    location = inputLocation;
  }

  public UUID getId() {
    return id;
  }
}
