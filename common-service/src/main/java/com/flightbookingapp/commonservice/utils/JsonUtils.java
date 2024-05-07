package com.flightbookingapp.commonservice.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flightbookingapp.commonservice.exception.CommonException;

import jakarta.servlet.http.HttpServletRequest;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class JsonUtils {
	@Autowired
	ErrorMessage errMsg;
	@Autowired
	ErrorCode errCode;
	
	public String serializeClass(final Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			log.error("Error during serialization", e);
			return null;
		}
	}
	
	public byte[] serializeClassToByte(final Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsBytes(obj);
		} catch (JsonProcessingException e) {
			log.error("Error during serialization", e);
			return new byte[0];
		}
	}
	
	public static <T> T deserializeClass(String obj, TypeReference<T> typeReference) {
		if(obj == null)return null;
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			obj = obj.replace("\n", "");
			return mapper.readValue(obj, typeReference);
		} catch (JsonProcessingException e) {
			log.error("Error during deserialization", e);
			return null;
		}
	}
	
	public <T> T bindRequestToObject(HttpServletRequest request, TypeReference<T> typeReference) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		T response = null;
		try {
			response = mapper.readValue(request.getInputStream(), typeReference);
		} catch (Exception e) {
			log.error("Exception at json request parsing ", e);
			throw new CommonException(errMsg.getInvalidRequest(), errCode.getInvalidRequest(), HttpStatus.BAD_REQUEST);
			}
		return response;
	}

}
