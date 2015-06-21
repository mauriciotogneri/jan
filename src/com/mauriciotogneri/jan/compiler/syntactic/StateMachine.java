package com.mauriciotogneri.jan.compiler.syntactic;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.compiler.lexical.Token.Type;
import com.mauriciotogneri.jan.compiler.syntactic.states.AnonymousExpressionStartState;
import com.mauriciotogneri.jan.compiler.syntactic.states.InitialState;
import com.mauriciotogneri.jan.kernel.Expression;
import com.mauriciotogneri.jan.kernel.Function;
import com.mauriciotogneri.jan.kernel.Program;

import java.util.List;

class StateMachine
{
	public Program getProgram(List<Token> tokens)
	{
		Program program = new Program();
		
		State state = new InitialState(program);
		
		for (Token token : tokens)
		{
			state = state.process(token);
		}
		
		return program;
	}
	
	public Function getAnonymousFunction(List<Token> tokens)
	{
		Program program = new Program();
		Function function = new Function(new Token("", Type.ANONYMOUS_FUNCTION, 1, 1));
		Expression expression = new Expression();
		
		State state = new AnonymousExpressionStartState(program, function, expression);
		
		for (Token token : tokens)
		{
			state = state.process(token);
		}
		
		return function;
	}
}