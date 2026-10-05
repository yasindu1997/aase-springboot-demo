package lk.acpt.test_app.controller;

import jakarta.persistence.GeneratedValue;
import lk.acpt.test_app.dto.CustomerDto;
import lk.acpt.test_app.service.CustomerService;
import lk.acpt.test_app.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerDto> saveCustomer(@RequestBody CustomerDto customerDto){
        CustomerDto resCustomer = customerService.saveCustomer(customerDto);
        return new ResponseEntity<>(resCustomer, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerDto> deleteCustomer(@PathVariable Integer id){
        CustomerDto customerDto = customerService.deleteCustomer(id);
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable Integer id, @RequestBody CustomerDto customerDto){
        customerDto.setId(id);
        CustomerDto resCustomer = customerService.updateCustomer(customerDto);
        return new ResponseEntity<>(resCustomer, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomer(){
        List<CustomerDto> allCustomer = customerService.getAllCustomer();
        return new ResponseEntity<>(allCustomer, HttpStatus.OK);
    }

    @GetMapping("/get_customer_by_id/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Integer id){
        CustomerDto customerById = customerService.getCustomerById(id);
        return new ResponseEntity<>(customerById, HttpStatus.OK);
    }

}
