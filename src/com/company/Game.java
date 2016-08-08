package com.company;

import java.util.LinkedList;
import java.util.List;

public class Game {
    private List<Integer> rolls;

    public Game() {
        rolls = new LinkedList<>();

    }

    public void roll(int pins) {
        rolls.add(pins);
        if (pins == 10 && (rolls.size() % 2 == 1)) {
            rolls.add(0);
        }
    }

    public int getscore() {
        int score = 0;
        int index = 0;
        for (int round = 0; round < 10; round++) {
            if (isStrike(index)) {
                score += 10 + strikeBonus(index);
            } else if (isSpare(index)) {
                score += 10 + spareBonus(index);
            } else {
                score += sumOfBallsInFrame(index);
            }
            index += 2;
        }
        return score;
    }

    private int sumOfBallsInFrame(int index) {
        return rolls.get(index) + rolls.get(index+1);
    }

    private int spareBonus(int index) {
        return rolls.get(index+2);
    }

    private boolean isSpare(int index) {
        return rolls.get(index)+rolls.get(index+1)==10;
    }

    private int strikeBonus(int index) {
        return rolls.get(index+1) + rolls.get(index+2);
    }

    private boolean isStrike(int index) {
        return rolls.get(index)==10;
    }


}

