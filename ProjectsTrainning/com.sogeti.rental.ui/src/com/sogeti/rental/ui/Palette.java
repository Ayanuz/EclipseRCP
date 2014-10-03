package com.sogeti.rental.ui;

import org.eclipse.jface.viewers.IColorProvider;

public class Palette {
	private String id, name;
	private IColorProvider color_provider;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public IColorProvider getColor_provider() {
		return color_provider;
	}

	public void setColor_provider(IColorProvider color_provider) {
		this.color_provider = color_provider;
	}

}
