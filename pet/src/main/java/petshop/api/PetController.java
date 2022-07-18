package petshop.api;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import petshop.aggregate.*;
import petshop.command.*;

@RestController
public class PetController {

    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;

    public PetController(
        CommandGateway commandGateway,
        QueryGateway queryGateway
    ) {
        this.commandGateway = commandGateway;
        this.queryGateway = queryGateway;
    }

    @RequestMapping(
        value = "/feed",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public void feed(@RequestBody ItemAggregate item) throws Exception {
        System.out.println("##### /item/feed  called #####");
    }

    @RequestMapping(
        value = "/item/register",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public void register(@RequestBody ItemAggregate item) throws Exception {
        System.out.println("##### /item/register  called #####");
        // make command
        RegisterCommand register = new RegisterCommand();
        // TODO set attribute
        // send command
        commandGateway.send(register);
    }
}
