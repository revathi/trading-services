package net.springboot.ipotrading.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.springboot.ipotrading.model.User;
import org.springframework.stereotype.Repository;

@Repository("userRepository")

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
    User findByEmail(String email);
}


