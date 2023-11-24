package com.java.agroupname;

public class App {
    public static void main(String[] args) {
        System.out.println("Task & TaskList test");
        // Create a task list
        TaskList todo = new TaskList("To Do");

        // Add tasks to todo task list
        todo.addTask("Write code in Java");
        todo.addTask("Do homework");
        todo.addTask("Do another homework");

        // Print todo task list
        todo.printTaskList();
    }
}
