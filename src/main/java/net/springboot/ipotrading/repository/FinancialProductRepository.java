package net.springboot.ipotrading.repository;


import net.springboot.ipotrading.model.FinancialProduct;
import net.springboot.ipotrading.model.Ipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("financialProductRepository")

public interface FinancialProductRepository extends JpaRepository<FinancialProduct, Long> {


}
