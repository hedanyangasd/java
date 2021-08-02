package com.rainsia.test.exp004.line;

import org.junit.Assert;
import org.junit.Test;

import danyang.he.Line.Point2D;

public class TestPoint2D {

	@Test
	public void testZeroPointEqual() {
		Point2D p1 = new Point2D (0, 0);
		Point2D p2 = new Point2D (0, 0);
		
		Assert.assertEquals("������ȷ�ж���ͨ���Ƿ����", p1, p2);
	}

	@Test
	public void testPositivePointEqual() {
		Point2D p1 = new Point2D (2, 100);
		Point2D p2 = new Point2D (2, 100);
		
		Assert.assertEquals("������ȷ�ж���ͨ���Ƿ����", p1, p2);
	}

	@Test
	public void testNegativePointEqual() {
		Point2D p1 = new Point2D (-10, -50);
		Point2D p2 = new Point2D (-10, -50);
		
		Assert.assertEquals("������ȷ�ж���ͨ���Ƿ����", p1, p2);
	}
	
	@Test
	public void testDoublePointEqual() {
		Point2D p1 = new Point2D (0.03, 1.6);
		Point2D p2 = new Point2D (0.03, 1.6);
		
		Assert.assertEquals("������ȷ�ж���ͨ���������Ƿ����", p1, p2);
	}
	
	@Test
	public void testPointNotEqual() {
		Point2D p1 = new Point2D (0, 0);
		Point2D p2 = new Point2D (0, 2);

		Assert.assertNotEquals("������ȷ�ж���ͨ���Ƿ����", p1, p2);
	}

	@Test
	public void testDoublePointNotEqual() {
		Point2D p1 = new Point2D (10.5, 99.9);
		Point2D p2 = new Point2D (0, 2.9);

		Assert.assertNotEquals("������ȷ�ж���ͨ�����͵��Ƿ����", p1, p2);
	}
	
	
	@Test
	public void testInfinityPointNotEqual() {
		try {
			Point2D p1 = new Point2D (0, Double.POSITIVE_INFINITY);
			Point2D p2 = new Point2D (0, Double.POSITIVE_INFINITY);

			Assert.assertNotEquals("������ȷ��������������ĵ�", p1, p2);
		} catch(Exception e) {
			Assert.fail("������ȷ��������������ĵ�");
		}
	}
	
		
	@Test
	public void testPointNotEqualToObject() {
		Point2D p1 = new Point2D (0, 0);
		Object p2 = new Object();
		
		try{
			Assert.assertNotEquals("�޷���ȷ�жϵ����ͨ�����ϵ", p1, p2);
		}catch(Exception e) {
			Assert.fail("�޷���ȷ�жϵ����ͨ�����ϵ");
		}
	}
	
	@Test
	public void testDefaultPoint() {
//		Point2D p = new Point();
	}
	

}
