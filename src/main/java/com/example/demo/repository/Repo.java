package com.example.demo.repository;

import com.example.demo.model.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo extends JpaRepository<CurrencyEntity, Long> {

}
