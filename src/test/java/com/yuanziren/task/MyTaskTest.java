package com.yuanziren.task;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class MyTaskTest {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("spring.xml");
    }
}