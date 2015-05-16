package com.mauriciotogneri.jan.compiler.lexical.states;

import java.util.List;
import com.mauriciotogneri.jan.compiler.lexical.Character;
import com.mauriciotogneri.jan.compiler.lexical.LexicalException;
import com.mauriciotogneri.jan.compiler.lexical.State;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.lexical.Token.Type;

public class GreaterState extends State
{
	public GreaterState(List<Token> tokens, int line, int column)
	{
		super(tokens, line, column);
		
		addCharacter(Character.GREATER);
	}
	
	@Override
	public State process(Character character, int line, int column)
	{
		if (character == Character.EQUAL)
		{
			return new GreaterEqualState(getTokens(), line, column);
		}
		else if (character.isDelimiter())
		{
			return createToken(character, Type.LOGIC_GREATER, line, column);
		}
		else
		{
			throw new LexicalException(character, line, column);
		}
	}
}