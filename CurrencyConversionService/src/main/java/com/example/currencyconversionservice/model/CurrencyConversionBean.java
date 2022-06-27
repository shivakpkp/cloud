package com.example.currencyconversionservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CurrencyConversionBean {

    private Long id;
    private String from;
    private String to;
    private Long conversionMultiple;
    private Long totalAmount;
    private Long port;




}
