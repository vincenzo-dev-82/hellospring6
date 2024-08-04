package com.vincenzo.hellospring;

import java.util.List;

public class Sort {

    public List<String> sortByLength(List<String> list) {
//        Collections.sort(list, (o1, o2) -> o1.length() - o2.length());
        list.sort((o1, o2) -> o1.length() - o2.length());
        return list;
    }

//    public static void main(String[] args) {
//
//        List<String> scores1 = Arrays.asList("z", "a", "spring", "java");
//        Collections.sort(scores1);
//        scores1.forEach(System.out::println);
//
//        // Comparator를 사용한 비교
//        List<String> scores2 = Arrays.asList("z", "a", "spring", "java");
//        Collections.sort(scores2, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length() - o2.length();
//            }
//        });
//        scores2.forEach(System.out::println);
//
//        // 람다식
//        List<String> scores3 = Arrays.asList("z", "a", "spring", "java");
//        Collections.sort(scores3, (o1, o2) -> o1.length() - o2.length());
//        scores3.forEach(System.out::println);
//    }

}
