public class BowlingGame {

    private int score;
    
    private int frame;
    private int nbRoll=0;

    private int bonusPoint;
    
    public int score() {
        return score;
    }
    
    public void roll(int numberPins) {
    		nbRoll += 1;
    		frame += numberPins;
    		
    		if (bonusPoint != 0)
    		{
    			frame += numberPins;
    			bonusPoint -=1;
    		}
    			
    		addStrikeBonus(numberPins, nbRoll);
    		
    		addSpareBonus(frame);
			
    		if (nbRoll == 2)
    		{
    			updateScore(frame);
    		}
    }
    
    private void updateScore(int localFrame)
    {
    	score += localFrame;
		frame = 0;
		nbRoll = 0;
    }
    
    private int addStrikeBonus(int numberPins,int nbRoll)
    {
    	if ((numberPins == 10) && (nbRoll == 1))
			bonusPoint += 1;
    	return bonusPoint;
    }
    
    private int addSpareBonus(int frame)
    {
    	if (frame == 10)
			bonusPoint += 1;
    	return bonusPoint;
    }
}
