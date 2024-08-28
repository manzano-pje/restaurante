package com.restaurante.repositories;

import com.restaurante.entities.Groups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Groups, Long> {

    Optional<Groups> findByName(String name);
}
