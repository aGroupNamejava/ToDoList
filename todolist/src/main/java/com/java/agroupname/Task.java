package com.java.agroupname;

import java.util.UUID;

public class Task {
  private UUID id;
  private String title; // Refers to the content of the task
  private String location; // Refers to where is this Task located (Which list of tasks)

  public Task(String inputTitle, String inputLocation) {
    this.id = UUID.randomUUID();

    this.title = inputTitle;
    this.location = inputLocation;
  }

  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
  public String getTitle() {
    return this.title;
  }

  public void setTitle(String inputTitle) {
    this.title = inputTitle;
  }

  public String getLocation() {
    return this.location;
  }

  public void setLocation(String inputLocation) {
    this.location = inputLocation;
  }

  public UUID getId() {
    return this.id;
  }
  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

}
