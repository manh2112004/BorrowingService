package org.example.borrwingservice.command.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowingCreateEvent {
    private String id;
    private String bookId;
    private String employeeId;
    private Date borrowingDate;
}
