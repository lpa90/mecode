package calculator;

class NormalNumbers implements Numbers {
	private int firstNumber;
	private int secondNumber;
	private int result;


	public NormalNumbers(int firstNumber,int secondNumber) {
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}


	public void add() {
		result = firstNumber + secondNumber;
	}

	public void sub() {
		result = firstNumber - secondNumber;
	}

	public void mult() {
		result = firstNumber * secondNumber;
	}

	public void div() {
		result = firstNumber / secondNumber;
	}


	public int getResult() {
		return result;
	}
}
