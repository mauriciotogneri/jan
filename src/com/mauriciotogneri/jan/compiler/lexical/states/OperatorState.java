package com.mauriciotogneri.jan.compiler.lexical.states;

import java.util.List;
import com.mauriciotogneri.jan.compiler.lexical.Character;
import com.mauriciotogneri.jan.compiler.lexical.LexicalException;
import com.mauriciotogneri.jan.compiler.lexical.State;
import com.mauriciotogneri.jan.compiler.lexical.Token;

public class OperatorState extends State
{
	public OperatorState(List<Token> tokens, Character character, int line, int column)
	{
		super(tokens, line, column);
		
		addCharacter(character);
	}
	
	@Override
	public State process(Character character, int line, int column)
	{
		if (character.isDelimiter())
		{
			return createToken(character, Character.get(getLexeme().charAt(0)).getOperatorType(), line, column);
		}
		else
		{
			throw new LexicalException(character, line, column);
		}
	}
}