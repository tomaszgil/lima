package pl.put.poznan.transformer.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pl.put.poznan.transformer.logic.TextTransformerAbbreviation;

public class TestTextTransformerAbbreviation {
	
	TextTransformerAbbreviation textTransformer = new TextTransformerAbbreviation();
	
	@Test
	public void testToAbbreviationProfesorLowerCase() {
		assertEquals("prof.", textTransformer.toAbbreviation("profesor"));
	}
	
	@Test
	public void testToAbbreviationProfesorUpperCase() {
		assertEquals("Prof.", textTransformer.toAbbreviation("Profesor"));
	}
	
	@Test
	public void testToAbbreviationDoctorLowerCase() {
		assertEquals("dr", textTransformer.toAbbreviation("doktor"));
	}
	
	@Test
	public void testToAbbreviationDoctorUpperCase() {
		assertEquals("Dr", textTransformer.toAbbreviation("Doktor"));
	}
	
	@Test
	public void testToAbbreviationNaPrzykladLowerCase() {
		assertEquals("np.", textTransformer.toAbbreviation("na przykład"));
	}
	
	@Test
	public void testToAbbreviationNaPrzykladUpperCase() {
		assertEquals("Np.", textTransformer.toAbbreviation("Na przykład"));
	}
	
	@Test
	public void testToAbbreviationITymPodobneLowerCase() {
		assertEquals("itp.", textTransformer.toAbbreviation("i tym podobne"));
	}
	
	@Test
	public void testToAbbreviationITymPodobneUpperCase() {
		assertEquals("Itp.", textTransformer.toAbbreviation("I tym podobne"));
	}
	
	@Test
	public void testToAbbreviationNoAbbreviations() {
		assertEquals("Text without any abbreviations profesr na przykld i tym  dktor podobne", textTransformer.toAbbreviation("Text without any abbreviations profesr na przykld i tym  dktor podobne"));
	}

	@Test
	public void testFromAbbreviationProfesorLowerCase() {
		assertEquals("profesor", textTransformer.fromAbbreviation("prof."));
	}
	
	@Test
	public void testFromAbbreviationProfesorUpperCase() {
		assertEquals("Profesor", textTransformer.fromAbbreviation("Prof."));
	}
	
	@Test
	public void testFromAbbreviationDoctorLowerCase() {
		assertEquals("doktor", textTransformer.fromAbbreviation("dr"));
	}
	
	@Test
	public void testFromAbbreviationDoctorUpperCase() {
		assertEquals("Doktor", textTransformer.fromAbbreviation("Dr"));
	}
	
	@Test
	public void testFromAbbreviationNaPrzykladLowerCase() {
		assertEquals("na przykład", textTransformer.fromAbbreviation("np."));
	}
	
	@Test
	public void testFromAbbreviationNaPrzykladUpperCase() {
		assertEquals("Na przykład", textTransformer.fromAbbreviation("Np."));
	}
	
	@Test
	public void testFromAbbreviationITymPodobneLowerCase() {
		assertEquals("i tym podobne", textTransformer.fromAbbreviation("itp."));
	}
	
	@Test
	public void testFromAbbreviationITymPodobneUpperCase() {
		assertEquals("I tym podobne", textTransformer.fromAbbreviation("Itp."));
	}
	
	@Test
	public void testFromAbbreviationNoAbbreviations() {
		assertEquals("Text without any abbreviations d. np itp prof", textTransformer.fromAbbreviation("Text without any abbreviations d. np itp prof"));
	}

}