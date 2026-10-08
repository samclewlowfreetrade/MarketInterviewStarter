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
    fun `emits one update per ticker per tick`() = runTest {
        val source = FakeMarketDataSource()

        val updates = source.connect(setOf("AAPL", "MSFT")).take(4).toList()

        assertEquals(listOf("AAPL", "MSFT", "AAPL", "MSFT"), updates.map { it.ticker })
        assertEquals(1, source.connectionCount)
    }

    @Test(expected = IOException::class)
    fun `throws when the connection drops`() = runTest {
        FakeMarketDataSource(dropAfter = 2).connect(setOf("AAPL")).toList()
    }
}
