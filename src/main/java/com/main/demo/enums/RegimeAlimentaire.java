package com.main.demo.enums;

public enum RegimeAlimentaire {

	C("C", "Carnivore"),
	H("H", "Herbivore"),
	O("O", "Omnivore");
	
	private String label;
	private String code;

	RegimeAlimentaire(String label, String code) {
		this.label = label;
		this.code = code;
	}

	
	public String getLabel() {
		return label;
	}
	
	public String getCode() {
		return code;
	}


	public RegimeAlimentaire mapFromCode(String code) {
		for(RegimeAlimentaire regimeAlimentaire : RegimeAlimentaire.values()) {
			if(regimeAlimentaire.getCode().equals(code)) {
				return regimeAlimentaire;
			}
		}
		
		throw new IllegalArgumentException("Code inconnu : " + code);
	}

	
	
	
}
