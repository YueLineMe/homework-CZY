package dao;

import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class util {
	static ObjectMapper mapper = new ObjectMapper();
	public static String toJson(Object obj) {
		// 对象映射器
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd HH:mm:ss");
		//mapper.setDateFormat(sdf);
		String result = null;
		// 序列化user对象为json字符串
		try {
			result = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static <T> T toObject(String json,Class<T> valueType) {
		//对象映射器
		T result=null;
		try {
			result=mapper.readValue(json,valueType);

		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
