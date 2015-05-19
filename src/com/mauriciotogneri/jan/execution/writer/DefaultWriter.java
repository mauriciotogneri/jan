package com.mauriciotogneri.jan.execution.writer;

public class DefaultWriter implements Writer
{
	@Override
	public void printValue(String text)
	{
		System.out.print(text);
	}
	
	@Override
	public void printError(String text)
	{
		System.err.print(text);
	}
}