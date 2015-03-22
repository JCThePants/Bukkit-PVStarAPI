/*
 * This file is part of PV-StarAPI for Bukkit, licensed under the MIT License (MIT).
 *
 * Copyright (c) JCThePants (www.jcwhatever.com)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */


package com.jcwhatever.pvs.api.events.players;

import com.jcwhatever.nucleus.mixins.ICancellable;
import com.jcwhatever.pvs.api.arena.Arena;
import com.jcwhatever.pvs.api.arena.ArenaPlayer;
import com.jcwhatever.pvs.api.arena.managers.PlayerManager;

/**
 * Called when the players lives is incremented or decremented.
 */
public class PlayerLivesChangeEvent extends AbstractPlayerEvent implements ICancellable {

    private int _previousLives;
    private int _newLives;
    private boolean _isCancelled;

    /**
     * Constructor.
     *
     * @param arena          The event arena.
     * @param player         The event player.
     * @param previousLives  The number of lives the player had.
     * @param newLives       The number of lives the player will have.
     */
    public PlayerLivesChangeEvent(Arena arena, ArenaPlayer player, PlayerManager relatedManager,
                                  int previousLives, int newLives) {
        super(arena, player, relatedManager);

        _previousLives = previousLives;
        _newLives = newLives;
    }

    /**
     * Get the number of lives the player had before the change.
     */
    public int getPreviousLives() {
        return _previousLives;
    }

    /**
     * Get the number of lives the player will have after the change.
     */
    public int getNewLives() {
        return _newLives;
    }

    /**
     * Set the number of lives the player will have after the change.
     *
     * @param lives  The number of lives.
     */
    public void setNewLives(int lives) {
        _newLives = lives;
    }

    @Override
    public boolean isCancelled() {
        return _isCancelled;
    }

    @Override
    public void setCancelled(boolean isCancelled) {
        _isCancelled = isCancelled;
    }
}
