package day10_01;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @acthor KKKKK
 * @creay 2021-04-27-{TIME}
 */
public class FileUtilsTest
{
    public static void main(String[] args) throws IOException
    {
        File srcFile = new File("day10\\image.jpg");
        File destFile = new File("day10\\image2.jpg");
        FileUtils.copyFile(srcFile,destFile);
    }
}
