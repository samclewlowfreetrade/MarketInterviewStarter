package com.example.marketinterview.data

import kotlinx.coroutines.flow.Flow

interface MarketDataSource {
    /**
     * Opens a connection and emits updates for all instruments in the market.
     * Throws IOException when the connection drops.
     */
    fun connect(): Flow<PriceUpdate>
}
