package com.mauriciotogneri.jan.compiler.lexical.states;

import java.util.List;
import com.mauriciotogneri.jan.compiler.lexical.LexicalException;
import com.mauriciotogneri.jan.compiler.lexical.State;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.lexical.Token.Type;

public class SymbolState extends State
{
	public SymbolState(List<Token> tokens, char character, int line, int column)
	{
		super(tokens, line, column);
		
		addCharacter(character);
	}
	
	@Override
	public State process(char character, int line, int column)
	{
		State state = this;
		
		if (isLetter(character) || isDigit(character) || (character == UNDERSCORE))
		{
			addCharacter(character);
		}
		else if (isDelimiter(character))
		{
			state = createToken(character, Type.SYMBOL, line, column);
		}
		else
		{
			throw new LexicalException(line, column);
		}
		
		return state;
	}
}