package com.cursomc.resources.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tes {

	public static void main(String[] args) {
		String ints = "1, 2, 3";
		List<Integer> list = Stream.of(ints.split(", "))
	    .map(Integer::parseInt)
	    .collect(Collectors.toList());
		
		System.out.println(list);
		
	}

}
