public class BowlingGame {

    private int score;
    
    private int framePoint;
    private int rollNb=0;
    private int totalRollNb=0;
    private int bonusPoint;
    private int bonusRoll = 0;
    
    public int score() {
        return score;
    }
    
    public int totalRollNb() {
        return totalRollNb;
    }
    
    public int totalBonus() {
        return bonusRoll;
    }
         
    public void roll(int numberPins) {
		totalRollNb += 1;
		
		if (bonusRoll > 0)
		{
			updateScore(numberPins);
			bonusRoll -= 1;
		};
		
		if (totalRollNb <= 20)
		{
			rollNb += 1;
    		framePoint += numberPins;
    		
    		if (bonusPoint != 0)
    		{
    			framePoint += numberPins;
    			bonusPoint -=1;
    		}
    			
    		rollNb = addStrikeBonus(numberPins, rollNb);
    		
    		addSpareBonus(framePoint);

    		if (rollNb == 2)
    		{
    			updateScore(framePoint);
    			isLastFrame(totalRollNb);
    		}
		};	
	
    }
    
    private void updateScore(int point)
    {
    	score += point;
		framePoint = 0;
		rollNb = 0;
    }
    
    private int addStrikeBonus(int numberPins,int rollNb)
    {
    	if ((numberPins == 10) && (rollNb == 1))
    	{
			bonusPoint += 1;
			rollNb += 1;
			totalRollNb += 1;
    	};
    	return rollNb;
    }
    
    private void addSpareBonus(int frame)
    {
    	if (frame == 10)
			bonusPoint += 1;
    }
    
    private void isLastFrame(int totalRollNb)
    {
    	if (totalRollNb == 20)
    	{
    		bonusRoll = bonusPoint;
    	}
    }
}