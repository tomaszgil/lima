package pl.put.poznan.transformer.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestTextTransformerLetterSize {
	
	TextTransformerLetterSize textTransformer = new TextTransformerLetterSize(null);	
	
	@Test
	public void testUpperCaseToLowerCase() {
		assertEquals("qwertyuiop", textTransformer.lower("QWERTYUIOP"));
	}
	
	@Test
	public void testLowerCaseToUpperCase() {
		assertEquals("QWERTYUIOP", textTransformer.upper("qwertyuiop"));
	}
	
	@Test
	public void testCapitalize() {
		assertEquals("Let's Check If Capitalize Method Is Working.", textTransformer.capitalize("let's check if capitalize method is working."));

	}
	
}
