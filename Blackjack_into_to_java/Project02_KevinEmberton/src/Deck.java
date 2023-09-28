import java.util.ArrayList;
import java.util.Random;

public class Deck {

	// variable declarations
	
	ArrayList<Cards> deck = new ArrayList<Cards>();
	
	//constructor
	
	Deck() {
		
		reset();
	}
	
	// creates new deck
	
	public void reset() {
		
		deck.clear();
		String suit = "";
		String face = "";
		
		for (int i = 0; i < 4; i++) {
			
			if (i == 0) {
				
				suit = "heart";
			} else if (i == 1) {
				
				suit = "diamond";
			} else if (i == 2) {
				
				suit = "spade";
			} else if (i == 3) {
				
				suit = "club";
			}
			
			for (int k = 0; k < 13; k++) {
				
				if (k == 0) {
					
					face = "A";
				} else if (k == 1) {
					
					face = "2";
				} else if (k == 2) {
					
					face = "3";
				} else if (k == 3) {
					
					face = "4";
				} else if (k == 4) {
					
					face = "5";
				} else if (k == 5) {
					
					face = "6";
				} else if (k == 6) {
					
					face = "7";
				} else if (k == 7) {
					
					face = "8";
				} else if (k == 8) {
					
					face = "9";
				} else if (k == 9) {
					
					face = "10";
				} else if (k == 10) {
					
					face = "J";
				} else if (k == 11) {
					
					face = "Q";
				} else if (k == 12) {
					
					face = "K";
				}
				
				deck.add(new Cards(face, suit));
			}
		}
	}
	
	// Takes card from deck and deals to player
	
	public Cards dealCard() {
		
		Cards temp;
		Random rand = new Random();
		int selection = rand.nextInt(deck.size());
		temp = deck.get(selection);
		deck.remove(selection);
		return temp;
	}
}
