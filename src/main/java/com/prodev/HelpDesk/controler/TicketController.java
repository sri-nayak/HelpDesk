package com.prodev.HelpDesk.controler;

import com.prodev.HelpDesk.model.Ticket;
import com.prodev.HelpDesk.repository.TicketRepository;
import com.prodev.HelpDesk.service.impl.JavaMail;
import com.prodev.HelpDesk.service.impl.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/app/ticket")
public class TicketController {
    private TicketServiceImpl ticketServiceImpl;
    @Autowired
    public TicketController(TicketServiceImpl ticketServiceImpl){
        this.ticketServiceImpl=ticketServiceImpl;
    }

    @GetMapping("getAll")
    public List<Ticket> getData(){
        return ticketServiceImpl.getTickets();
    }
    @PostMapping("/raise")
    public Ticket raiseTicket(@RequestBody Ticket ticket){
        Ticket ticket1=null;
        try {
           ticket1= ticketServiceImpl.raiseTicket(ticket);
        }catch (Exception e){
            System.err.println("Error"+e.getMessage());
        }
        return ticket1;
    }
    @DeleteMapping("/delete")
    public Boolean deleteTicket(@RequestParam Integer id){
       return ticketServiceImpl.deleteTicket(id);
    }
}
