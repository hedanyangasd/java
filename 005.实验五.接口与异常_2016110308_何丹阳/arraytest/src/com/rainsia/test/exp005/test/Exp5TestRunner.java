package com.rainsia.test.exp005.test;

import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.rainsia.exp005.test.list.MyArrayListTest;
import com.rainsia.exp005.test.list.MyLinkedListTest;

public class Exp5TestRunner {
	public static void main(String[] args) {
		int totalTests = 59;
		Result testResult = JUnitCore.runClasses(MyArrayListTest.class, MyLinkedListTest.class);
		int runCount = testResult.getRunCount();
		if(runCount != totalTests) {
			System.err.println("������ڴ����޷�ִ�����еĲ�������������������²��ԡ�");
		} else {
			int failureCount = testResult.getFailureCount();
			System.out.println("������" + runCount + "�����ԣ�������" + failureCount + "������!");
			List<Failure> failures = testResult.getFailures();
			int count = 0;
			for(Failure failure : failures) {
				System.out.println("����" + ++count);
				System.out.println("\t" + failure.getMessage());
				System.out.println("\t" + failure.getDescription());
			}
			
			double lose = Math.round((double)failureCount / (double)totalTests * 50);
			
			System.out.println("���յ÷�: " + (50 - lose));
		}
	}
}
