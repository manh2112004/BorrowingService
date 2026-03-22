package org.example.borrwingservice.command.aggregate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.example.borrwingservice.command.command.CreateBorrowingCommand;
import org.example.borrwingservice.command.event.BorrowingCreateEvent;
import org.springframework.beans.BeanUtils;

import java.util.Date;
@Data
@Aggregate
public class BorrowingAggregate {
    @AggregateIdentifier
    private String id;

    private String bookId;
    private String employeeId;
    private Date borrowingDate;
    private Date returnDate;
    public BorrowingAggregate(){}

    @CommandHandler
    public BorrowingAggregate(CreateBorrowingCommand command){
        BorrowingCreateEvent event=new BorrowingCreateEvent();
        BeanUtils.copyProperties(command,event);
        AggregateLifecycle.apply(event);
    }
    @EventSourcingHandler
    public void on(BorrowingCreateEvent event){
        this.id=event.getId();
        this.bookId=event.getBookId();
        this.employeeId=event.getEmployeeId();
        this.borrowingDate=event.getBorrowingDate();
    }
}
