package com.mauriciotogneri.jan.compiler.semantic;

import com.mauriciotogneri.jan.compiler.definitions.ProgramDefinition;

public class SemanticAnalyzer
{
	public void analyze(ProgramDefinition program)
	{
		program.analyzeTree();
	}
}