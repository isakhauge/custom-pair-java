package com.isakhauge;

import com.isakhauge.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		ArrayList<Pair<String,Double>> pairs = new ArrayList<>(Arrays.asList(
			new Pair<>("Test", 3.14),
			new Pair<>("Test", 10.0),
			new Pair<>("Test", 20.0),
			new Pair<>("Test", 1337.0),
			new Pair<>("Test", -3.14),
			new Pair<>("Test", 0.0)
		));
		System.out.println(pairs.toString());
		Collections.sort(pairs);
		System.out.println(pairs.toString());
	}
}
