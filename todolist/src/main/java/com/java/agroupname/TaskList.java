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
  }

  public TaskList(String inputTitle, TaskList inputPrevDest, TaskList inputNextDest) {
    this.title = inputTitle;
    this.tasklist = new ArrayList<>();
    this.prev_dest = inputPrevDest;
    this.next_dest = inputNextDest;
  }
  // TODO: Add task to tasklist method

  // TODO: Print tasks method

  // TODO: Remove task from tasklist method

  // TODO: get set methods
}
