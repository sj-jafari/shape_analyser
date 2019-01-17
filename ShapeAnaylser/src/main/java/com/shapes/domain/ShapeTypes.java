package com.shapes.domain;

/**
 * <h1>An enum type presenting the possible types of a {@link Shape}</h1>
 * <p>
 * Each type also has a description which can be used in UIs and messages.
 * </p>
 * 
 * @author Jalal
 * @since 20190117
 * @version 1.0
 */
public enum ShapeTypes {
	Equilateral_Triangle("Equilateral Triangle"), 
	Scalene_Triangle("Scalene Triangle"),
	Isosceles_Triangle("Isosceles Triangle"),
	Polygon("Polygon");
	
	private String description;

	ShapeTypes(String description) {
		this.setDescription(description);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
