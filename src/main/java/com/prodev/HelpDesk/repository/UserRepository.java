package com.prodev.HelpDesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import com.prodev.HelpDesk.model.UserDetai;


@Repository
public interface UserRepository extends JpaRepository<UserDetai,Integer> {
}
