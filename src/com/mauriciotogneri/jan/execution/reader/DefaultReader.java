package com.mauriciotogneri.jan.execution.reader;

import java.util.Scanner;

public class DefaultReader implements Reader
{
	private static final String PROMPT = "> ";
	
	private final Scanner scanner = new Scanner(System.in);
	
	@Override
	public String readExpression()
	{
		System.out.print("\n\n" + PROMPT);
		
		return this.scanner.nextLine();
	}
	
	@Override
	public void close()
	{
		this.scanner.close();
	}
}