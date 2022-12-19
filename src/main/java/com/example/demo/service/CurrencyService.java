package com.example.demo.service;

import com.example.demo.model.CurrencyEntity;
import com.example.demo.model.Root;
import com.example.demo.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CurrencyService implements ICurrencyService {
    @Autowired
    public Repo repo;
    @Override
    public void mapToCurrencyEntity(Root root) {
        CurrencyEntity currencyEntity = new CurrencyEntity();
        currencyEntity.setCurrency(root.base);
        currencyEntity.setDateTime(root.date);
        currencyEntity.setClose(root.rates.kZT);
        repo.save(currencyEntity);
    }

    @Override
    public void saveAll(List<Root> list) {
        List<CurrencyEntity> list1 = new ArrayList<>();

        list1.stream().map(this::mapToCurrencyEntity).collect(Collectors.toSet());
    }
}
