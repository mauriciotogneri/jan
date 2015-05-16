package com.mauriciotogneri.jan.compiler.lexical.states;

import java.util.List;
import com.mauriciotogneri.jan.compiler.lexical.Character;
import com.mauriciotogneri.jan.compiler.lexical.LexicalException;
import com.mauriciotogneri.jan.compiler.lexical.State;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.lexical.Token.Type;

public class SubstractState extends State
{
	public SubstractState(List<Token> tokens, int line, int column)
	{
		super(tokens, line, column);
		
		addCharacter(Character.MINUS);
	}
	
	@Override
	public State process(Character character, int line, int column)
	{
		if (character == Character.MINUS)
		{
			return new DecrementState(getTokens(), line, column);
		}
		else if (character.isDigit())
		{
			addCharacter(character);
			
			return new IntegerState(getTokens(), getLexeme(), line, column);
		}
		else if (character.isDelimiter())
		{
			return createToken(character, Type.ARITHMETIC_SUBSTRACT, line, column);
		}
		else
		{
			throw new LexicalException(character, line, column);
		}
	}
}