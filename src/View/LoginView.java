package View;

import Controller.CarDealerController;
import Model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame{
    private JPanel mainPanel;
    private JTextField txtUserFirstName;
    private JPasswordField txtUserPassword;
    private JButton btnUserLogin;
    private JTextField txtUserLastName;

    private CarDealerController carDealerController;

    public LoginView(CarDealerController carDealerController) {
        super("CarDealer Manager Login");
        setContentPane(mainPanel);
        pack(); // To render the GUI
        setVisible(true);

        this.carDealerController = carDealerController;

        btnUserLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                User user = carDealerController.validateLogin(txtUserLastName.getText(), txtUserFirstName.getText(), txtUserPassword.getText());
                if(user == null){
                    infoBox("Die Login Informationen sind ungültig", "Ungültiges Login");
                }
                else{
                    setVisible(false); //you can't see me!
                    dispose(); //Destroy the JFrame object
                }
            }
        } );
    }

    private static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}
