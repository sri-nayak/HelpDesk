package com.prodev.HelpDesk.service.impl;

import com.prodev.HelpDesk.model.Ticket;
import com.prodev.HelpDesk.repository.TicketRepository;
import com.prodev.HelpDesk.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

public class TicketServiceImpl implements TicketService {
    private TicketRepository ticketRepository;
    private JavaMail javaMail;
    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository,JavaMail javaMail){
        this.ticketRepository=ticketRepository;
        this.javaMail=javaMail;
    }

    public List<Ticket> getTickets(){
       return ticketRepository.findAll().stream().toList();
    }
    @Override
    public Ticket raiseTicket(Ticket ticket) {
        Ticket ticket1=ticketRepository.save(ticket);
        javaMail.sendMail();
        return ticket1;
    }

    @Override
    public Ticket resolveTicket(Ticket ticket) {
        return null;
    }

    @Override
    public String rejectTicket(Ticket ticket) {
        return null;
    }

    @Override
    public Boolean deleteTicket(Integer id) {
        try{
            ticketRepository.delete(
                    ticketRepository.findAllById(Collections.singleton(id)).get(0));
        }catch (Exception e){
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

}
