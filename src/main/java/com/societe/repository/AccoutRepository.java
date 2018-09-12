package com.societe.repository;

import com.societe.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for accounts
 */
@Repository
public interface AccoutRepository extends JpaRepository<Account, Long> {


}
