package com.hotmarzz.bicyle.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.sql.rowset.spi.XmlWriter;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.hotmarzz.bicycle.bean.User;

public class XmlUtil {
	public static User getXmlAdmin() {
		File file = new File("admin.xml");
		SAXReader sax = new SAXReader();
		Document doc;
		User user =null;
		try {
			doc = sax.read(file);
			Element root= doc.getRootElement();
			List<Element> list= root.elements();
			for (Element ele : list) {
				if("1".equals(ele.attributeValue("name"))){
					List<Element> list2= ele.elements();
					String loginame=list2.get(0).getTextTrim();
					String password= list2.get(1).getTextTrim();
					String maxlogin= list2.get(2).getTextTrim();
					user = new User();
					user.setuserName(loginame);
					user.setpassword(password);
					user.setMaxlogin(Integer.parseInt(maxlogin));
					
				}
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return user;
	}
	
	public static void updateAdmin(String XmlName,String str){
		File file = new File("admin.xml");
		SAXReader sax = new  SAXReader();
		
			Document doc;
			try {
				doc = sax.read(file);
				Element root= doc.getRootElement();
				List<Element> list = root.elements();
				list.get(0).element(XmlName).setText(str);
				
				
				XMLWriter xw = new XMLWriter(new FileOutputStream(file),OutputFormat.createPrettyPrint());
				xw.write(doc);
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
