package com.mauriciotogneri.jan.compiler.semantic;

import com.mauriciotogneri.jan.kernel.Program;

public class SemanticAnalyzer
{
	public void analyze(Program program)
	{
		program.analyzeTree();
	}
}