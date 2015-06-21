package com.mauriciotogneri.jan.kernel;

import com.mauriciotogneri.jan.kernel.Value.Type;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program
{
    private Type returnType;
    private final List<String> imports = new ArrayList<>();
    private final Map<String, Function> functions = new HashMap<>();

    public void addImport(String path)
    {
        imports.add(path);
    }

    public Type getReturnType()
    {
        return returnType;
    }

    private void setTree()
    {
        Collection<Function> list = functions.values();

        for (Function function : list)
        {
            function.setTree(this);
        }
    }

    public void analyzeTree()
    {
        setTree();

        // TODO

        returnType = Type.UNDEFINED;
    }

    public void addFunction(Function function)
    {
        functions.put(function.getName().lexeme, function);
    }

    public boolean containsFunction(String name)
    {
        return functions.containsKey(name);
    }

    public Function getFunction(String name)
    {
        return functions.get(name);
    }

    public Value evaluate(Function function)
    {
        Context context = new Context();

        return function.evaluate(context);
    }

    public Value run()
    {
        return evaluate(functions.get("\\"));
    }

    public boolean hasEntryPoint()
    {
        return functions.containsKey("\\");
    }
}