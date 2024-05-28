package com.tlh.xmlservice.services

data class Currency(
    var currencyName: String,
    var forexBuying: Double,
    var forexSelling: Double,
    var crossRateUSD: Double
)