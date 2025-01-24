package View;

import Controller.CarDealerController;
import Model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class LoginView extends JFrame{
    private JPanel mainPanel;
    private JTextField txtUserFirstName;
    private JPasswordField txtUserPassword;
    private JButton btnUserLogin;
    private JTextField txtUserLastName;

    private CarDealerController carDealerController;
    private User currentUser;
    public User getCurrentUser() { return currentUser; }

    public LoginView(CarDealerController carDealerController) {
        super("CarDealer Manager Login");
        setContentPane(mainPanel);
        pack(); // To render the GUI
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        this.carDealerController = carDealerController;

        btnUserLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!carDealerController.validateLogin(txtUserLastName.getText(), txtUserFirstName.getText(), String.valueOf(txtUserPassword.getPassword()))){
                    infoBox("Die Login Informationen sind ungültig", "Ungültiges Login");
                }
                else{
                    MainView view = new MainView(carDealerController);
                    view.setVisible(true);
                    setVisible(false);
                    dispose();
                }
            }
        } );
    }

    private static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}
