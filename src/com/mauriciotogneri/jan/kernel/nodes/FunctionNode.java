package com.mauriciotogneri.jan.kernel.nodes;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.kernel.Context;
import com.mauriciotogneri.jan.kernel.Function;
import com.mauriciotogneri.jan.kernel.Value;

public class FunctionNode extends OperatorNode
{
    private final Function function;

    public FunctionNode(Token token, Function function)
    {
        super(token, function.getNumberOfParameters());

        this.function = function;
    }

    @Override
    public Value evaluate(Context context)
    {
        return function.evaluate(getContext(context));
    }
}