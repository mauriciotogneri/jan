package com.mauriciotogneri.jan.compiler.lexical;

public class LexicalException extends RuntimeException
{
	private static final long serialVersionUID = -1999285208964229934L;
	
	public final Character character;
	public final int line;
	public final int column;
	
	public LexicalException(Character character, int line, int column)
	{
		super("Invalid character '" + character.getCharacter() + "' at: [" + line + ", " + column + "]");
		
		this.character = character;
		this.line = line;
		this.column = column;
	}
	
	public LexicalException(char character, int line, int column)
	{
		super("Illegal character '" + character + "' (" + ((int)character) + ") at: [" + line + ", " + column + "]");
		
		this.character = null;
		this.line = line;
		this.column = column;
	}
}