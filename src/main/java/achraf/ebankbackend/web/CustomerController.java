package achraf.ebankbackend.web;

import achraf.ebankbackend.dtos.CustomerDTO;
import achraf.ebankbackend.entities.Customer;
import achraf.ebankbackend.services.BankAccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class CustomerController {
    private BankAccountService bankAccountService;

    @GetMapping("/customers")
    private List<CustomerDTO> customers(){
        return bankAccountService.listCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public CustomerDTO getCustomer(@PathVariable(name = "customerId") Long customerId){
        return bankAccountService.getCustomer(customerId);
    }

    @PostMapping("/customers")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customer){
        return bankAccountService.saveCustomer(customer);
    }

    @PutMapping("/customers/{customerId}")
    public CustomerDTO updateCustomer(@PathVariable(name = "customerId") Long customerId, @RequestBody CustomerDTO customer){
        customer.setId(customerId);
        return bankAccountService.updateCustomer(customer);
    }

    @DeleteMapping("/customers/{customerId}")
    public void deleteCustomer(@PathVariable(name = "customerId") Long customerId){
        bankAccountService.deleteCustomer(customerId);
    }
}
