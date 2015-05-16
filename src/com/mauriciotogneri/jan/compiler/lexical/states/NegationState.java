package com.mauriciotogneri.jan.compiler.lexical.states;

import java.util.List;
import com.mauriciotogneri.jan.compiler.lexical.Character;
import com.mauriciotogneri.jan.compiler.lexical.LexicalException;
import com.mauriciotogneri.jan.compiler.lexical.State;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.lexical.Token.Type;

public class NegationState extends State
{
	public NegationState(List<Token> tokens, int line, int column)
	{
		super(tokens, line, column);
		
		addCharacter(Character.EXCLAMATION);
	}
	
	@Override
	public State process(Character character, int line, int column)
	{
		if (character == Character.EQUAL)
		{
			return new NotEqualState(getTokens(), line, column);
		}
		else if (character.isDelimiter())
		{
			return createToken(character, Type.LOGIC_NEGATION, line, column);
		}
		else
		{
			throw new LexicalException(character, line, column);
		}
	}
}