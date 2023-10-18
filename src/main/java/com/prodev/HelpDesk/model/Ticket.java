package com.prodev.HelpDesk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "title")
    public String ttle;
    public String text;
    public String status;
    @ManyToOne(cascade = CascadeType.ALL)
    private UserDetai userDetai;
}
