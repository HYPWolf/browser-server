package com.platon.browser.config;

import java.io.IOException;
import java.math.RoundingMode;

import org.web3j.utils.Convert;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.platon.browser.util.EnergonUtil;

/**
 *  返回金额转化实现类
 *  @file CustomLatSerializer.java
 *  @description 使用方式在具体的get方法上添加@JsonSerialize(using = CustomLatSerializer.class)
 *	@author zhangrj
 *  @data 2019年8月31日
 */
public class CustomLatSerializer  extends JsonSerializer<String>{

	@Override
	public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		/**	金额转换 von统一转换成小数点12位向下取整lat */
		String transEner = EnergonUtil.format(Convert.fromVon(value, Convert.Unit.LAT).setScale(18,RoundingMode.DOWN), 12);
		gen.writeString(transEner);
	}

}