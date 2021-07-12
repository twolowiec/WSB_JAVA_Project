package com.company.game;

import javax.swing.text.StyledEditorKit;

public class Game {
    public final Integer noOfPlayers;
    public final Boolean winingCondition;


    public Game(Integer noPlayers, Boolean winingCondition) {
        this.noOfPlayers = noPlayers;
        this.winingCondition = winingCondition;
    }

    public Boolean isWiningConditionMeet () {
        return true;
    }
}
