package com.mauriciotogneri.jan.compiler.lexical.states;

import java.util.List;
import com.mauriciotogneri.jan.compiler.lexical.Character;
import com.mauriciotogneri.jan.compiler.lexical.LexicalException;
import com.mauriciotogneri.jan.compiler.lexical.State;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.lexical.Token.Type;

public class SymbolState extends State
{
	public SymbolState(List<Token> tokens, Character character, int line, int column)
	{
		super(tokens, line, column);
		
		addCharacter(character);
	}
	
	@Override
	public State process(Character character, int line, int column)
	{
		if (character.isLetter() || character.isDigit() || (character == Character.UNDERSCORE))
		{
			addCharacter(character);
			
			return this;
		}
		else if (character.isDelimiter())
		{
			return createToken(character, Type.SYMBOL, line, column);
		}
		else
		{
			throw new LexicalException(character, line, column);
		}
	}
}