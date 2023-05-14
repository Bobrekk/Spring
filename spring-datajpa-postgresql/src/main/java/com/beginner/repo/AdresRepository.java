package com.beginner.repo;

import com.beginner.entity.Adres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdresRepository extends JpaRepository<Adres, Long> {

}
