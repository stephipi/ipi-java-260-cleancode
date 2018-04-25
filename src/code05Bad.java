//Bons commentaires?
public class code05Bad {

	//attribut du score total
    private int score;
    
    //attribut du score d'une manche
    private int framePoint;
    
    //attribut du nombre de lancer d'une manche
    private int rollNb=0;
    
    //attribut du nombre de lancer total de la partie
    private int totalRollNb=0;
    
    //attribut pour comptabiliser les points lors de spare ou strike
    private int bonusPoint;
    
    //attribut de lancer bonus en fin de partie
    private int bonusRoll = 0;
    
    //fonction qui retourne score
    public int score() {
        return score;
    }
    
    //fonction qui retourne le nombre de lancers effectués
    public int totalRollNb() {
        return totalRollNb;
    }
    
    //fonction qui retourne le nombre de lancer bonus en fin de partie
    public int totalBonus() {
        return bonusRoll;
    }
         
    //
    public void roll(int numberPins) {
		totalRollNb += 1;
		
		//teste si on est dans le cas des lancers bonus de fin de partie
		if (bonusRoll > 0)
		{
			updateScore(numberPins);
			bonusRoll -= 1;
		};
		
		//teste si on a fait moins de 20 lancers 
		if (totalRollNb <= 20)
		{
			rollNb += 1;
    		framePoint += numberPins;
    		
    		//ajoute au score les points supplémentaires en cas de strike ou de spare
    		if (bonusPoint != 0)
    		{
    			framePoint += numberPins;
    			bonusPoint -=1;
    		}
    		
    		//détecte si on a fait un strike
    		rollNb = addStrikeBonus(numberPins, rollNb);
    		
    		//détecte si on a fait un spare
    		addSpareBonus(framePoint);

    		//vérifie si on arrive à la fin d'une manche
    		if (rollNb == 2)
    		{
    			updateScore(framePoint);
    			isLastFrame(totalRollNb);
    		}
		};	
	
    }
    
    //met a jour le score de la partie en fin de manche
    private void updateScore(int point)
    {
    	score += point;
		framePoint = 0;
		rollNb = 0;
    }
    
    //détecte si un strike a été fait
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
    
    //détecte si un spare a été fait
    private void addSpareBonus(int frame)
    {
    	if (frame == 10)
			bonusPoint += 1;
    }
    
    //détecte si on vient de faire un strike ou un spare dans le dernier lancer
    private void isLastFrame(int totalRollNb)
    {
    	if (totalRollNb == 20)
    	{
    		bonusRoll = bonusPoint;
    	}
    }
}