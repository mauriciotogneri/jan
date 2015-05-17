package com.mauriciotogneri.jan.compiler.lexical;

import java.util.ArrayList;
import java.util.List;
import com.mauriciotogneri.jan.compiler.lexical.states.InitialState;

public class StateMachine
{
	private int line = 1;
	private int column = 0;
	
	public List<Token> getTokens(char[] characters)
	{
		List<Token> tokens = new ArrayList<Token>();
		State state = new InitialState(tokens, this.line, this.column);
		
		for (char chr : characters)
		{
			Character character = Character.get(chr);
			
			if (character != null)
			{
				if (character == Character.NEW_LINE)
				{
					this.line++;
					this.column = 0;
				}
				
				if (character == Character.TAB)
				{
					this.column += 3;
				}
				
				if (!character.isNewLine())
				{
					this.column++;
				}
				
				state = state.process(character, this.line, this.column);
			}
			else
			{
				throw new LexicalException(chr, this.line, this.column);
			}
		}
		
		state.process(Character.NEW_LINE, this.line, this.column);
		
		return tokens;
	}
}