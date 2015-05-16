package com.mauriciotogneri.jan.compiler.lexical.states;

import java.util.List;
import com.mauriciotogneri.jan.compiler.lexical.Character;
import com.mauriciotogneri.jan.compiler.lexical.LexicalException;
import com.mauriciotogneri.jan.compiler.lexical.State;
import com.mauriciotogneri.jan.compiler.lexical.Token;

public class StringState extends State
{
	public StringState(List<Token> tokens, int line, int column)
	{
		super(tokens, line, column);
	}
	
	public StringState(List<Token> tokens, String lexeme, int line, int column)
	{
		super(tokens, line, column);
		
		setLexeme(lexeme);
	}
	
	@Override
	public State process(Character character, int line, int column)
	{
		if (character == Character.DOUBLE_QUOTES)
		{
			return new StringEndState(getTokens(), getLexeme(), line, column);
		}
		else if (character == Character.BACK_SLASH)
		{
			addCharacter(character);
			
			return new StringEscapeState(getTokens(), getLexeme(), line, column);
		}
		else if (character.isNewLine())
		{
			throw new LexicalException(character, line, column);
		}
		else
		{
			addCharacter(character);
			
			return this;
		}
	}
}