package com.example.demo.controller;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.CurrencyEntity;
import com.example.demo.model.Root;
import com.example.demo.model.Value;
import com.example.demo.service.ICurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SampleRestClient {

    @Autowired
    private ICurrencyService iCurrencyService;

    @GetMapping("/test")
    public Object[] test() {

        String url = "https://api.exchangerate-api.com/v4/latest/USD";

        RestTemplate template = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        HttpEntity requestEntity = new HttpEntity<>(headers);

//        Map<String, String> uriVariables = new HashMap<>();

//        uriVariables.put("urlParameter", "myURLParameter");
//        uriVariables.put("queryParameter", "myQueryParameter");


        ResponseEntity<Root> response = template.exchange(url, HttpMethod.GET, requestEntity, Root.class);
        Root root = response.getBody();
        String currency = root.base;
        List<CurrencyEntity> list = new ArrayList<>();
        CurrencyEntity entity = new CurrencyEntity();
        entity.setCurrency(currency);
        entity.setDateTime(root.date);
        entity.setClose(root.rates.kZT);
        list.add(entity);

        return iCurrencyService.saveAll(list);

    }

}
