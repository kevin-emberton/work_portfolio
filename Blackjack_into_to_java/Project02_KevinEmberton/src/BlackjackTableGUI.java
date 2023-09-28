import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.event.*;
import java.util.ArrayList;
import javafx.scene.image.*;

public class BlackjackTableGUI extends Application {
	
	// variables
	
	Player dealer = new Player();
	Player player = new Player();
	Label dealerHandLbl = new Label("Dealer Hand");
	Label dealerHandScore = new Label("Value: 0");
	HBox dealerHand = new HBox();
	Label playerHandLbl = new Label("Player Hand");
	Label playerHandScore = new Label("Value: 0");
	HBox playerHand = new HBox();
	Button start = new Button("Start");
	Button hit = new Button("Hit");
	Button stand = new Button("stand");
	Label playerScore = new Label("Player Score: 0");
	Label dealerScore = new Label("Dealer Score: 0");
	Label winLoss = new Label();
	VBox root = new VBox();

	public static void main(String[] args) {
		
		launch(args);
	}
	
	// creates display
	
	public void start(Stage primaryStage) {
		
		HBox dealerBar = new HBox(dealerHandLbl, dealerHandScore);
		dealerBar.setSpacing(100);
		dealerBar.setAlignment(Pos.CENTER);
		HBox playerBar = new HBox(playerHandLbl, playerHandScore);
		playerBar.setSpacing(100);
		playerBar.setAlignment(Pos.CENTER);
		dealerHandLbl.setStyle("-fx-text-fill: white\n"
				+ "; -fx-font-weight: bold\n"
				+ "; -fx-font-size: 14");
		dealerHandScore.setStyle("-fx-text-fill: white\n"
				+ "; -fx-font-weight: bold\n"
				+ "; -fx-font-size: 14");
		playerHandLbl.setStyle("-fx-text-fill: white\n"
				+ "; -fx-font-weight: bold\n"
				+ "; -fx-font-size: 14");
		playerHandScore.setStyle("-fx-text-fill: white\n"
				+ "; -fx-font-weight: bold\n"
				+ "; -fx-font-size: 14");
		playerScore.setStyle("-fx-text-fill: white\n"
				+ "; -fx-font-weight: bold\n"
				+ "; -fx-font-size: 14");
		dealerScore.setStyle("-fx-text-fill: white\n"
				+ "; -fx-font-weight: bold\n"
				+ "; -fx-font-size: 14");
		winLoss.setStyle("-fx-text-fill: white\n"
				+ "; -fx-font-weight: bold\n"
				+ "; -fx-font-size: 14");
		dealerHand.setPrefSize(600, 150);
		playerHand.setPrefSize(600, 150);
		HBox buttonBox = new HBox(start, hit, stand);
		start.setOnAction(new startButtonHandler());
		hit.setOnAction(new hitButtonHandler());
		stand.setOnAction(new standButtonHandler());
		hit.setDisable(true);
		stand.setDisable(true);
		buttonBox.setSpacing(10);
		buttonBox.setAlignment(Pos.CENTER);
		VBox scoreBox = new VBox(playerScore, dealerScore);
		scoreBox.setSpacing(10);
		HBox box = new HBox(scoreBox, winLoss);
		box.setAlignment(Pos.CENTER);
		box.setSpacing(280);
		winLoss.setAlignment(Pos.CENTER_RIGHT);
		scoreBox.setAlignment(Pos.CENTER_LEFT);
		root = new VBox(dealerBar, dealerHand, playerBar, playerHand, buttonBox, box);
		dealerBar.setStyle("-fx-background-color: springgreen");
		dealerHand.setStyle("-fx-background-color: springgreen");
		playerBar.setStyle("-fx-background-color: springgreen");
		playerHand.setStyle("-fx-background-color: springgreen");
		buttonBox.setStyle("-fx-background-color: springgreen");
		scoreBox.setStyle("-fx-background-color: springgreen");
		box.setStyle("-fx-background-color: springgreen");
		root.setStyle("-fx-background-color: springgreen");
		root.setPadding(new Insets(10));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Blackjack");
		primaryStage.show();
	}
	
