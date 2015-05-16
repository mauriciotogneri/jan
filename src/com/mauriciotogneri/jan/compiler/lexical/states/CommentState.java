package com.mauriciotogneri.jan.compiler.lexical.states;

import java.util.List;
import com.mauriciotogneri.jan.compiler.lexical.State;
import com.mauriciotogneri.jan.compiler.lexical.Token;

public class CommentState extends State
{
	public CommentState(List<Token> tokens, int line, int column)
	{
		super(tokens, line, column);
	}
	
	@Override
	public State process(char character, int line, int column)
	{
		if ((character == NEW_LINE) || (character == CARRIAGE_RETURN))
		{
			addToken(getDelimiterType(character), character, line, column);
			
			return new InitialState(getTokens(), line, column);
		}
		else
		{
			return this;
		}
	}
}