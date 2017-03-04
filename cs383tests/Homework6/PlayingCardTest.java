package Homework6;

import static org.junit.Assert.*;

import java.util.Iterator;


import org.junit.Test;

import Homework6.PlayingCard.Rank;
import Homework6.PlayingCard.Suit;

public class PlayingCardTest {

	
	@Test
	public void testCompareTo() {
		PlayingCard card1 = new PlayingCard(Rank.Three,Suit.Clubs);
		PlayingCard card2 = new PlayingCard(Rank.Four,Suit.Clubs);
		PlayingCard card3 = new PlayingCard(Rank.Three,Suit.Clubs);
		PlayingCard card4 = new PlayingCard(Rank.Three,Suit.Clubs);
		PlayingCard card5 = new PlayingCard(Rank.Three,Suit.Diamonds);
		PlayingCard card6 = new PlayingCard(Rank.Three,Suit.Clubs);
		assertEquals(-1,card1.compareTo(card2));
		assertEquals(0,card3.compareTo(card4));
		assertEquals(1,card5.compareTo(card6));
	}
	
	@Test
	public void testOrderedDeck(){
		Iterator<PlayingCard> myDeck = PlayingCard.OrderedDeck();
		assertEquals(myDeck.next().rank(),new PlayingCard(Rank.Two, Suit.Clubs).rank());
		assertEquals(myDeck.next().rank(),new PlayingCard(Rank.Two, Suit.Diamonds).rank());
		assertEquals(myDeck.next().rank(),new PlayingCard(Rank.Two, Suit.Hearts).rank());
		assertEquals(myDeck.next().rank(),new PlayingCard(Rank.Two, Suit.Spades).rank());
		assertEquals(myDeck.next().rank(),new PlayingCard(Rank.Three, Suit.Clubs).rank());
		assertEquals(myDeck.next().rank(),new PlayingCard(Rank.Three, Suit.Diamonds).rank());
		assertEquals(myDeck.next().rank(),new PlayingCard(Rank.Three, Suit.Hearts).rank());
		assertEquals(myDeck.next().rank(),new PlayingCard(Rank.Three, Suit.Spades).rank());
	}
	
	@Test
	public void testShuffledDeck(){
		Iterator<PlayingCard> myDeck = PlayingCard.ShuffledDeck();
		//1 in 52 chance this will fail
		assertNotEquals(myDeck.next().rank(),new PlayingCard(Rank.Two, Suit.Clubs).rank());
	}
	
}








