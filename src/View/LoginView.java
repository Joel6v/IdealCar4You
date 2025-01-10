package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame{
    private JPanel mainPanel;
    private JTextField tfdUserFirstName;
    private JPasswordField pfdUser;
    private JButton btnUserState;
    private JTextField tfdUserLastName;

    public LoginView() {
        super("My Employee Manager");
        setContentPane(mainPanel);
        pack(); // To render the GUI

        btnUserState.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        } );
    }
}
