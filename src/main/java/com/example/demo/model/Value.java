package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

public class Value {
    public Date datetime;
    @JsonProperty("open")
    public String myopen;
    public String high;
    public String low;
    public BigDecimal close;
    public String volume;
}
