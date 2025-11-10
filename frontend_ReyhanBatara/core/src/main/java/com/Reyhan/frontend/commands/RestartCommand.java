package com.Reyhan.frontend.commands;

import com.Reyhan.frontend.Player;

public class RestartCommand implements Command{
    private Player player;

    public RestartCommand(Player player) {
        this.player = player;
    }

    @Override
    if (!player.isDead()) {
        player.fly();
    }
}

