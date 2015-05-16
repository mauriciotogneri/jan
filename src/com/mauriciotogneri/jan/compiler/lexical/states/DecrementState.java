package com.mauriciotogneri.jan.compiler.lexical.states;

import java.util.List;
import com.mauriciotogneri.jan.compiler.lexical.LexicalException;
import com.mauriciotogneri.jan.compiler.lexical.State;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.lexical.Token.Type;

public class DecrementState extends State
{
	public DecrementState(List<Token> tokens, int line, int column)
	{
		super(tokens, line, column);
		
		setLexeme(String.valueOf(MINUS) + String.valueOf(MINUS));
	}
	
	@Override
	public State process(char character, int line, int column)
	{
		if (isDelimiter(character))
		{
			return createToken(character, Type.ARITHMETIC_DECREMENT, line, column);
		}
		else
		{
			throw new LexicalException(character, line, column);
		}
	}
}