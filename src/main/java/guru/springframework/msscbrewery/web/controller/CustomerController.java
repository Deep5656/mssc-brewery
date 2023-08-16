package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.services.CustomerService;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //GetMapping
    @GetMapping("/{cId}")
    public ResponseEntity<CustomerDto>getCustomer(@PathVariable("cId") UUID cId){
        return new ResponseEntity<>(customerService.getCustomerById(cId), HttpStatus.OK);
    }

    //PostMapping
    @PostMapping
    public  ResponseEntity handlePost(@RequestBody CustomerDto customerDto){
        CustomerDto savedCustomer = customerService.saveNewCustomer(customerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("location","/api/v1/customer"+savedCustomer.getId().toString());
        return new ResponseEntity(headers,HttpStatus.CREATED);
    }

    //PutMapping
    public ResponseEntity handleUpdate(@PathVariable("cId") UUID cId,@RequestBody CustomerDto customerDto){
        customerService.updateCustomer(cId,customerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    //DeleteMapping
    @DeleteMapping("{cId}")
    public void deleteCustomer(@PathVariable("cId")UUID cId){
        customerService.deleteById(cId);
    }


}
