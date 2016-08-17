package com.app.util;

import java.io.PrintWriter;
import java.security.MessageDigest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

/**
 * 工具类
 * @author lbz
 *
 */
@Service
public class UtilTool {

	/**
	 * @param value 准备加密的字符串
	 * 字符串加密
	 * @return String
	 */
	public String md5(String value) {
		try {
			if (null != value) {
				MessageDigest digest = MessageDigest.getInstance("MD5");
				digest.update(value.getBytes());
				byte bytes[] = digest.digest();
				int i;
				StringBuffer buffer = new StringBuffer("");
				for (int offset = 0; offset < bytes.length; offset++) {
					i = bytes[offset];
					if (i < 0) {
						i += 256;
					}				
					if (i < 16) {
						buffer.append("0");
					}					
					buffer.append(Integer.toHexString(i));
				}
				return buffer.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * 输出流
	 * @param response 
	 * @param type 输出类型(1表示文本,2表示HTML,3表示XML)
	 * @param content 输出内容
	 * */ 
	public void write(HttpServletResponse response, int type, String content) {
		try {
			switch (type) {
				case 1:
					response.setContentType("text/plain;charset=UTF-8");
					break;
				case 2:
					response.setContentType("text/html;charset=UTF-8");
					break;	
				case 3:
					response.setContentType("text/xml;charset=UTF-8");
					break;
			}
			PrintWriter out = response.getWriter();
			out.print(content);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
