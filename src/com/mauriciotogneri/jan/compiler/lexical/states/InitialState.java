package com.mauriciotogneri.jan.compiler.lexical.states;

import java.util.List;
import com.mauriciotogneri.jan.compiler.lexical.LexicalException;
import com.mauriciotogneri.jan.compiler.lexical.State;
import com.mauriciotogneri.jan.compiler.lexical.Token;

public class InitialState extends State
{
	public InitialState(List<Token> tokens, int line, int column)
	{
		super(tokens, line, column);
	}
	
	@Override
	public State process(char character, int line, int column)
	{
		State state = this;
		
		if (isLetter(character))
		{
			state = new SymbolState(getTokens(), character, line, column);
		}
		else if (isDigit(character))
		{
			state = new IntegerState(getTokens(), character, line, column);
		}
		else
		{
			switch (character)
			{
				case SPACE | TAB:
					
					break;
				
				default:
					throw new LexicalException(line, column);
			}
		}
		
		return state;
	}
}