package com.mauriciotogneri.jan.compiler.syntactic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.kernel.Expression;
import com.mauriciotogneri.jan.kernel.Function;
import com.mauriciotogneri.jan.kernel.Parameter;
import com.mauriciotogneri.jan.kernel.Program;
import com.mauriciotogneri.jan.kernel.Operator;
import com.mauriciotogneri.jan.kernel.Operand.Type;
import com.mauriciotogneri.jan.kernel.operands.IntOperand;

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
		e.add(new Operator("*"));
		e.add(new Operator("a"));
		e.add(new Operator("a"));
		
		function.addExpression(e);
		
		Map<String, Function> functions = new HashMap<>();
		functions.put(function.name, function);
		
		Expression entryPoint = new Expression();
		
		entryPoint.add(new Operator("double"));
		entryPoint.add(new Operator("+"));
		entryPoint.add(new IntOperand(3));
		entryPoint.add(new IntOperand(2));
		
		return new Program(functions, entryPoint);
	}
}