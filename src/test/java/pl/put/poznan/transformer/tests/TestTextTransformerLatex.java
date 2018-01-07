package pl.put.poznan.transformer.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pl.put.poznan.transformer.logic.TextTransformerLatex;

public class TestTextTransformerLatex {
	
	TextTransformerLatex textTransformer = new TextTransformerLatex();
	
	@Test
	public void testToLatexPercent() {
		assertEquals("\\%", textTransformer.toLatex("%"));
	}
	
	@Test
	public void testToLatexFloor() {
		assertEquals("\\_", textTransformer.toLatex("_"));
	}
	
	@Test
	public void testToLatexCurlyBracketLeft() {
		assertEquals("\\{", textTransformer.toLatex("{"));
	}
	
	@Test
	public void testToLatexCurlyBracketRight() {
		assertEquals("\\}", textTransformer.toLatex("}"));
	}
	
	@Test
	public void testToLatexHashtag() {
		assertEquals("\\#", textTransformer.toLatex("#"));
	}
	
	@Test
	public void testToLatexAnd() {
		assertEquals("\\&", textTransformer.toLatex("&"));
	}
	
	@Test
	public void testToLatexDollar() {
		assertEquals("\\$", textTransformer.toLatex("$"));
	}
	
	@Test
	public void testToLatexOnlySpecialCharacters() {
		assertEquals("\\%\\_\\{\\}\\#\\&\\$", textTransformer.toLatex("%_{}#&$"));
	}
	
	@Test
	public void testToLatexStringNoCharacters() {
		assertEquals("Example without any special character", textTransformer.toLatex("Example without any special character"));
	}
	
	@Test
	public void testToLatexStringCharacters() {
		assertEquals("Exa\\{mple with\\_special\\%characters", textTransformer.toLatex("Exa{mple with_special%characters"));
	}
}