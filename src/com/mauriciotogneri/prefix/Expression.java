package com.mauriciotogneri.prefix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Expression
{
	private final List<ExpressionElement> elements = new ArrayList<>();
	
	public Expression(String line)
	{
		this.elements.add(new Symbol("+"));
		this.elements.add(new IntValue(2));
		this.elements.add(new IntValue(3));
		
		Collections.reverse(this.elements);
	}
	
	public void add(ExpressionElement element)
	{
		this.elements.add(element);
	}
	
	public List<ExpressionElement> getElements()
	{
		return this.elements;
	}
}