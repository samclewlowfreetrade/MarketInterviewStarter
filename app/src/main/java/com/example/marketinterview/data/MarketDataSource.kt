package com.example.marketinterview.data

import kotlinx.coroutines.flow.Flow

interface MarketDataSource {
    /**
     * Opens a connection and emits updates for the given tickers.
     * Throws IOException when the connection drops.
     */
    fun connect(tickers: Set<String>): Flow<PriceUpdate>
}
