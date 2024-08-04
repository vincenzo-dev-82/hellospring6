package com.vincenzo.hellospring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SortTest {

    Sort sort;

    @BeforeEach
    void beforeach() {
        sort = new Sort();
        System.out.println(sort); // 항상 새로운 객체를 생성하도록 하여 각 테스트가 순서에 상관없이 동일한 결과를 만들어 내어야만 한다
    }

    @Test
    void sort() {
        List<String> list = sort.sortByLength(Arrays.asList("aa", "b"));

        Assertions.assertThat(list).isEqualTo(List.of("b", "aa"));
    }

    @Test
    void sort3Items() {
        List<String> list = sort.sortByLength(Arrays.asList("aa", "ccc", "b"));

        Assertions.assertThat(list).isEqualTo(List.of("b", "aa", "ccc"));
    }

    @Test
    void sortAlreadySorted() {
        List<String> list = sort.sortByLength(Arrays.asList("b", "aa", "ccc"));

        Assertions.assertThat(list).isEqualTo(List.of("b", "aa", "ccc"));
    }
}
