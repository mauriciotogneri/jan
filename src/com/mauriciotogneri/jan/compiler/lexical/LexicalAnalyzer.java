package com.mauriciotogneri.jan.compiler.lexical;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class LexicalAnalyzer
{
	public List<Token> getTokens(String sourcePath)
	{
		char[] characters = getCharacters(sourcePath);
		
		return getTokens(characters);
	}
	
	public List<Token> getTokens(char[] characters)
	{
		StateMachine stateMachine = new StateMachine();
		
		return stateMachine.getTokens(characters);
	}
	
	private char[] getCharacters(String sourcePath)
	{
		char[] result = null;
		BufferedReader bufferedReader = null;
		
		try
		{
			bufferedReader = new BufferedReader(new FileReader(sourcePath));
			
			File file = new File(sourcePath);
			
			result = new char[(int)file.length()];
			bufferedReader.read(result);
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