package com.metacube.training2;

import java.util.List;
import java.util.Set;

public class TextEditor2 {
	private List<SpellChecker2> sc;
	
	private Set<SpellChecker2> sco;

	/**
	 * @return the sc
	 */
	public List<SpellChecker2> getSc() {
		return sc;
	}

	/**
	 * @param sc the sc to set
	 */
	public void setSc(List<SpellChecker2> sc) {
		this.sc = sc;
	}
	
	public void textEditor2() {
		int i = 1;
		for(SpellChecker2 sc2 : sc) {
			System.out.println("spell checker " + i + " = " + sc2.getA() +", "+ sc2.getB());
			i++;
		}
	}
}
