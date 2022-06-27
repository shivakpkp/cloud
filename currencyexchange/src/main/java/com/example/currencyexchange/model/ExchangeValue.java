package com.example.currencyexchange.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class ExchangeValue {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "exchangeFrom")
    private String from;
    @Column(name = "exchangeTo")
    private String to;
    private Long conversionMultiple;
    private int port;


    public ExchangeValue(Long id, String from, String to, Long conversionMultiple) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
    }
}
