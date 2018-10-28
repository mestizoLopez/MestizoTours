package com.mestizo.repository;

import com.mestizo.model.Travels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelsRepository extends JpaRepository<Travels,Integer> {
}
