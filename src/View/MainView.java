package View;

import Controller.CarDealerController;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.time.format.DateTimeFormatter;

public class MainView extends JFrame{
    private JPanel mainPanel;
    private JTabbedPane tabMenu;
    private JButton btnLogout;
    private JPanel pnlCustomers;
    private JPanel pnlVehicles;
    private JTextField txtSearchVehicles;
    private JButton btnSearchVehicles;
    private JList lstVehicles;
    private JTextField txtBrand;
    private JTextField txtModel;
    private JTextField txtDisplacement;
    private JTextField txtCurrentKm;
    private JTextField txtPower;
    private JTextField txtFirstRegistration;
    private JTextField txtEmptyWeigth;
    private JButton btnNewVehicles;
    private JButton btnSaveVehicles;
    private JButton btnDeleteVehicles;
    private JTextField txtSearchCostumers;
    private JButton btnSearch;
    private JList lstCostumers;
    private JTextField txtLastName;
    private JTextField txtFirstName;
    private JTextField txtAdress;
    private JTextField txtPhoneNumberMobile;
    private JTextField txtEmail;
    private JTextField txtBirthDate;
    private JTextField textField17;
    private JButton btnNewCostumer;
    private JButton btnSaveCostumer;
    private JButton btnDeleteCostumer;
    private JComboBox cmbFuel;
    private JComboBox cmbCarStructure;
    private JCheckBox cmbCarNavigation;
    private JComboBox cmbType;
    private JTextField cmbVanMaxLoad;
    private JLabel lblVanMaxLoad;
    private JLabel lblCarNavigation;
    private JLabel lblCarStructure;
    private JTextField txtAge;

    private CarDealerController controller;

    public MainView(CarDealerController carDealerController){
        super("CarDealer Manager");
        setContentPane(mainPanel);
        pack(); // To render the GUI
        setVisible(true);

        controller = carDealerController;

        tabMenu.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event) {

            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {

            }

            @Override
            public void ancestorMoved(AncestorEvent event) {

            }
        });
    }

    private void setContentCustomers(int indexUser){
        txtLastName.setText(controller.getCustomer(indexUser).getLastName());
        txtFirstName.setText(controller.getCustomer(indexUser).getFirstName());
        txtAdress.setText(controller.getCustomer(indexUser).getAdress());
        txtPhoneNumberMobile.setText(controller.getCustomer(indexUser).getPhoneNumberMobile());
        txtEmail.setText(controller.getCustomer(indexUser).getEmail());
        txtBirthDate.setText(controller.getCustomer(indexUser).getBirthDateString());
        txtAge.setText(Integer.toString(controller.getCustomer(indexUser).getAge()));

    }
}
