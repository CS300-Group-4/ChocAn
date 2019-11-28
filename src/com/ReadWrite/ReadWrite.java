package com.ReadWrite;

import java.io.*;
import java.util.ArrayList;

class ReadWrite
{
    public String[] fileRead(String filename)
    {
        try {
            FileReader file = new FileReader(filename);
            ArrayList<String> input = new ArrayList<>();
            String[] data;
            int i = 0;
            int c;

            input.add("");
            while ((c = file.read()) != -1) {
                if (c == ',') {
                    input.add("");
                    ++i;
                } else
                    input.set(i, input.get(i) + (char) c);
            }
            file.close();

            c = input.size();
            data = new String[c];
            for (i = 0; i < c; ++i)
                data[i] = input.get(i);

            return data;
        }
        catch (IOException a) {
            System.out.println("Could not open " + filename);
            return null;
        }
    }

    static String[][] fileReadAll(String filename) throws IOException
    {
        String[][] ret = {{"Placeholder"}, {"Placeholder"}};
        return ret;
    }

    static int fileWrite(String filename, String[] data, boolean append) throws IOException
    {
        if(data[0] == null)
            return -1;

        try {
            FileWriter file = new FileWriter(filename + ".txt", append);
            int i;
            for (i = 0; i < data.length - 1; ++i) {
                file.write(data[i]);
                file.write(',');
            }
            file.write(data[i]);
            file.write('\n');

            file.close();
            return 1;
        }
        catch (IOException a) {
            System.out.println("Could not open " + filename);
            return -1;
        }
    }
}
