

import java.util.Scanner;

public class Blackjack
	{
		static int firstTotalCards;
		
		static int playerHand;
		static int dealerHand;
		static String dealerSecondCard;
	
		
					public static void intro() 
					{
							@SuppressWarnings("resource")
							Scanner userInput = new Scanner(System.in);
							print("What is your name?");
							String name = userInput.nextLine();
							print("Hello " + name + " and welcome to Blackjack! "
								+ "\nThe object of the game is to get as close to or at 21 for your card value.  "
								+ "\nIf you go over 21 you loose! "
								+ "\nYou and the dealer will start out with two cards.");
					}
					
					public static void dealTwoCards()   
						{
							playerHand = Deck.deck.get(0).getValue() + Deck.deck.get(1).getValue();
							print(" \nYour first two cards are a " + Deck.deck.get(0).getRank() + " of " + Deck.deck.get(0).getSuit()
							+ " and a " + Deck.deck.get(1).getRank() + " of " + Deck.deck.get(1).getSuit() + "\nfor a total of " +  playerHand + ". ");
							Deck.deck.remove(0);
							Deck.deck.remove(0);	
							
							dealerHand = Deck.deck.get(0).getValue() + Deck.deck.get(1).getValue();
							dealerSecondCard = Deck.deck.get(1).getRank() + " of " + Deck.deck.get(1).getSuit();
							print( "The dealer is showing a " + Deck.deck.get(0).getRank() + " of " + Deck.deck.get(0).getSuit());
	
							Deck.deck.remove(0);
							Deck.deck.remove(0);
						}
  
					public static void addOneCard()
						{
						
							print(" Would you like to hit or stay? ");
							@SuppressWarnings("resource")
							Scanner userInput = new Scanner(System.in);
							String hitOrStay = userInput.nextLine();
						
							if (hitOrStay.equals("hit"))
								{
									print("The card that you drew is a " + Deck.deck.get(0).getRank() + " of " + Deck.deck.get(0).getSuit() + ". ");
									playerHand = playerHand + Deck.deck.get(0).getValue();
									print(" \nYour new total is " + playerHand + ". ");
									Deck.deck.remove(0);
									if (playerHand > 21)
											{
												print("I'm sorry but you went over 21, therefore you lose!");
												System.exit(0);
											}
									
									if (playerHand == 21)
											{
												print("\nCongratulations you win! You got exactly 21!");
											}
									addOneCard();
								}
							
							else if (hitOrStay.equals("stay"))
								{
								
								print("The dealer's second card is a " + dealerSecondCard + " for a total of " + dealerHand + ". ");
								compareCards();
								}
						}
  					 
					public static void compareCards()  
					
					{
						if (playerHand > 21)
						{
							print("I'm sorry but you went over 21, therefore you lose!");
						}
						else if (dealerHand == playerHand)
								{
									print(" \nIm sorry but ties do go to the dealer.  So you loose!");
								}
							
						else if (dealerHand < playerHand)
						{
							print(" \nCongratulations! You Won! ");
						}
							else if (dealerHand > playerHand)
								{
									print(" \nSorry but the dealer was closer to 21. You loose!");
								}
					}

					public static void print(String s) 
					{
						for(int i = 0; i < s.length(); i++)
							{
								System.out.print(s.substring(i, i+1));
								try
									{
										Thread.sleep(50);
									}
										catch (InterruptedException e)
									{
										e.printStackTrace();
									}
							}
					}
					public static void checkForAllCards() 
					{
						print("\nWould you like to see all of the cards to make sure that they are shuffled?");
						@SuppressWarnings("resource")
						Scanner userInput = new Scanner(System.in);
						String yesOrNo = userInput.nextLine();
						if (yesOrNo.equals("yes"))
						{
						for (Card c : Deck.deck)
							{
								System.out.println(c.getRank() + " of " + c.getSuit());
							}
						}
					}
					
}
	