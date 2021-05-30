package net.springboot.ipotrading.repository;

import net.springboot.ipotrading.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("transactionRepository")

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUserName(String userName);

}
