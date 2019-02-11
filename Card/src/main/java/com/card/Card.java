package com.card;

import java.util.Objects;

public class Card implements Comparable<Card> {

	public static enum Face {
		Deuce(13), Three(12), Four(11), Five(10), Six(9), Seven(8), Eight(7), Nine(6), Ten(5), Jack(4), Queen(3),
		King(2), Ace(1);
		int rank;

		Face(int r) {
			rank = r;
		}

		public int getRank() {
			return rank;
		}
	}

	public static enum Suit {
		Spades(1), Hearts(2), Diamonds(3), Clubs(4);
		int order;

		Suit(int ord) {
			order = ord;
		}

		public int getOrder() {
			return order;
		}
	}

	private final Face face;
	private final Suit suit;
	private int weight;

	public Card(Face cardFace, Suit cardSuit) {
		face = cardFace;
		suit = cardSuit;
		weight = 4 * cardFace.getRank() + cardSuit.getOrder();
	}

	public Face getFace() {
		return face;
	}

	public Suit getSuit() {
		return suit;
	}

	public String toString() {
		return String.format("%s.%s", suit, face);
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public int compareTo(Card o) {
		return o.getWeight() - this.getWeight();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (!(obj instanceof Card)) {
			return false;
		}

		Card card = (Card) obj;
		return this.weight == card.weight && this.getFace().getRank() == card.getFace().getRank()
				&& this.getSuit().getOrder() == card.getSuit().getOrder();
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getFace().getRank(), this.getSuit().getOrder(), this.getWeight());
	}
}
