import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
//these are my changes that I need to make below

/*
  
 * make the option for the user to choose the value of the ace to be one or eleven
 	Do I create a new method to give that option?
 * make a new player
    give the user in the intro() the option to select how many players there will be
 	new player can be a robot or an actual player 2	
 *add gambling
 	two person gambling
 		
*/
public class BlackjackRunner
	{
		static int firstTotalCards;
		static ArrayList<Card> deck =new ArrayList <Card>();
		static int playerHandValue;
		public static void main(String[] args)
			{
						deck();
						
					{
						intro();
						dealTwoCards();
						addOneCard();
						youWonOrLost();
						playAgain();
					}
			}
		
					public static void intro()
					{
							@SuppressWarnings("resource")
							Scanner userInput = new Scanner(System.in);
							print("What is your name?");
							String name = userInput.nextLine();
							print("Hello " + name + " and welcome to Blackjack! "
								+ "\nThe object of the game is to get a total of 21 for your card value.  "
								+ "\nIf you go over 21 you loose! "
								+ "\nYou will start out with two cards.");
					}
					
					public static void dealTwoCards()
					{
						playerHandValue = deck.get(0).getValue() + deck.get(1).getValue();
						print(" \nYour first two cards are a " + deck.get(0).getRank() + " of " + deck.get(0).getSuit()
							+ " and a " + deck.get(1).getRank() + " of " + deck.get(1).getSuit() + "\nfor a total of " +  playerHandValue + ".");
						
						youWonOrLost();
						deck.remove(0);
						deck.remove(0);	
					}

					public static void addOneCard()
					{
						print(" Would you like to draw another card? ");
						@SuppressWarnings("resource")
						Scanner userInput = new Scanner(System.in);
						print("\n 1. Yes ");
						print("\n 2. No ");
						int yesOrNo = userInput.nextInt();
				
							if (yesOrNo == 1)
								{
									print("The card that you drew is a " + deck.get(0).getRank() + " of " + deck.get(0).getSuit() + ". ");
									playerHandValue = playerHandValue + deck.get(0).getValue();
									print(" \nYour new total is " + playerHandValue + ". ");
									deck.remove(0);
									
									youWonOrLost();
									addOneCard();
								}
							
							else if (yesOrNo == 2)
								{
									print("I'm sorry to tell  you but you came up just short of 21. \nThat means that you loose.  Would you like to play again?");
									playAgain();
									System.exit(0);
								}
					}
					
					public static void youWonOrLost()
						{
							if (playerHandValue == 21)
								{
									print(" Congratulations! You Win");
									playAgain();
								}
							else if (playerHandValue > 21)
								{
									print(" \nIm sorry to inform you, but you went over 21 so you lose.");
									playAgain();
								}
						}
					public static void playAgain()
					{
						print(" \nWould you like to play again?");
						@SuppressWarnings("resource")
						Scanner userInput = new Scanner(System.in);
						print("\n 1. Yes");
						print("\n 2. No");
				
						int yesOrNo = userInput.nextInt();
						
						if (yesOrNo == 1)
							{
								dealTwoCards();
								addOneCard();
								youWonOrLost();
							}
						else if (yesOrNo == 2)
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
										Thread.sleep(50);
									} catch (InterruptedException e)
									{
										e.printStackTrace();
									}
							}
					}
					
					
					public static void deck()
						{
								{
									deck.add(new Card("ace", "hearts", 11));
									deck.add(new Card("ace", "clubs", 11));
									deck.add(new Card("ace", "spades", 11));
									deck.add(new Card("ace", "diamonds", 11));
									deck.add(new Card("king", "hearts", 10));
									deck.add(new Card("king", "clubs", 10));
									deck.add(new Card("king", "spades", 10));
									deck.add(new Card("king", "diamonds", 10));
									deck.add(new Card("queen", "hearts", 10));
									deck.add(new Card("queen", "clubs", 10));
									deck.add(new Card("queen", "spades", 10));
									deck.add(new Card("queen", "diamonds", 10));
									deck.add(new Card("jack", "hearts", 10));
									deck.add(new Card("jack", "clubs", 10));
									deck.add(new Card("jack", "spades", 10));
									deck.add(new Card("jack", "diamonds", 10));
									deck.add(new Card("ten", "hearts", 10));
									deck.add(new Card("ten", "clubs", 10));
									deck.add(new Card("ten", "spades", 10));
									deck.add(new Card("ten", "diamonds", 10));
									deck.add(new Card("nine", "hearts", 9));
									deck.add(new Card("nine", "clubs", 9));
									deck.add(new Card("nine", "spades", 9));
									deck.add(new Card("nine", "diamonds", 9));
									deck.add(new Card("eight", "hearts", 8));
									deck.add(new Card("eight", "clubs", 8));
									deck.add(new Card("eight", "spades", 8));
									deck.add(new Card("eight", "diamonds", 8));
									deck.add(new Card("seven", "hearts", 7));
									deck.add(new Card("seven", "clubs", 7));
									deck.add(new Card("seven", "spades", 7));
									deck.add(new Card("seven", "diamonds", 7));
									deck.add(new Card("six", "hearts", 6));
									deck.add(new Card("six", "clubs", 6));
									deck.add(new Card("six", "spades", 6));
									deck.add(new Card("six", "diamonds", 6));
									deck.add(new Card("five", "hearts", 5));
									deck.add(new Card("five", "clubs", 5));
									deck.add(new Card("five", "spades", 5));
									deck.add(new Card("five", "diamonds", 5));
									deck.add(new Card("four", "hearts", 4));
									deck.add(new Card("four", "clubs", 4));
									deck.add(new Card("four", "spades", 4));
			 						deck.add(new Card("four", "diamonds", 4));
									deck.add(new Card("three", "hearts", 3));
									deck.add(new Card("three", "clubs", 3));
									deck.add(new Card("three", "spades", 3));
									deck.add(new Card("three", "diamonds", 3));
									deck.add(new Card("two", "hearts", 2));
									deck.add(new Card("two", "clubs", 2));
									deck.add(new Card("two", "spades", 2));
									deck.add(new Card("two", "diamonds", 2));
									Collections.shuffle(deck);
								}
								
						}	
						
}
						