package com.mauriciotogneri.jan.kernel;

import java.util.Scanner;
import com.mauriciotogneri.jan.compiler.Compiler;

public class Jan
{
	private static final String PROMPT = "> ";
	
	public void run(String sourcePath)
	{
		Compiler compiler = new Compiler();
		Program program = compiler.compile(sourcePath);
		
		if (program.hasEntryPoint())
		{
			Value result = program.run();
			printResult(result);
		}
		
		Scanner scanner = new Scanner(System.in);
		
		while (true)
		{
			System.out.print("\n" + PROMPT);
			String line = scanner.nextLine();
			
			if (!line.isEmpty())
			{
				Expression expression = compiler.getExpression(line);
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