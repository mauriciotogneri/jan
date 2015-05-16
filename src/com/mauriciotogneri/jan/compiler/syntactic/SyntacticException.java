package com.mauriciotogneri.jan.compiler.syntactic;

import com.mauriciotogneri.jan.compiler.lexical.Token;

public class SyntacticException extends RuntimeException
{
	private static final long serialVersionUID = -4336303078381836231L;
	
	public final Token token;
	
	public SyntacticException(Token token)
	{
		super("Invalid token '" + token + "' at: [" + token.line + ", " + token.column + "]");
		
		this.token = token;
	}
}