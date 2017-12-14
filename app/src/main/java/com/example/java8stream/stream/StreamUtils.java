package com.example.java8stream.stream;

import android.widget.ArrayAdapter;

import com.example.java8stream.bean.Artist;
import com.example.java8stream.data.SampleData;
import com.example.java8stream.toast.ToastUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamUtils {
	
	static int[] arr = {4,12,1,3,5,7,9};

    public static void filter(){
        Arrays.stream(arr).filter((x) -> x%2 !=0).forEach(System.out::println);
    }
    
    public static void map(){
        Arrays.stream(arr).map((x) -> x * x).forEach(System.out::println);
    }
    public static void reduce(){
        Arrays.stream(arr).reduce((x,y) -> x+y).ifPresent(System.out::println);
        //System.out.println(Arrays.stream(arr).reduce(-10, (x, y) -> x + y));
        ToastUtils.showToast(Arrays.stream(arr).reduce(-10, (x, y) -> x + y));
    }
    public static void collect(){
        List<Integer> list = Arrays.stream(arr).collect(ArrayList::new,ArrayList::add,ArrayList::addAll);
        System.out.println(list);

        Set<Integer> set = list.stream().collect(Collectors.toSet());
        System.out.println(set);
    }
    public static void peek(){
        long count = Arrays.stream(arr).filter(x -> x > 2).peek(System.out::println).count();
        System.out.println(count);
    }
    public static void average(){
        Arrays.stream(arr).average().ifPresent(System.out::println);
    }
    public static void sum(){
        System.out.println(Arrays.stream(arr).sum());
    }
    public static void max(){
        Arrays.stream(arr).max().ifPresent(System.out::println);
    }
    public static void min(){
        Arrays.stream(arr).min().ifPresent(System.out::println);
    }
    public static void arrStream(){
        Arrays.stream(arr).forEach(System.out::println);
    }
    public static void then(){
//      IntConsumer out = System.out::println;
//      IntConsumer err = System.err::println;
      IntConsumer out = (x) -> System.out.println("out consume:"+x);
      IntConsumer err = (x) -> System.err.println("err consume:"+x);
//      Arrays.stream(arr).forEach(out.andThen(err));
      Arrays.stream(arr).forEach(err.andThen(out));
  }
    public static void foreach(){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        numbers.forEach(System.out::println);
    }
    public static void visitOuterVar(){
        final int num = 2;
        Function<Integer,Integer> fun = (from) -> from * num;
        System.out.println(fun.apply(3));
    }
    
    public static void sorted(){
        Comparator<Artist> asc = (x,y) -> x.getName().compareTo(y.getName());
     
        //SampleData.getThreeArtists().stream().sorted(asc).forEach(System.out::println);
        //SampleData.getThreeArtists().stream().sorted(asc.reversed()).forEach(System.out::println);
        //SampleData.getThreeArtists().stream().sorted(Comparator.comparing(Artist::getName)).forEach(System.out::println);
         //SampleData.getThreeArtists().stream().sorted(Comparator.comparing(Artist::getName).reversed()).forEach(System.out::println);
        SampleData.getThreeArtists().stream().sorted(Comparator.comparing(Artist::getName).thenComparing(Artist::getNationality)).forEach(System.out::println);
    }
    public static void groupBy(){
        Map<String,List<Artist>> rs = SampleData.getThreeArtists().stream().collect(Collectors.groupingBy(Artist::getNationality));
        System.out.println(rs);
    }
    public static void join(){
        String joinedNames = SampleData.getThreeArtists().stream().map(Artist::getName).collect(Collectors.joining(","));
        System.out.println(joinedNames);
        joinedNames.chars().mapToObj(c -> (char) Character.toUpperCase(c)).forEach(System.out::println);
    }
    public static void flatMap(){
        Set<String> rs = SampleData.getThreeArtists().stream().flatMap(a -> Stream.of(a.getName())).collect(Collectors.toSet());
        rs.stream().forEach(System.out::println);
    }
}
