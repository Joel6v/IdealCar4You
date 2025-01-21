package View;

import Controller.CarDealerController;

import javax.swing.*;

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

    public MainView(CarDealerController carDealerController){
        super("CarDealer Manager");
        setContentPane(mainPanel);
        pack(); // To render the GUI
        setVisible(true);
    }
}
