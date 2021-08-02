package com.rainsia.exp006.test;

import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.rainsia.exp006.test.freq.FrequencyTest;

public class Exp6TestRunner {
	public static void main(String[] args) {
		int totalTests = 12;
		Result testResult = JUnitCore.runClasses(FrequencyTest.class);
		int runCount = testResult.getRunCount();
		if(runCount != totalTests) {
			System.err.println("程序存在错误，无法执行所有的测试例，请检查改正后重新测试！");
		} else {
			int failureCount = testResult.getFailureCount();
			System.out.println("共运行" + runCount + "个测试，其中有" + failureCount + "个错误!");
			List<Failure> failures = testResult.getFailures();
			int count = 0;
			for(Failure failure : failures) {
				System.out.println("错误" + ++count);
				System.out.println("\t" + failure.getMessage());
				System.out.println("\t" + failure.getDescription());
			}
			
			double lose = Math.round((double)failureCount / (double)totalTests * 50);
			
			System.out.println("最终得分: " + (50 - lose));
		}
	}
}
