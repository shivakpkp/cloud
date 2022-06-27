package com.example.currencyconversionservice.controller;

import com.example.currencyconversionservice.inter.CurrencyExchangeServiceProxy;
import com.example.currencyconversionservice.model.CurrencyConversionBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
public class ConversionController {

    CurrencyExchangeServiceProxy proxy;

    @Autowired
    public ConversionController(CurrencyExchangeServiceProxy proxy) {
        this.proxy = proxy;
    }

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean conversion(@PathVariable String from,
                                             @PathVariable String to,
                                             @PathVariable Long quantity){
        Map<String,String> variable=new HashMap<>();
        variable.put("from",from);
        variable.put("to",to);
        CurrencyConversionBean currencyConversionBean = new RestTemplate().getForObject("http://localhost:8001/exchange/from/{from}/to/{to}", CurrencyConversionBean.class, variable);
        currencyConversionBean.setTotalAmount(quantity*currencyConversionBean.getConversionMultiple());
        return currencyConversionBean;
    }

    @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean conversionFeign(@PathVariable String from,
                                                  @PathVariable String to,
                                                  @PathVariable Long quantity){
        System.out.println("In feign");
        CurrencyConversionBean currency = proxy.convert(from, to);
        currency.setTotalAmount(currency.getConversionMultiple()*quantity);
        return currency;
    }
}
