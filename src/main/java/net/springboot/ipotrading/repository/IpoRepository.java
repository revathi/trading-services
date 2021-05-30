package net.springboot.ipotrading.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import net.springboot.ipotrading.model.Ipo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ipoRepository")

public interface IpoRepository extends JpaRepository<Ipo, Long> {

    List<Ipo> findByUserName(String userName);

}
