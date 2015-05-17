package com.mauriciotogneri.jan.compiler.semantic.nodes;

import com.mauriciotogneri.jan.compiler.definitions.FunctionDefinition;
import com.mauriciotogneri.jan.compiler.definitions.ProgramDefinition;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.kernel.Value;
import com.mauriciotogneri.jan.kernel.symbols.Context;

public class FunctionNode extends OperatorNode
{
	private final FunctionDefinition function;
	
	public FunctionNode(Token token, FunctionDefinition function)
	{
		super(token, function.getNumberOfParameters());
		
		this.function = function;
	}
	
	@Override
	public Value evaluate(ProgramDefinition program, Context context)
	{
		return this.function.evaluate(program, getContext(program, context));
	}
}