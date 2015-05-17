package com.mauriciotogneri.jan.compiler.syntactic.definitions;

import java.util.ArrayList;
import java.util.List;
import com.mauriciotogneri.jan.compiler.lexical.Token;

public class ExpressionDefinition
{
	private final List<Token> elements = new ArrayList<>();
	
	public void addElement(Token token)
	{
		this.elements.add(token);
	}
	
	public boolean isEmpty()
	{
		return this.elements.isEmpty();
	}
}