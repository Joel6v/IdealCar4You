package View;

import Controller.CarDealerController;
import Model.*;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

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
    private JButton btnSearchCostumers;
    private JList lstCostumers;
    private JTextField txtLastName;
    private JTextField txtFirstName;
    private JTextField txtAdress;
    private JTextField txtPhoneNumberMobile;
    private JTextField txtEmail;
    private JTextField txtBirthDate;
    private JTextField txtCreatedAt;
    private JButton btnNewCostumer;
    private JButton btnSaveCostumer;
    private JButton btnDeleteCostumer;
    private JComboBox cmbFuel;
    private JComboBox cmbCarStructure;
    private JCheckBox chkCarNavigation;
    private JComboBox cmbType;
    private JTextField txtVanMaxLoad;
    private JLabel lblVanMaxLoad;
    private JLabel lblCarNavigation;
    private JLabel lblCarStructure;
    private JTextField txtAge;
    private JPanel pnlUsers;
    private JList lstUsers;
    private JComboBox cmbUserRole;
    private JPasswordField txtUserPassword;
    private JTextField txtUserLastName;
    private JTextField txtUserFirstName;
    private JTextField txtUserAdress;
    private JTextField txtUserPhoneNumberMobile;
    private JTextField txtUserEmail;
    private JTextField txtUserBirthDate;
    private JTextField txtUserAge;
    private JButton btnNewUser;
    private JButton btnDeleteUser;
    private JButton btnSaveUser;
    private JButton btnSearchUsers;
    private JTextField txtSearchUsers;
    private JButton btnResetCostumers;
    private JButton btnResetVehicles;
    private JButton btnResetUsers;
    private JButton btnSaveAll;

    private CarDealerController controller;

    public MainView(CarDealerController carDealerController){
        super("CarDealer Manager");
        setContentPane(mainPanel);
        pack(); // To render the GUI
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        controller = carDealerController;

        setLists(controller.getCustomer(), controller.getVehicle(), controller.getUser());
        setPanelCurrentUser();
        setCmbValuesVehicle();
        setCmbValuesUser();

        tabMenu.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int index = tabMenu.getSelectedIndex();
                switch (index){
                    case -1, 0:{
                        lstVehicles.setSelectedIndex(0);
                        setContentVehicle(0);
                    }break;
                    case 1:{
                        setContentCustomer(0);
                    }
                    case 2:{
                        setContentUser(0);
                    }
                }
            }
        });

        cmbType.addActionListener(new ActionListener() { //Vehicle specific
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cmbType.getSelectedIndex() == 0){
                    setVisibleCar();
                }else if(cmbType.getSelectedIndex() == 1){
                    setVisibleVan();
                }
            }
        });

        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setCurrentUserNull();
                LoginView view = new LoginView(controller);
                view.setVisible(true);
                setVisible(false);
                dispose();
            }
        });

        lstCostumers.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(lstCostumers.getSelectedIndex() != -1){
                    setContentCustomer(lstCostumers.getSelectedIndex());
                }
            }
        });
        lstVehicles.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(lstVehicles.getSelectedIndex() != -1){
                    setContentVehicle(lstVehicles.getSelectedIndex());
                }
            }
        });
        lstUsers.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(lstUsers.getSelectedIndex() != -1){
                    setContentUser(lstUsers.getSelectedIndex());
                }
            }
        });

        searchButtons();
        crudButtonsCustomer();
    }

    private void searchButtons(){
        btnSearchVehicles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lstVehicles.setListData(controller.searchVehicle(txtSearchVehicles.getText()).toArray());
            }
        });

        btnResetVehicles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lstVehicles.setListData(controller.getVehicle().toArray());

                txtSearchVehicles.setText("");
            }
        });

        btnSearchCostumers.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lstCostumers.setListData(controller.searchCustomer(txtSearchCostumers.getText()).toArray());
            }
        });

        btnResetCostumers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lstCostumers.setListData(controller.getCustomer().toArray());
                txtSearchCostumers.setText("");
            }
        });

        btnSearchUsers.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lstUsers.setListData(controller.searchUser(txtSearchUsers.getText()).toArray());
            }
        });

        btnResetUsers.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lstUsers.setListData(controller.getUser().toArray());
                txtSearchUsers.setText("");
            }
        });
    }

    private void crudButtonsCustomer(){ // The buttons at the bottom of the frame and one in the top. New, no read, save, delete
        btnNewCostumer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setCustomer(new Customer());
                lstCostumers.setListData(controller.getCustomer().toArray());
                setContentCustomer(controller.getCustomer().size() -1);
            }
        });
        btnSaveCostumer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Customer currentCustomer = new Customer(txtFirstName.getText(), txtLastName.getText(), txtAdress.getText(), txtPhoneNumberMobile.getText(), txtEmail.getText(), txtBirthDate.getText());
                    controller.setCustomer(currentCustomer, lstCostumers.getSelectedIndex());
                }catch(DateTimeParseException dateTimeParseException){
                    controller.infoBox("An exception occurred when parsing the date", "Error parsing date");
                }catch(InvalidAddressException invalidAddressException){
                    controller.infoBox(invalidAddressException.getMessage(), "Error converting address");
                }
            }
        });
        btnDeleteCostumer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = lstCostumers.getSelectedIndex();
                controller.deleteCustomer(index);
                lstCostumers.setListData(controller.getCustomer().toArray());
                lstCostumers.setSelectedIndex(index);
                setContentCustomer(index);
            }
        });

        btnSaveAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.saveAllLists();
            }
        });
    }

    private void setContentCustomer(int index){
        if(!controller.getCustomer().isEmpty() && index != -1){
            txtLastName.setText(controller.getCustomer(index).getLastName());
            txtFirstName.setText(controller.getCustomer(index).getFirstName());
            txtAdress.setText(controller.getCustomer(index).getAddress());
            txtPhoneNumberMobile.setText(controller.getCustomer(index).getPhoneNumberMobile());
            txtEmail.setText(controller.getCustomer(index).getEmail());
            txtBirthDate.setText(controller.getCustomer(index).getBirthDateString());
            txtAge.setText(Integer.toString(controller.getCustomer(index).getAge()));
            txtCreatedAt.setText(controller.getCustomer(index).getCreateAtString());
        }
    }

    private void setContentUser(int index){
        if(!controller.getUser().isEmpty() && index != -1){
            txtUserLastName.setText(controller.getUser(index).getLastName());
            txtUserFirstName.setText(controller.getUser(index).getFirstName());
            txtUserAdress.setText(controller.getUser(index).getAddress());
            txtUserPhoneNumberMobile.setText(controller.getUser(index).getPhoneNumberMobile());
            txtUserEmail.setText(controller.getUser(index).getEmail());
            txtUserBirthDate.setText(controller.getUser(index).getBirthDateString());
            txtUserAge.setText(Integer.toString(controller.getUser(index).getAge()));
            cmbUserRole.setSelectedIndex(Role.indexOf(controller.getUser(index).getRole()));
            txtUserPassword.setText("");
        }
    }

    private void setContentVehicle(int index){
        if(!controller.getVehicle().isEmpty() && index != -1){

            cmbType.setSelectedIndex(0);
            txtBrand.setText(controller.getVehicle(index).getBrand());
            txtModel.setText(controller.getVehicle(index).getModel());
            txtDisplacement.setText(String.valueOf(controller.getVehicle(index).getDisplacement()));
            cmbFuel.setSelectedIndex(Fuel.indexOf(controller.getVehicle(index).getFuel()));
            txtCurrentKm.setText(String.valueOf(controller.getVehicle(index).getCurrentKm()));
            txtPower.setText(String.valueOf(controller.getVehicle(index).getPower()));
            txtFirstRegistration.setText(controller.getVehicle(index).getFirstRegistrationString());
            txtEmptyWeigth.setText(String.valueOf(controller.getVehicle(index).getEmptyWeigth()));

            if(controller.getVehicle(index) instanceof Car){
                setContentCar(index);
            }else{
                setContentVan(index);
            }
        }
    }

    private void setContentVan(int index){
        setVisibleVan();

        cmbType.setSelectedIndex(1);
        txtVanMaxLoad.setText(String.valueOf(((Van)controller.getVehicle(index)).getMaxLoad()));
    }

    private void setVisibleVan(){
        lblCarStructure.setVisible(false);
        cmbCarStructure.setVisible(false);
        lblCarNavigation.setVisible(false);
        chkCarNavigation.setVisible(false);

        lblVanMaxLoad.setVisible(true);
        txtVanMaxLoad.setVisible(true);
    }

    private void setContentCar(int index){
        setVisibleCar();

        cmbType.setSelectedIndex(0);
        cmbCarStructure.setSelectedIndex(Structure.indexOf(((Car)controller.getVehicle(index)).getStructure()));
        chkCarNavigation.setSelected(((Car)controller.getVehicle(index)).getNavigation());
    }

    private void setVisibleCar(){
        lblCarStructure.setVisible(true);
        cmbCarStructure.setVisible(true);
        lblCarNavigation.setVisible(true);
        chkCarNavigation.setVisible(true);

        lblVanMaxLoad.setVisible(false);
        txtVanMaxLoad.setVisible(false);
    }

    private void setPanelCurrentUser(){
        if(controller.getCurrentUser().getRole() == Role.ADMIN){
            pnlCustomers.setVisible(true);
            pnlVehicles.setVisible(true);
            pnlUsers.setVisible(true);
        }else if(controller.getCurrentUser().getRole() == Role.CUSTOMER_CONSULTANT){
            pnlCustomers.setVisible(true);
            pnlVehicles.setVisible(true);
            pnlUsers.setVisible(false);
        }else if(controller.getCurrentUser().getRole() == Role.VEHICLE_FLEET_MANAGER){
            pnlCustomers.setVisible(false);
            pnlVehicles.setVisible(true);
            pnlUsers.setVisible(false);
        }
    }

    private void setCmbValuesVehicle(){
        cmbType.addItem("Car");
        cmbType.addItem("Van");
        setVisibleCar();

        for(Fuel fuel : Fuel.values()){
            cmbFuel.addItem(fuel);
        }

        for(Structure structure : Structure.values()){
            cmbCarStructure.addItem(structure);
        }
    }

    private void setCmbValuesUser(){
        for(Role role : Role.values()){
            cmbUserRole.addItem(role);
        }
    }

    private void setLists(ArrayList<Customer> customers, ArrayList<Vehicle> vehicles, ArrayList<User> users){
        lstCostumers.setListData(customers.toArray());
        lstVehicles.setListData(vehicles.toArray());
        lstUsers.setListData(users.toArray());
    }
}
