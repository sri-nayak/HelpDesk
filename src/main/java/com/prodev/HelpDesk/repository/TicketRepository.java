package com.prodev.HelpDesk.repository;

import com.prodev.HelpDesk.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Integer> {
}
