package com.atck.boot.bean;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XMLPaser
{
    public static void main(String args[]) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("links.xml");
            doc.normalize();
            NodeList links = doc.getElementsByTagName("link");
            for (int i = 0; i < links.getLength(); i++) {
                Element link = (Element) links.item(i);
                System.out.print("Content: ");
                System.out.println(link.getElementsByTagName("text").item(0)
                        .getFirstChild().getNodeValue());
                System.out.print("URL: ");
                System.out.println(link.getElementsByTagName("url").item(0)
                        .getFirstChild().getNodeValue());
                System.out.print("Author: ");
                System.out.println(link.getElementsByTagName("author").item(0)
                        .getFirstChild().getNodeValue());
                System.out.print("Date: ");
                Element linkdate = (Element) link.getElementsByTagName("date")
                        .item(0);
                String day = linkdate.getElementsByTagName("day").item(0)
                        .getFirstChild().getNodeValue();
                String month = linkdate.getElementsByTagName("month").item(0)
                        .getFirstChild().getNodeValue();
                String year = linkdate.getElementsByTagName("year").item(0)
                        .getFirstChild().getNodeValue();
                System.out.println(day + "-" + month + "-" + year);
                System.out.print("Description: ");
                System.out.println(link.getElementsByTagName("description")
                        .item(0).getFirstChild().getNodeValue());
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
