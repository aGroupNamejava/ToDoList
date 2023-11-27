import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.UUID;

class Task {
    private UUID id;
    private String title;

    public Task(String title) {
        this.id = UUID.randomUUID();
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String title) {
        this.tasks.add(new Task(title));
    }

    public ArrayList<Task> getTasks() {
        return this.tasks;
    }
}

public class todolisto {
    private JFrame frame;
    private JTextField textField;
    private DefaultListModel<String> toDoListModel;
    private JList<String> toDoList;
    private DefaultListModel<String> inProgressListModel;
    private JList<String> inProgressList;
    private DefaultListModel<String> completedListModel;
    private JList<String> completedList;
    private TaskList taskList;

    public todolisto() {
        // Create and set up the window.
        frame = new JFrame("To-Do List by --- Evan, Kaila, Young, Andrew");
        frame.setSize(1200, 500);
        frame.getContentPane().setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Components for input
        JLabel title = new JLabel("Title");
        textField = new JTextField(15);
        JButton enterTask = new JButton("Add Task");
        JButton deleteTask = new JButton("Delete Task");
        JButton clearTask = new JButton("Clear Tasks");

        // Add input components to the frame
        frame.add(title);
        frame.add(textField);
        frame.add(enterTask);
        frame.add(deleteTask);
        frame.add(clearTask);

        // Panel with three columns for task lists
        JPanel threeColumns = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(15, 100, 15, 15);
        c.ipadx = 3;
        c.ipady = 15;

        // Labels for task lists
        JLabel toDoLab = new JLabel("To-Do");
        JLabel inProgressLab = new JLabel("In Progress");
        JLabel completedLab = new JLabel("Done");

        // Add labels to the panel
        c.gridx = 0;
        c.gridy = 0;
        threeColumns.add(toDoLab, c);

        c.gridx = 1;
        c.gridy = 0;
        threeColumns.add(inProgressLab, c);

        c.gridx = 2;
        c.gridy = 0;
        threeColumns.add(completedLab, c);

        // Initialize the task list
        taskList = new TaskList();

        // Create models and lists for each task list
        toDoListModel = new DefaultListModel<>();
        toDoList = new JList<>(toDoListModel);
        JScrollPane toDoScrollPane = new JScrollPane(toDoList);
        c.gridx = 0;
        c.gridy = 1;
        threeColumns.add(toDoScrollPane, c);

        inProgressListModel = new DefaultListModel<>();
        inProgressList = new JList<>(inProgressListModel);
        JScrollPane inProgressScrollPane = new JScrollPane(inProgressList);
        c.gridx = 1;
        c.gridy = 1;
        threeColumns.add(inProgressScrollPane, c);

        completedListModel = new DefaultListModel<>();
        completedList = new JList<>(completedListModel);
        JScrollPane completedScrollPane = new JScrollPane(completedList);
        c.gridx = 2;
        c.gridy = 1;
        threeColumns.add(completedScrollPane, c);

        // Action listeners for buttons
        enterTask.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String taskTitle = textField.getText();
                if (!taskTitle.isEmpty()) {
                    taskList.addTask(taskTitle);
                    toDoListModel.addElement(taskTitle); // Add to to-do list by default
                    textField.setText("");
                }
            }
        });

        clearTask.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                toDoListModel.clear();
                inProgressListModel.clear();
                completedListModel.clear();
            }
        });

        // Add the panel to the frame
        frame.add(threeColumns);
        frame.setVisible(true);
    }

    // Main method to launch the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new todolisto());
    }
}
