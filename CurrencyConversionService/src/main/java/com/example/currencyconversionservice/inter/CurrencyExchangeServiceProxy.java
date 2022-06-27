package com.example.currencyconversionservice.inter;

import com.example.currencyconversionservice.model.CurrencyConversionBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "currency-exchange-service")
//@RibbonClient(name = "currency-exchange-service",configuration = RibbonConfig.class)
public interface CurrencyExchangeServiceProxy {


    @GetMapping("/exchange/from/{from}/to/{to}")
    public CurrencyConversionBean convert(@PathVariable(name = "from")  String from, @PathVariable(name = "to") String to);

}
