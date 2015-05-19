package com.mauriciotogneri.jan.kernel;

import java.util.List;
import java.util.Scanner;
import com.mauriciotogneri.jan.compiler.Compiler;

public class Jan
{
	private static final String PROMPT = "> ";
	
	public void run(String sourcePath, boolean showPrompt)
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
			
			if (showPrompt)
			{
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
							Value value = program.evaluate(function);
							printResult(value);
						}
						catch (Exception e)
						{
							printException(e);
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
		catch (Exception e)
		{
			printException(e);
		}
	}
	
	private void printException(Exception e)
	{
		System.err.println(e.getClass().getSimpleName() + ": " + e.getMessage());
	}
	
	private void printResult(Value value)
	{
		StringBuilder builder = new StringBuilder();
		printResult(value, builder);
		System.out.print(builder);
	}
	
	private void printResult(Value value, StringBuilder builder)
	{
		if (value.isNumber())
		{
			builder.append(value.getNumber());
		}
		else if (value.isBoolean())
		{
			builder.append(value.getBoolean());
		}
		else if (value.isString())
		{
			builder.append(value.getString());
		}
		else if (value.isList())
		{
			List<Value> list = value.getList();
			
			builder.append("[");
			
			for (int i = 0; i < list.size(); i++)
			{
				Value element = list.get(i);
				
				if (i != 0)
				{
					builder.append(", ");
				}
				
				printResult(element, builder);
			}
			
			builder.append("]");
		}
	}
	
	public static void main(String[] args)
	{
		if (args.length > 0)
		{
			boolean showPrompt = (args.length > 1) ? Boolean.parseBoolean(args[1]) : true;
			
			Jan jan = new Jan();
			jan.run(args[0], showPrompt);
		}
		else
		{
			System.err.println("Usage: java -jar jan.jar [SOURCE_PATH] [SHOW_PROMPT]");
		}
	}
}