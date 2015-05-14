package com.mauriciotogneri.jan.kernel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Expression
{
	private final List<ExpressionElement> elements = new ArrayList<>();
	
	public void add(ExpressionElement element)
	{
		this.elements.add(element);
	}
	
	public void closeExpression()
	{
		Collections.reverse(this.elements);
	}
	
	public List<ExpressionElement> getElements()
	{
		return this.elements;
	}
}