import java.util.ArrayList;
import java.util.Random;

public class Player {

	// variable declarations
	
	ArrayList<Cards> hand = new ArrayList<Cards>();
	static Deck deck = new Deck();
	
	// constructor
	
	Player() {
		
	}
	
	// getter
	
	public ArrayList<Cards> getHand() {
		
		return hand;
	}
	
	// clears hand
	
	public void clearHand() {
		
		hand.clear();
	}
	
	// determines value of player hand
	
	public int valueOfHand() {
		
		int sum = 0;
		for (int i = 0; i < hand.size(); i++) {
			
			sum += hand.get(i).valueOf();
		}
		
		return sum;
	}
	
	// determines whether dealer stands or not
	
	public boolean stand() {
		
		Random rand = new Random();
		if (valueOfHand() > 18) {
			
			return true;
		} else if (valueOfHand() > 15) {
			
			int temp = rand.nextInt(2);
			if (temp == 0) {
				
				return true;
			} else {
				
				return false;
			}
		} else if (valueOfHand() > 18) {
			
			return true;
		}
		
		return false;
	}
	
	// removes card from deck and adds to hand
	
	public void hit() {
		
		Cards selection = deck.dealCard();
		hand.add(selection);
	}
	
	// determines whether or not the player has busted
	
	public boolean bust() {
		
		if (valueOfHand() > 21) {
			
			return true;
		}
		
		return false;
	}
}