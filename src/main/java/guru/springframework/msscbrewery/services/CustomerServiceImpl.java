package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID cId) {
        return CustomerDto.builder().id(UUID.randomUUID())
                .name("Aman").build();
    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        return CustomerDto.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void updateCustomer(UUID cId, CustomerDto customerDto) {
        //todo complete this..
    }

    @Override
    public void deleteById(UUID cId) {
        log.debug("Deleting Customer ................");
    }
}
