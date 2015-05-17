package com.mauriciotogneri.jan.compiler.semantic;

import com.mauriciotogneri.jan.compiler.definitions.ProgramDefinition;
import com.mauriciotogneri.jan.kernel.symbols.Operand.Type;

public class SemanticAnalyzer
{
	// TODO: return the result type of the program
	// TODO: construct the tree of the program to validate it
	public Type analyze(ProgramDefinition program)
	{
		program.setTree();
		
		return Type.UNDEFINED;
	}
}