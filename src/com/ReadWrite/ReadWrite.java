package com.ReadWrite;

import java.io.*;
import java.util.ArrayList;

public class ReadWrite
{
    public static String[] fileRead(String filename) throws IOException
    {
        FileReader file;
        ArrayList<String> input = new ArrayList<String>();
        String[] data;
        int i = 0;
        int c;

        try
        {
            file = new FileReader(filename);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found.");
            return null;
        }

        input.add("");
        while((c = file.read()) != -1)
        {
            if (c == ',')
            {
                input.add("");
                ++i;
            } else
                input.set(i, input.get(i) + (char) c);
        }
        file.close();

        c = input.size();
        data = new String[c];
        for(i = 0; i < c; ++i)
            data[i] = input.get(i);

        return data;
    }

    public static String[][] fileReadAll(String filename) throws IOException
    {
        FileReader file;
        ArrayList<String> input = new ArrayList<String>();
        ArrayList<String[]> holder = new ArrayList<String[]>();
        String[][] ret;
        String[] data;
        int i = 0;
        int j = 0;
        int c;

        try
        {
            file = new FileReader(filename);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found.");
            return null;
        }

        input.add("");
        while((c = file.read()) != -1)
        {
            if(c == ',')
            {
                input.add("");
                ++i;
            }
            else if(c == '\n')
            {
                holder.add(new String[input.size()]);
                data = new String[input.size()];
                for(i = 0; i < input.size(); ++i)
                    data[i] = input.get(i);
                holder.set(j, data);
                input.clear();
                input.add("");
                ++j;
                i = 0;
            }
            else
                input.set(i, input.get(i) + (char) c);
        }

        ret = new String[holder.size()][];
        for(i = 0; i < holder.size(); ++i)
        {
            ret[i] = new String[holder.get(i).length];
            ret[i] = holder.get(i);
        }

        return ret;
    }

    public static int fileWrite(String filename, String[] data, boolean append) throws IOException
    {
        FileWriter file;
        int i;

        if(data[0] == null)
            return -1;

        file = new FileWriter(filename, append);
        for(i = 0; i < data.length - 1; ++i)
        {
            file.write(data[i]);
            if(i != data.length - 1)
                file.write(',');
        }
        file.write(data[i]);
        file.write('\n');

        file.close();
        return 1;
    }
}