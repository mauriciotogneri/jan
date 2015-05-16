package com.mauriciotogneri.jan.compiler.lexical.states;

import java.util.List;
import com.mauriciotogneri.jan.compiler.lexical.Character;
import com.mauriciotogneri.jan.compiler.lexical.LexicalException;
import com.mauriciotogneri.jan.compiler.lexical.State;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.lexical.Token.Type;

public class FloatState extends State
{
	public FloatState(List<Token> tokens, String lexeme, int line, int column)
	{
		super(tokens, line, column);
		
		setLexeme(lexeme);
	}
	
	@Override
	public State process(Character character, int line, int column)
	{
		if (character.isDigit())
		{
			addCharacter(character);
			
			return this;
		}
		else if (character.isDelimiter())
		{
			return createToken(character, Type.FLOAT, line, column);
		}
		else
		{
			throw new LexicalException(character, line, column);
		}
	}
}