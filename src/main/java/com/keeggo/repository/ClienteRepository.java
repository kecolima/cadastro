package com.keeggo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keeggo.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}