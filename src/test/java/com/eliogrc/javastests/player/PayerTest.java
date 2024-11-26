package com.eliogrc.javastests.player;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PayerTest {
    @Test
    public void lose_dice_number_is_too_low() {
        // Dice dice = new Dice(6);
        Dice dice = Mockito.mock(Dice.class);

        Mockito.when(dice.roll()).thenReturn(2);

        Player player = new Player(dice, 5);

        assertFalse(player.play());
    }

    @Test
    public void wins_dice_number_is_too_low() {
        // Dice dice = new Dice(6);
        Dice dice = Mockito.mock(Dice.class);

        Mockito.when(dice.roll()).thenReturn(6);

        Player player = new Player(dice, 5);

        assertTrue(player.play());
    }
}