package com.mauriciotogneri.jan.compiler.lexical.states;

import java.util.List;
import com.mauriciotogneri.jan.compiler.lexical.Character;
import com.mauriciotogneri.jan.compiler.lexical.LexicalException;
import com.mauriciotogneri.jan.compiler.lexical.State;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.lexical.Token.Type;

public class IfElseState extends State
{
	public IfElseState(List<Token> tokens, int line, int column)
	{
		super(tokens, line, column);
		
		setLexeme(Character.QUESTION.toString() + Character.QUESTION.toString());
	}
	
	@Override
	public State process(Character character, int line, int column)
	{
		if (character.isDelimiter())
		{
			return createToken(character, Type.CONDITIONAL_IF_ELSE, line, column);
		}
		else
		{
			throw new LexicalException(character, line, column);
		}
	}
}