package com.cursomc.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class URL {
	
	public static String decodeParam(String s) {
		try {
			return URLDecoder.decode(s, "UTF-8");
		} 
		catch (UnsupportedEncodingException e) {
			return "";
		}
	}	
	
	public static List<Integer> decodeIntList(String s) {
		return Stream.of(s.split(",")).map(Integer::parseInt).collect(Collectors.toList());

	}
}
