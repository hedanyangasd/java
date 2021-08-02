package com.rainsia.test.exp004.line;

import org.junit.Assert;
import org.junit.Test;

import danyang.he.Line.Line2D;
import danyang.he.Line.Point2D;

public class TestLine2DParallel {

	/////////////normal parallel/////////////
	@Test
	public void testNormal2PointsLineParallel() {
		Line2D line1 = new Line2D(new Point2D(4.7, 5.2), new Point2D(1, -17));
		Line2D line2 = new Line2D(new Point2D(100.9, 7.6), new Point2D(9, -543.8));
		
		Assert.assertTrue("����������������ʽƽ��", line1.isParallel(line2));
	}
	
	@Test
	public void test2PointsLineParallelWithSlopePointLine() {
		Line2D line1 = new Line2D(new Point2D(4.7, 5.2), new Point2D(1, -17));
		Line2D line2 = new Line2D(new Point2D(20, 22), 6.0);
		Assert.assertTrue("����������������ʽ���бʽƽ��", line1.isParallel(line2));
	}
	
	@Test
	public void test2PointsLineParallelWithInterceptLine() {
		Line2D line1 = new Line2D(new Point2D(100.9, 7.6), new Point2D(9, -543.8));
		Line2D line2 = new Line2D(8.2, -49.2);

		Assert.assertTrue("����������������ʽ��ؾ�ʽƽ��", line1.isParallel(line2));
	}
	
	@Test
	public void testSlopePointLineParallelWith2Intercepts() {
		Line2D line1 = new Line2D(new Point2D(100, 22), 6.0);
		Line2D line2 = new Line2D(7.6, -45.6);

		Assert.assertTrue("�������������бʽ��ؾ�ʽƽ��", line1.isParallel(line2));
	}

	/////////////normal not parallel/////////////
	@Test
	public void testNormal2PointsLineNotParallel() {
		Line2D line1 = new Line2D(new Point2D(4.7, 5.2), new Point2D(1, -23));
		Line2D line2 = new Line2D(new Point2D(100.9, 7.6), new Point2D(9, -543.8));
		
		Assert.assertFalse("����������������ʽ��ƽ��", line1.isParallel(line2));
	}
	
	@Test
	public void test2PointsLineNotParallelWithSlopePointLine() {
		Line2D line1 = new Line2D(new Point2D(4.7, 5.2), new Point2D(1, -17));
		Line2D line2 = new Line2D(new Point2D(20, 22), -6.0);

		Assert.assertFalse("����������������ʽ���бʽ��ƽ��", line1.isParallel(line2));
	}
	
	@Test
	public void test2PointsLineNotParallelWithInterceptLine() {
		Line2D line1 = new Line2D(new Point2D(100.9, 7.6), new Point2D(9, -543.8));
		Line2D line2 = new Line2D(8.2, 49.2);

		Assert.assertFalse("����������������ʽ��ؾ�ʽ��ƽ��", line1.isParallel(line2));
	}
	
	@Test
	public void testSlopePointLineNotParallelWith2Intercepts() {
		Line2D line1 = new Line2D(new Point2D(100, 22), 0.5);
		Line2D line2 = new Line2D(7.6, -41.6);

		Assert.assertFalse("�������������бʽ��ؾ�ʽ��ƽ��", line1.isParallel(line2));
	}
	
	////////////illegal/////////////////////
	@Test
	public void test2PointsNotParallel() {
		Line2D line1 = new Line2D(new Point2D(1, 1), new Point2D(1, 1));
		Line2D line2 = new Line2D(new Point2D(1, 1), new Point2D(1, 1));
		
		Assert.assertFalse("����������������ʽ��������ͬ�����", line1.isParallel(line2));
	}

	@Test
	public void test2PointsOriginalNotParallel() {
		Line2D line1 = new Line2D(new Point2D(0, 0), new Point2D(0, 0));
		Line2D line2 = new Line2D(new Point2D(0, 0), new Point2D(0, 0));
		
		Assert.assertFalse("����������������ʽ������ͬʱ��ԭ�����", line1.isParallel(line2));
	}
	
	@Test
	public void test2InitifyPointsNotParallel() {
		Line2D line1 = new Line2D(new Point2D(1, Double.POSITIVE_INFINITY), new Point2D(Double.NEGATIVE_INFINITY, 1));
		Line2D line2 = new Line2D(new Point2D(1, Double.POSITIVE_INFINITY), new Point2D(Double.NEGATIVE_INFINITY, 1));
		
		Assert.assertFalse("����������������ʽ������Ϊ��������", line1.isParallel(line2));
	}
	
	@Test
	public void test2InterceptsZeroNotEqual() {
		Line2D line1 = new Line2D(0, 0);
		Line2D line2 = new Line2D(0, 0);
		
		Assert.assertFalse("������������ؾ�ʽ�нؾ�ͬʱΪ������", line1.isParallel(line2));
	}
	
