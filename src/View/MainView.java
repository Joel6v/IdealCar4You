package View;

import Controller.CarDealerController;
import Model.*;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    private CarDealerController controller;

    public MainView(CarDealerController carDealerController){
        super("CarDealer Manager");
        setContentPane(mainPanel);
        pack(); // To render the GUI
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        controller = carDealerController;

        setLists();
        setPanelCurrentUser();
        setCmbValuesVehicle();

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
                        setContentCustomers(0);
                    }
                }
            }
        });

        cmbType.addActionListener(new ActionListener() {
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
                    setContentCustomers(lstCostumers.getSelectedIndex());
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
    }

    private void searchButtons(){
        btnSearchVehicles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentCustomers(controller.searchCustomer(txtSearchCostumers.getText()));
            }
        });

        btnSearchVehicles.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentVehicle(controller.searchVehicle(txtSearchVehicles.getText()));
            }
        });
    }

    private void setContentCustomers(int indexUser){
        if(!controller.getCustomer().isEmpty() && indexUser != -1){
            txtLastName.setText(controller.getCustomer(indexUser).getLastName());
            txtFirstName.setText(controller.getCustomer(indexUser).getFirstName());
            txtAdress.setText(controller.getCustomer(indexUser).getAdress());
            txtPhoneNumberMobile.setText(controller.getCustomer(indexUser).getPhoneNumberMobile());
            txtEmail.setText(controller.getCustomer(indexUser).getEmail());
            txtBirthDate.setText(controller.getCustomer(indexUser).getBirthDateString());
            txtAge.setText(Integer.toString(controller.getCustomer(indexUser).getAge()));
            txtCreatedAt.setText(controller.getCustomer(indexUser).getCreateAtString());
        }
    }

    private void setContentVehicle(int vehiclesIndex){
        if(!controller.getVehicle().isEmpty() && vehiclesIndex != -1){

            cmbType.setSelectedIndex(0);
            txtBrand.setText(controller.getVehicle(vehiclesIndex).getBrand());
            txtModel.setText(controller.getVehicle(vehiclesIndex).getModel());
            txtDisplacement.setText(String.valueOf(controller.getVehicle(vehiclesIndex).getDisplacement()));
            cmbFuel.setSelectedIndex(Fuel.indexOf(controller.getVehicle(vehiclesIndex).getFuel()));
            txtCurrentKm.setText(String.valueOf(controller.getVehicle(vehiclesIndex).getCurrentKm()));
            txtPower.setText(String.valueOf(controller.getVehicle(vehiclesIndex).getPower()));
            txtFirstRegistration.setText(controller.getVehicle(vehiclesIndex).getFirstRegistrationString());
            txtEmptyWeigth.setText(String.valueOf(controller.getVehicle(vehiclesIndex).getEmptyWeigth()));

            if(controller.getVehicle(vehiclesIndex) instanceof Car){
                setContentCar(vehiclesIndex);
            }else{
                setContentVan(vehiclesIndex);
            }
        }
    }

    private void setContentVan(int vehiclesIndex){
        setVisibleVan();

        cmbType.setSelectedIndex(1);
        txtVanMaxLoad.setText(String.valueOf(((Van)controller.getVehicle(vehiclesIndex)).getMaxLoad()));
    }

    private void setVisibleVan(){
        lblCarStructure.setVisible(false);
        cmbCarStructure.setVisible(false);
        lblCarNavigation.setVisible(false);
        chkCarNavigation.setVisible(false);

        lblVanMaxLoad.setVisible(true);
        txtVanMaxLoad.setVisible(true);
    }

    private void setContentCar(int vehiclesIndex){
        setVisibleCar();

        cmbType.setSelectedIndex(0);
        cmbCarStructure.setSelectedIndex(Structure.indexOf(((Car)controller.getVehicle(vehiclesIndex)).getStructure()));
        chkCarNavigation.setSelected(((Car)controller.getVehicle(vehiclesIndex)).getNavigation());
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

    private void setLists(){
        lstCostumers.setListData(controller.getCustomer().toArray());
        lstVehicles.setListData(controller.getVehicle().toArray());
        //lstUsers.setListData(controller.getUser().toArray());
    }
}
