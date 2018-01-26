package com.zon.interview.utils;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by rwq on 2016/4/14.
 */

/**
 * 功能1：从Json字符串解析到JavaBean 
 * 功能2：从JsonArray字符串数组解析到JavaBean集合
 * 功能3：从JavaBean解析到Json字符串 
 * 功能4：从JavaBean集合解析到Json字符串
 *
 **/
public class GsonUtil {

	// 从Json字符串解析到JavaBean
	public static <T> T str2Bean(String jsonString, Class<T> clazz) {
		if (isEmptyJsonStr(jsonString)) {
			return null;
		}
		Gson gson = new Gson();
		try {
			return gson.fromJson(jsonString, clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// T泛型传入参数类型 E泛型返回参数类型 实现从JSONString到JavaBean的转换 数组也没问题
	@SuppressWarnings("unchecked")
	public static <T, E> E Str2Bean(String jsonString, Class<T> clazz) {
		if (isEmptyJsonStr(jsonString)) {
			return null;
		}
		Gson mGson = new Gson();
		try {
			return (E) mGson.fromJson(jsonString, clazz);
		} catch (Exception e) {
			e.printStackTrace();
			ArrayList<T> mList = new ArrayList<T>();
			JsonArray array = new JsonParser().parse(jsonString).getAsJsonArray();
			for (final JsonElement elem : array) {
				mList.add(mGson.fromJson(elem, clazz));
			}
			return (E) mList;
		}

	}

	// T泛型传入参数类型 E泛型返回参数类型 实现从JSONObject到JavaBean的转换 数组也没问题
	@SuppressWarnings("unchecked")
	public static <T, E> E Json2Bean(JSONObject jsonObject, Class<T> clazz) {
		if (jsonObject == null) {
			return null;
		}
		Gson mGson = new Gson();
		try {
			return (E) mGson.toJson(jsonObject, clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	// Javabean到Json字符串
	public static <T> String bean2Str(T t) {
		Gson gson = new Gson();
		return gson.toJson(t);
	}

	// Javabean到Json数组字符串
	public static <T> String list2Str(List<T> t, Type type) {
		Gson gson = new Gson();
		return gson.toJson(t, type);
	}

	// 从JsonArray字符串数组解析到JavaBean
	public static <T> List<T> str2List(String jsonString, Class<T> clazz) {
		if (isEmptyJsonStr(jsonString)) {
			return null;
		}
		Gson mGson = new Gson();
		ArrayList<T> mList = new ArrayList<T>();
		JsonArray array = new JsonParser().parse(jsonString).getAsJsonArray();
		for (final JsonElement elem : array) {
			mList.add(mGson.fromJson(elem, clazz));
		}
		return mList;
	}

	// 从JsonArray字符串数组解析到JavaBean
	public static <T> List<T> str2List(String jsonString, Type type) {
		if (isEmptyJsonStr(jsonString)) {
			return null;
		}
		Gson gson = new Gson();
		try {
			List<T> list = gson.fromJson(jsonString, type);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	  //T泛型传入参数类型  E泛型返回参数类型  实现从JSONString到JavaBean的转换  数组也没问题
    public static <T,E> E StrToBean(String jsonString, Class<T> clazz){
        if(isEmptyJsonStr(jsonString)){
            return null;
        }
        Gson mGson = new Gson();
        try{
            return (E) mGson.fromJson(jsonString,clazz);
        }catch (Exception e){
            e.printStackTrace();
            ArrayList<T> mList = new ArrayList<T>();
            JsonArray array = new JsonParser().parse(jsonString).getAsJsonArray();
            for(final JsonElement elem : array){
                mList.add(mGson.fromJson(elem, clazz));
            }
            return (E) mList;
        }
    }
    
    /**
     * @param json
     * @param clazz
     * @return
     */
    public static <T> ArrayList<T> jsonToArrayList(String json, Class<T> clazz)
    {
        Type type = new TypeToken<ArrayList<JsonObject>>()
        {}.getType();
        ArrayList<JsonObject> jsonObjects = new Gson().fromJson(json, type);

        ArrayList<T> arrayList = new ArrayList<T>();
        for (JsonObject jsonObject : jsonObjects)
        {
            arrayList.add(new Gson().fromJson(jsonObject, clazz));
        }
        return arrayList;
    }
	

	public static Map<String, String> toMap(String json) {
		return new Gson().fromJson(json, new TypeToken<Map<String, String>>() {}.getType());
	}

	// Json的判空工具
	private static boolean isEmptyJsonStr(String jsonString) {
		if (jsonString == null) {
			return true;
		}
		// switch (jsonString) {
		// case "":
		// case "null":
		// case "{}":
		// return true;
		// }
		if ("".equals(jsonString) || "null".equals(jsonString) || "{}".equals(jsonString)) {
			return true;
		}
		return false;
	}

//	判断该字符串是否属于一个 json 字符串
	public static boolean isGoodJson(String jsonString) {

		if (TextUtils.isEmpty(jsonString)) {
			return false;
		}
		Gson gson = new Gson();
		try {
			new JsonParser().parse(jsonString);
			return true;
		} catch (JsonParseException e) {
			return false;
		}

	}

}
