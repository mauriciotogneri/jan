package com.mauriciotogneri.jan.compiler.lexical.states;

import java.util.List;
import com.mauriciotogneri.jan.compiler.lexical.State;
import com.mauriciotogneri.jan.compiler.lexical.Token;

public class InitialState extends State
{
	public InitialState(int line, int column)
	{
		super(line, column);
	}
	
	@Override
	public State process(List<Token> tokens, char character, int line, int column)
	{
		State state = this;
		
		if (character == OPEN_PARENTHESES)
		{
			// setToken(Type.OPEN_PARENTHESES, character, line, column);
		}
		else if (character == CLOSE_PARENTHESES)
		{
			// setToken(Type.CLOSE_PARENTHESES, character, line, column);
		}
		else if (isLetter(character))
		{
			// state = new IdentifierState(this.automata, line, column, character);
		}
		else if (!isDelimiter(character))
		{
			throw new RuntimeException(line + " " + column); // TODO
		}
		
		return state;
	}
}