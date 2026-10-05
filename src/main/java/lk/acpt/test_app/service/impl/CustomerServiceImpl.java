package lk.acpt.test_app.service.impl;

import lk.acpt.test_app.dto.CustomerDto;
import lk.acpt.test_app.entity.Customer;
import lk.acpt.test_app.repo.CustomerRepo;
import lk.acpt.test_app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        Customer save = customerRepo.save(new Customer(customerDto.getId(), customerDto.getName(), customerDto.getAddress(), customerDto.getSalary()));
        return new CustomerDto(save.getId(), save.getName(), save.getAddress(), save.getSalary());
    }

    @Override
    public CustomerDto deleteCustomer(int id) {
        Optional<Customer> byId = customerRepo.findById(id);

        if (byId.isPresent()) {
            customerRepo.deleteById(id);
            Customer customer = byId.get();
            return new CustomerDto(customer.getId(), customer.getName(), customer.getAddress(), customer.getSalary());
        }
        return null;
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto) {
        Optional<Customer> byId = customerRepo.findById(customerDto.getId());

        if (byId.isPresent()) {
            Customer customer = byId.get();
            customer.setName(customerDto.getName());
            customer.setAddress(customerDto.getAddress());
            customer.setSalary(customerDto.getSalary());

            Customer save = customerRepo.save(customer);

            return new CustomerDto(save.getId(), save.getName(), save.getAddress(), save.getSalary());
        }
        return null;
    }

    @Override
    public List<CustomerDto> getAllCustomer() {
        List<Customer> all = customerRepo.findAll();
        List<CustomerDto> customerDtos = new ArrayList<>();

        for (Customer customer : all) {
            customerDtos.add(new CustomerDto(customer.getId(), customer.getName(), customer.getAddress(), customer.getSalary()));
        }
        return customerDtos;
    }

    @Override
    public CustomerDto getCustomerById(int id) {
        Optional<Customer> byId = customerRepo.findById(id);

        if (byId.isPresent()) {
            Customer customer = byId.get();
            return new CustomerDto(customer.getId(), customer.getName(), customer.getAddress(), customer.getSalary());
        }
        return null;
    }
}
