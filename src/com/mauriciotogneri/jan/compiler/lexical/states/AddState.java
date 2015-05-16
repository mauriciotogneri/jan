package com.mauriciotogneri.jan.compiler.lexical.states;

import java.util.List;
import com.mauriciotogneri.jan.compiler.lexical.Character;
import com.mauriciotogneri.jan.compiler.lexical.LexicalException;
import com.mauriciotogneri.jan.compiler.lexical.State;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.lexical.Token.Type;

public class AddState extends State
{
	public AddState(List<Token> tokens, int line, int column)
	{
		super(tokens, line, column);
		
		addCharacter(Character.PLUS);
	}
	
	@Override
	public State process(Character character, int line, int column)
	{
		if (character == Character.PLUS)
		{
			return new IncrementState(getTokens(), line, column);
		}
		else if (character.isDelimiter())
		{
			return createToken(character, Type.ARITHMETIC_ADD, line, column);
		}
		else
		{
			throw new LexicalException(character, line, column);
		}
	}
}