package net.springboot.ipotrading.repository;


import net.springboot.ipotrading.model.FinancialProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository("financialProductRepository")
public interface FinancialProductRepository extends JpaRepository<FinancialProduct, Long> {
}
