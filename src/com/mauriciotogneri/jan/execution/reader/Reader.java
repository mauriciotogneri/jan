package com.mauriciotogneri.jan.execution.reader;

public interface Reader
{
	String readExpression();
	
	void close();
}