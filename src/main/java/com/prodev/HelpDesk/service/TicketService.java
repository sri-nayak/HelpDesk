package com.prodev.HelpDesk.service;


import com.prodev.HelpDesk.controler.TicketController;
import com.prodev.HelpDesk.model.Ticket;

import java.util.List;

public interface TicketService {
   List<Ticket> getTickets();
   Ticket raiseTicket(Ticket ticket);
   Ticket resolveTicket(Ticket ticket);
   String rejectTicket(Ticket ticket);
   Boolean deleteTicket(Integer id);
}
