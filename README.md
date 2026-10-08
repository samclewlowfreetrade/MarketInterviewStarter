# Market Interview: AI-assisted pairing

## Brief

> Our watchlist needs a repository that provides live prices to multiple screens. Build a `WatchlistRepository` that:
>
> 1. Lets multiple consumers observe prices for a set of tickers.
> 2. Uses a single upstream connection to the market data source, regardless of the number of consumers.
> 3. Caches the last known price, so a new consumer receives a value immediately.
> 4. Reconnects automatically when the source drops, with backoff.
> 5. Indicates when a price is stale because the connection is down.
> 6. Exposes this to a ViewModel that drives a simple watchlist UI state. No UI code is needed.
>
> Use any AI tools you normally would. Talk us through how you are directing them and what you are checking in the output. Unit tests for the repository are a bonus, not a requirement.

## Provided scaffold

All in `app/src/main/java/com/example/marketinterview/data/`:

| File | Contents |
| --- | --- |
| `PriceUpdate.kt` | The price update data class |
| `MarketDataSource.kt` | The upstream source interface |
| `FakeMarketDataSource.kt` | Fake source that ticks every 250ms and throws `IOException` after `dropAfter` ticks; exposes `connectionCount` |

`kotlinx-coroutines-test`, Turbine and JUnit 4 are already on the unit test classpath.

## Running

```bash
./gradlew testDebugUnitTest
```
