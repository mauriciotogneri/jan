package com.mauriciotogneri.jan.compiler.lexical;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LexicalAnalyzer
{
	public List<Token> analyze(String sourcePath)
	{
		List<Token> result = new ArrayList<>();
		
		List<String> lines = getLines(sourcePath);
		
		for (String line : lines)
		{
			// System.out.println(line);
		}
		
		return result;
	}
	
	private List<String> getLines(String sourcePath)
	{
		List<String> result = new ArrayList<>();
		
		BufferedReader bufferedReader = null;
		
		try
		{
			bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(sourcePath)));
			String line = null;
			
			while ((line = bufferedReader.readLine()) != null)
			{
				result.add(line);
			}
		}
		catch (Exception e)
		{
			throw new RuntimeException("Error reading file: " + sourcePath);
		}
		finally
		{
			try
			{
				if (bufferedReader != null)
				{
					bufferedReader.close();
				}
			}
			catch (IOException e)
			{
			}
		}
		
		return result;
	}
}