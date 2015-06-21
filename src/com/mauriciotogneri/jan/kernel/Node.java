package com.mauriciotogneri.jan.kernel;

import com.mauriciotogneri.jan.compiler.lexical.Token;

import java.util.ArrayList;
import java.util.List;

public abstract class Node
{
    protected final Token token;
    private final List<Node> children = new ArrayList<>();

    protected Node(Token token)
    {
        this.token = token;
    }

    public void addChild(Node node)
    {
        children.add(node);
    }

    protected Value get(int index, Context context)
    {
        Node node = children.get(index);

        return node.evaluate(context);
    }

    protected Context getContext(Context context)
    {
        Value[] values = new Value[children.size()];

        for (int i = 0; i < children.size(); i++)
        {
            Node node = children.get(i);

            values[i] = node.evaluate(context);
        }

        return new Context(values);
    }

    public abstract Value evaluate(Context context);
}