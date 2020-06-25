package com.maratcompany.app;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;
import java.awt.event.*;	
import java.awt.*;

public class Kirov {
	
	public static void main (String[] args) {

		new Kirov().go();
		
	}
	//метод по выводу первого окна
	public void go () {
	
		//создаём фрейм, задаём "конец программы при закрытии", размер
		final JFrame frame = new JFrame("Тестовые задания");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.setSize(650,150);
		frame.setLocation(300, 300);
		//метка
		JLabel label = new JLabel("Выберите задание");
		label.setHorizontalAlignment(JLabel.CENTER);	
		//кнопки
		JButton button_1 = new JButton("Задание 1");
		JButton button_2 = new JButton("Задание 2");
		//панель для метки
		JPanel panel_A = new JPanel(new GridLayout(1, 3, 30, 30));
		panel_A.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel_A.add(label);
		//панель для кнопок
		JPanel panel_B = new JPanel(new GridLayout(1, 4, 30, 30));
		panel_B.add(new JPanel());
		panel_B.add(button_1);
		panel_B.add(button_2);
		panel_B.add(new JPanel());
		//размещаем панели вертикально внутри внешней панели
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(panel_A);			//панель для метки
		panel.add(panel_B);			//панель для кнопок
		//размещаем внешнюю панель во фрейм и делаем видимым
		frame.getContentPane().add(BorderLayout.NORTH,panel);		
		frame.setVisible(true);
		//слушатель кнопки 1
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new IPgenerator().dialogFormation();
				frame.setVisible(false);
			}
		});
		//слушатель кнопки 2
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new PhoneBook().windowFormation();
				frame.setVisible(false);
			}
		});
		
	}
	
}

class IPgenerator {
	
    private String ipResult;            //результирующий IP-aдрес в виде строки
    private int ipStart;                //начальный IP-адрес в виде числа
    private int ipEnd;                  //конечный IP-адрес в виде числа
	String r = "1";						//возвращаемый текст
	
	//метод по выводу окна "Задание 1"
	public void dialogFormation () {
		
		//создаём фрейм, задаём "конец программы при закрытии", размер
		JFrame frame_2 = new JFrame("Задание 1");
		frame_2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame_2.setSize(400,500);
		frame_2.setLocation(300, 300);
		//метки
		JLabel label_2 = new JLabel("Введите начальный IP-адрес");
		label_2.setHorizontalAlignment(JLabel.LEFT);
		JLabel label_3 = new JLabel("Введите конечный IP-адресс");
		label_3.setHorizontalAlignment(JLabel.LEFT);		
		JLabel label_4 = new JLabel("Результат:");
		label_4.setHorizontalAlignment(JLabel.LEFT);
		//текстовое поля
		final JTextField textField = new JTextField(30);
		final JTextField textField_2 = new JTextField(30);
		final JTextArea textArea = new JTextArea(8, 30);
		//кнопка
		JButton button_2 = new JButton("Старт");
		//скролл-панель
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(textArea);
		//панель для кнопки
		JPanel panel_C = new JPanel(new GridLayout(1, 3, 1, 1));
		panel_C.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel_C.add(new JPanel());
		panel_C.add(button_2);	
		panel_C.add(new JPanel());
		//панель для скролл-панели
		JPanel panel_D = new JPanel(new GridLayout(1, 1, 1, 1));
		panel_D.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));		
		panel_D.add(scroll);
		//размещаем компоненты внутри панели
		JPanel panel_2 = new JPanel(new GridLayout(6, 1, 1, 1));
		panel_2.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		panel_2.add(label_2);			//первая метка		
		panel_2.add(textField);			//текстовое поле 1
		panel_2.add(label_3);			//вторая метка
		panel_2.add(textField_2);		//текстовое поле 2
		panel_2.add(panel_C);			//панель для кнопки
		panel_2.add(label_4);			//третья метка
		//размещаем панели внутри внешней панели
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		panel_3.add(panel_2);
		panel_3.add(panel_D);
		//размещаем внешнюю панель во фрейм и делаем видимым
		frame_2.getContentPane().add(BorderLayout.NORTH, panel_3);
		frame_2.setVisible(true);
		//слушатель кнопки Старт
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String s1 = textField.getText();
				String s2 = textField_2.getText();
				textArea.setText(new IPgenerator().generation(s1, s2));	//передаём IP-адреса в строковом виде, из полей 1 и 2 
			}
		});
		
	}
	
	//метод по генерации IP-адресов и передаче результата в окно "Задание 1"
	public String generation (String userValStart, String userValEnd) {		//принимает начальный и конечный IP-адреса в виде строки
		
		//проверки начального IP-адреса
		//проверка на количество символов
        if (userValStart.length() != 11) {
            r = "Некорректный начальный IP-адрес, повторите попытку";
			return r;
        }
        //проверка на наличие символа "." в нужных позициях
        if (!userValStart.substring(3, 4).equals(".") || !userValStart.substring(7, 8).equals(".") || !userValStart.substring(9, 10).equals(".")) {
            r = "Некорректный начальный IP-адрес, повторите попытку";
			return r;
        }
        //проверка на возможность преобразования введенного строкового IP-адреса в число, преобразование введенного строкового IP-адреса в число
        try {
            ipStart = Integer.parseInt(userValStart.substring(0, 3) + userValStart.substring(4, 7) + userValStart.substring(8, 9) + userValStart.substring(10));
        } catch (NumberFormatException ex) {
            r = "Некорректный начальный IP-адрес, повторите попытку";
			return r;
        }
		//проверки конечного IP-адреса		
        if (userValEnd.length() != 11) {
            r = "Некорректный конечный IP-адрес, повторите попытку";
			return r;
        }
        if (!userValEnd.substring(3, 4).equals(".") || !userValEnd.substring(7, 8).equals(".") || !userValEnd.substring(9, 10).equals(".")) {
            r = "Некорректный конечный IP-адрес, повторите попытку";
			return r;
        }
        try {
            ipEnd = Integer.parseInt(userValEnd.substring(0, 3) + userValEnd.substring(4, 7) + userValEnd.substring(8, 9) + userValEnd.substring(10));
        } catch (NumberFormatException ex) {
            r = "Некорректный конечный IP-адрес, повторите попытку";
			return r;
        }
        //проверка-сравнение велечин начального и конечного IP-адреса
        if (ipEnd <= ipStart) {
            r = "Конечный IP-адрес должен быть больше начального, повторите попытку";
			return r;
        }
        //записываем в виде строки IP-адреса между начальным и конечным, добавляя символы "."
        for(int i = ipStart+1; i < ipEnd; i++) {
            ipResult = Integer.toString(i);
            ipResult = ipResult.substring(0,3) + "." + ipResult.substring(3,6) + "." + ipResult.substring(6,7) + "." + ipResult.substring(7,8);
            if (r.equals("1")) {
				r = ipResult + "\n";
			} else {
				r = r + ipResult + "\n";
			}
		}
		return r;
		
	}
	
}

