package com.dolan.study.demo.streams;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * Created by fangqj on 2017/7/13.
 */
public class XMLDemo {
    public void go() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        File f = Paths.get("data.xml").toFile();
        Document doc = builder.parse(f);
        Document doc1 = builder.parse("");
        Element root = doc.getDocumentElement();
        root.getChildNodes();



    }
}
