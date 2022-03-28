package com.microservice2.cammelservice.port;

import com.microservice2.cammelservice.model.Currency;

public interface CurrencyExchange {
    Currency operation(Currency currency);
}
