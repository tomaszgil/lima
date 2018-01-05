package pl.put.poznan.transformer.logic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestTextTransformerInverse {

	TextTransformerInverse textTransformer = new TextTransformerInverse();	
	
	@Test
	public void testTextInverseLettersAllLowerCase() {
		assertEquals("hgfedcba", textTransformer.inverse("abcdefgh"));
	}
	
	@Test
	public void testTextInverseLettersAllUpperCase() {
		assertEquals("HGFEDCBA", textTransformer.inverse("ABCDEFGH"));
	}

	@Test
	public void testTextInverseLettersMixedCase() {
		assertEquals("KJIhGfedCBa", textTransformer.inverse("ABCdEfghIJk"));
	}
	
	@Test
	public void testTextInverseWithNumbersLowerCase() {
		assertEquals("fed4321cba", textTransformer.inverse("abc1234def"));
	}
	
	@Test
	public void testTextInverseWithNumbersUpperCase() {
		assertEquals("NML987kjIHG", textTransformer.inverse("GHIJK789LMN"));
	}
	
	@Test
	public void testTextInverseWithNumbersMixedCase() {
		assertEquals("Nml987kjIHG", textTransformer.inverse("GhiJK789LMN"));
	}
	
	@Test
	public void testTextInverseWithSymbolsLowerCase() {
		assertEquals("gfed#@!cba", textTransformer.inverse("abc!@#defg"));
	}
	
	@Test
	public void testTextInverseWithSymbolsUpperCase() {
		assertEquals("rewqLKJ)(*&", textTransformer.inverse("&*()JKLQWER"));
	}
	
	@Test
	public void testTextInverseWithSymbolsMixedCase() {
		assertEquals("aAsjg((&^Lph", textTransformer.inverse("hPl^&((GJSaa"));
	}	
}