public class code04Bad {

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
    			
        	if ((numberPins == 10) && (rollNb == 1))
        	{
    			bonusPoint += 1;
    			rollNb += 1;
    			totalRollNb += 1;
        	};

        	if (frame == 10)
    			bonusPoint += 1;
        	
    		if (rollNb == 2)
    		{
    	    	score += point;
    			framePoint = 0;
    			rollNb = 0;
    			
    			if (totalRollNb == 20)
    	    	{
    	    		bonusRoll = bonusPoint;
    	    	};
    		}
		};	
	
    }
}