	@Test
	public void test2InterceptsInfinityNotEqual() {
		Line2D line1 = new Line2D(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
		Line2D line2 = new Line2D(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
		
		Assert.assertFalse("������������ؾ�ʽ�нؾ�ͬʱΪ��������", line1.isParallel(line2));
	}
	///////////////parallel with x axis not equal///////////////
	@Test
	public void test2PointsParallelXParallel() {
		Line2D line1 = new Line2D(new Point2D(1, 11.2), new Point2D(5, 11.2));
		Line2D line2 = new Line2D(new Point2D(100, 11), new Point2D(-55, 11));
		
		Assert.assertTrue("����������������ʽֱ��ƽ����x������", line1.isParallel(line2));
	}
	
	@Test
	public void testSlopePointParallelXParallel() {
		Line2D line1 = new Line2D(new Point2D(2.7, 22), 0.0);
		Line2D line2 = new Line2D(new Point2D(20, -22), 0.0);
		
		Assert.assertTrue("�������������бʽֱ��ƽ����x������", line1.isParallel(line2));
	}

	@Test
	public void test2InterceptsParallelXParallel() {
		Line2D line1 = new Line2D(Double.POSITIVE_INFINITY, 34.1);
		Line2D line2 = new Line2D(Double.POSITIVE_INFINITY, 34);
		
		Assert.assertTrue("������������ؾ�ʽֱ��ƽ����x������", line1.isParallel(line2));
	}

	@Test
	public void test2InterceptsParallelXParallelWith2Points() {
		Line2D line1 = new Line2D(Double.POSITIVE_INFINITY, 22);
		Line2D line2 = new Line2D(new Point2D(2, 21), new Point2D(11, 21));
		
		Assert.assertTrue("������������ؾ�ʽ������ʽֱ��ƽ����x������", line1.isParallel(line2));
	}

	@Test
	public void test2InterceptsParallelXParallelWithSlopePoint() {
		Line2D line1 = new Line2D(Double.POSITIVE_INFINITY, 1000);
		Line2D line2 = new Line2D(new Point2D(0, 0), 0.0);
		
		Assert.assertTrue("������������ؾ�ʽ���бʽֱ��ƽ����x������", line1.isParallel(line2));
	}

	@Test
	public void testSlopePointParallelXParallelWith2Points() {
		Line2D line1 = new Line2D(new Point2D(44, 500), 0.0);
		Line2D line2 = new Line2D(new Point2D(2, 200), new Point2D(11, 200));
		
		Assert.assertTrue("����������������ʽֱ��ƽ����x������", line1.isParallel(line2));
		Assert.assertNotEquals("�������������бʽֱ��������ʽƽ����x������", line1, line2);
	}

	///////////////parallel with y axis parallel///////////////
	@Test
	public void test2PointsParallelYParallel() {
		Line2D line1 = new Line2D(new Point2D(11.2, 1), new Point2D(11.2, 5));
		Line2D line2 = new Line2D(new Point2D(21.2, 100), new Point2D(21.2, -55));
		
		Assert.assertTrue("����������������ʽֱ��ƽ����Y������", line1.isParallel(line2));
	}
	
	@Test
	public void testSlopePointParallelYParallel() {
		Line2D line1 = new Line2D(new Point2D(0, 2.7), Double.POSITIVE_INFINITY);
		Line2D line2 = new Line2D(new Point2D(22, 20), Double.POSITIVE_INFINITY);
		
		Assert.assertTrue("�������������бʽֱ��������ʽƽ����Y������", line1.isParallel(line2));
	}

	@Test
	public void test2InterceptsParallelYParallel() {
		Line2D line1 = new Line2D(34.1, Double.POSITIVE_INFINITY);
		Line2D line2 = new Line2D(34, Double.POSITIVE_INFINITY);
		
		Assert.assertTrue("������������ؾ�ʽֱ��ƽ����Y������", line1.isParallel(line2));
	}

	@Test
	public void test2InterceptsParallelYParallelWith2Points() {
		Line2D line1 = new Line2D(99, Double.POSITIVE_INFINITY);
		Line2D line2 = new Line2D(new Point2D(22, 2), new Point2D(22, 11));
		
		Assert.assertTrue("������������ؾ�ʽֱ��������ʽƽ����Y������", line1.isParallel(line2));
	}

	@Test
	public void test2InterceptsParallelYParallelWithSlopePoint() {
		Line2D line1 = new Line2D(1000, Double.POSITIVE_INFINITY);
		Line2D line2 = new Line2D(new Point2D(1000, 2), Double.POSITIVE_INFINITY); 
		
		Assert.assertTrue("������������ؾ�ʽֱ�����бʽƽ����Y������", line1.isParallel(line2));
	}

	@Test
	public void testSlopePointParallelYParallelWith2Points() {
		Line2D line1 = new Line2D(new Point2D(500, 44), Double.POSITIVE_INFINITY);
		Line2D line2 = new Line2D(new Point2D(500.99, 2), new Point2D(500.99, 11));
		
		Assert.assertTrue("�������������бʽֱ��������ʽƽ����Y������", line1.isParallel(line2));
	}
}
