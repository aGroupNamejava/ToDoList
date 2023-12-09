import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.TransferHandler;
import javax.swing.border.Border;

class todolisto {
    private JFrame frame;
    private JTextField textField;
    private DefaultListModel<String> toDoListModel;
    private JList<String> toDoList;
    private DefaultListModel<String> inProgressListModel;
    private JList<String> inProgressList;
    private DefaultListModel<String> completedListModel;
    private JList<String> completedList;

    public todolisto() {
        // Create and set up the window.
        frame = new JFrame("To-Do List by --- Evan, Kaila, Young, Andrew");
        frame.setSize(700, 550);
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().setBackground(new Color(255, 248, 222));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Components for input
        JLabel title = new JLabel("Title");
        textField = new JTextField(15);
        JButton enterTask = new JButton("Add Task");
        enterTask.setFocusPainted(false);
        enterTask.setContentAreaFilled(false);
        JButton deleteTask = new JButton("Delete Task");
        deleteTask.setFocusPainted(false);
        deleteTask.setContentAreaFilled(false);
        JButton clearTask = new JButton("Clear Tasks");
        clearTask.setFocusPainted(false);
        clearTask.setContentAreaFilled(false);

        //colors!!
        Border border1 = BorderFactory.createLineBorder(new Color(153, 169, 143), 2);
        Border border2 = BorderFactory.createLineBorder(new Color(193, 208, 181), 2);
        Border border3 = BorderFactory.createLineBorder(new Color(214, 232, 219), 2);
        Color buttonColor = new Color(193, 208, 181);
        enterTask.setBackground(buttonColor);
        enterTask.setOpaque(true);
        enterTask.setBorder(border1);
        enterTask.setBorderPainted(true);
        deleteTask.setBackground(buttonColor);
        deleteTask.setOpaque(true);
        deleteTask.setBorder(border1);
        deleteTask.setBorderPainted(true);
        clearTask.setBackground(buttonColor);
        clearTask.setOpaque(true);
        clearTask.setBorder(border1);
        clearTask.setBorderPainted(true);
        textField.setBorder(border2);

        // Add input components to the frame
        frame.add(title);
        frame.add(textField);
        frame.add(enterTask);
        frame.add(deleteTask);
        frame.add(clearTask);

        // Panel with three columns for task lists
        JPanel threeColumns = new JPanel(new GridBagLayout());
        threeColumns.setBackground(new Color(254, 250, 224));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);
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

        TransferHandler dragDrop = new TransferHandler("String");

        // Create models and lists for each task list
        toDoListModel = new DefaultListModel<>();
        toDoList = new JList<>(toDoListModel);
        JScrollPane toDoScrollPane = new JScrollPane(toDoList);
        toDoScrollPane.setPreferredSize(new Dimension(200, 400));
        c.gridx = 0;
        c.gridy = 1;
        threeColumns.add(toDoScrollPane, c);
        toDoScrollPane.setBorder(border3);

        inProgressListModel = new DefaultListModel<>();
        inProgressList = new JList<>(inProgressListModel);
        JScrollPane inProgressScrollPane = new JScrollPane(inProgressList);
        inProgressScrollPane.setPreferredSize(new Dimension(200, 400));
        c.gridx = 1;
        c.gridy = 1;
        threeColumns.add(inProgressScrollPane, c);
        inProgressScrollPane.setBorder(border3);

        completedListModel = new DefaultListModel<>();
        completedList = new JList<>(completedListModel);
        JScrollPane completedScrollPane = new JScrollPane(completedList);
        completedScrollPane.setPreferredSize(new Dimension(200, 400));
        c.gridx = 2;
        c.gridy = 1;
        threeColumns.add(completedScrollPane, c);
        completedScrollPane.setBorder(border3);

