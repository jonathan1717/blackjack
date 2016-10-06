import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Blackjack
	{
		static int firstTotalCards;
		static ArrayList<Card> deck =new ArrayList <Card>();
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
						playerHand = deck.get(0).getValue() + deck.get(1).getValue();
						print(" \nYour first two cards are a " + deck.get(0).getRank() + " of " + deck.get(0).getSuit()
						+ " and a " + deck.get(1).getRank() + " of " + deck.get(1).getSuit() + "\nfor a total of " +  playerHand + ". ");
						deck.remove(0);
						deck.remove(0);	
						
						dealerHand = deck.get(0).getValue() + deck.get(1).getValue();
						dealerSecondCard = deck.get(1).getRank() + " of " + deck.get(1).getSuit();
						print( "The dealer is showing a " + deck.get(0).getRank() + " of " + deck.get(0).getSuit());

						deck.remove(0);
						deck.remove(0);
						
 
					}

					public static void addOneCard()
					{
						
						print(" Would you like to hit or stay? ");
						@SuppressWarnings("resource")
						Scanner userInput = new Scanner(System.in);
					    String hitOrStay = userInput.nextLine();
						
							if (hitOrStay == "hit")
								{
									print("The card that you drew is a " + deck.get(0).getRank() + " of " + deck.get(0).getSuit() + ". ");
									playerHand = playerHand + deck.get(0).getValue();
									print(" \nYour new total is " + playerHand + ". ");
									deck.remove(0);
									
									addOneCard();
								}
							
							else if (hitOrStay == "stay")
								{
									print("The dealer's second card is a " + dealerSecondCard + " for a total of " + dealerHand + ". ");
									compareCards();
								}
					}
					 
					public static void compareCards()
					
						{
							
							if (dealerHand == playerHand)
								{
									print(" \nIm sorry but ties do go to the dealer.  So you loose!");
								}
							else if (playerHand > 21)
								{
								print("\n I'm sorry but you went over 21 so you loose.");
								}
							else if (dealerHand > 21)
								{
									print("\n The dealer went over 21 so you win!");
								}
							else if (dealerHand == 21)
								{
									print("\n I'm sorry but the dealer has exactly 21 so you lose.");
								}
							else if (playerHand == 21)
								{
								print("\n  You have exactly 21 so you win!");
								}
							
							playAgain();
						}
					public static void compareCards2()
						{
						print("Your total is " + playerHand + ".");
						
						if (dealerHand < playerHand)
							{
								print(" \nCongratulations! You Won! ");
							}
						else if (dealerHand > playerHand)
							{
								print(" \nSorry but the dealer was closer to 21. You loose!");
							}
						}
					public static void playAgain()
					{
						print(" \nWould you like to play again?");
						@SuppressWarnings("resource")
						Scanner userInput = new Scanner(System.in);
						String yesOrNo = userInput.nextLine();
						
						if (yesOrNo == "yes")
							{
								dealTwoCards();
								addOneCard();
								
							}
						else if (yesOrNo == "no")
						{
							print("Alright thanks for playing! See you next time!");
							System.exit(0);
						}
					}
					public static void print(String s)
					{
						for(int i = 0; i < s.length(); i++)
							{
								System.out.print(s.substring(i, i+1));
								try
									{
										Thread.sleep(5);
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
						print("\n 1. Yes");
						print("\n 2. No");
						int yesOrNo = userInput.nextInt();
						if (yesOrNo == 1)
						{
						for (Card c : deck)
							{
								System.out.println(c.getRank() + " of " + c.getSuit());
							}
						}
					}
					public static void deck()
						{
								{
									deck.add(new Card("Ace", "Hearts", 11));
									deck.add(new Card("Ace", "Hlubs", 11));
									deck.add(new Card("Ace", "Spades", 11));
									deck.add(new Card("Ace", "Diamonds", 11));
									deck.add(new Card("King", "Hearts", 10));
									deck.add(new Card("King", "Clubs", 10));
									deck.add(new Card("King", "Spades", 10));
									deck.add(new Card("King", "Diamonds", 10));
									deck.add(new Card("Queen", "Hearts", 10));
									deck.add(new Card("Queen", "Clubs", 10));
									deck.add(new Card("Queen", "Spades", 10));
									deck.add(new Card("Queen", "Diamonds", 10));
									deck.add(new Card("Jack", "Hearts", 10));
									deck.add(new Card("Jack", "Clubs", 10));
									deck.add(new Card("Jack", "Spades", 10));
									deck.add(new Card("Jack", "Diamonds", 10));
									deck.add(new Card("Ten", "Hearts", 10));
									deck.add(new Card("Ten", "Clubs", 10));
									deck.add(new Card("Ten", "Spades", 10));
									deck.add(new Card("Ten", "Diamonds", 10));
									deck.add(new Card("Nine", "Hearts", 9));
									deck.add(new Card("Nine", "Clubs", 9));
									deck.add(new Card("Nine", "Spades", 9));
									deck.add(new Card("Nine", "Diamonds", 9));
									deck.add(new Card("Eight", "Hearts", 8));
									deck.add(new Card("Eight", "Clubs", 8));
									deck.add(new Card("Eight", "Spades", 8));
									deck.add(new Card("Eight", "Diamonds", 8));
									deck.add(new Card("Seven", "Hearts", 7));
									deck.add(new Card("Seven", "Clubs", 7));
									deck.add(new Card("Seven", "Spades", 7));
									deck.add(new Card("Seven", "Diamonds", 7));
									deck.add(new Card("Six", "Hearts", 6));
									deck.add(new Card("Six", "Clubs", 6));
									deck.add(new Card("Six", "Spades", 6));
									deck.add(new Card("Six", "Diamonds", 6));
									deck.add(new Card("Sive", "Hearts", 5));
									deck.add(new Card("Five", "Clubs", 5));
									deck.add(new Card("Five", "Spades", 5));
									deck.add(new Card("Five", "Diamonds", 5));
									deck.add(new Card("Four", "Hearts", 4));
									deck.add(new Card("Four", "Clubs", 4));
									deck.add(new Card("Four", "Spades", 4));
			 						deck.add(new Card("Four", "Diamonds", 4));
									deck.add(new Card("Three", "Hearts", 3));
									deck.add(new Card("Three", "Clubs", 3));
									deck.add(new Card("Three", "Spades", 3));
									deck.add(new Card("Three", "Diamonds", 3));
									deck.add(new Card("Two", "Hearts", 2));
									deck.add(new Card("Two", "Clubs", 2));
									deck.add(new Card("Two", "Spades", 2));
									deck.add(new Card("Two", "Diamonds", 2));
									Collections.shuffle(deck);
								}
								
						}						
	}					