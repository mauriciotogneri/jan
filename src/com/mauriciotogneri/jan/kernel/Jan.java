package com.mauriciotogneri.jan.kernel;

import com.mauriciotogneri.jan.compiler.Compiler;
import com.mauriciotogneri.jan.execution.input.DefaultProgramInput;
import com.mauriciotogneri.jan.execution.input.ProgramInput;
import com.mauriciotogneri.jan.execution.output.DefaultProgramOutput;
import com.mauriciotogneri.jan.execution.output.ProgramOutput;

public class Jan
{
    public void run(String sourcePath, ProgramOutput programOutput, ProgramInput programInput)
    {
        try
        {
            Compiler compiler = new Compiler();
            Program program = compiler.compile(sourcePath);

            if (program.hasEntryPoint())
            {
                // long start = System.nanoTime();

                Value result = program.run();
                programOutput.processResult(result);

                // long end = System.nanoTime();

                // System.out.println(((end - start) / 1000) + " us");
            }

            if (programInput != null)
            {
                String line;

                do
                {
                    line = programInput.getExpression();

                    if ((line != null) && (!line.isEmpty()))
                    {
                        try
                        {
                            Function function = compiler.getAnonymousFunction(program, line);
                            Value result = program.evaluate(function);
                            programOutput.processResult(result);
                        }
                        catch (Exception e)
                        {
                            printException(e, programOutput);
                        }
                    }
                } while ((line != null) && (!line.isEmpty()));

                programInput.close();
            }
        }
        catch (Exception e)
        {
            printException(e, programOutput);
        }
    }

    public void run(String sourcePath, ProgramOutput programOutput)
    {
        run(sourcePath, programOutput, null);
    }

    private void printException(Exception e, ProgramOutput programOutput)
    {
        programOutput.processError(e.getClass().getSimpleName() + ": " + e.getMessage());
    }

    public static void main(String[] args)
    {
        if (args.length > 0)
        {
            Jan jan = new Jan();

            ProgramOutput programOutput = new DefaultProgramOutput();

            boolean showPrompt = (args.length <= 1) || Boolean.parseBoolean(args[1]);

            if (showPrompt)
            {
                ProgramInput programInput = new DefaultProgramInput();

                jan.run(args[0], programOutput, programInput);
            }
            else
            {
                jan.run(args[0], programOutput);
            }
        }
        else
        {
            System.err.println("Usage: java -jar jan.jar [SOURCE_PATH] [SHOW_PROMPT]");
        }
    }
}