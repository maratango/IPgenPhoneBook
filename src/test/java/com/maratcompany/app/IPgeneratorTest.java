package com.maratcompany.app;

import static org.junit.Assert.*;
import org.junit.Test;

public class IPgeneratorTest 
{
	
    @Test
    public void testGeneration() {
		String s1;
		String s2;
		String s3 = "123.456.7.9" + "\n";
		
		s1 = "123.456.78.90";
		s2 = "123.456.7.8";
		assertEquals("Unexpected value 1", "Некорректный начальный IP-адрес, повторите попытку", new IPgenerator().generation(s1, s2));
		
		s1 = "12345678";
		s2 = "123.456.7.8";
		assertEquals("Unexpected value 2", "Некорректный начальный IP-адрес, повторите попытку", new IPgenerator().generation(s1, s2));
		
		s1 = "abc.456.h.k";
		s2 = "123.456.7.8";
		assertEquals("Unexpected value 3", "Некорректный начальный IP-адрес, повторите попытку", new IPgenerator().generation(s1, s2));
		
		s1 = "123.456.7.8";
		s2 = "123.456.78.90";
		assertEquals("Unexpected value 4", "Некорректный конечный IP-адрес, повторите попытку", new IPgenerator().generation(s1, s2));
		
		s1 = "123.456.7.8";
		s2 = "12345678";
		assertEquals("Unexpected value 5", "Некорректный конечный IP-адрес, повторите попытку", new IPgenerator().generation(s1, s2));
		
		s1 = "123.456.7.8";
		s2 = "abc.456.h.k";
		assertEquals("Unexpected value 6", "Некорректный конечный IP-адрес, повторите попытку", new IPgenerator().generation(s1, s2));
		
		s1 = "123.456.7.8";
		s2 = "123.456.7.1";
		assertEquals("Unexpected value 7", "Конечный IP-адрес должен быть больше начального, повторите попытку", new IPgenerator().generation(s1, s2));
		
		s1 = "123.456.7.8";
		s2 = "123.456.8.0";
		assertEquals("Unexpected value 8", s3, new IPgenerator().generation(s1, s2));
    }
	
}