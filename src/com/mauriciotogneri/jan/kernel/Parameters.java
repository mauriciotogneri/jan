package com.mauriciotogneri.jan.kernel;

import java.util.ArrayList;
import java.util.List;
import com.mauriciotogneri.jan.compiler.lexical.Token;

public class Parameters
{
	private final List<Token> parameters = new ArrayList<>();
	
	public void add(Token name)
	{
		this.parameters.add(name);
	}
	
	public int getSize()
	{
		return this.parameters.size();
	}
	
	public boolean containsParameter(String name)
	{
		for (Token token : this.parameters)
		{
			if (token.lexeme.equals(name))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public int getIndex(String name)
	{
		for (int i = 0; i < this.parameters.size(); i++)
		{
			Token token = this.parameters.get(i);
			
			if (token.lexeme.equals(name))
			{
				return i;
			}
		}
		
		return -1;
	}
}