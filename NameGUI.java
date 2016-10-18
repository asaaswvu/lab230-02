import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.awt.*;

class NameGUI extends JFrame implements ActionListener{
    
    JTextField txtWord1;
    JTextField txtWord2;
    
    NameGUI(){
        Container pane = getContentPane();  //the visible container of the JFRAME, need it later
        
        //create a background panel to put things into, uses BorderLayout & FlowLayout Managers
        JPanel panelMain = new JPanel(new BorderLayout());
        JPanel panelTop = new JPanel(new FlowLayout());
        JPanel panelMiddle = new JPanel(new FlowLayout());
        JPanel panelBottom = new JPanel(new FlowLayout());
        
        //create a button named btnSample with text Sample Button
        JButton myButton = new JButton("Press me to find out who I am.");
      
        //create sample textboxes
        txtWord1 = new JTextField(15);
        txtWord2 = new JTextField(15);
        
        //create a label for display
        JLabel lblSwap = new JLabel("Ahmed Mian");
        
        //buttons need to say something(ActionCommand) to someone who's listening
        btnSample.setActionCommand("name");  //yours will have to be unique
        btnSample.addActionListener(this);
     
 
        //Add components to proper panels
       
        panelMiddle.add(myButton);

        panelBottom.add(lblSwap);
        panelBottom.add(btnSwap);
        panelBottom.add(txtWord1);
        panelBottom.add(txtWord2);
        
        //Add individual panels to panelMain, applies to BORDERLAYOUT only
        //PAGE_START is top of screen
        //PAGE_END is bottom of screen
        //LINE_START is right side of screen
        //LINE_END is left side of screen
        //CENTER is center
        panelMain.add(panelTop,BorderLayout.PAGE_START);
        panelMain.add(panelMiddle,BorderLayout.CENTER);
        panelMain.add(panelBottom,BorderLayout.PAGE_END);
        
        //created separate method to generate menu, not necessary, but cleaner
        generateMenu();
        
        //set the window size for the app
        setSize(800,600);

        //tells java what to do when the class object closes
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("NameGui Title (how original)");

        
        //get visible container and add panelMain to it
        //EVERYTHING has to be arranged and set before adding to ContentPane
        getContentPane().add(panelMain);

        
        //make sure you can actually see it, starts off false
        setVisible(true);
        
    }
    private void generateMenu(){
        //create an empty menu bar
        JMenuBar menuBar = new JMenuBar();

        //create a menu  (file, edit, help, etc)
        JMenu menuFile = new JMenu("File");
        JMenu menuHelp = new JMenu("Help");
        
        //create a menu item and set up its listeners, similar to buttons
        JMenuItem miQuit = new JMenuItem("Quit");
        miQuit.addActionListener(this);
        miQuit.setActionCommand("quit");
    
        JMenuItem miHelp = new JMenuItem("Help me");
        miHelp.addActionListener(this);
        miHelp.setActionCommand("help");
    
        //put together the pieces
        menuFile.add(miQuit);
        menuHelp.add(miHelp);
        menuBar.add(menuFile);
        menuBar.add(menuHelp);
        //add bar to this JFrame
        setJMenuBar(menuBar);    
    
    }
    public void actionPerformed(ActionEvent evt) {
        //this method listens to the JFrame's events and performs appropriately
        switch (evt.getActionCommand()){
            case "name":
                JOptionPane.showMessageDialog(this,"Ahmed Mian",JOptionPane.PLAIN_MESSAGE);
                break;
            case "quit" :
                System.exit(0);
                break;
        }
    }
    
    public static void main(String [] args){
        new NameGUI();
    }
    
}
