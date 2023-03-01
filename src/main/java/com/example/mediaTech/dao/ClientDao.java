package com.example.mediaTech.dao;

import com.example.mediaTech.models.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDao extends JpaRepository<ClientEntity,Integer> {
    ClientEntity findByFirstName(String firstName);
}
