package view;

public class MainView {
    int mainMenuResult;
    public boolean isExit = false;

    public static final String MAIN_MENU = "\nВыберите операцию, которую вы хотите осуществить:\n" +
            "1 - Создать пользователя;\n" +
            "2 - Прочитать данные о пользователе;\n" +
            "3 - Изменить данные о пользователе;\n" +
            "4 - Удалить пользователя;\n" +
            "5 - Выйти из приложения.";
    public static final String GLOBAL_EXIT = "-Вы вышли из приложения!-";
    public static final String MAIN_MENU_VARIANTS = "Введите число от 1 до 5";

    CustomerView customerView = new CustomerView();
    public void renderMainMenu() {
        System.out.println(MAIN_MENU);
    }

    public void chooseAction() {
        mainMenuResult = InputChecker.readIntInput();
        switch (mainMenuResult) {
            case (1):
                customerView.save();
                break;
            case (2):
                customerView.getAll();
                break;
            case (3):
                customerView.update();
                break;
            case (4):
                customerView.delete();
                break;
            case (5):
                isExit = true;
                System.out.println(GLOBAL_EXIT);
                break;
            default:
                System.out.println(MAIN_MENU_VARIANTS);
        }
    }

}
