import service.CustomerList;
import ui.CustomerView;

public class CustomerManager {
    public static void main(String[] args) throws Exception {
        CustomerList customerList = new CustomerList(10);
        CustomerView view = new CustomerView(customerList);
        view.enterMainMenu();
    }
}
