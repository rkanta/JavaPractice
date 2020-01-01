package com.lambdaexp.lambda;

import javax.management.RuntimeErrorException;

interface CalcImpl{
	//public void PrintSomething();
	int Substract(int i,int j); 
}

public class LambdaCalculator{



	public static void main(String[] args) {

		//CalcImpl calc = ()->System.out.println("Printing from Lambda expression!!");
		//calc.PrintSomething();
		CalcImpl calc = (a,b)->{
			if(a<b) {
				throw new RuntimeException("message");
			}else {
				return a-b;
			}
		};

		System.out.println(calc.Substract(12, 10));

	}



}
