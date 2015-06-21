package com.mauriciotogneri.jan.compiler.lexical;

import com.mauriciotogneri.jan.compiler.lexical.Token.Type;
import com.mauriciotogneri.jan.compiler.lexical.states.InitialState;

import java.util.List;

public abstract class State
{
	private final int line;
	private final int column;
	private final StringBuilder lexeme = new StringBuilder();
	private final List<Token> tokens;

	protected State(List<Token> tokens, int line, int column)
	{
		this.tokens = tokens;
		this.line = line;
		this.column = column;
	}
	
	protected int getLine()
	{
		return line;
	}
	
	protected int getColumn()
	{
		return column;
	}
	
	protected void addCharacter(Character character)
	{
		lexeme.append(character.toString());
	}
	
	protected void setLexeme(String newLexeme)
	{
		lexeme.setLength(0);
		lexeme.append(newLexeme);
	}
	
	protected String getLexeme()
	{
		return lexeme.toString();
	}
	
	protected List<Token> getTokens()
	{
		return tokens;
	}
	
	private void addToken(Type type, Character character, int line, int column)
	{
		tokens.add(new Token(character.toString(), type, line, column));
	}
	
	protected void addToken(Type type)
	{
		tokens.add(new Token(getLexeme(), type, line, column));
	}
	
	protected State createToken(Character character, int line, int column)
	{
		addToken(character.getDelimiterType(), character, line, column);
		
		return new InitialState(tokens, line, column);
	}
	
	protected State createToken(Character character, Type type, int line, int column)
	{
		addToken(type);
		addToken(character.getDelimiterType(), character, line, column);
		
		return new InitialState(tokens, line, column);
	}
	
	public abstract State process(Character character, int line, int column);
}