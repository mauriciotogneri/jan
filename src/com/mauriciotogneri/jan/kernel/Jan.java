package com.mauriciotogneri.jan.kernel;

import java.util.List;
import com.mauriciotogneri.jan.compiler.Compiler;
import com.mauriciotogneri.jan.execution.reader.DefaultReader;
import com.mauriciotogneri.jan.execution.reader.Reader;
import com.mauriciotogneri.jan.execution.writer.DefaultWriter;
import com.mauriciotogneri.jan.execution.writer.Writer;

public class Jan
{
	public void run(String sourcePath, Writer writer, Reader reader)
	{
		try
		{
			Compiler compiler = new Compiler();
			Program program = compiler.compile(sourcePath);
			
			if (program.hasEntryPoint())
			{
				// long start = System.nanoTime();
				
				Value result = program.run();
				printResult(result, writer);
				
				// long end = System.nanoTime();
				
				// System.out.println(((end - start) / 1000) + " us");
			}
			
			if (reader != null)
			{
				String line = null;
				
				do
				{
					line = reader.readExpression();
					
					if ((line != null) && (!line.isEmpty()))
					{
						try
						{
							Function function = compiler.getAnonymousFunction(program, line);
							Value value = program.evaluate(function);
							printResult(value, writer);
						}
						catch (Exception e)
						{
							printException(e, writer);
						}
					}
				} while ((line != null) && (!line.isEmpty()));
				
				reader.close();
			}
			
		}
		catch (Exception e)
		{
			printException(e, writer);
		}
	}
	
	public void run(String sourcePath, Writer writer)
	{
		run(sourcePath, writer, null);
	}
	
	private void printException(Exception e, Writer writer)
	{
		writer.printError(e.getClass().getSimpleName() + ": " + e.getMessage());
	}
	
	private void printResult(Value value, Writer writer)
	{
		StringBuilder builder = new StringBuilder();
		printResult(value, builder);
		writer.printValue(builder.toString());
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
			builder.append("\"" + value.getString() + "\"");
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
			Jan jan = new Jan();
			
			Writer writer = new DefaultWriter();
			
			boolean showPrompt = (args.length > 1) ? Boolean.parseBoolean(args[1]) : true;
			
			if (showPrompt)
			{
				Reader reader = new DefaultReader();
				
				jan.run(args[0], writer, reader);
			}
			else
			{
				jan.run(args[0], writer);
			}
		}
		else
		{
			System.err.println("Usage: java -jar jan.jar [SOURCE_PATH] [SHOW_PROMPT]");
		}
	}
}