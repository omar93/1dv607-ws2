import View.SimpleView;
import Controller.Controller;

public class App {
    public static void main(String[] args) throws Exception {

        SimpleView view = new SimpleView();
        Model.Menu menu = new Model.Menu();
        Controller controller = new Controller(view,menu);

        controller.startProgram();
    }
}
