package com.example.java8stream.data;

import com.example.java8stream.bean.Artist;

import java.util.ArrayList;
import java.util.List;

public class SampleData {

	public static List<Artist> getThreeArtists() {
		List<Artist> lists=new ArrayList<>();
		lists.add(new Artist("张三", "zh"));
		lists.add(new Artist("Mike", "USA"));
		lists.add(new Artist("Frice", "FR"));
		return lists;
	}

}
