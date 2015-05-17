package com.mauriciotogneri.jan.compiler.definitions;

import java.util.ArrayList;
import java.util.List;
import com.mauriciotogneri.jan.compiler.lexical.Token;

public class ParametersDefinition
{
	private final List<Token> parameters = new ArrayList<>();
	
	public void add(Token name)
	{
		this.parameters.add(name);
	}
}