package UpDown.game;

import java.util.Random;

public class GuessNum {
	Random rand = new Random();
	private int randNum;
	private int tryCnt;
	private int limitCnt;
	
	public GuessNum(int range) {
		randNum = rand.nextInt(range);
		limitCnt = 10;
	}
	
	public Result compare(int guessNum) {
		if(tryCnt > limitCnt) {
			return new Fail();
		}
		if(randNum > guessNum) {
			tryCnt++;
			return new Up();
		} else if(randNum < guessNum) {
			tryCnt++;
			return new Down();
		} else if(randNum == guessNum) {
			return new Correct();
		}
		return null; 
	}
}
