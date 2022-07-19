package petshop.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import org.springframework.beans.BeanUtils;
import java.util.List;


import petshop.command.*;
import petshop.event.*;

@Aggregate
public class PetAggregate {

    @AggregateIdentifier
    private Long id;
    private String name;
    private int appearance;
    private int energy;
    private Address address;

    private PetAggregate(){}

    @CommandHandler
    public void handle(FeedCommand command){
        // TODO send Event
        // AggregateLifecycle.apply( Event );

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        .external.Item item = new .external.Item();
        // mappings goes here
        PetApplication.applicationContext.getBean(.external.ItemService.class)
        .feed(item);

        }
    @CommandHandler
    public void handle(RegisterCommand command){
        // TODO send Event
        // AggregateLifecycle.apply( Event );

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        .external.Item item = new .external.Item();
        // mappings goes here
        PetApplication.applicationContext.getBean(.external.ItemService.class)
        .register(item);

        }


    @EventSourcingHandler
    public void on(PetRegisteredEvent event) {
        BeanUtils.copyProperties(event, this);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getAppearance() {
        return appearance;
    }

    public void setAppearance(int appearance) {
        this.appearance = appearance;
    }
    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


}
