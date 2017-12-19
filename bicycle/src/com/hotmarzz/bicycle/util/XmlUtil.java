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

	// ��ȡxml�ļ���Ϣ
	public static User getXmlAdmin() {
		File file = new File("admin.xml");
		SAXReader sax = new SAXReader();
		Document doc;
		User user = null;
		try {
			doc = sax.read(file);
			Element root = doc.getRootElement();
			List<Element> list = root.elements();
			// ��ȡ�ڵ�����Ϊloginname���ı�ֵ
			// String loginName =
			// list.get(0).element("loginname").getTextTrim();
			// String password = list.get(0).element("password").getTextTrim();
			// String maxLogin = list.get(0).element("maxlogin").getTextTrim();
			for (Element ele : list) {
				// ��ȡ�ӽڵ��е�Ԫ������ֵ ��ֵΪ1ʱ Ϊtrue
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
	// �޸�xml�ļ���Ϣ
	public static void updateXmlAdmin(String str,String xmlName){
		File file = new File("admin.xml");
		SAXReader sax = new SAXReader();
		try {
			Document doc = sax.read(file);
			Element root = doc.getRootElement();
			List<Element> eles = root.elements();
			eles.get(0).element(xmlName).setText(str);
			//ͨ��xmlWrite���޸ĺ���ı�ֵ д�뵽xml�ļ���
			//new FileOutputStream(file) �ļ������ ����Ϊ�����λ��
			//OutputFormat.createPrettyPrint() xml��һ��Ư���������ʽ
			XMLWriter xw = new XMLWriter(new FileOutputStream(file),OutputFormat.createPrettyPrint());
			//��doc�ĵ������еò��������admin.xml�ļ���
			xw.write(doc);
			//��������ر�
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
