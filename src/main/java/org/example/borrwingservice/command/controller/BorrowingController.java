package org.example.borrwingservice.command.controller;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.example.borrwingservice.command.command.CreateBorrowingCommand;
import org.example.borrwingservice.command.model.BorrowingCreateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/borrowing")
public class BorrowingController {
    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String createBorrowing(@RequestBody BorrowingCreateModel req){
        CreateBorrowingCommand command= new CreateBorrowingCommand(UUID.randomUUID().toString(),req.getBookId(),req.getEmployeeId(),new Date());
        return commandGateway.sendAndWait(command);
    }
}
