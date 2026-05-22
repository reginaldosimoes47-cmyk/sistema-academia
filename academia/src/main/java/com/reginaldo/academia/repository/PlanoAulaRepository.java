package com.reginaldo.academia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.reginaldo.academia.model.PlanoAula;

@Repository
public interface PlanoAulaRepository extends JpaRepository<PlanoAula, Long> {
}