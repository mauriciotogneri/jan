package com.mauriciotogneri.jan.kernel;

import java.util.HashMap;
import java.util.Map;

class Parameters
{
    private int index = 0;
    private final Map<String, Integer> parameters = new HashMap<>();

    public void add(String name)
    {
        parameters.put(name, index++);
    }

    public int getSize()
    {
        return parameters.size();
    }

    public boolean containsParameter(String name)
    {
        return parameters.containsKey(name);
    }

    public int getIndex(String name)
    {
        Integer result = parameters.get(name);

        return (result != null) ? result : -1;
    }
}