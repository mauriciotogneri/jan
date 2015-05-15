package com.mauriciotogneri.jan.compiler.lexical.states;

import java.util.List;
import com.mauriciotogneri.jan.compiler.lexical.State;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.lexical.Token.Type;

public class AddState extends State
{
	public AddState(int line, int column)
	{
		super(line, column);
		
		addCharacter(PLUS);
	}
	
	@Override
	public State process(List<Token> tokens, char character, int line, int column)
	{
		State state = this;
		
		if (isDigit(character))
		{
			addToken(tokens, Type.ARITHMETIC_ADD);
			// state = new IntegerState(this.automata, line, column, character);
		}
		else if (isLetter(character))
		{
			addToken(tokens, Type.ARITHMETIC_ADD);
			// state = new IdentifierState(this.automata, line, column, character);
		}
		else
		{
			throw new RuntimeException(line + " " + column); // TODO
		}
		
		return state;
	}
}