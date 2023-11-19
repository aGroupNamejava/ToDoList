import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 Kaila dump of ideas because I would like to dump them asap but I can't code everything rn

 make each seperate task a class, make a jlist of these classes, and when the buttons are pressed, we add them accordingly
 my only concern is the actionListener, do we put it in the individual classes or still in the main class?
 either way I feel like this is a start
 */
class toDoBoxes{
    toDoBoxes(String t){
        JLabel task = new JLabel(t);
        JButton next = new JButton("→");
    }
}
/* 
class inProgressBoxes{

}

class doneBoxes{

}
*/
class playground {
    
    toDoBoxes toDoTasks[] = new toDoBoxes[10];

    playground(){
        JFrame jfrm = new JFrame("Playground");
        jfrm.setSize(600,400);
        jfrm.getContentPane().setLayout(new FlowLayout()); //gridbag maybe??
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("Title");
        JTextField addTask = new JTextField(15);
        JButton enterTask = new JButton("Add Task");
        JButton deleteTask = new JButton("Delete Task");
        JButton clearTask = new JButton("Clear Tasks");

        jfrm.add(title);
        jfrm.add(addTask);
        jfrm.add(enterTask);
        jfrm.add(deleteTask);
        jfrm.add(clearTask);

        JPanel threeColumns = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints(); // makes the model for constraints
        c.fill = GridBagConstraints.BOTH; // fills both vertically and horizontally
        c.insets = new Insets(15,100,15,15);
        
        c.ipadx = 3; //padding x
        c.ipady = 15; //padding y

        //--> labels for top
        JLabel toDoLab = new JLabel("To-Do");
        JLabel inProgressLab = new JLabel("In Progress");
        JLabel completedLab = new JLabel("Done");

        c.gridx = 0; //declares x & y coordinates we need to work with
        c.gridy = 0;
        threeColumns.add(toDoLab, c);

        c.gridx = 1;
        c.gridy = 0;
        threeColumns.add(inProgressLab, c);

        c.gridx = 2;
        c.gridy = 0;
        threeColumns.add(completedLab, c);

        //create list model
        DefaultListModel<toDoBoxes> toDoModel = new DefaultListModel<toDoBoxes>();
        JList<toDoBoxes> toDoList = new JList<toDoBoxes>(toDoModel);
        c.gridx = 0;
        c.gridy = 1;
        threeColumns.add(toDoList);

        jfrm.add(threeColumns);
        jfrm.setVisible(true);
    }

    public static void main(String args[]){
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                new playground();
            }
        });
    }
}