package com.hotmarzz.bicycle.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.hotmarzz.bicycle.bean.User;

public class XmlUtil {

	// 读取xml文件信息
	public static User getXmlAdmin() {
		File file = new File("admin.xml");
		SAXReader sax = new SAXReader();
		Document doc;
		User user = null;
		try {
			doc = sax.read(file);
			Element root = doc.getRootElement();
			List<Element> list = root.elements();
			// 获取节点名称为loginname的文本值
			// String loginName =
			// list.get(0).element("loginname").getTextTrim();
			// String password = list.get(0).element("password").getTextTrim();
			// String maxLogin = list.get(0).element("maxlogin").getTextTrim();
			for (Element ele : list) {
				// 获取子节点中的元素属性值 当值为1时 为true
				if ("1".equals(ele.attributeValue("name"))) {
					String loginName = ele.element("loginname").getTextTrim();
					String password = ele.element("password").getTextTrim();
					String maxLogin = ele.element("maxlogin").getTextTrim();
					user = new User();
					user.setUserName(loginName);
					user.setPassword(password);
					user.setMaxLogin(Integer.parseInt(maxLogin));
				}
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	// 修改xml文件信息
	public static void updateXmlAdmin(String str,String xmlName){
		File file = new File("admin.xml");
		SAXReader sax = new SAXReader();
		try {
			Document doc = sax.read(file);
			Element root = doc.getRootElement();
			List<Element> eles = root.elements();
			eles.get(0).element(xmlName).setText(str);
			//通过xmlWrite将修改后的文本值 写入到xml文件中
			//new FileOutputStream(file) 文件输出流 参数为输出的位置
			//OutputFormat.createPrettyPrint() xml的一种漂亮的输出方式
			XMLWriter xw = new XMLWriter(new FileOutputStream(file),OutputFormat.createPrettyPrint());
			//将doc文档对象中得参数输出到admin.xml文件中
			xw.write(doc);
			//将输出流关闭
			xw.close();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
