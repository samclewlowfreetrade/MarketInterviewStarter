package com.example.marketinterview.data

import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.IOException

/** Sanity check that the test setup works. */
class FakeMarketDataSourceTest {

    @Test
    fun `emits one update per instrument per tick`() = runTest {
        val source = FakeMarketDataSource()

        val updates = source.connect().take(6).toList()

        assertEquals(listOf("AAPL", "MSFT", "TSLA", "VOD", "BARC", "SAP"), updates.map { it.ticker })
        assertEquals(1, source.connectionCount)
    }

    @Test(expected = IOException::class)
    fun `throws when the connection drops`() = runTest {
        FakeMarketDataSource(dropAfter = 2).connect().toList()
    }
}
