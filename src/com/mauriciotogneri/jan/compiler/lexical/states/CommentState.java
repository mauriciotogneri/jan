package com.mauriciotogneri.jan.compiler.lexical.states;

import java.util.List;
import com.mauriciotogneri.jan.compiler.lexical.Character;
import com.mauriciotogneri.jan.compiler.lexical.State;
import com.mauriciotogneri.jan.compiler.lexical.Token;

public class CommentState extends State
{
	public CommentState(List<Token> tokens, int line, int column)
	{
		super(tokens, line, column);
	}
	
	@Override
	public State process(Character character, int line, int column)
	{
		if (character.isNewLine())
		{
			addToken(character.getDelimiterType(), character, line, column);
			
			return new InitialState(getTokens(), line, column);
		}
		else
		{
			return this;
		}
	}
}