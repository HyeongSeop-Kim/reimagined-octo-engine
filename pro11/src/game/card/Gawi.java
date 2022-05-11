package game.card;

public class Gawi extends Hand {

	@Override
	public int compare(Hand otherHand) {
		// -1:패, 0:,무, 1:승
		int result = 0;
		if(otherHand instanceof Gawi) {
			result = 0;
		} else if(otherHand instanceof Bawi) {
			result = -1;
		} else if(otherHand instanceof Bo) {
			result = 1;
		}
		return result;
	}

	@Override
	public Hand cheat(Hand otherHand) {
		Hand newHand = null;
		if(otherHand instanceof Gawi) {
			newHand = new Bawi();
		} else if(otherHand instanceof Bawi) {
			newHand = new Bo();
		} else if(otherHand instanceof Bo) {
			newHand = new Gawi();
		}
		return newHand;
	}

}
