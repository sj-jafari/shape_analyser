package com.shapes.domain;

import com.shapes.exceptions.InvalidSideLengthException;

/**
 * <h1>This class defines a side for {@link Polygon}.</h1>
 * <p>
 * Although a side can be can be described with a simple {@link Integer} indicating its length, 
 * we may want to expand our design and consider more details for this attribute, such as its location and etc.
 * Therefore we consider a separated class for this entity. 
 * </p>
 * 
 * @author Jalal
 * @since 20190117
 * @version 1.0
 */
public class Side {
	private Integer length;

	/**
	 * Constructs a side
	 * @param length
	 * @throws InvalidSideLengthException
	 */
	public Side(Integer length) throws InvalidSideLengthException {
		if (length <= 0)
			throw new InvalidSideLengthException(length);
		this.length = length;
	}

	/**
	 * 
	 * @return the length of side
	 */
	public Integer getLength() {
		return length;
	}

	/**
	 * sets the side length.
	 * @param length
	 * @throws InvalidSideLengthException
	 */
	public void setLength(Integer length) throws InvalidSideLengthException {
		if (length <= 0)
			throw new InvalidSideLengthException(length);
		this.length = length;
	}
}
