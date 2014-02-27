package com.cmmi.test.mapper;
/*package com.cmmi.main.mapper;

import static org.junit.Assert.*;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;

import com.cmmi.common.utils.mapper.JaxbMapper;
import com.google.common.collect.Lists;

*//**
 * 演示基于JAXB2.0的Java对象-XML转换及Dom4j的使�?
 * 
 * 演示用xml如下:
 * 
 * <pre>
 * <?xml version="1.0" encoding="UTF-8"?>
 * <user id="1">
 * 	<name>calvin</name>
 * 	<interests>
 * 		<interest>movie</interest>
 * 		<interest>sports</interest>
 * 	</interests>
 * </user>
 * </pre>
 *//*
public class JaxbMapperTest {

	@Test
	public void objectToXml() {
		User user = new User();
		user.setId(1L);
		user.setName("calvin");

		user.getInterests().add("movie");
		user.getInterests().add("sports");

		String xml = JaxbMapper.toXml(user, "UTF-8");
		System.out.println("Jaxb Object to Xml result:\n" + xml);
		assertXmlByDom4j(xml);
	}

	@Test
	public void xmlToObject() {
		String xml = generateXmlByDom4j();
		User user = JaxbMapper.fromXml(xml, User.class);

		System.out.println("Jaxb Xml to Object result:\n" + user);

		assertEquals(Long.valueOf(1L), user.getId());
		assertEquals(2, user.getInterests().size());
		assertEquals("movie", user.getInterests().get(0));
	}

	*//**
	 * 测试以List对象作为根节点时的XML输出
	 *//*
	@Test
	public void toXmlWithListAsRoot() {
		User user1 = new User();
		user1.setId(1L);
		user1.setName("calvin");

		User user2 = new User();
		user2.setId(2L);
		user2.setName("kate");

		List<User> userList = Lists.newArrayList(user1, user2);

		String xml = JaxbMapper.toXml(userList, "userList", User.class, "UTF-8");
		System.out.println("Jaxb Object List to Xml result:\n" + xml);
	}

	*//**
	 * 使用Dom4j生成测试用的XML文档字符�?
	 *//*
	private static String generateXmlByDom4j() {
		Document document = DocumentHelper.createDocument();

		Element root = document.addElement("user").addAttribute("id", "1");

		root.addElement("name").setText("calvin");

		// List<String>
		Element interests = root.addElement("interests");
		interests.addElement("interest").addText("movie");
		interests.addElement("interest").addText("sports");

		return document.asXML();
	}

	*//**
	 * 使用Dom4j验证Jaxb�?��成XML的正确�?.
	 *//*
	private static void assertXmlByDom4j(String xml) {
		Document doc = null;
		try {
			doc = DocumentHelper.parseText(xml);
		} catch (DocumentException e) {
			fail(e.getMessage());
		}
		Element user = doc.getRootElement();
		assertEquals("1", user.attribute("id").getValue());

		Element interests = (Element) doc.selectSingleNode("//interests");
		assertEquals(2, interests.elements().size());
		assertEquals("movie", ((Element) interests.elements().get(0)).getText());
	}

	@XmlRootElement
	// 指定子节点的顺序
	@XmlType(propOrder = { "name", "interests" })
	private static class User {

		private Long id;
		private String name;
		private String password;

		private List<String> interests = Lists.newArrayList();

		// 设置转换为xml节点中的属�?
		@XmlAttribute
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		// 设置不转换为xml
		@XmlTransient
		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		// 设置对List<String>的映�? xml�?interests><interest>movie</interest></interests>
		@XmlElementWrapper(name = "interests")
		@XmlElement(name = "interest")
		public List<String> getInterests() {
			return interests;
		}

		public void setInterests(List<String> interests) {
			this.interests = interests;
		}

		@Override
		public String toString() {
			return ToStringBuilder.reflectionToString(this);
		}
	}
}
*/