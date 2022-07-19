package petshop.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import petshop.domain.*;

@RestController
@RequestMapping(value = "/customers")
@Transactional
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping(
        value = "/{id}/createAccount3",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Customer createAccount(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /customer/createAccount  called #####");
        Optional<Customer> optionalCustomer = customerRepository.findById(id);

        optionalCustomer.orElseThrow(() -> new Exception("No Entity Found"));
        Customer customer = optionalCustomer.get();
        customer.createAccount();

        customerRepository.save(customer);
        return customer;
    }
    // keep
}
