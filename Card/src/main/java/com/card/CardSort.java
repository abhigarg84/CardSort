package com.card;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class CardSort {

	private List<Card> cards;

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public void init1() {
		cards = new ArrayList<>(52);

		for (Card.Suit suit : Card.Suit.values()) {
			for (Card.Face face : Card.Face.values()) {
				Card card = new Card(face, suit);
				cards.add(card);
			}
		}
	}

	public void init2() {
		Set<Card> initSet = new TreeSet();
		for (Card.Suit suit : Card.Suit.values()) {
			for (Card.Face face : Card.Face.values()) {
				Card card = new Card(face, suit);
				initSet.add(card);
			}
		}
		cards = new ArrayList<>(initSet);
	}

	
	private void shuffle() {
		Random rnd = new Random();
		for(int i=cards.size(); i>=1 ; i--) {
			int random = rnd.nextInt(i);
			Card tmp1 = cards.get(i-1);
			Card tmp2 = cards.get(random);
			cards.set(i-1, tmp2);
			cards.set(random, tmp1);
		}
	}
	
	public List<Card> sortApproch2() {
		shuffle();

		Set<Card> newCards = new TreeSet<>();
		for(Card card: cards) {
			newCards.add(card);
		}
		return new ArrayList<Card>(newCards);
	}

	public List<Card> sortApproch1() {
		shuffle();

		//divide in 4 suites then sort
		CardFaceComparator faceComp = new CardFaceComparator();
		Set<Card> spades = new TreeSet<>(faceComp);
		Set<Card> hearts = new TreeSet<>(faceComp);
		Set<Card> diamonds = new TreeSet<>(faceComp);
		Set<Card> clubs = new TreeSet<>(faceComp);
		
		for(Card card: cards) {
			if(card.getSuit() == Card.Suit.Spades) {
				spades.add(card);
			} else if(card.getSuit() == Card.Suit.Hearts) {
				hearts.add(card);
			} else if(card.getSuit() == Card.Suit.Diamonds) {
				diamonds.add(card);
			} else if(card.getSuit() == Card.Suit.Clubs) {
				clubs.add(card);
			}
		}
		List<Card> sortedCards = new ArrayList<Card>(52);
		sortedCards.addAll(spades);
		sortedCards.addAll(hearts);
		sortedCards.addAll(diamonds);
		sortedCards.addAll(clubs);
		return sortedCards;
	}

}
