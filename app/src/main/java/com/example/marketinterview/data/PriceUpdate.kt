package com.example.marketinterview.data

import java.math.BigDecimal
import java.time.Instant
import java.util.Currency

data class PriceUpdate(
    val ticker: String,
    val price: BigDecimal,
    val currency: Currency,
    val timestamp: Instant
)
