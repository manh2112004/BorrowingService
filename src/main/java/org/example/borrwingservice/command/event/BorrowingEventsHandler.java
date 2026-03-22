package org.example.borrwingservice.command.event;

import org.axonframework.eventhandling.EventHandler;
import org.example.borrwingservice.command.data.Borrowing;
import org.example.borrwingservice.command.data.BorrowingRepository;
import org.example.borrwingservice.command.model.BorrowingCreateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BorrowingEventsHandler {
    @Autowired
    private BorrowingRepository borrowingRepository;

    @EventHandler
    public void on(BorrowingCreateEvent event){
        Borrowing model=new Borrowing();
        model.setId(event.getId());
        model.setBookId(event.getBookId());
        model.setEmployeeId(event.getEmployeeId());
        model.setReturnDate(event.getBorrowingDate());
        borrowingRepository.save(model);
    }

}
