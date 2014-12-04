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


package com.jcwhatever.bukkit.pvs.api.arena;

import com.jcwhatever.bukkit.generic.utils.text.TextColor;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import javax.annotation.Nullable;

public enum ArenaTeam {
    
    NONE    (-1, TextColor.WHITE,        "None"),
    GOLD    ( 1, TextColor.GOLD,         "Gold Team"),

    SKY     ( 3, TextColor.BLUE,         "Blue Team"),
    YELLOW  ( 4, TextColor.YELLOW,       "Yellow Team"),
    EMERALD ( 5, TextColor.GREEN,        "Green Team"),
    PINK    ( 6, TextColor.LIGHT_PURPLE, "Pink Team"),
    DARK    ( 7, TextColor.DARK_GRAY,    "Dark Team"),
    GRAY    ( 8, TextColor.GRAY,         "Gray Team"),
    AQUA    ( 9, TextColor.AQUA,         "Aqua Team"),
    PURPLE  (10, TextColor.DARK_PURPLE,  "Purple Team"),
    BLUE    (11, TextColor.DARK_BLUE,    "Blue Team"),
    GREEN   (13, TextColor.DARK_GREEN,   "Green Team"),
    //TEAL (4, TextColor.DARK_AQUA, "Teal Team"),

    RED     (14, TextColor.RED,          "Red Team"),
    BLACK   (15, TextColor.BLACK,        "Black Team")

    ;

    private final int _teamId;
    private final TextColor _color;
    private final String _display;

    ArenaTeam (int teamId, TextColor color, String display) {
        _teamId = teamId;
        _color = color;
        _display = (color != null ? color : "") + display;
    }

    /**
     * Get the color used to represent the team in chat.
     */
    public TextColor getTextColor() {
        return _color;
    }

    /**
     * Get the display name of the team
     */
    public String getDisplay() {
        return _display;
    }

    /**
     * Get the block material used to represent the team.
     * @return {@code MaterialData} object.
     */
    public MaterialData getTeamBlock() {
        if (_teamId >= 0 && _teamId <= 15)
            return getWoolData(_teamId);

        return new MaterialData(Material.WOOD);
    }

    /*
     * Get wool material using color code
     */
    private MaterialData getWoolData(int color) {
        ItemStack stack = new ItemStack(Material.WOOL);
        stack.setDurability((short)color);
        return stack.getData();
    }

    /**
     * Team distribution helper
     *
     * @author JC The Pants
     *
     */
    public static class TeamDistributor {

        PriorityQueue<Team> _teams = new PriorityQueue<Team>(20);
        List<ArenaTeam> _cache = new ArrayList<ArenaTeam>(20);

        /**
         * Constructor
         * @param teams  {@code ArenaTeam} parameters as available teams.
         */
        public TeamDistributor(ArenaTeam... teams) {
            Collections.addAll(_cache, teams);

            loadTeams();
        }

        /**
         * Constructor
         * @param teams  Collection of {@code ArenaTeam} objects as available teams.
         */
        public TeamDistributor(Collection<ArenaTeam> teams) {
            _cache.addAll(teams);

            loadTeams();
        }

        /**
         * Get the next team a player should be put on.
         */
        @Nullable
        public ArenaTeam next() {

            if (_teams.isEmpty())
                return null;

            // remove team from beginning of queue
            Team team = _teams.remove();

            team.uses++;

            // add team to end of queue
            _teams.add(team);

            return team.team;
        }

        /**
         * Place a team slot back. Used when a player leaves an
         * arena before it starts.
         *
         * @param arenaTeam  The team to recycle.
         */
        public void recycle(ArenaTeam arenaTeam) {

            Iterator<Team> iterator = _teams.iterator();

            Team team = null;

            while (iterator.hasNext()) {
                team = iterator.next();

                //noinspection EqualsBetweenInconvertibleTypes
                if (team.equals(arenaTeam)) {
                    iterator.remove();
                    team.uses--;
                    break;
                }

                team = null;
            }

            if (team != null) {
                _teams.add(team);
            }
        }

        /**
         * Reset distribution to start over.
         */
        public void reset() {
            loadTeams();
        }


        private void loadTeams() {
            _teams.clear();

            for (ArenaTeam team : _cache) {
                _teams.add(new Team(team));
            }

        }

        private static class Team implements Comparable<Team> {
            public final ArenaTeam team;
            public int uses = 0;

            private final int hash;

            public Team (ArenaTeam team) {
                this.team = team;
                this.hash = team.hashCode();
            }

            @Override
            public boolean equals(Object obj) {
                if (obj instanceof Team)
                    return obj == this;

                if (obj instanceof ArenaTeam)
                    return obj == this.team;

                return false;
            }

            @Override
            public int hashCode() {
                return this.hash;
            }

            @Override
            public int compareTo(Team team) {
                return Integer.compare(this.uses, team.uses);
            }
        }

    }

}
