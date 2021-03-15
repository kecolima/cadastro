package com.keeggo.repository.v1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keeggo.model.v1.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
