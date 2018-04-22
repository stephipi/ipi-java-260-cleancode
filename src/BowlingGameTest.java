import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class BowlingGameTest {

    BowlingGame game = new BowlingGame();

    @Test
    public void testQueDesGoutieresDonne0Points() {
        rollMany(20, 0);
        assertEquals(0, game.score());
    }

    @Test
    public void testUneSeuleQuille(){
        game.roll(1);
        rollMany(19, 0);
        assertEquals(1, game.score());
    }

    @Test
    public void testBonusDuSpare(){
        game.roll(8);
        game.roll(2);
        game.roll(1);
        rollMany(17, 0);
        assertEquals(12, game.score());
    }

    @Test
    public void testBonusDuStrike(){
        game.roll(10);
        game.roll(2);
        game.roll(1);
        rollMany(16, 0);
        assertEquals(16, game.score());
    }

    @Test
    public void testBonusDuSparePasStrike(){
        game.roll(0);
        game.roll(10);
        game.roll(2);
        game.roll(5);
        rollMany(16, 0);
        assertEquals(19, game.score());
    }

    private void rollMany(int numberRolls, int numberPins) {
        for (int i = 0; i < numberRolls; i++) {
            game.roll(numberPins);
        }
    }
}
