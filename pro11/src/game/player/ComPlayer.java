package game.player;

import java.util.Random;

import game.card.Bawi;
import game.card.Bo;
import game.card.Gawi;
import game.card.Hand;

public class ComPlayer implements Player {
	private Random rand = new Random();
	private Hand hand;
	private int loseCnt;
	private int cheatCnt;
	
	@Override
	public void randomCardHand() {
		int r = rand.nextInt(3);
		
		switch(r) {
			case 0:
				hand = new Gawi(); break;
			case 1:
				hand = new Bawi(); break;
			case 2:
				hand = new Bo(); break;
		}
	}

	@Override
	public String versus(Hand h1) {
		String result = "";
		
		switch(hand.compare(h1)) {
			case -1 :
				result = "패배";
				loseCnt++; break;
			case 0 :
				result = "무승부";
				loseCnt = 0; break;
			case 1 :
				result = "승리";
				loseCnt = 0; break;
		}
		if(loseCnt == 3) {
			cheatCnt++;
		}
		return result;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}
	
	public int getCheatCnt() {
		return cheatCnt;
	}
	
}
