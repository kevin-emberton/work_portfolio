import javafx.scene.image.*;
import java.io.File;

public class Cards {

	// Variable declarations
	
	static String[] faces = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	static String[] suits = {"heart", "diamond", "spade", "club"};
	static double height = 130;
	String face;
	String suit;
	Image card;
	
	// constructor
	
	Cards(String face, String suit) {
		
		this.face = face;
		this.suit = suit;
		
		if (this.face.equals(faces[0])) {
			
			if (this.suit.equals(suits[0])) {
				
				card = new Image(new File("ace_of_hearts.png").toURI().toString(), 80, height, true, true);
			} else if (this.suit.equals(suits[1])) {
				
				card = new Image(new File("ace_of_diamonds.png").toURI().toString(), 80, height, true, true);
			} else if (this.suit.equals(suits[2])) {
				
				card = new Image(new File("ace_of_spades.png").toURI().toString(), 80, height, true, true);
			} else if (this.suit.equals(suits[3])) {
				
				card = new Image(new File("ace_of_clubs.png").toURI().toString(), 80, height, true, true);
			}
		} else if (this.face.equals(faces[1])) {
			
			if (this.suit.equals(suits[0])) {
				
				card = new Image(new File("2_of_hearts.png").toURI().toString(), 80, height, true, true);
			} else if (this.suit.equals(suits[1])) {
				
				card = new Image(new File("2_of_diamonds.png").toURI().toString(), 80, height, true, true);
			} else if (this.suit.equals(suits[2])) {
				
				card = new Image(new File("2_of_spades.png").toURI().toString(), 80, height, true, true);
			} else if (this.suit.equals(suits[3])) {
				
				card = new Image(new File("2_of_clubs.png").toURI().toString(), 80, height, true, true);
			}		
		} else if (this.face.equals(faces[2])) {
			
			if (this.suit.equals(suits[0])) {
				
				card = new Image(new File("3_of_hearts.png").toURI().toString(), 80, height, true, true);
			} else if (this.suit.equals(suits[1])) {
				
				card = new Image(new File("3_of_diamonds.png").toURI().toString(), 80, height, true, true);
			} else if (this.suit.equals(suits[2])) {
				
				card = new Image(new File("3_of_spades.png").toURI().toString(), 80, height, true, true);
			} else if (this.suit.equals(suits[3])) {
				
				card = new Image(new File("3_of_clubs.png").toURI().toString(), 80, height, true, true);
			}		
		} else if (this.face.equals(faces[3])) {
			
			if (this.suit.equals(suits[0])) {
				
				card = new Image(new File("4_of_hearts.png").toURI().toString(), 80, height, true, true);
			} else if (this.suit.equals(suits[1])) {
				
				card = new Image(new File("4_of_diamonds.png").toURI().toString(), 80, height, true, true);
			} else if (this.suit.equals(suits[2])) {
				
				card = new Image(new File("4_of_spades.png").toURI().toString(), 80, height, true, true);
			} else if (this.suit.equals(suits[3])) {
				
				card = new Image(new File("4_of_clubs.png").toURI().toString(), 80, height, true, true);
			}
		} else if (this.face.equals(faces[4])) {
			
			if (this.suit.equals(suits[0])) {
				
				card = new Image(new File("5_of_hearts.png").toURI().toString(), 80, height, true, true);
			} else if (this.suit.equals(suits[1])) {
				
				card = new Image(new File("5_of_diamonds.png").toURI().toString(), 80, height, true, true);
			} else if (this.suit.equals(suits[2])) {
				
				card = new Image(new File("5_of_spades.png").toURI().toString(), 80, height, true, true);
			} else if (this.suit.equals(suits[3])) {
				
				card = new Image(new File("5_of_clubs.png").toURI().toString(), 80, height, true, true);
			}
		} else if (this.face.equals(faces[5])) {
			
			if (this.suit.equals(suits[0])) {
				
				card = new Image(new File("6_of_hearts.png").toURI().toString(), 80, height, true, true);
			} else if (this.suit.equals(suits[1])) {
				
				card = new Image(new File("6_of_diamonds.png").toURI().toString(), 80, height, true, true);
			} else if (this.suit.equals(suits[2])) {
				
				card = new Image(new File("6_of_spades.png").toURI().toString(), 80, height, true, true);
			} else if (this.suit.equals(suits[3])) {
				
				card = new Image(new File("6_of_clubs.png").toURI().toString(), 80, height, true, true);
			}
		} else if (this.face.equals(faces[6])) {
			
			if (this.suit.equals(suits[0])) {
				
				card = new Image(new File("7_of_hearts.png").toURI().toString(), 80, height, true, true);
			} else if (this.suit.equals(suits[1])) {
				
				card = new Image(new File("7_of_diamonds.png").toURI().toString(), 80, height, true, true);
			} else if (this.suit.equals(suits[2])) {
				
				card = new Image(new File("7_of_spades.png").toURI().toString(), 80, height, true, true);
			} else if (this.suit.equals(suits[3])) {
				
				card = new Image(new File("7_of_clubs.png").toURI().toString(), 80, height, true, true);
			}
		} else if (this.face.equals(faces[7])) {
			
			if (this.suit.equals(suits[0])) {
				
				card = new Image(new File("8_of_hearts.png").toURI().toString(), 80, height, true, true);
			} else if (this.suit.equals(suits[1])) {
				
				card = new Image(new File("8_of_diamonds.png").toURI().toString(), 80, height, true, true);
			} else if (this.suit.equals(suits[2])) {
				
				card = new Image(new File("8_of_spades.png").toURI().toString(), 80, height, true, true);
			} else if (this.suit.equals(suits[3])) {
				
				card = new Image(new File("8_of_clubs.png").toURI().toString(), 80, height, true, true);
			}
		} else if (this.face.equals(faces[8])) {
			
			if (this.suit.equals(suits[0])) {
				
				card = new Image(new File("9_of_hearts.png").toURI().toString(), 80, height, true, true);
			} else if (this.suit.equals(suits[1])) {
				
				card = new Image(new File("9_of_diamonds.png").toURI().toString(), 80, height, true, true);
			} else if (this.suit.equals(suits[2])) {
				
				card = new Image(new File("9_of_spades.png").toURI().toString(), 80, height, true, true);
			} else if (this.suit.equals(suits[3])) {
				
				card = new Image(new File("9_of_clubs.png").toURI().toString(), 80, height, true, true);
			}
		} else if (this.face.equals(faces[9])) {
			
			if (this.suit.equals(suits[0])) {
				
				card = new Image(new File("10_of_hearts.png").toURI().toString(), 80, height, true, true);
			} else if (this.suit.equals(suits[1])) {
				
				card = new Image(new File("10_of_diamonds.png").toURI().toString(), 80, height, true, true);
			} else if (this.suit.equals(suits[2])) {
				
				card = new Image(new File("10_of_spades.png").toURI().toString(), 80, height, true, true);
			} else if (this.suit.equals(suits[3])) {
				
				card = new Image(new File("10_of_clubs.png").toURI().toString(), 80, height, true, true);
			}
		} else if (this.face.equals(faces[10])) {
			
			if (this.suit.equals(suits[0])) {
				
				card = new Image(new File("jack_of_hearts2.png").toURI().toString(), 80, height, true, true);
			} else if (this.suit.equals(suits[1])) {
				
				card = new Image(new File("jack_of_diamonds2.png").toURI().toString(), 80, height, true, true);
			} else if (this.suit.equals(suits[2])) {
				
				card = new Image(new File("jack_of_spades2.png").toURI().toString(), 80, height, true, true);
			} else if (this.suit.equals(suits[3])) {
				
				card = new Image(new File("jack_of_clubs2.png").toURI().toString(), 80, height, true, true);
			}
		} else if (this.face.equals(faces[11])) {
			
			if (this.suit.equals(suits[0])) {
				
				card = new Image(new File("queen_of_hearts2.png").toURI().toString(), 80, height, true, true);
			} else if (this.suit.equals(suits[1])) {
				
				card = new Image(new File("queen_of_diamonds2.png").toURI().toString(), 80, height, true, true);
			} else if (this.suit.equals(suits[2])) {
				
				card = new Image(new File("queen_of_spades2.png").toURI().toString(), 80, height, true, true);
			} else if (this.suit.equals(suits[3])) {
				
				card = new Image(new File("queen_of_clubs2.png").toURI().toString(), 80, height, true, true);
			}
		} else if (this.face.equals(faces[12])) {
			
			if (this.suit.equals(suits[0])) {
				
				card = new Image(new File("king_of_hearts2.png").toURI().toString(), 80, height, true, true);
			} else if (this.suit.equals(suits[1])) {
				
				card = new Image(new File("king_of_diamonds2.png").toURI().toString(), 80, height, true, true);
			} else if (this.suit.equals(suits[2])) {
				
				card = new Image(new File("king_of_spades2.png").toURI().toString(), 80, height, true, true);
			} else if (this.suit.equals(suits[3])) {
				
				card = new Image(new File("king_of_clubs2.png").toURI().toString(), 80, height, true, true);
			}
		}
	}
	
	// getters
	
	public String getFace() {
		
		return face;
	}
	
	public Image getCard() {
		
		return card;
	}
	
	// converts card into integer value
	
	public int valueOf() {
		
		if (face.equals(faces[0])) {
			
			return 11;
		}
		
		for (int i = 1; i < 10; i++) {
			
			if (face.equals(faces[i])) {
				
				return Integer.parseInt(faces[i]);
			}
		}
		
		for (int i = 10; i < 13; i++) {
			
			if (face.equals(faces[i])) {
				
				return 10;
			}
		}
		
		return 0;
	}
}