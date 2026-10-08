package com.example.marketinterview.data

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import java.math.BigDecimal
import java.time.Instant
import java.util.Currency
import kotlin.random.Random

class FakeMarketDataSource(
    private val dropAfter: Int = 20
) : MarketDataSource {

    private val tickers = listOf("AAPL", "MSFT", "TSLA", "VOD", "BARC", "SAP")

    var connectionCount = 0
        private set

    override fun connect(): Flow<PriceUpdate> = flow {
        connectionCount++
        var emitted = 0
        while (true) {
            delay(250)
            tickers.forEach { ticker ->
                emit(
                    PriceUpdate(
                        ticker = ticker,
                        price = BigDecimal(100 + Random.nextInt(-5, 5)),
                        currency = Currency.getInstance("USD"),
                        timestamp = Instant.now()
                    )
                )
            }
            if (++emitted >= dropAfter) throw IOException("Connection dropped")
        }
    }
}
