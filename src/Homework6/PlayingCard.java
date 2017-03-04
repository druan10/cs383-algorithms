//David Ruan

package Homework6;

import java.util.Iterator;
import java.util.Random;

public class PlayingCard implements Comparable<PlayingCard> {
	
	public enum  Rank { Two, Three, Four, Five, Six,
		Seven, Eight, Nine, Ten, Jack, Queen, King, Ace }
	
	public enum Suit { Clubs, Diamonds, Hearts, Spades }

	private Rank _r;
	private Suit _s;
	
	public PlayingCard(Rank r, Suit s) {
		this._r=r;
		this._s=s;
	}
	
	public Rank rank() {
		return this._r;
	}
	
	public Suit suit() {
		return this._s;
	}
	
	/***
	 * 
	 * @return an Iterator over a set of 52 PlayingCard objects in 
	 * their natural order
	 */
	public static Iterator<PlayingCard> OrderedDeck() {
		PlayingCard[] Deck = new PlayingCard[52];
		int arrayIndex = 0;
		Rank[] cardRanks = Rank.values();
		Suit[] cardSuits = Suit.values();
		for (int rank = 0; rank < 13; rank++){
			for (int suit = 0; suit < 4; suit++){
				Deck[arrayIndex++] = new PlayingCard(cardRanks[rank],cardSuits[suit]);
			}
		}
		return deckIterator(Deck);
	}
	
	/***
	 * 
	 * @return an Iterator over a set of 52 PlayingCard objects 
	 *  in a randomized order
	 */
	public static Iterator<PlayingCard> ShuffledDeck() {
		PlayingCard[] Deck = new PlayingCard[52];
		
		int arrayIndex = 0;
		Rank[] cardRanks = Rank.values();
		Suit[] cardSuits = Suit.values();
		for (int rank = 0; rank < 13; rank++){
			for (int suit = 0; suit < 4; suit++){
				Deck[arrayIndex++] = new PlayingCard(cardRanks[rank],cardSuits[suit]);
			}
		}
		
		//Shuffle Code
		//Implemented using pseudo code from https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle
		int j;
		PlayingCard swapSpace;
		Random randomInteger = new Random();
		for (int i = Deck.length-1; i>1; i--){
			j = randomInteger.nextInt(i);
			swapSpace = Deck[i];
			Deck[i] = Deck[j];
			Deck[j] = swapSpace;
		}
		return deckIterator(Deck);
	}
	
	//Deck Iterator
	private static Iterator<PlayingCard> deckIterator(PlayingCard[] deck){
		Iterator<PlayingCard> di = new Iterator<PlayingCard>(){
			PlayingCard[] myDeck = deck;
			private int position = 0;
			@Override
			public boolean hasNext(){
				return (position<myDeck.length);
			}
			@Override
			public PlayingCard next(){
				if (!hasNext()) throw new NullPointerException("No more cards");
				return (myDeck[position++]);
			}
			@Override
			public void remove(){
				//Not supported
			}
		};
		return di;
	}
	
	/***
	 * assumptions for natural ordering:
	 *   Rank:  Two < Three < ..Ten < Jack < Queen < King < Ace
	 *   Suit: Clubs < Diamonds < Hearts < Spades
	 */
	@Override
	public int compareTo(PlayingCard o) {
		if (o == null) throw new NullPointerException();
		if (o == this) return 0;
		//check enum values
		if (_r.ordinal() > o._r.ordinal()) return 1;
		if (_r.ordinal() < o._r.ordinal()) return -1;
		if (_s.ordinal() > o._s.ordinal()) return 1;
		if (_s.ordinal() < o._s.ordinal()) return -1;	
		return 0;
	}
}