	// updates the hand
	
	public void updateHand(Player p, HBox box, Label handValue) {
		
		p.hit();
		Image img = p.hand.get(p.hand.size() - 1).card;
		ImageView pic = new ImageView(img);
		box.getChildren().add(pic);
		handValue.setText(String.format("Value: %s", p.valueOfHand()));
	}
	
	//ends game
	
	public void endGame() {
		
		boolean playerWins = false;
		boolean tie = false;
		if (dealer.valueOfHand() > 21) {
			
			winLoss.setText("Player wins!");
			playerWins = true;
		} else if (player.valueOfHand() == dealer.valueOfHand()) {
			
			winLoss.setText("Push! No one wins.");
			tie = true;
		} else if (player.valueOfHand() > dealer.valueOfHand()) {
			
			winLoss.setText("Player wins!");
			playerWins = true;
		} else if (player.valueOfHand() < dealer.valueOfHand()) {
			
			winLoss.setText("Dealer wins!");
		}
		
		if (!tie && !playerWins) {
			
			String str = dealerScore.getText();
			char c = str.charAt(str.length() - 1);
			str = String.format("%s", c);
			int num = Integer.parseInt(str);
			num += 1;
			dealerScore.setText(String.format("Dealer Score: %s" , num));
		} else if (playerWins) {
			
			String str = playerScore.getText();
			char c = str.charAt(str.length() - 1);
			str = String.format("%s", c);
			int num = Integer.parseInt(str);
			num += 1;
			playerScore.setText(String.format("Player Score: %s" , num));
		}
		
		start.setDisable(false);
		hit.setDisable(true);
		stand.setDisable(true);
	}
	
	// starts the game
	
	class startButtonHandler implements EventHandler<ActionEvent> {
		
		@Override
		public void handle(ActionEvent event) {
			
			dealerHand.getChildren().clear();
			playerHand.getChildren().clear();
			Player.deck.reset();
			dealer.clearHand();
			player.clearHand();
			dealer.hit();
			ArrayList<Cards> hand = dealer.getHand();
			for (int i = 0; i < hand.size(); i++) {
				
				Image img = hand.get(i).card;
				ImageView pic = new ImageView(img);
				dealerHand.getChildren().add(pic);
			}
			hit.setDisable(false);
			stand.setDisable(false);
			start.setDisable(true);
			dealerHandScore.setText(String.format("Value: %s", dealer.valueOfHand()));
			playerHandScore.setText("Value: 0");
		}
	}
	
	// allows player to draw a card
	
	class hitButtonHandler implements EventHandler<ActionEvent> {
		
		@Override
		public void handle(ActionEvent event) {
			
			updateHand(player, playerHand, playerHandScore);
			if (player.valueOfHand() > 21) {
				
				playerHandScore.setText(playerHandScore.getText() + "  Bust!");
				winLoss.setText("Dealer wins!");
				String str = dealerScore.getText();
				char c = str.charAt(str.length() - 1);
				str = String.format("%s", c);
				int num = Integer.parseInt(str);
				num += 1;
				dealerScore.setText(String.format("Dealer Score: %s" , num));
				start.setDisable(false);
				hit.setDisable(true);
				stand.setDisable(true);
			}
		}
	}
	
	// ends player turn
	
	class standButtonHandler implements EventHandler<ActionEvent> {
		
		@Override
		public void handle(ActionEvent event) {
			
			boolean dealerTurnDone = false;
			while (!dealerTurnDone) {
				
				updateHand(dealer, dealerHand, dealerHandScore);
				dealerTurnDone = dealer.stand();
				if (dealer.valueOfHand() > 21) {
					
					dealerHandScore.setText(dealerHandScore.getText() + "  Bust!");
					
				}
			}
			
			endGame();
		}
	}
}