class PhoneBook {
	
    private ArrayList<String> phoneNumbers = new ArrayList<> ();        //для хранения списка Телефонов
    private HashMap<String, String> numbersAndNames = new HashMap<>();  //для хранения списка пар Телефон-ФИО
	String g = "1";														//возвращаемый текст
    int fQuan;                                                          //счётчик подходящих Телефонов
	
	//метод по выводу окна "Задание 2"
	public void windowFormation () {
		
		//создаём фрейм, задаём "конец программы при закрытии", размер
		JFrame frame_3 = new JFrame("Задание 2");
		frame_3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame_3.setSize(400,350);
		frame_3.setLocation(300, 300);
		//метки
		JLabel label_5 = new JLabel("Введите ФИО(в формате Фамилия И.О.)");
		label_5.setHorizontalAlignment(JLabel.LEFT);
		JLabel label_6 = new JLabel("Результат:");
		label_6.setHorizontalAlignment(JLabel.LEFT);
		//текстовые поля
		final JTextField textField_3 = new JTextField(30);
		final JTextArea textArea_2 = new JTextArea(8, 30);
		//кнопка
		JButton button_3 = new JButton("Старт");
		//скролл-панель
		JScrollPane scroll_2 = new JScrollPane();
		scroll_2.setViewportView(textArea_2);
		//панель для кнопки
		JPanel panel_E = new JPanel(new GridLayout(1, 3, 1, 1));
		panel_E.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
		panel_E.add(new JPanel());
		panel_E.add(button_3);	
		panel_E.add(new JPanel());
		//панель для скролл-панели
		JPanel panel_F = new JPanel(new GridLayout(1, 1, 1, 1));
		panel_F.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));		
		panel_F.add(scroll_2);
		//размещаем компоненты внутри панели
		JPanel panel_4 = new JPanel(new GridLayout(4, 1, 1, 1));
		panel_4.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		panel_4.add(label_5);			//первая метка		
		panel_4.add(textField_3);		//текстовое поле 1
		panel_4.add(panel_E);			//панель для кнопки
		panel_4.add(label_6);			//третья метка		
		//размещаем панели внутри внешней панели
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.Y_AXIS));
		panel_5.add(panel_4);
		panel_5.add(panel_F);		
		//размещаем внешнюю панель во фрейм и делаем видимым
		frame_3.getContentPane().add(BorderLayout.NORTH, panel_5);
		frame_3.setVisible(true);
		//слушатель кнопки Старт
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String z1 = textField_3.getText();
				textArea_2.setText(new PhoneBook().phoneBookWorking(z1));	//передаём ФИО из поля
			}
		});
		
	}
	
	//метод по поиску Телефонов и передаче результата в окно "Задание 2"
	public String phoneBookWorking (String userVal) {
		
        //наполним список пар Телефон-ФИО
        numbersAndNames.put("+8 800 2000 500","Иванов И.И.");
        numbersAndNames.put("+8 800 2000 600","Иванов И.И.");
        numbersAndNames.put("+8 800 2000 700","Петров П.П.");
        numbersAndNames.put("+8 800 2000 800","Сидоров С.С.");
        numbersAndNames.put("+8 800 2000 900","Сидоров С.С.");
        numbersAndNames.put("+8 800 2000 000","Сидоров С.С.");
        //наполним список Телефонов
        phoneNumbers.add("+8 800 2000 500");
        phoneNumbers.add("+8 800 2000 600");
        phoneNumbers.add("+8 800 2000 700");
        phoneNumbers.add("+8 800 2000 800");
        phoneNumbers.add("+8 800 2000 900");
        phoneNumbers.add("+8 800 2000 000");
        //перебор списков, запись Телефона если его ФИО равно ФИО введённому пользователем
        for (String i :  phoneNumbers) {
            if (numbersAndNames.get(i).equals(userVal)) {
                if (g.equals("1")) {
					g = i + "\n";
				} else {
					g = g + i + "\n";
				}
                fQuan++;
            }
        }
        //если не нашлось Телефона
        if (fQuan < 1) {
            g = "Такого ФИО нет в телефонной книге";
        }
		return g;
		
	}
	
}