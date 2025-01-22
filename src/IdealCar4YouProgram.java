import Controller.CarDealerController;
import Model.CarDealerModel;
import View.*;

public class IdealCar4YouProgram {
    public static CarDealerModel model;
    public static CarDealerController controller;

    public static void main(String[] args){
        model = new CarDealerModel();
        controller = new CarDealerController(model);

        LoginView loginView = new LoginView(controller);

        //loginView.setModal(true);
        loginView.setVisible(true);

        MainView mainView = new MainView(controller);
    }
}
