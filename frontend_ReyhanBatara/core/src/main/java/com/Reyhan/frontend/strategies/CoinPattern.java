package com.Reyhan.frontend.strategies;

import com.Reyhan.frontend.Coin;
import com.Reyhan.frontend.factories.CoinFactory;
import java.util.List;

public interface CoinPattern {
    List<Coin> spawn(CoinFactory factory, float groundTopY, float spawnX, float screenHeight);
    String getName();
}
