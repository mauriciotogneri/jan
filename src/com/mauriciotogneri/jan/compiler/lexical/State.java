package com.mauriciotogneri.jan.compiler.lexical;

import java.util.List;
import com.mauriciotogneri.jan.compiler.lexical.Token.Type;
import com.mauriciotogneri.jan.compiler.lexical.states.InitialState;

public abstract class State
{
	private final int line;
	private final int column;
	private final StringBuilder lexeme = new StringBuilder();
	private final List<Token> tokens;
	
	public State(List<Token> tokens, int line, int column)
	{
		this.tokens = tokens;
		this.line = line;
		this.column = column;
	}
	
	protected int getLine()
	{
		return this.line;
	}
	
	protected int getColumn()
	{
		return this.column;
	}
	
	protected void addCharacter(Character character)
	{
		this.lexeme.append(character.toString());
	}
	
	protected void setLexeme(String lexeme)
	{
		this.lexeme.setLength(0);
		this.lexeme.append(lexeme);
	}
	
	protected String getLexeme()
	{
		return this.lexeme.toString();
	}
	
	protected List<Token> getTokens()
	{
		return this.tokens;
	}
	
	protected void addToken(Type type, Character character, int line, int column)
	{
		this.tokens.add(new Token(character.toString(), type, line, column));
	}
	
	protected void addToken(Type type)
	{
		this.tokens.add(new Token(getLexeme(), type, this.line, this.column));
	}
	
	protected State createToken(Character character, int line, int column)
	{
		addToken(character.getDelimiterType(), character, line, column);
		
		return new InitialState(this.tokens, line, column);
	}
	
	protected State createToken(Character character, Type type, int line, int column)
	{
		addToken(type);
		addToken(character.getDelimiterType(), character, line, column);
		
		return new InitialState(this.tokens, line, column);
	}
	
	public abstract State process(Character character, int line, int column);
}