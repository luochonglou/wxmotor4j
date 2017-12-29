package org.wxmotor4j.pay.api.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.sun.xml.internal.bind.marshaller.CharacterEscapeHandler;

/**
 * XML解析工具类
 * 
 * @ClassName: JAXBUtils
 * @author Tluo
 * @date 2017年2月6日
 *
 */
@SuppressWarnings("restriction")
public abstract class JAXBUtils {
	private final static String encoding = "utf-8";

	/**
	 * XML字节流转换为对象
	 * 
	 * @Title: inputStreamtoObject
	 * @return T 返回类型
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Object> T inputStreamtoObject(InputStream in, Class<T> clazz) {
		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance(clazz);
			Unmarshaller u = jc.createUnmarshaller();
			T o = (T) u.unmarshal(in);
			return o;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> T toObject(Class<T> clazz, String xmlString) {
		JAXBContext jc;
		StringReader reader = new StringReader(xmlString);
		try {
			jc = JAXBContext.newInstance(clazz);
			Unmarshaller u = jc.createUnmarshaller();
			@SuppressWarnings("unchecked")
			T o = (T) u.unmarshal(reader);
			return o;
		} catch (JAXBException e) {
			e.printStackTrace();
		} finally {
			reader.close();
		}
		return null;
	}

	/**
	 * 
	 * 
	 * @Title: objectToXML
	 * @return String 返回类型
	 */
	public static <T extends Object> String objectToXML(T obj) {
		try {
			JAXBContext context = JAXBContext.newInstance(obj.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
			// 转换所有的适配字符，包括xml实体字符&lt;和&gt;，xml实体字符在好多处理xml的框架中是处理不了的，除非序列化。
			marshaller.setProperty("com.sun.xml.internal.bind.marshaller.CharacterEscapeHandler",
					new CharacterEscapeHandler() {
						public void escape(char[] ch, int start, int length, boolean isAttVal,
								Writer writer) throws IOException {
							writer.write(ch, start, length);
						}
					});

			StringWriter writer = new StringWriter();
			// 添加自己想要的xml报文头
			// writer.write("<?xml version=\'1.0\' encoding=\'" + "utf-8" +
			// "\'?>\n");
			marshaller.marshal(obj, writer);
			return writer.toString();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

}
