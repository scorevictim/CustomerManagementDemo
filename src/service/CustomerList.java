package service;

import bean.Customer;

public class CustomerList {
    private Customer[] customers;
    private int total = 0;

    /**
     * Constructor to init CustomerList.
     * 
     * @param totalCustomer set max numbers of list
     */
    public CustomerList(int totalCustomer) {
        
        this.customers = new Customer[totalCustomer];
        // init a customer
        Customer customer = new Customer("Tom", 'M', 12, "4088886768", "a@a.c");
        this.addCustomer(customer);
    }

    /**
     * Add specific customer to array
     * 
     * @param customer
     * @return true when successful; false when unsuccessful
     */
    public boolean addCustomer(Customer customer) {
        if (total >= customers.length) {
            return false;
        } else {
            this.customers[total] = customer;
            this.total++;
            return true;
        }
    }

    /**
     * This method modify specific customer info based on index
     * 
     * @param index
     * @param cust
     * @return true when successful; false when unsuccessful
     */
    public boolean replaceCustomer(int index, Customer cust) {
        if (index < 0 || index >= total) {
            return false;
        } else {
            this.customers[index] = cust;
            return true;
        }
    }

    /**
     * This method delete specific customer info based on index
     * 
     * @param index
     * @return true when successful; false when unsuccessful
     */
    public boolean deleteCustomer(int index) {
        if (index < 0 || index >= total) {
            return false;
        } else {
            for (int i = index; i < total - 1; i++) {
                this.customers[i] = this.customers[i + 1];
            }

            // set final data to null
            this.customers[total - 1] = null;
            this.total--;
            return true;
        }
    }

    /**
     * Get all customers info
     * @return
     */
    public Customer[] getAllCustomers() {
        Customer[] custs = new Customer[total];
        for (int i = 0; i < total; i++) {
            custs[i] = customers[i];
        }
        return custs;
    }

    /**
     * Get customer info based on index
     * @param index
     * @return if found, then return it; if not found, then return null
     */
    public Customer getCustomer(int index) {
        if (index < 0 || index >= total) {
            return null;
        }
        return customers[index];
    }

    /**
     * Get total number of customers
     * @return
     */
    public int getTotal() {
        return total;
    }
}
