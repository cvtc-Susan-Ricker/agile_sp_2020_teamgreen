package edu.cvtc.agile2020.greentime.financetracker.financetracker.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
