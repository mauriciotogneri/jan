package com.mauriciotogneri.jan.compiler;

import java.util.List;
import com.mauriciotogneri.jan.compiler.lexical.LexicalAnalyzer;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.semantic.SemanticAnalyzer;
import com.mauriciotogneri.jan.compiler.syntactic.SyntacticAnalyzer;
import com.mauriciotogneri.jan.kernel.Function;
import com.mauriciotogneri.jan.kernel.Program;

public class Compiler
{
	public Program compile(String sourcePath)
	{
		LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer();
		List<Token> tokens = lexicalAnalyzer.getTokens(sourcePath);
		
		SyntacticAnalyzer syntacticAnalyzer = new SyntacticAnalyzer();
		Program program = syntacticAnalyzer.getProgram(tokens);
		
		SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer();
		semanticAnalyzer.analyze(program);
		
		return program;
	}
	
	public Function getAnonymousFunction(Program program, String line)
	{
		char[] characters = line.toCharArray();
		
		LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer();
		List<Token> tokens = lexicalAnalyzer.getTokens(characters);
		
		SyntacticAnalyzer syntacticAnalyzer = new SyntacticAnalyzer();
		Function function = syntacticAnalyzer.getFunction(tokens);
		
		function.setTree(program);
		
		return function;
	}
}