package com.mauriciotogneri.prefix;

import java.util.Scanner;

public class Prefix
{
	public void run(String filePath)
	{
		Program program = new Program();
		program.parse(filePath);
		
		if (program.isValid())
		{
			Object result = program.run();
			System.out.println(result);
			
			Scanner scanner = new Scanner(System.in);
			
			while (true)
			{
				System.out.print("\n> ");
				String expression = scanner.nextLine();
				
				if (!expression.isEmpty())
				{
					Object output = program.evaluate(expression);
					System.out.println(output);
				}
				else
				{
					break;
				}
			}
			
			scanner.close();
		}
	}
	
	public static void main(String[] args)
	{
		Prefix prefix = new Prefix();
		prefix.run(""); // TODO: args[0]
	}
}