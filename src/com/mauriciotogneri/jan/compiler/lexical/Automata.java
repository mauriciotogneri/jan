package com.mauriciotogneri.jan.compiler.lexical;

import java.util.ArrayList;
import java.util.List;
import com.mauriciotogneri.jan.compiler.lexical.states.InitialState;

public class Automata
{
	private int line = 1;
	private int column = 1;
	
	public List<Token> getTokens(char[] characters)
	{
		List<Token> tokens = new ArrayList<Token>();
		State state = new InitialState(tokens, this.line, this.column);
		
		for (char character : characters)
		{
			if (character == '\n')
			{
				this.line++;
				this.column = 1;
			}
			
			if (character == '\t')
			{
				this.column += 3;
			}
			
			if (!isNewLine(character))
			{
				this.column++;
			}
			
			state = state.process(character, this.line, this.column);
		}
		
		return tokens;
	}
	
	private boolean isNewLine(char character)
	{
		return (character == '\r') || (character == '\n');
	}
}