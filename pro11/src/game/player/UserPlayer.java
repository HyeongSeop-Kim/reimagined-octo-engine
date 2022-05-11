package game.player;

import java.util.Random;

import game.card.Bawi;
import game.card.Bo;
import game.card.Gawi;
import game.card.Hand;
import game.record.Record;

public class UserPlayer implements Player {
	
	private Random rand = new Random();
	private String name;
	private Hand hand;
	private Record record = new Record();
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
				record.addLose();
				loseCnt++; break;
			case 0 :
				result = "무승부";
				record.addDraw(); 
				loseCnt = 0; break;
			case 1 :
				result = "승리";
				record.addWin();
				loseCnt = 0; break;
		}
		if(loseCnt == 3) {
			cheatCnt++;
		}
		return result;
	}
	
	public String getTotalRecord() {
		String result = String.format("총 전적 : %d 전\n", record.getRecordCount());
		result += String.format("%d 승 %d 패 %d 무\n", record.getWin(), record.getLose(), record.getDraw());
		result += String.format("승률 : %.1f", record.getWinRate());
		
		return result;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(String hand) {
		if(hand.equals("가위")) {
			this.hand = new Gawi();
		} else if(hand.equals("바위")) {
			this.hand = new Bawi();
		} else if(hand.equals("보")) {
			this.hand = new Bo();
		} else {
			randomCardHand();
		}
	}
	
	public int getCheatCnt() {
		return cheatCnt;
	}
	
	public int[] getRecord() {
		return this.record.getScore();
	}
	
	public void setRecord(int[] record) {
		this.record.setScore(record);
	}
}
