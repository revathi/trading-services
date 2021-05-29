package net.springboot.ipotrading.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import net.springboot.ipotrading.model.Ipo;
import org.springframework.stereotype.Repository;

@Repository("ipoRepository")

public interface IpoRepository extends JpaRepository<Ipo, Long> {

}
