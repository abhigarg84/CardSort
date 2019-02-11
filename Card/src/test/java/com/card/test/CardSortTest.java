package com.card.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.card.Card;
import com.card.CardSort;

class CardSortTest {

	private CardSort cardSort;
	
	@Test
	void testSortApproach1() {
		cardSort = new CardSort();
		cardSort.init1();
		List<Card> expected = new ArrayList<>(cardSort.getCards());
		System.out.println("Expected Order ->");
		System.out.println(expected);
		List<Card> result = cardSort.sortApproch1();
		System.out.println("Shuffled Order ->");
		System.out.println(cardSort.getCards());
		System.out.println("Sorted Order ->");
		System.out.println(result);
//		boolean isEqual = true;
//		for(int i=0; i<52;i++) {
//			if(!expected.get(i).equals(result.get(i))) {
//				isEqual = false;
//			}
//		}
//		assertTrue(isEqual);
		assertTrue(Objects.deepEquals(result, expected));
	}

	
	@Test
	void testSortApproach2() {
		cardSort = new CardSort();
		cardSort.init2();
		List<Card> expected = new ArrayList<>(cardSort.getCards());
		System.out.println("Expected Order ->");
		System.out.println(expected);
		List<Card> result = cardSort.sortApproch2();
		System.out.println("Shuffled Order ->");
		System.out.println(cardSort.getCards());
		System.out.println("Sorted Order ->");
		System.out.println(result);
//		boolean isEqual = true;
//		for(int i=0; i<52;i++) {
//			if(!expected.get(i).equals(result.get(i))) {
//				isEqual = false;
//			}
//		}
//		assertTrue(isEqual);
		assertTrue(Objects.deepEquals(result, expected));
	}

}
