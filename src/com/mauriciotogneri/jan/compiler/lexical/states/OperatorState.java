package com.mauriciotogneri.jan.compiler.lexical.states;

import java.util.List;
import com.mauriciotogneri.jan.compiler.lexical.LexicalException;
import com.mauriciotogneri.jan.compiler.lexical.State;
import com.mauriciotogneri.jan.compiler.lexical.Token;

public class OperatorState extends State
{
	public OperatorState(List<Token> tokens, char character, int line, int column)
	{
		super(tokens, line, column);
		
		addCharacter(character);
	}
	
	@Override
	public State process(char character, int line, int column)
	{
		if (isDelimiter(character))
		{
			return createToken(character, getOperatorType(getLexeme().charAt(0)), line, column);
		}
		else
		{
			throw new LexicalException(character, line, column);
		}
	}
}