package com.maratcompany.app;

import static org.junit.Assert.*;
import org.junit.Test;

public class PhoneBookTest 
{
	
    @Test
    public void testPhoneBookWorking()
    {
		String z1;
		String z2 = "+8 800 2000 700" + "\n";
		
		z1 = "Шнякин А.А.";
		assertEquals("Unexpected value 1", "Такого ФИО нет в телефонной книге", new PhoneBook().phoneBookWorking(z1));
		
		z1 = "Иванов Иван Иванович";
		assertEquals("Unexpected value 2", "Такого ФИО нет в телефонной книге", new PhoneBook().phoneBookWorking(z1));
		
		z1 = "Петров П.П.";
		assertEquals("Unexpected value 3", z2, new PhoneBook().phoneBookWorking(z1));
    }
	
}