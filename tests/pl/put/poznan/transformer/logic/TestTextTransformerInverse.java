package pl.put.poznan.transformer.logic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestTextTransformerInverse {

	private String textBeforeTransformation;
	private String textAfterTransformation;
	
	TextTransformerInverse textTransformer = new TextTransformerInverse(null);	
	
	public String inverse(String text) {
	    char[] input = text.toCharArray();
	    char[] output = text.toCharArray();
	    int begin = 0;
	    int end = input.length-1;
	    char temp;
	    while(end>begin) {
	    	temp = input[begin];
	    	output[begin]=input[end];
	    	output[end] = temp;
	    	end--;
	    	begin++;
	    }
	    for (int i = 0; i<input.length; i++) {
	    	if (Character.isUpperCase(input[i])) {
	    		output[i] = Character.toUpperCase(output[i]);
	    	}
		    else if (Character.isLowerCase(input[i])) {
		    	output[i] = Character.toLowerCase(output[i]);
		    }
	    }
	    return new String(output);
	}

	@Test
	public void testTextInverseLettersAllLowerCase() {
		textBeforeTransformation = "abcdefgh";
		textAfterTransformation = textTransformer.inverse(textBeforeTransformation);
		assertEquals(this.inverse(textBeforeTransformation), textAfterTransformation);
	}
	
	@Test
	public void testTextInverseLettersAllUpperCase() {
		textBeforeTransformation = "ABCDEFGH";
		textAfterTransformation = textTransformer.inverse(textBeforeTransformation);
		assertEquals(this.inverse(textBeforeTransformation), textAfterTransformation);
	}

	@Test
	public void testTextInverseLettersMixedCase() {
		textBeforeTransformation = "ABCdEfghIJk";
		textAfterTransformation = textTransformer.inverse(textBeforeTransformation);
		assertEquals(this.inverse(textBeforeTransformation), textAfterTransformation);
	}
	
	@Test
	public void testTextInverseWithNumbersLowerCase() {
		textBeforeTransformation = "abc1234def";
		textAfterTransformation = textTransformer.inverse(textBeforeTransformation);
		assertEquals(this.inverse(textBeforeTransformation), textAfterTransformation);
	}
	
	@Test
	public void testTextInverseWithNumbersUpperCase() {
		textBeforeTransformation = "GHIJK789LMN";
		textAfterTransformation = textTransformer.inverse(textBeforeTransformation);
		assertEquals(this.inverse(textBeforeTransformation), textAfterTransformation);
	}
	
	@Test
	public void testTextInverseWithNumbersMixedCase() {
		textBeforeTransformation = "GhiJK789LMN";
		textAfterTransformation = textTransformer.inverse(textBeforeTransformation);
		assertEquals(this.inverse(textBeforeTransformation), textAfterTransformation);
	}
	
	@Test
	public void testTextInverseWithSymbolsLowerCase() {
		textBeforeTransformation = "abc!@#defg";
		textAfterTransformation = textTransformer.inverse(textBeforeTransformation);
		assertEquals(this.inverse(textBeforeTransformation), textAfterTransformation);
	}
	
	@Test
	public void testTextInverseWithSymbolsUpperCase() {
		textBeforeTransformation = "&*()JKLQWER";
		textAfterTransformation = textTransformer.inverse(textBeforeTransformation);
		assertEquals(this.inverse(textBeforeTransformation), textAfterTransformation);
	}
	
	@Test
	public void testTextInverseWithSymbolsMixedCase() {
		textBeforeTransformation = "hPl^&((GJSaa";
		textAfterTransformation = textTransformer.inverse(textBeforeTransformation);
		assertEquals(this.inverse(textBeforeTransformation), textAfterTransformation);
	}	
}