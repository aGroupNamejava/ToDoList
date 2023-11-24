package com.java.agroupname;

import java.util.ArrayList;

public class TaskList {
  String title; // refers to TaskList's title
  ArrayList<Task> tasklist;
  TaskList prev_dest;
  TaskList next_dest;

  public TaskList(String inputTitle) {
    this.title = inputTitle;
    this.tasklist = new ArrayList<>();
    this.prev_dest = null;
    this.next_dest = null;
  }

  public TaskList(String inputTitle, TaskList inputPrevDest, TaskList inputNextDest) {
    this.title = inputTitle;
    this.tasklist = new ArrayList<>();
    this.prev_dest = inputPrevDest;
    this.next_dest = inputNextDest;
  }

  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
  public void addTask(String inputTitle) {
    tasklist.add(new Task(inputTitle, this.title));
  }

  public void printTaskList() {
    System.out.println(this.title);
    System.out.println("-----------");
    for (Task task : tasklist) {
      System.out.println(task.getTitle() + " " + task.getLocation());
    }
  }

  // TODO: Remove task from tasklist
  // TODO: (Optional) Update task form tasklist
  // TODO: Move task between tasklist
  // TODO: Add GUI component logics

  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
  public String getTitle() {
    return this.title;
  }

  public void setTitle(String inputTitle) {
    this.title = inputTitle;
  }

  public ArrayList<Task> getTaskList() {
    return this.tasklist;
  }

  public void setTaskList(ArrayList<Task> inputTasklist) {
    this.tasklist = inputTasklist;
  }

  public String getPrevDest() {
    return this.prev_dest.getTitle();
  }

  public void setPrevDest(TaskList inputTask) {
    this.prev_dest = inputTask;
  }

  public String getNextDest() {
    return this.next_dest.getTitle();
  }

  public void setNextDest(TaskList inputTask) {
    this.next_dest = inputTask;
  }
  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

}
