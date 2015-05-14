package com.mauriciotogneri.prefix;

import java.util.Scanner;

public class Prefix
{
	private static final String PROMPT = "> ";
	
	public void run(String filePath)
	{
		Program program = new Program();
		program.parse(filePath);
		
		if (program.isValid())
		{
			if (program.hasEntryPoint())
			{
				Value result = program.run();
				System.out.println(result);
			}
			
			Scanner scanner = new Scanner(System.in);
			
			while (true)
			{
				System.out.print("\n" + PROMPT);
				String expression = scanner.nextLine();
				
				if (!expression.isEmpty())
				{
					Value output = program.evaluate(expression);
					
					if (output.isNumber())
					{
						System.out.println(output.getInt());
					}
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