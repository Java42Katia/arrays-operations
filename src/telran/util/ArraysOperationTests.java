package telran.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static telran.util.ArraysOperations.*;

import java.util.Arrays;

class ArraysOperationsTests {

	private static final String INSERTED_STRING = "World and ";
	private static final int INSERTED_NUMBER = 100;

	@Test
	void testInsert() {
		String arStr[] = {"hello", "Java"}; 
		String expectedStr[] = {"hello", INSERTED_STRING, "Java"}; 
		String actualStr[] = new String[arStr.length + 1];
		int indexInsert = 1;
		assertEquals(OK,insert(arStr, INSERTED_STRING, indexInsert, actualStr));
		assertArrayEquals(expectedStr, actualStr);
		assertEquals(WRONG_INDEX,insert(arStr, INSERTED_STRING, 100, actualStr));
		actualStr = new String[1];
		assertEquals(WRONG_RESULT_LENGTH,insert(arStr, INSERTED_STRING, indexInsert, actualStr));
		Integer numbers[] = {1, 2, 3};
		indexInsert = 0;
		Integer actualNumbers[] = new Integer[numbers.length + 1];
		Integer expectedFirst[] = {INSERTED_NUMBER, 1, 2, 3};
		insert(numbers,INSERTED_NUMBER, indexInsert, actualNumbers );
		assertArrayEquals(expectedFirst, actualNumbers);
		indexInsert = numbers.length;
		Integer expectedLast[] = { 1, 2, 3, INSERTED_NUMBER};
		insert(numbers,INSERTED_NUMBER, indexInsert, actualNumbers );
		assertArrayEquals(expectedLast, actualNumbers);
		
		
		
		
	}

	@Test
	void testRemove() {
		String arStr[] = {"hello", INSERTED_STRING, "Java"};
		String expectedStr[] = {"hello", "Java"}; 
		String actualStr[] = new String[arStr.length - 1];
		assertEquals(OK, remove(arStr, 1, actualStr));
		assertArrayEquals(expectedStr, actualStr);
		assertEquals(WRONG_INDEX, remove(arStr, 5, actualStr));
		assertEquals(WRONG_RESULT_LENGTH, remove(arStr, 1, new String[arStr.length]));
	}

	@Test
	void testInsertSorted() {
		// tests String
		String arStr[] = {"Alisa", "Borya", "Oleg", "Vasya", "Yuri"};
		String expectedStr[] = {"Alisa", "Borya", "Katia", "Oleg", "Vasya", "Yuri"};
		String actualStr[] = new String[arStr.length + 1];
		insertSorted(arStr, "Katia", actualStr);
		assertArrayEquals(expectedStr, actualStr);
		
		// tests Integer
		Integer arInt[] = {12, 65, 78, 98, 453};
		Integer expectedInt[] = {0, 12, 65, 78, 98, 453};
		Integer actualInt[] = new Integer[arInt.length + 1];
		insertSorted(arInt, 0, actualInt);
		assertArrayEquals(expectedInt, actualInt);		
	}

	@Test
	void testAddLast() {
		String arStr[] = {"hello", "Java"};
		String expectedStr[] = {"hello", "Java", INSERTED_STRING};
		String actualStr[] = new String[arStr.length + 1];
		addLast(arStr, INSERTED_STRING, actualStr);
		assertArrayEquals(expectedStr, actualStr);
	}

	@Test
	void testAddFirst() {
		String arStr[] = {"hello", "Java"};
		String expectedStr[] = {INSERTED_STRING, "hello", "Java"};
		String actualStr[] = new String[arStr.length + 1];
		addFirst(arStr, INSERTED_STRING, actualStr);
		assertArrayEquals(expectedStr, actualStr);
	}

}
