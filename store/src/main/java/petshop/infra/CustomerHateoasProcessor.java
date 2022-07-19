package petshop.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import petshop.domain.*;

@Component
public class CustomerHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Customer>> {

    @Override
    public EntityModel<Customer> process(EntityModel<Customer> model) {
<<<<<<< HEAD
=======
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/createAccount2")
                .withRel("createAccount2")
        );

>>>>>>> f17a1f0 (commit msg)
        return model;
    }
}
