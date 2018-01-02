package pl.put.poznan.transformer.logic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestTextTransformerAbbreviation {

	private String textBeforeTransformation;
	private String textAfterTransformation;
	
	TextTransformerAbbreviation textTransformer = new TextTransformerAbbreviation(null);
	
	@Test
	public void testToAbbreviationProfesorLowerCase() {
		textBeforeTransformation = "profesor";
		textAfterTransformation = textTransformer.toAbbreviation(textBeforeTransformation);
		assertEquals("prof.", textAfterTransformation);
	}
	
	@Test
	public void testToAbbreviationProfesorUpperCase() {
		textBeforeTransformation = "Profesor";
		textAfterTransformation = textTransformer.toAbbreviation(textBeforeTransformation);
		assertEquals("Prof.", textAfterTransformation);
	}
	
	@Test
	public void testToAbbreviationDoctorLowerCase() {
		textBeforeTransformation = "doktor";
		textAfterTransformation = textTransformer.toAbbreviation(textBeforeTransformation);
		assertEquals("dr", textAfterTransformation);
	}
	
	@Test
	public void testToAbbreviationDoctorUpperCase() {
		textBeforeTransformation = "Doktor";
		textAfterTransformation = textTransformer.toAbbreviation(textBeforeTransformation);
		assertEquals("Dr", textAfterTransformation);
	}
	
	@Test
	public void testToAbbreviationNaPrzykladUpperCase() {
		textBeforeTransformation = "na przyklad";
		textAfterTransformation = textTransformer.toAbbreviation(textBeforeTransformation);
		assertEquals("np.", textAfterTransformation);
	}
	
	@Test
	public void testToAbbreviationNaPrzykladLowerCase() {
		textBeforeTransformation = "Na przyklad";
		textAfterTransformation = textTransformer.toAbbreviation(textBeforeTransformation);
		assertEquals("Np.", textAfterTransformation);
	}
	
	@Test
	public void testToAbbreviationITymPodobneLowerCase() {
		textBeforeTransformation = "i tym podobne";
		textAfterTransformation = textTransformer.toAbbreviation(textBeforeTransformation);
		assertEquals("itp.", textAfterTransformation);
	}
	
	@Test
	public void testToAbbreviationITymPodobneUpperCase() {
		textBeforeTransformation = "I tym podobne";
		textAfterTransformation = textTransformer.toAbbreviation(textBeforeTransformation);
		assertEquals("Itp.", textAfterTransformation);
	}
	
	@Test
	public void testToAbbreviationNoAbbreviations() {
		textBeforeTransformation = "Text without any abbreviations profesr na przykld i tym  dktor podobne";
		textAfterTransformation = textTransformer.toAbbreviation(textBeforeTransformation);
		assertEquals(textBeforeTransformation, textAfterTransformation);
	}

	@Test
	public void testFromAbbreviationProfesorLowerCase() {
		textBeforeTransformation = "prof.";
		textAfterTransformation = textTransformer.fromAbbreviation(textBeforeTransformation);
		assertEquals("profesor", textAfterTransformation);
	}
	
	@Test
	public void testFromAbbreviationProfesorUpperCase() {
		textBeforeTransformation = "Prof.";
		textAfterTransformation = textTransformer.fromAbbreviation(textBeforeTransformation);
		assertEquals("Profesor", textAfterTransformation);
	}
	
	@Test
	public void testFromAbbreviationDoctorLowerCase() {
		textBeforeTransformation = "dr";
		textAfterTransformation = textTransformer.fromAbbreviation(textBeforeTransformation);
		assertEquals("doktor", textAfterTransformation);
	}
	
	@Test
	public void testFromAbbreviationDoctorUpperCase() {
		textBeforeTransformation = "Dr";
		textAfterTransformation = textTransformer.fromAbbreviation(textBeforeTransformation);
		assertEquals("Doktor", textAfterTransformation);
	}
	
	@Test
	public void testFromAbbreviationNaPrzykladUpperCase() {
		textBeforeTransformation = "np.";
		textAfterTransformation = textTransformer.fromAbbreviation(textBeforeTransformation);
		assertEquals("na przyklad", textAfterTransformation);
	}
	
	@Test
	public void testFromAbbreviationNaPrzykladLowerCase() {
		textBeforeTransformation = "Np.";
		textAfterTransformation = textTransformer.fromAbbreviation(textBeforeTransformation);
		assertEquals("Na przyklad", textAfterTransformation);
	}
	
	@Test
	public void testFromAbbreviationITymPodobneLowerCase() {
		textBeforeTransformation = "itp.";
		textAfterTransformation = textTransformer.fromAbbreviation(textBeforeTransformation);
		assertEquals("i tym podobne", textAfterTransformation);
	}
	
	@Test
	public void testFromAbbreviationITymPodobneUpperCase() {
		textBeforeTransformation = "Itp.";
		textAfterTransformation = textTransformer.fromAbbreviation(textBeforeTransformation);
		assertEquals("I tym podobne", textAfterTransformation);
	}
	
	@Test
	public void testFromAbbreviationNoAbbreviations() {
		textBeforeTransformation = "Text without any abbreviations d. np itp prof";
		textAfterTransformation = textTransformer.fromAbbreviation(textBeforeTransformation);
		assertEquals(textBeforeTransformation, textAfterTransformation);
	}

}