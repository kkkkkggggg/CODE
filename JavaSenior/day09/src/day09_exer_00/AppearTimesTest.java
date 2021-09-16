package day09_exer_00;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.*;

/**
 * @acthor KKKKK
 * @creay 2021-04-26-{TIME}
 */
public class AppearTimesTest
{
    @Test
    public void test() throws IOException
    {
        FileReader fr = new FileReader(new File("dbcp.txt"));

        Map<Character,Integer> map = new HashMap<>();

        char[] buf = new char[5];
        int len;
        while((len = fr.read(buf)) != -1)
        {
            for(int i = 0; i < len; i++)
            {
                if(map.get(buf[i]) == null)
                {
                    map.put(buf[i],1);
                }else
                {
                    map.put(buf[i],map.get(buf[i]) + 1);
                }
            }
        }

        Set<Map.Entry<Character,Integer>> set = map.entrySet();

        Iterator<Map.Entry<Character,Integer>> iterator = set.iterator();

        while(iterator.hasNext())
        {
            Map.Entry<Character,Integer> entry = iterator.next();
            Character key = entry.getKey();
            Integer value = entry.getValue();

            System.out.println("--" + key + "--" + " --出现了--> " + value + "次");
        }
    }

    @Test
    public void test1()
    {
        Map<Character,Integer> map = new HashMap<>();

        System.out.println(map.get('a'));
    }
}
