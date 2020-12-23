package view;

import controller.AccountController;
import controller.CustomerController;
import controller.SpecialtyController;
import model.Account;
import model.Customer;
import model.Specialty;

import java.util.Set;

public class CustomerView {

    public static final String INPUT_CUSTOMER_NAME = "Введите имя клиента";
    public static final String READ_CUSTOMER_NAME = "Введите имя клиента, данные о котором вы хотите получить";
    public static final String UPDATE_CUSTOMER_NAME = "Введите имя клиента, данные которого вы хотите обновить";
    public static final String UPDATE_ACCOUNT_VALUE = "Введите сумму, на которую вы хотите изменить аккаунт клиента";
    public static final String DELETE_CUSTOMER_NAME = "Введите имя клиента, которого вы хотите удалить";


    public static String customerName;
    public static Set<Specialty> specialties;
    CustomerController customerController = new CustomerController();
    SpecialtyController specialtyController = new SpecialtyController();
    AccountController accountController = new AccountController();

    public static Customer customer;

    public void create() {
        System.out.println(INPUT_CUSTOMER_NAME);
        customerName = InputChecker.readInput();
        customer = new Customer(customerName);

        Account customerAccount = new AccountView().createAccount();
        customer.setAccount(customerAccount);

        SpecialtyView specialtyView=new SpecialtyView();
        specialties=specialtyView.create();
        customer.setSpecialties(specialties);
        System.out.println(customer);
        customerController.create();
    }

    public void read() {
        System.out.println(READ_CUSTOMER_NAME);
        customerName = InputChecker.readInput();
        customerController.read();
    }

    public static Long customerChangeAccountValue;

    public void update() {
        System.out.println(UPDATE_CUSTOMER_NAME);
        customerName = InputChecker.readInput();
        System.out.println(UPDATE_ACCOUNT_VALUE);
        customerChangeAccountValue = InputChecker.readLongInput();
        customerController.update();
    }

    public void delete() {
        System.out.println(DELETE_CUSTOMER_NAME);
        customerName = InputChecker.readInput();
        //accountController.delete();
        customerController.delete();

    }
}