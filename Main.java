package calculator;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Введите запрос: ");

		String userInput = scan.nextLine();

		System.out.println(calc(userInput));
	}

	public static String calc(String input) {

        	String[] array = input.split(" ");
		if (array.length != 3) throw new IllegalArgumentException("Введено неверно; выражение должно состоять из трёх частей. Пример правильного ввода: 5 - 2");

		Numbers numbers;


	try {
    		if (Integer.parseInt(array[0]) > 10 || Integer.parseInt(array[2]) > 10 || Integer.parseInt(array[0]) < 1 || Integer.parseInt(array[2]) < 1) throw new IllegalArgumentException("Введено неверно; цифры должны быть в диапазоне от 1 до 10.");
		numbers = new NormalNumbers(Integer.parseInt(array[0]), Integer.parseInt(array[2])); 
	
	} catch (NumberFormatException e) {
		int i = 1;
		boolean firstIsRoman = false;
		boolean secondIsRoman = false;



		
		while (i < 11 && (firstIsRoman == false || secondIsRoman == false)) {
			if (array[0].equals(RomanNumbers.getRomanArray()[i])) {
				firstIsRoman = true;
			}
			if (array[2].equals(RomanNumbers.getRomanArray()[i])) {
				secondIsRoman = true;
			}
			i++;
		}

		if (firstIsRoman && secondIsRoman) {
			numbers = new RomanNumbers(array[0], array[2]);
		}
				
		else throw new NumberFormatException("Ошибка в вводе.");


	}


	switch(array[1]) {
		case "+":
			numbers.add();
			break;
		case "-":
			numbers.sub();
			break;
		case "*":
			numbers.mult();
			break;
		case "/":
			numbers.div();
			break;
		default:
			throw new IllegalArgumentException("Оператор введён неправильно; допускаются только: + - * /");
	}


	
	if (numbers instanceof NormalNumbers) {

		return "" + ((NormalNumbers)numbers).getResult();  
	}

		return ((RomanNumbers)numbers).getResultAsRoman();
	
	}
}