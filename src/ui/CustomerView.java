package ui;

import bean.Customer;
import service.CustomerList;
import util.CMUtility;

public class CustomerView {

    CustomerList customerList;

    public CustomerView() {

    }

    public CustomerView(CustomerList customerList) {
        this.customerList = customerList;
    }

    public void enterMainMenu() {
        boolean isFlag = true;
        while (isFlag) {
            System.out.println("\n-------------------Customer Info Management-------------------");
            System.out.println("                     1. Add Customer");
            System.out.println("                     2. Modify Customer");
            System.out.println("                     3. Delete Customer");
            System.out.println("                     4. Customer List");
            System.out.println("                     5. Exit\n");
            System.out.println("                     Please choose 1 - 5");

            char menu = CMUtility.readMenuSelection();

            switch (menu) {
                case '1':
                    addNewCustomer();
                    break;

                case '2':
                    modifyCustomer();
                    break;

                case '3':
                    deleteCustomer();
                    ;
                    break;

                case '4':
                    listAllCustomers();
                    ;
                    break;

                case '5':
                    System.out.println("Your sure you want to exit:(Y/N)");
                    char isExit = CMUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        isFlag = false;
                    }
                    break;
            }
        }

    }

    private void addNewCustomer() {
        System.out.println("-----------------------Add Customer---------------------");
        System.out.println("Name: ");
        String name = CMUtility.readString(10);
        System.out.println("Gender(M/F): ");
        char gender = CMUtility.readChar();
        System.out.println("Age: ");
        int age = CMUtility.readInt();
        System.out.println("Phone: ");
        String phone = CMUtility.readString(11);
        System.out.println("Email: ");
        String email = CMUtility.readString(30);

        Customer customer = new Customer(name, gender, age, phone, email);
        boolean isSuccess = this.customerList.addCustomer(customer);
        if (isSuccess) {
            System.out.println("--------------------------Successful---------------------");
        } else {
            System.out.println("-------------------Dictionary Full, Failed------------------");

        }
    }

    private void modifyCustomer() {
        System.out.println("---------------------------Modify Customer------------------------------");
        Customer cust;
        int id;

        for (;;) {
            System.out.println("Please select the id you want to modify(\"-1\" to exit)");
            id = CMUtility.readInt();

            if (id == -1) {
                return;
            }

            cust = customerList.getCustomer(id - 1);
            if (cust == null) {// didn't find
                System.out.println("No such user");
            } else {// found
                break;
            }
        }

        // modify info
        System.out.println("Name(" + cust.getName() + "):");
        String name = CMUtility.readString(10, cust.getName());

        System.out.println("Age(" + cust.getAge() + "):");
        int age = CMUtility.readInt(cust.getAge());

        System.out.println("Gender(" + cust.getGender() + "):");
        char gender = CMUtility.readChar(cust.getGender());

        System.out.println("Phone(" + cust.getPhone() + "):");
        String phone = CMUtility.readString(11, cust.getPhone());

        System.out.println("Email(" + cust.getEmail() + "):");
        String email = CMUtility.readString(30, cust.getEmail());

        Customer newCust = new Customer(name, gender, age, phone, email);

        this.customerList.replaceCustomer(id - 1, newCust);
    }

    private void deleteCustomer() {
        System.out.println("Deleting");
    }

    private void listAllCustomers() {
        System.out.println("----------------------Customer List-----------------------");
        int total = customerList.getTotal();
        if (total == 0) {
            System.out.println("No customer found!");
        } else {
            System.out.println("ID \tName \tGender \tAge \tPhone \tEmail");
            Customer[] custs = customerList.getAllCustomers();
            for (int index = 0; index < custs.length; index++) {
                Customer cust = custs[index];
                System.out.println((index + 1) + "\t" + cust.getName() + "\t" + cust.getGender() + "\t" + cust.getAge()
                        + "\t" + cust.getPhone() + "\t" + cust.getEmail());
            }
        }

        System.out.println("---------------------Loaded Complete-----------------------");
    }

}