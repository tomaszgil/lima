package pl.put.poznan.transformer.logic;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestTextTransformerLetterSize {

	private String textBeforeTransformation;
	private String textAfterTransformation;
	
	TextTransformerLetterSize textTransformer = new TextTransformerLetterSize(null);	
	
	@Test
	public void testUpperCaseToLowerCase() {
		textBeforeTransformation = "QWERTYUIOP";
		textAfterTransformation = textTransformer.lower(textBeforeTransformation);
		char[] CharsAfterTransformation = textAfterTransformation.toCharArray();
		for (int i = 0; i<textBeforeTransformation.length(); i++) {
			assertTrue("Character " + CharsAfterTransformation[i] + " is not transformed to lowercase as it should be.", Character.isLowerCase(CharsAfterTransformation[i]));
		}
	}
	
	@Test
	public void testLowerCaseToUpperCase() {
		textBeforeTransformation = "qwertyuiop";
		textAfterTransformation = textTransformer.upper(textBeforeTransformation);
		char[] CharsAfterTransformation = textAfterTransformation.toCharArray();
		for (int i = 0; i<textBeforeTransformation.length(); i++) {
			assertTrue("Character " + CharsAfterTransformation[i] + " is not transformed to uppercase as it should be.", Character.isUpperCase(CharsAfterTransformation[i]));
		}
	}
	
	@Test
	public void testCapitalize() {
		textBeforeTransformation = "let's check if capitalize method is working.";
		textAfterTransformation = textTransformer.capitalize(textBeforeTransformation);
		char[] CharsAfterTransformation = textAfterTransformation.toCharArray();
		assertTrue("Character " + CharsAfterTransformation[0] + " is not transformed to uppercase as it should be.", Character.isUpperCase(CharsAfterTransformation[0]));
        for(int i=1; i<CharsAfterTransformation.length; i++) {
            if (CharsAfterTransformation[i-1] == ' ') {
        		assertTrue("Character " + CharsAfterTransformation[i] + " is not transformed to uppercase as it should be.", Character.isUpperCase(CharsAfterTransformation[i]));
            }
        }
	}
	
}
