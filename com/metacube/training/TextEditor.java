package com.metacube.training;

public class TextEditor {
	private String type;
	SpellChecker sc1;
	SpellChecker sc2;
	SpellChecker sc3;
	
	
	/**
	 * @return the sc1
	 */
	public SpellChecker getSc1() {
		return sc1;
	}
	/**
	 * @param sc1 the sc1 to set
	 */
	public void setSc1(SpellChecker sc1) {
		this.sc1 = sc1;
	}
	/**
	 * @return the sc2
	 */
	public SpellChecker getSc2() {
		return sc2;
	}
	/**
	 * @param sc2 the sc2 to set
	 */
	public void setSc2(SpellChecker sc2) {
		this.sc2 = sc2;
	}
	/**
	 * @return the sc3
	 */
	public SpellChecker getSc3() {
		return sc3;
	}
	/**
	 * @param sc3 the sc3 to set
	 */
	public void setSc3(SpellChecker sc3) {
		this.sc3 = sc3;
	}
	
	//constructor
	
	/*public TextEditor(String type) {
		this.type = type;
	}*/
	
	//returning the variable type
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void textEditor() {
		System.out.println(getType() + ", You have entered the editor");
		System.out.println(getSc3().getA() + " " + getSc3().getB());
		System.out.println(getSc2().getA() + " " + getSc2().getB());
		System.out.println(getSc1().getA() + " " + getSc1().getB());
	}
}
