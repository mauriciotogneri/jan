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
		List<Token> tokens = lexicalAnalyzer.analyze(sourcePath);
		
		SyntacticAnalyzer syntacticAnalyzer = new SyntacticAnalyzer();
		Program program = syntacticAnalyzer.analyze(tokens);
		
		SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer();
		semanticAnalyzer.analyze(program);
		
		return program;
	}
	
	public Function getAnonymousFunction(String line)
	{
		return null;
	}
}