import Model.Model;
import Controller.Controller;

public class App {
    public static void main(String[] args) throws Exception {

        Model model = new Model();
        Controller controller = new Controller();
        
        controller.startMenu(model);
    }
}