        // Action listeners for buttons
        enterTask.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String taskTitle = textField.getText();
                toDoListModel.addElement(taskTitle); // Add to to-do list by default
                textField.setText("");
            }
        });
        enterTask.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent me){
                enterTask.setBackground(new Color(153, 169, 143));
            }

            public void mouseExited(MouseEvent me){
                enterTask.setBackground(buttonColor);
            }
        });
        
        deleteTask.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int[] values = toDoList.getSelectedIndices();
                for (int i = values.length - 1; i >= 0; i--) {
                    toDoListModel.remove(values[i]);
                }
                values = inProgressList.getSelectedIndices();
                for (int i = values.length - 1; i >= 0; i--) {
                    inProgressListModel.remove(values[i]);
                }
                values = completedList.getSelectedIndices();
                for (int i = values.length - 1; i >= 0; i--) {
                    completedListModel.remove(values[i]);
                }
            }
        });

        deleteTask.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent me){
                deleteTask.setBackground(new Color(153, 169, 143));
            }

            public void mouseExited(MouseEvent me){
                deleteTask.setBackground(buttonColor);
            }
        });

        clearTask.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                toDoListModel.clear();
                inProgressListModel.clear();
                completedListModel.clear();
            }
        });

        clearTask.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent me){
                clearTask.setBackground(new Color(153, 169, 143));
            }

            public void mouseExited(MouseEvent me){
                clearTask.setBackground(buttonColor);
            }
        });

        toDoList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JList list = (JList) e.getSource();

                if (e.getClickCount() == 2) {
                    int index = list.locationToIndex(e.getPoint());

                    String newTask = JOptionPane.showInputDialog("Edit task name:");
                    if (!newTask.equals("")) {
                        toDoListModel.setElementAt(newTask, index);
                    }
                }
            }
        });

        inProgressList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JList list = (JList) e.getSource();

                if (e.getClickCount() == 2) {
                    int index = list.locationToIndex(e.getPoint());

                    String newTask = JOptionPane.showInputDialog("Edit task name:");
                    if (!newTask.equals("")) {
                        inProgressListModel.setElementAt(newTask, index);
                    }
                }
            }
        });

        completedList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JList list = (JList) e.getSource();

                if (e.getClickCount() == 2) {
                    int index = list.locationToIndex(e.getPoint());

                    String newTask = JOptionPane.showInputDialog("Edit task name:");
                    if (!newTask.equals("")) {
                        completedListModel.setElementAt(newTask, index);
                    }
                }
            }
        });

        toDoList.setDragEnabled(true);
        inProgressList.setDragEnabled(true);
        completedList.setDragEnabled(true);

        toDoList.setDropMode(DropMode.INSERT);
        inProgressList.setDropMode(DropMode.INSERT);
        completedList.setDropMode(DropMode.INSERT);

        toDoList.setTransferHandler(new ListTransferHandler());
        inProgressList.setTransferHandler(new ListTransferHandler());
        completedList.setTransferHandler(new ListTransferHandler());

        // Add the panel to the frame
        frame.add(threeColumns);
        frame.setVisible(true);
    }

    // Main method to launch the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new todolisto();
            }
        });
    }
}

class ListTransferHandler extends TransferHandler {
    private int[] indices = null;
    private int addIndex = -1; // Location where items were added
    private int addCount = 0; // Number of items added.

    /**
     * We only support importing strings.
     */
    public boolean canImport(TransferHandler.TransferSupport info) {
        // Check for String flavor
        if (!info.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            return false;
        }
        return true;
    }

    /**
     * Bundle up the selected items in a single list for export.
     * Each line is separated by a newline.
     */
    protected Transferable createTransferable(JComponent c) {
        JList list = (JList) c;
        indices = list.getSelectedIndices();
        Object[] values = list.getSelectedValues();

        StringBuffer buff = new StringBuffer();

        for (int i = 0; i < values.length; i++) {
            Object val = values[i];
            buff.append(val == null ? "" : val.toString());
            if (i != values.length - 1) {
                buff.append("\n");
            }
        }

        return new StringSelection(buff.toString());
    }

    /**
     * We support both copy and move actions.
     */
    public int getSourceActions(JComponent c) {
        return TransferHandler.COPY_OR_MOVE;
    }

    /**
     * Perform the actual import. This demo only supports drag and drop.
     */
    public boolean importData(TransferHandler.TransferSupport info) {
        if (!info.isDrop()) {
            return false;
        }

        JList list = (JList) info.getComponent();
        DefaultListModel listModel = (DefaultListModel) list.getModel();
        JList.DropLocation dl = (JList.DropLocation) info.getDropLocation();
        int index = dl.getIndex();
        boolean insert = dl.isInsert();

        // Get the string that is being dropped.
        Transferable t = info.getTransferable();
        String data;
        try {
            data = (String) t.getTransferData(DataFlavor.stringFlavor);
        } catch (Exception e) {
            return false;
        }

        // Wherever there is a newline in the incoming data,
        // break it into a separate item in the list.
        String[] values = data.split("\n");

        addIndex = index;
        addCount = values.length;

        // Perform the actual import.
        for (int i = 0; i < values.length; i++) {
            if (insert) {
                listModel.add(index++, values[i]);
            } else {
                // If the items go beyond the end of the current
                // list, add them in.
                if (index < listModel.getSize()) {
                    listModel.set(index++, values[i]);
                } else {
                    listModel.add(index++, values[i]);
                }
            }
        }
        return true;
    }

    /**
     * Remove the items moved from the list.
     */
    protected void exportDone(JComponent c, Transferable data, int action) {
        JList source = (JList) c;
        DefaultListModel listModel = (DefaultListModel) source.getModel();

        if (action == TransferHandler.MOVE) {
            for (int i = indices.length - 1; i >= 0; i--) {
                listModel.remove(indices[i]);
            }
        }

        indices = null;
        addCount = 0;
        addIndex = -1;
    }
}