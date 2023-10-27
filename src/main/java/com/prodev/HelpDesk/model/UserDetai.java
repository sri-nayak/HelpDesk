package com.prodev.HelpDesk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDetai{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    public String name;
    public String email;
    public String password;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "userDetai")
    private List<Ticket> tickets;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "raiesedTo")
    private List<Ticket> ticket;

    public UserDetai(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
