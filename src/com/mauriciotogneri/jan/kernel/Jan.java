package com.mauriciotogneri.jan.kernel;

import java.util.Scanner;
import com.mauriciotogneri.jan.compiler.Compiler;

public class Jan
{
	private static final String PROMPT = "> ";
	
	public void run(String sourcePath)
	{
		try
		{
			Compiler compiler = new Compiler();
			Program program = compiler.compile(sourcePath);
			
			if (program.hasEntryPoint())
			{
				// long start = System.nanoTime();
				
				Value result = program.run();
				printResult(result);
				
				// long end = System.nanoTime();
				
				// System.out.println(((end - start) / 1000) + " us");
			}
			
			Scanner scanner = new Scanner(System.in);
			
			while (true)
			{
				System.out.print("\n" + PROMPT);
				String line = scanner.nextLine();
				
				if (!line.isEmpty())
				{
					try
					{
						Function function = compiler.getAnonymousFunction(program, line);
						Value output = program.evaluate(function);
						printResult(output);
					}
					catch (Exception e)
					{
						System.err.println(e.getClass().getSimpleName() + ": " + e.getMessage());
					}
				}
				else
				{
					break;
				}
			}
			
			scanner.close();
			
		}
		catch (Exception e)
		{
			System.err.println(e.getClass().getSimpleName() + ": " + e.getMessage());
		}
	}
	
	private void printResult(Value operand)
	{
		if (operand.isNumber())
		{
			System.out.println(operand.getNumber());
		}
		else if (operand.isBoolean())
		{
			System.out.println(operand.getBoolean());
		}
		else if (operand.isString())
		{
			System.out.println(operand.getString());
		}
	}
	
	public static void main(String[] args)
	{
		if (args.length > 0)
		{
			Jan jan = new Jan();
			jan.run(args[0]);
		}
		else
		{
			System.err.println("Usage: java -jar jan.jar [SOURCE_PATH]");
		}
	}
}