package com.mauriciotogneri.jan.kernel;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tests
{
    private static final String SCRIPTS_FOLDER = "tests/scripts/";

    @Test
    public void testInteger() throws Exception
    {
        runTest(SCRIPTS_FOLDER + "test_integer.jan");
    }

    @Test
    public void testFloat() throws Exception
    {
        runTest(SCRIPTS_FOLDER + "test_float.jan");
    }

    @Test
    public void testBoolean() throws Exception
    {
        runTest(SCRIPTS_FOLDER + "test_boolean.jan");
    }

    private void runTest(String scriptPath)
    {
        CustomProgramOutput programOutput = new CustomProgramOutput();

        Jan jan = new Jan();
        jan.run(scriptPath, programOutput);

        Assert.assertTrue(programOutput.error, programOutput.isValid());

        Assert.assertEquals(programOutput.result.toString(), getTestResult(scriptPath), programOutput.result.toString());
    }

    private String getTestResult(String filePath)
    {
        String result = "";
        BufferedReader bufferedReader = null;

        try
        {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
            String line;

            while ((line = bufferedReader.readLine()) != null)
            {
                result = line;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (bufferedReader != null)
            {
                try
                {
                    bufferedReader.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }

        return (result.length() > 1) ? result.substring(2) : result;
    }
}