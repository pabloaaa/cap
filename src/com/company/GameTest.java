package com.company;

import org.junit.Test;
import static org.junit.Assert.*;


public class GameTest {

    @Test
    public void testManyanyRoll() throws Exception {
        Game bowling = new Game();
        for(int i = 0; i < 20; i++){
            bowling.roll(0);
        }
        assertEquals(bowling.getscore(),0);
    }

    @Test
    public void testanyscore() throws Exception {
        Game bowling = new Game();
        for(int i = 0; i < 20; i++){
            bowling.roll(2);
        }
        assertEquals(bowling.getscore(),40);
    }

    @Test
    public void testSpare() throws Exception {
        Game g = new Game();
        g.roll(5);
        g.roll(5);
        g.roll(3);
        for(int i = 0; i < 17; i++){
            g.roll(0);
        }
        assertEquals(13,g.getscore());
    }

    @Test
    public void testStrike() throws Exception {
        Game g = new Game();
        g.roll(10);
        g.roll(5);
        g.roll(3);
        for(int i = 0; i < 18; i++){
            g.roll(0);
        }
        assertEquals(17,g.getscore());
    }

    @Test
    public void testAllStrike(){
        Game g = new Game();
        for(int i = 0; i < 12; i++){
            g.roll(10);
        }
        assertEquals(g.getscore(),300);
    }


}