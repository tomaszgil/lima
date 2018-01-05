package pl.put.poznan.transformer.logic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

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
}