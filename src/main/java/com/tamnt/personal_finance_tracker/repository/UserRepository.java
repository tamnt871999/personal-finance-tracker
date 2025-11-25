package com.tamnt.personal_finance_tracker.repository;

import com.tamnt.personal_finance_tracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);

    boolean existsByEmail(String email);
}
