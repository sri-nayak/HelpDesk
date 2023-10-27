package com.prodev.HelpDesk.payload;

import com.prodev.HelpDesk.model.Ticket;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class TicketReg {
    public String Sourcemail;
    public Ticket ticket;
}
