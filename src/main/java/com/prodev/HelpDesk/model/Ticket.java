package com.prodev.HelpDesk.model;

import com.google.firebase.database.annotations.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.ToString;
import org.checkerframework.common.aliasing.qual.Unique;
import org.springframework.context.annotation.Primary;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ticket_table")
@ToString
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ticketid")
    @NotNull
    @Unique
    private Integer ticketId;
    @Column(name = "title")
    public String ttle;
    public String text;
    public String status;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "raisedTO")
    private UserDetai userDetai;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "raisedBy" )
    private UserDetai raiesedTo;
}
