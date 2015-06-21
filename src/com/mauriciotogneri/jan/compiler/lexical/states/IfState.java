package com.mauriciotogneri.jan.compiler.lexical.states;

import com.mauriciotogneri.jan.compiler.lexical.Character;
import com.mauriciotogneri.jan.compiler.lexical.LexicalException;
import com.mauriciotogneri.jan.compiler.lexical.State;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.lexical.Token.Type;

import java.util.List;

public class IfState extends State
{
	public IfState(List<Token> tokens, int line, int column)
	{
		super(tokens, line, column);
		
		addCharacter(Character.QUESTION);
	}
	
	@Override
	public State process(Character character, int line, int column)
	{
		if (character == Character.QUESTION)
		{
			return new IfElseState(getTokens(), line, column);
		}
		else if (character.isDelimiter())
		{
			return createToken(character, Type.CONDITIONAL_IF, line, column);
		}
		else
		{
			throw new LexicalException(character, line, column);
		}
	}
}