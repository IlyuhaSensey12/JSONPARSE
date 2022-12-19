package com.example.demo.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "currency")
public class CurrencyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String currency;
    private String dateTime;
    private double close;

}
