package com.mauriciotogneri.jan.compiler.syntactic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.kernel.Expression;
import com.mauriciotogneri.jan.kernel.Function;
import com.mauriciotogneri.jan.kernel.Parameter;
import com.mauriciotogneri.jan.kernel.Program;
import com.mauriciotogneri.jan.kernel.Symbol;
import com.mauriciotogneri.jan.kernel.Value.Type;
import com.mauriciotogneri.jan.kernel.values.IntValue;

public class SyntacticAnalyzer
{
	public Program analyze(List<Token> tokens)
	{
		// TODO
		return getExapleProgram();
	}
	
	private Program getExapleProgram()
	{
		Function function = new Function("double");
		function.addParameter(new Parameter("a", 0, Type.INT));
		
		Expression e = new Expression();
		e.add(new Symbol("*"));
		e.add(new Symbol("a"));
		e.add(new Symbol("a"));
		e.closeExpression();
		
		function.addExpression(e);
		
		Map<String, Function> functions = new HashMap<>();
		functions.put(function.name, function);
		
		Expression entryPoint = new Expression();
		
		entryPoint.add(new Symbol("double"));
		entryPoint.add(new Symbol("+"));
		entryPoint.add(new IntValue(3));
		entryPoint.add(new IntValue(2));
		
		entryPoint.closeExpression();
		
		return new Program(functions, entryPoint);
	}
}