package com.mauriciotogneri.jan.compiler.lexical;

public class LexicalException extends RuntimeException
{
	private static final long serialVersionUID = -1999285208964229934L;
	
	public final char character;
	public final int line;
	public final int column;
	
	public LexicalException(char character, int line, int column)
	{
		super("Lexical error. Invalid character '" + Token.getCharacter(character) + "' at: [" + line + ", " + column + "]");
		
		this.character = character;
		this.line = line;
		this.column = column;
	}
}