package com.mauriciotogneri.jan.compiler.lexical;

public class LexicalException extends RuntimeException
{
	private static final long serialVersionUID = -1999285208964229934L;
	
	public LexicalException(int line, int column)
	{
		super("Lexical error at: [" + line + ", " + column + "]");
	}
}