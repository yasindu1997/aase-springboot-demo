package lk.acpt.test_app.service;

import lk.acpt.test_app.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    CustomerDto saveCustomer(CustomerDto customerDto);
    CustomerDto deleteCustomer(int id);
    CustomerDto updateCustomer(CustomerDto customerDto);
    List<CustomerDto> getAllCustomer();
    CustomerDto getCustomerById(int id);
}
