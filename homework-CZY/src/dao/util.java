package dao;

import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class util {
	static ObjectMapper mapper = new ObjectMapper();
	public static String toJson(Object obj) {
		// ����ӳ����
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd HH:mm:ss");
		//mapper.setDateFormat(sdf);
		String result = null;
		// ���л�user����Ϊjson�ַ���
		try {
			result = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static <T> T toObject(String json,Class<T> valueType) {
		//����ӳ����
		T result=null;
		try {
			result=mapper.readValue(json,valueType);

		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
