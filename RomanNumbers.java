package calculator;

class RomanNumbers implements Numbers {

	private int firstNumber;
	private int secondNumber;
	private String result;
	
	private final static String[] SMALLROMAN = {"0","I","II","III","IV","V","VI","VII","VIII","IX","X"};
	private final static String[] BIGROMAN = {"0","X","XX","XXX","XL","L","LX","LXX","LXXX","XC","C"};
	


	public static String[] getRomanArray() {			
		return SMALLROMAN;
	}


	public RomanNumbers(String firstNumber, String secondNumber) {
		this.firstNumber = makeInt(firstNumber);
		this.secondNumber = makeInt(secondNumber);
	}


	public void add() {	
		result = makeRoman(firstNumber + secondNumber);
	}
	public void sub() {
		result = makeRoman(firstNumber - secondNumber);
	}
	public void mult() {
		result = makeRoman(firstNumber * secondNumber);
	}
	public void div() {
		result = makeRoman(firstNumber / secondNumber);
	}

	
	public String getResultAsRoman() {
		return result;
	}
	
	
	private int makeInt(String roman) {
		int i = 0;
		while (!roman.equals(SMALLROMAN[i])) {
			i++;
		}
		return i;
	}


	
	private String makeRoman(int number) {

		
		if (number == 100)
			return "C";
		
		if (number < 1) {
			throw new RuntimeException("Результат меньше нуля");
		}


		int small = number % 10;
		int big = (number - small) / 10;

		String smallRoman = SMALLROMAN[small];
		String bigRoman = BIGROMAN[big];
		
		if (big == 0)
			return smallRoman;
		if (small == 0)
			return bigRoman;
		
		return (bigRoman + smallRoman);
	}
}






