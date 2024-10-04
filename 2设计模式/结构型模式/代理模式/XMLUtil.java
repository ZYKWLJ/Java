package com.EthanYankang.结构型模式.代理模式;

import org.w3c.dom.Document;import org.w3c.dom.Node;import org.w3c.dom.NodeList;import javax.xml.parsers.DocumentBuilder;import javax.xml.parsers.DocumentBuilderFactory;import java.io.File; /**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-20 18:24
 **/

class XMLUtil {
    public static Object getBean() {
        try {
            // 创建文档对象
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc;
            doc = builder.parse(new File("D:\\设计模式\\CreatePattern\\src\\main\\resources\\结构型模式\\ProxyPattern\\config.xml"));


            // 获取包含类名的文本节点
            NodeList nl = doc.getElementsByTagName("add");
            Node classNode = nl.item(0).getAttributes().getNamedItem("value");
            String cName = classNode.getNodeValue();

            // 通过类名生成实例对象并将其返回
            Class c = Class.forName(cName);
            Object obj = c.newInstance();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}