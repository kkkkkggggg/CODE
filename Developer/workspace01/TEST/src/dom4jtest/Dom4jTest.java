package dom4jtest;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.junit.Test;


public class Dom4jTest
{
   @Test
   
   public void test() throws Exception
   {
	   SAXReader reader = new SAXReader();
       Document document = reader.read("src/books.xml");


       System.out.println(document);
   }
   
}
