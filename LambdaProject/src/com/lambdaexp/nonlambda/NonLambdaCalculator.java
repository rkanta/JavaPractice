package com.lambdaexp.nonlambda;

 interface CalcInter{
	
	public void PrintSomething();
}

public class NonLambdaCalculator implements CalcInter{

	@Override
	public void PrintSomething() {
		System.out.println("Implementing non lamda implmentation");
		
	}
	
	public static void main(String[] args) {
		CalcInter calc = new NonLambdaCalculator();
		calc.PrintSomething();
	}
	
}