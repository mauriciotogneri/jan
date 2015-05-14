package com.mauriciotogneri.prefix.compiler;

import java.util.List;
import com.mauriciotogneri.prefix.compiler.lexical.LexicalAnalyzer;
import com.mauriciotogneri.prefix.compiler.lexical.Token;
import com.mauriciotogneri.prefix.compiler.semantic.SemanticAnalyzer;
import com.mauriciotogneri.prefix.compiler.syntactic.SyntacticAnalyzer;
import com.mauriciotogneri.prefix.kernel.Expression;
import com.mauriciotogneri.prefix.kernel.Program;

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
	
	public Expression getExpression(String line)
	{
		return null;
	}
}