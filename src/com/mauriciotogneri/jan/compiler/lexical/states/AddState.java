package com.mauriciotogneri.jan.compiler.lexical.states;

import java.util.List;
import com.mauriciotogneri.jan.compiler.lexical.LexicalException;
import com.mauriciotogneri.jan.compiler.lexical.State;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.lexical.Token.Type;

public class AddState extends State
{
	public AddState(List<Token> tokens, int line, int column)
	{
		super(tokens, line, column);
		
		addCharacter(PLUS);
	}
	
	@Override
	public State process(char character, int line, int column)
	{
		if (character == PLUS)
		{
			return new IncrementState(getTokens(), line, column);
		}
		else if (isDelimiter(character))
		{
			return createToken(character, Type.ARITHMETIC_ADD, line, column);
		}
		else
		{
			throw new LexicalException(character, line, column);
		}
	}
}