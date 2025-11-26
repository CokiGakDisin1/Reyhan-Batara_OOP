package com.Reyhan.frontend.factories;

import com.badlogic.gdx.utils.Array;
import com.Reyhan.frontend.Coin;
import com.Reyhan.frontend.pools.CoinPool;

public class CoinFactory {
    public final CoinPool coinPool;
    private final Array<Coin> activeCoins;

    public CoinFactory() {
        coinPool = new CoinPool();
        activeCoins = new Array<>();
    }

    public Array<Coin> getActiveCoins() {
        return activeCoins;
    }

    public void releaseCoin(Coin coin) {
        activeCoins.removeValue(coin, true);
        coinPool.release(coin);
    }

    public void releaseAll() {
        for (Coin coin : activeCoins) {
            coinPool.release(coin);
        }
        activeCoins.clear();
    }
}
