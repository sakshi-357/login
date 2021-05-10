import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class Login extends JFrame implements ActionListener {
    JFrame frame;
    JPanel loginPanel, homePanel;
    JLabel user_label, password_label, home_label, message;
    JTextField userName_text;
    JPasswordField password_text;
    JButton submit;
     
    Login(){
        frame = new JFrame();
        loginPanel = new JPanel();
        
        user_label = new JLabel();
        user_label.setText("User Name :");
        userName_text = new JTextField();
        
        password_label = new JLabel();
        password_label.setText("Password :");
        password_text = new JPasswordField();
        
        message = new JLabel();
        submit = new JButton("SUBMIT");
        
        loginPanel = new JPanel(new GridLayout(3, 1));
        loginPanel.add(user_label);
        loginPanel.add(userName_text);
        loginPanel.add(password_label);
        loginPanel.add(password_text);
        loginPanel.add(message);
        loginPanel.add(submit);
        
        submit.addActionListener( new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent arg0) {
            	String userName = userName_text.getText();
                String password = String.valueOf(password_text.getPassword());
                if (userName.trim().equals("admin") && password.trim().equals("admin")) {
                	message.setText(" Logout successfully !! ");    
                    frame.setContentPane(homePanel);
                    homePanel.revalidate();
                    reset();
                } else {
                    message.setText(" Invalid user.. ");
                    reset();
                } 
            }
        });
                
        homePanel = new JPanel();
         
        home_label = new JLabel("Welcome to HOME!!");
        JButton b2 = new JButton("LOGOUT");
        b2.addActionListener( new ActionListener() {
             
            @Override
            public void actionPerformed(ActionEvent arg0) {
                frame.setContentPane(loginPanel);
                loginPanel.revalidate();
            }
        });
        homePanel.add(home_label);
        homePanel.add(b2);
                 
        frame.setSize(450, 350);
        frame.setContentPane(loginPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);       
    }
    
    public void validateData() {
        String userName = userName_text.getText();
        String password = String.valueOf(password_text.getPassword());
        if (userName.trim().equals("admin") && password.trim().equals("admin")) {
            message.setText(" Hello " + userName);
        } else {
            message.setText(" Invalid user.. ");
        }
    }
     
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new Login();
            }
        });
    }

    public void reset() {
    	userName_text.setText("");
    	password_text.setText("");
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	} 
}