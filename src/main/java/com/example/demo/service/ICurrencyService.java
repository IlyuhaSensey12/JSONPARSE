package com.example.demo.service;

import com.example.demo.model.CurrencyEntity;

import java.util.List;

public interface ICurrencyService {
//    void save(Root root);

    Object[] saveAll(List<CurrencyEntity> list);
}
