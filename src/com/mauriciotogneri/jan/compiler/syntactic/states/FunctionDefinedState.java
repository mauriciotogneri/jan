package com.mauriciotogneri.jan.compiler.syntactic.states;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.lexical.Token.Type;
import com.mauriciotogneri.jan.compiler.syntactic.State;
import com.mauriciotogneri.jan.compiler.syntactic.SyntacticException;
import com.mauriciotogneri.jan.compiler.syntactic.definitions.ExpressionDefinition;
import com.mauriciotogneri.jan.compiler.syntactic.definitions.FunctionDefinition;
import com.mauriciotogneri.jan.compiler.syntactic.definitions.ProgramDefinition;

public class FunctionDefinedState extends State
{
	private final FunctionDefinition function;
	
	public FunctionDefinedState(ProgramDefinition program, FunctionDefinition function)
	{
		super(program);
		
		this.function = function;
	}
	
	@Override
	public State process(Token token)
	{
		if (token.type == Type.TAB)
		{
			return new ExpressionStartState(getProgram(), this.function, new ExpressionDefinition());
		}
		else if (token.type == Type.SYMBOL)
		{
			checkFunction();
			
			return new FunctionDefinitionState(getProgram(), new FunctionDefinition(token));
		}
		else if (token.type == Type.NEW_LINE)
		{
			checkFunction();
			
			return new InitialState(getProgram());
		}
		else
		{
			throw new SyntacticException(token);
		}
	}
	
	private void checkFunction()
	{
		if (this.function.isEmpty())
		{
			throw new SyntacticException("Function is empty", this.function.getName());
		}
		
		addFunction(this.function);
	}
}