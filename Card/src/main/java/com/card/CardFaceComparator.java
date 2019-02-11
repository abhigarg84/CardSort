package com.card;
import java.util.Comparator;

public class CardFaceComparator implements Comparator<Card> {

	@Override
	public int compare(Card o1, Card o2) {
		return o2.getFace().getRank() - o1.getFace().getRank();
	}

}
