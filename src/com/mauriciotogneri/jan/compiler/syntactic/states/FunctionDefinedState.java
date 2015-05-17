package com.mauriciotogneri.jan.compiler.syntactic.states;

import com.mauriciotogneri.jan.compiler.definitions.ExpressionDefinition;
import com.mauriciotogneri.jan.compiler.definitions.FunctionDefinition;
import com.mauriciotogneri.jan.compiler.definitions.ProgramDefinition;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.lexical.Token.Type;
import com.mauriciotogneri.jan.compiler.syntactic.State;
import com.mauriciotogneri.jan.compiler.syntactic.SyntacticException;

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
			addFunction(this.function);
			
			return new FunctionDefinitionState(getProgram(), new FunctionDefinition(token));
		}
		else if (token.type == Type.NEW_LINE)
		{
			addFunction(this.function);
			
			return new InitialState(getProgram());
		}
		else
		{
			throw new SyntacticException(token);
		}
	}
}