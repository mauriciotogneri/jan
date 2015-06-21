package com.mauriciotogneri.jan.kernel.nodes;

import com.mauriciotogneri.jan.compiler.lexical.Token;
import com.mauriciotogneri.jan.kernel.Node;

public abstract class OperatorNode extends Node
{
    public final int numberOfOperands;

    OperatorNode(Token token, int numberOfOperands)
    {
        super(token);

        this.numberOfOperands = numberOfOperands;
    }
}