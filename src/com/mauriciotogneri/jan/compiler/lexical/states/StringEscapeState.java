package com.mauriciotogneri.jan.compiler.lexical.states;

import java.util.List;
import com.mauriciotogneri.jan.compiler.lexical.Character;
import com.mauriciotogneri.jan.compiler.lexical.LexicalException;
import com.mauriciotogneri.jan.compiler.lexical.State;
import com.mauriciotogneri.jan.compiler.lexical.Token;

public class StringEscapeState extends State
{
	public StringEscapeState(List<Token> tokens, String lexeme, int line, int column)
	{
		super(tokens, line, column);
		
		setLexeme(lexeme);
	}
	
	@Override
	public State process(Character character, int line, int column)
	{
		if ((character == Character.NEW_LINE) || (character == Character.CARRIAGE_RETURN))
		{
			throw new LexicalException(character, line, column);
		}
		else
		{
			addCharacter(character);
			
			return new StringState(getTokens(), getLexeme(), line, column);
		}
	}
}