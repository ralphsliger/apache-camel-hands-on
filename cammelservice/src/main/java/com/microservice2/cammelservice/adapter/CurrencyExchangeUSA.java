package com.microservice2.cammelservice.adapter;

import com.microservice2.cammelservice.model.Currency;
import com.microservice2.cammelservice.port.CurrencyExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Qualifier("usa")
public class CurrencyExchangeUSA implements CurrencyExchange {

    @Override
    public Currency operation(Currency currency) {
        currency.setExchange(currency.getExchange().multiply(BigDecimal.TEN));
        return currency;
    }
}
