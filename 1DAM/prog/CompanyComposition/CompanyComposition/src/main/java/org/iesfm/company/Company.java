package org.iesfm.company;

import org.iesfm.company.exceptions.CustomerNotFoundException;
import org.iesfm.company.exceptions.OrderNotFoundException;

import java.util.*;

public class Company {

    private String companyName;
    private String cif;
    private Map<String, Customer> customers;

    public Company(String companyName, String cif, Map<String, Customer> customers) {
        this.companyName = companyName;
        this.cif = cif;
        this.customers = customers;
    }

    public Set<Order> getCustomerOrders(String id) throws CustomerNotFoundException {
        if (!customers.containsKey(id)) {
            throw new CustomerNotFoundException(id);
        }
        return customers.get(id).getOrders();
    }

    public int getOrderPrice(String id, int orderNumber) throws CustomerNotFoundException, OrderNotFoundException {
        Set<Order> orders = getCustomerOrders(id);

        Order customerOrder = null;

        for (Order order : orders) {
            if (order.getOrderNumber() == orderNumber) {
                customerOrder = order;
            }
        }
        if (customerOrder == null) {
            throw new OrderNotFoundException(orderNumber);
        }
        return customerOrder.price();
    }

    public Set<String> getProducts(String id) throws CustomerNotFoundException {
        Set<String> products = new HashSet<>();
        Set<Order> orders = getCustomerOrders(id);
        for (Order order : orders) {
            Set<String> orderProducts = order.getProductsName();
            products.addAll(orderProducts);
        }
        return products;
    }

    public int getPriceAllOrders(String id) throws CustomerNotFoundException {
        int price = 0;

        Set<Order> orders = getCustomerOrders(id);

        for (Order order : orders) {
            int priceOrder = order.price();
            price = price + priceOrder;
        }
        return price;
    }

    public int getProductAmount(String id, String productName) throws CustomerNotFoundException {
        Set<Order> orders = getCustomerOrders(id);
        int amount = 0;
        for (Order order : orders) {
            int ordersAmount = order.getAmount(productName);
            amount = amount + ordersAmount;
        }
        return amount;
    }

    public Set<String> getIdCostumer(String productName) {
        Set<String> customerId = new HashSet<>();
        for (Customer customer : customers.values()) {
            if (customer.hasBoughtProduct(productName)) {
                customerId.add(customer.getId());
            }
        }
        return customerId;
    }

    public int getOrdersAmountByCustomer(String id) throws CustomerNotFoundException {

        //return getCustomerOrders(id).size();

        if(customers.containsKey(id)) {
            Customer customer = customers.get(id);

            return customer.getOrders().size();
        } else {
            throw new CustomerNotFoundException(id);
        }
    }

    public Set<String> getClientsNoOrdered() {
        Set<String> noOrderClientsId = new HashSet<>();
        for(Customer customer : customers.values()) {
            if(customer.getOrders().isEmpty()) {
                noOrderClientsId.add(customer.getId());
            }
        }
        return noOrderClientsId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public Map<String, Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Map<String, Customer> customers) {
        this.customers = customers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(companyName, company.companyName) && Objects.equals(cif, company.cif) && Objects.equals(customers, company.customers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyName, cif, customers);
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + companyName + '\'' +
                ", cif='" + cif + '\'' +
                ", customers=" + customers +
                '}';
    }
}
