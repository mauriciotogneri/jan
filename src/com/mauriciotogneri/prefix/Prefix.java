package com.mauriciotogneri.prefix;

import java.util.Scanner;

public class Prefix
{
	private static final String PROMPT = "> ";
	
	public void run(String filePath)
	{
		Program program = new Program();
		program.parse(filePath);
		
		if (program.hasEntryPoint())
		{
			Value result = program.run();
			printResult(result);
		}
		
		Scanner scanner = new Scanner(System.in);
		
		while (true)
		{
			System.out.print("\n" + PROMPT);
			String expression = scanner.nextLine();
			
			if (!expression.isEmpty())
			{
				Value output = program.evaluate(expression);
				printResult(output);
			}
			else
			{
				break;
			}
		}
		
		scanner.close();
	}
	
	private void printResult(Value value)
	{
		if (value.isInt())
		{
			System.out.println(value.getInt());
		}
		else if (value.isFloat())
		{
			System.out.println(value.getFloat());
		}
	}
	
	public static void main(String[] args)
	{
		Prefix prefix = new Prefix();
		prefix.run(""); // TODO: args[0]
	}
}