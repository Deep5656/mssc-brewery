package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {

    CustomerDto getCustomerById(UUID cId);
    CustomerDto saveNewCustomer(CustomerDto customerDto);
    void updateCustomer(UUID cId, CustomerDto customerDto);
    void deleteById(UUID cId);
}
