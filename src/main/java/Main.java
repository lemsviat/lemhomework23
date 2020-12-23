import view.MainView;

public class Main {
    public static void main(String[] args) {
        MainView mainView = new MainView();
        mainView.renderMainMenu();
        while (!mainView.isExit) {
            mainView.chooseAction();
            if (!mainView.isExit) mainView.renderMainMenu();
        }
    }
}
