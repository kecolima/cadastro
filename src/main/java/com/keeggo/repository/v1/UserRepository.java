package com.keeggo.repository.v1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keeggo.model.v1.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
