package pl.put.poznan.transformer.tests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import pl.put.poznan.transformer.logic.TextTransformer;
import pl.put.poznan.transformer.logic.TextTransformerNumbers;

public class TestTextTransformerNumbers {

	private TextTransformerNumbers mockObject;
	private TextTransformer textTransformer;
	
	@Before
	public void setUp() {
		mockObject = mock(TextTransformerNumbers.class);
		when(mockObject.toText("000")).thenReturn("zero");
		when(mockObject.toText("1")).thenReturn("jeden");
		when(mockObject.toText("11")).thenReturn("jedenaście");
		when(mockObject.toText("01")).thenReturn("jeden");
		when(mockObject.toText("023")).thenReturn("dwadzieścia trzy");
		when(mockObject.toText("30")).thenReturn("trzydzieści");
		when(mockObject.toText("34")).thenReturn("trzydzieści cztery");
		when(mockObject.toText("100")).thenReturn("sto");
		when(mockObject.toText("123")).thenReturn("sto dwadzieścia trzy");
		when(mockObject.toText("999")).thenReturn("dziewięćset dziewięćdziesiąt dziewięć");
		String[] transforms = new String[]{"numbers"};
		textTransformer = new TextTransformer(transforms, mockObject);
	}
	
	@Test 
	public void TestTextTransformerNumbers000() {
		String result = textTransformer.transform("000");
		verify(mockObject).toText("000");
		assertEquals(result, "zero");
	}
	
	@Test 
	public void TestTextTransformerNumbers1() {
		String result = textTransformer.transform("1");
		verify(mockObject).toText("1");
		assertEquals(result, "jeden");
	}
		
	@Test 
	public void TestTextTransformerNumbers11() {
		String result = textTransformer.transform("11");
		verify(mockObject).toText("11");
		assertEquals(result, "jedenaście");
	}
	
	@Test 
	public void TestTextTransformerNumbers01() {
		String result = textTransformer.transform("01");
		verify(mockObject).toText("01");
		assertEquals(result, "jeden");
	}
	
	@Test 
	public void TestTextTransformerNumbers023() {
		String result = textTransformer.transform("023");
		verify(mockObject).toText("023");
		assertEquals(result, "dwadzieścia trzy");
	}
	
	@Test 
	public void TestTextTransformerNumbers30() {
		String result = textTransformer.transform("30");
		verify(mockObject).toText("30");
		assertEquals(result, "trzydzieści");
	}
		
	@Test 
	public void TestTextTransformerNumbers34() {
		String result = textTransformer.transform("34");
		verify(mockObject).toText("34");
		assertEquals(result, "trzydzieści cztery");
	}
		
	@Test 
	public void TestTextTransformerNumbers100() {
		String result = textTransformer.transform("100");
		verify(mockObject).toText("100");
		assertEquals(result, "sto");
	}
	
	@Test 
	public void TestTextTransformerNumbers123() {
		String result = textTransformer.transform("123");
		verify(mockObject).toText("123");
		assertEquals(result, "sto dwadzieścia trzy");
	}

	@Test 
	public void TestTextTransformerNumbers999() {
		String result = textTransformer.transform("999");
		verify(mockObject).toText("999");
		assertEquals(result, "dziewięćset dziewięćdziesiąt dziewięć");
	}
	
}
