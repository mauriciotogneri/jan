package com.mauriciotogneri.jan.execution.input;

import java.util.Scanner;

public class DefaultProgramInput implements ProgramInput
{
    private static final String PROMPT = "> ";

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String getExpression()
    {
        System.out.print("\n\n" + PROMPT);

        return scanner.nextLine();
    }

    @Override
    public void close()
    {
        scanner.close();
    }
}