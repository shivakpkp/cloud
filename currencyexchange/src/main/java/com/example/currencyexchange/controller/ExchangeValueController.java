package com.example.currencyexchange.controller;


import com.example.currencyexchange.model.ExchangeValue;
import com.example.currencyexchange.repository.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ExchangeValueController {

    @Autowired
    ExchangeValueRepository exchangeValueRep;

    @Autowired
    Environment environment;

    @GetMapping("/exchange/from/{from}/to/{to}")
    public ExchangeValue convert(@PathVariable(name = "from") String from,@PathVariable(name = "to") String to){

        ExchangeValue exchangeValue=exchangeValueRep.findByFromAndTo(from,to);
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return exchangeValue;
    }


}
