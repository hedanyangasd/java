package com.rainsia.test.exp004.line;

import org.junit.Assert;
import org.junit.Test;

import danyang.he.Line.Line2D;
import danyang.he.Line.Point2D;

public class TestLine2DEqual {

	/////////////normal equals///////////////
	@Test
	public void testNormal2PointsLineEqual() {
		Line2D line1 = new Line2D(new Point2D(1, 1), new Point2D(3, 2));
		Line2D line2 = new Line2D(new Point2D(-1, 0), new Point2D(-3, -1));
		
		Assert.assertEquals("����������������ʽ���", line1, line2);
	}
	
	@Test
	public void testNormal2DoublePointsLineEqual() {
		Line2D line1 = new Line2D(new Point2D(2.2, 1.6), new Point2D(-10.4, -4.7));
		Line2D line2 = new Line2D(new Point2D(101.8, 51.4), new Point2D(0.2, 0.6));
		
		Assert.assertEquals("��������������������ʽ���", line1, line2);
	}
	
	@Test
	public void test2PointsLineEqualsSlopePointLine() {
		Line2D line1 = new Line2D(new Point2D(1, 1), new Point2D(3, 2));
		Line2D line2 = new Line2D(new Point2D(5, 3), 0.5);

		Assert.assertEquals("����������������ʽ���бʽ���", line1, line2);
	}
	
	@Test
	public void test2PointsLineEqualsInterceptLine() {
		Line2D line1 = new Line2D(new Point2D(2.2, 1.6), new Point2D(-10.4, -4.7));
		Line2D line2 = new Line2D(-1, 0.5);

		Assert.assertEquals("����������������ʽ��ؾ�ʽ���", line1, line2);
	}

	@Test
	public void testGeneralEquals2PointsLine() {
		Line2D line1 = new Line2D(new Point2D(2.2, 1.6), new Point2D(-10.4, -4.7));
		Line2D line2 = new Line2D(-1.5, -1, 6.5);

		Assert.assertEquals("������������һ��ʽ������ʽ���", line1, line2);
	}	
	
	@Test
	public void testGeneralEqualsInterceptLine() {
		Line2D line1 = new Line2D(new Point2D(3, 2), -1.5);
		Line2D line2 = new Line2D(13 / 3, 6.5);

		Assert.assertEquals("����������������ʽ��ؾ�ʽ���", line1, line2);
	}

	@Test
	public void testGeneralEqualsSlopePointLine() {
		Line2D line1 = new Line2D(new Point2D(3, 2), -1.5);
		Line2D line2 = new Line2D(-1.5, -1, 6.5);

		Assert.assertEquals("������������һ��ʽ���бʽ���", line1, line2);
	}

	///////////////normal not equal///////////////
	@Test
	public void testNormal2PointsLineNotEqual() {
		Line2D line1 = new Line2D(new Point2D(1, 1), new Point2D(3, 2));
		Line2D line2 = new Line2D(new Point2D(0, 0), new Point2D(-1, -1));
		
		Assert.assertNotEquals("����������������ʽ�����", line1, line2);
	}

	@Test
	public void testNormal2DoublePointsLineNotEqual() {
		Line2D line1 = new Line2D(new Point2D(2.2, 1.6), new Point2D(-10.4, -4.7));
		Line2D line2 = new Line2D(new Point2D(101.2, 51.1), new Point2D(1.2, 2.6));
		
		Assert.assertNotEquals("��������������������ʽ�����", line1, line2);
	}

	@Test
	public void test2PointsLineNotEqualsSlopePointLine() {
		Line2D line1 = new Line2D(new Point2D(1, 1), new Point2D(3, 2));
		Line2D line2 = new Line2D(new Point2D(5, 3), 0.7);

		Assert.assertNotEquals("����������������ʽ���бʽ�����", line1, line2);
	}

	@Test
	public void test2PointsLineNotEqualsInterceptLine() {
		Line2D line1 = new Line2D(new Point2D(2.2, 1.6), new Point2D(-10, -4));
		Line2D line2 = new Line2D(-2, 0.5);

		Assert.assertNotEquals("����������������ʽ��ؾ�ʽ�����", line1, line2);
	}
	
	@Test
	public void testSlopePointLineNotEqualsInterceptLine() {
		Line2D line1 = new Line2D(new Point2D(2.2, 3), 0.7);
		Line2D line2 = new Line2D(2, -0.5);

		Assert.assertNotEquals("����������������ʽ��ؾ�ʽ�����", line1, line2);
	}

	@Test
	public void testGeneralNotEquals2PointsLine() {
		Line2D line1 = new Line2D(new Point2D(2.2, 1.6), new Point2D(-10.4, -4.7));
		Line2D line2 = new Line2D(1.5, -1, 6.5);

		Assert.assertEquals("������������һ��ʽ������ʽ�����", line1, line2);
	}	

	
	@Test
	public void testGeneralNotEqualsInterceptLine() {
		Line2D line1 = new Line2D(new Point2D(3, 2), 1.5);
		Line2D line2 = new Line2D(13 / 3, 6.5);

		Assert.assertEquals("����������������ʽ��ؾ�ʽ�����", line1, line2);
	}

	@Test
	public void testGeneralNotEqualsSlopePointLine() {
		Line2D line1 = new Line2D(new Point2D(3, 2), -1.5);
		Line2D line2 = new Line2D(-1.5, 1, 6.5);

		Assert.assertEquals("������������һ��ʽ���бʽ�����", line1, line2);
	}
	
	///////////////illegal/////////////////
	@Test
	public void test2PointsNotEqual() {
		Line2D line1 = new Line2D(new Point2D(1, 1), new Point2D(1, 1));
		Line2D line2 = new Line2D(new Point2D(1, 1), new Point2D(1, 1));
		
		Assert.assertNotEquals("����������������ʽ��������ͬ�����", line1, line2);
	}

	@Test
	public void test2PointsOriginalNotEqual() {
		Line2D line1 = new Line2D(new Point2D(0, 0), new Point2D(0, 0));
		Line2D line2 = new Line2D(new Point2D(0, 0), new Point2D(0, 0));
		
		Assert.assertNotEquals("����������������ʽ������ͬʱ��ԭ�����", line1, line2);
	}
	
	@Test
	public void test2InitifyPointsNotEqual() {
		Line2D line1 = new Line2D(new Point2D(1, Double.POSITIVE_INFINITY), new Point2D(Double.NEGATIVE_INFINITY, 1));
		Line2D line2 = new Line2D(new Point2D(1, Double.POSITIVE_INFINITY), new Point2D(Double.NEGATIVE_INFINITY, 1));
		
		Assert.assertNotEquals("����������������ʽ������Ϊ��������", line1, line2);
	}
	
	@Test
	public void test2InterceptsZeroNotEqual() {
		Line2D line1 = new Line2D(0, 0);
		Line2D line2 = new Line2D(0, 0);
		
		Assert.assertNotEquals("������������ؾ�ʽ�нؾ�ͬʱΪ������", line1, line2);
	}
	
	@Test
	public void test2InterceptsInfinityNotEqual() {
		Line2D line1 = new Line2D(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
		Line2D line2 = new Line2D(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
		
		Assert.assertNotEquals("������������ؾ�ʽ�нؾ�ͬʱΪ��������", line1, line2);
	}

	@Test
	public void testGeneralIlligeal() {
		Line2D line1 = new Line2D(new Point2D(2.2, 1.6), new Point2D(-10.4, -4.7));
		Line2D line2 = new Line2D(0, 0, 6.5);

		Assert.assertEquals("������������һ��ʽ�ķǷ����", line1, line2);
	}	
	
	///////////////x axis///////////////
	@Test
	public void test2PointsXEqual() {
		Line2D line1 = new Line2D(new Point2D(1, 0), new Point2D(5, 0));
		Line2D line2 = new Line2D(new Point2D(100, 0), new Point2D(-55, 0));
		
		Assert.assertEquals("����������������ʽֱ��Ϊx������", line1, line2);
	}
	
	@Test
	public void testSlopePointXEqual() {
		Line2D line1 = new Line2D(new Point2D(2.7, 0), 0.0);
		Line2D line2 = new Line2D(new Point2D(20, 0), 0.0);
		
		Assert.assertEquals("�������������бʽֱ��Ϊx������", line1, line2);
	}

	@Test
	public void test2InterceptsXEqual() {
		Line2D line1 = new Line2D(Double.POSITIVE_INFINITY, 0);
		Line2D line2 = new Line2D(Double.POSITIVE_INFINITY, 0);
		
		Assert.assertEquals("������������ؾ�ʽֱ��Ϊx������", line1, line2);
	}

	@Test
	public void test2InterceptsXEquals2Points() {
		Line2D line1 = new Line2D(Double.POSITIVE_INFINITY, 0);
		Line2D line2 = new Line2D(new Point2D(2, 0), new Point2D(11, 0));
		
		Assert.assertEquals("������������ؾ�ʽֱ��������ʽΪx������", line1, line2);
	}

	@Test
	public void test2InterceptsXEqualsSlopePoint() {
		Line2D line1 = new Line2D(Double.POSITIVE_INFINITY, 0);
		Line2D line2 = new Line2D(new Point2D(2, 0), 0.0);
		
		Assert.assertEquals("������������ؾ�ʽֱ�����бʽΪx������", line1, line2);
	}

	@Test
	public void testSlopePointXEquals2Points() {
		Line2D line1 = new Line2D(new Point2D(44, 0), 0.0);
		Line2D line2 = new Line2D(new Point2D(2, 0), new Point2D(11, 0));
		
		Assert.assertEquals("�������������бʽֱ��������ʽΪx������", line1, line2);
	}

	///////////////parallel with x axis///////////////
	@Test
	public void test2PointsParallelXEqual() {
		Line2D line1 = new Line2D(new Point2D(1, 11.2), new Point2D(5, 11.2));
		Line2D line2 = new Line2D(new Point2D(100, 11.2), new Point2D(-55, 11.2));
		
		Assert.assertEquals("����������������ʽֱ��ƽ����x������", line1, line2);
	}
	
	@Test
	public void testSlopePointParallelXEqual() {
		Line2D line1 = new Line2D(new Point2D(2.7, 22), 0.0);
		Line2D line2 = new Line2D(new Point2D(20, 22), 0.0);
		
		Assert.assertEquals("�������������бʽֱ��ƽ����x������", line1, line2);
	}

	@Test
	public void test2InterceptsParallelXEqual() {
		Line2D line1 = new Line2D(Double.POSITIVE_INFINITY, 34.1);
		Line2D line2 = new Line2D(Double.POSITIVE_INFINITY, 34.1);
		
		Assert.assertEquals("������������ؾ�ʽֱ��ƽ����x������", line1, line2);
	}

	@Test
	public void test2InterceptsParallelXEquals2Points() {
		Line2D line1 = new Line2D(Double.POSITIVE_INFINITY, 22);
		Line2D line2 = new Line2D(new Point2D(2, 22), new Point2D(11, 22));
		
		Assert.assertEquals("������������ؾ�ʽֱ��������ʽƽ����x������", line1, line2);
	}

	@Test
	public void test2InterceptsParallelXEqualsSlopePoint() {
		Line2D line1 = new Line2D(Double.POSITIVE_INFINITY, 1000);
		Line2D line2 = new Line2D(new Point2D(2, 1000), 0.0);
		
		Assert.assertEquals("������������ؾ�ʽֱ�����бʽƽ����x������", line1, line2);
	}

	@Test
	public void testSlopePointParallelXEquals2Points() {
		Line2D line1 = new Line2D(new Point2D(44, 500), 0.0);
		Line2D line2 = new Line2D(new Point2D(2, 500), new Point2D(11, 500));
		
		Assert.assertEquals("�������������бʽֱ��������ʽƽ����x������", line1, line2);
	}

	///////////////parallel with x axis not equal///////////////
	@Test
	public void test2PointsParallelXNotEqual() {
		Line2D line1 = new Line2D(new Point2D(1, 11.2), new Point2D(5, 11.2));
		Line2D line2 = new Line2D(new Point2D(100, 11), new Point2D(-55, 11));
		
		Assert.assertNotEquals("����������������ʽֱ��ƽ����x������", line1, line2);
	}
	
	@Test
	public void testSlopePointParallelXNotEqual() {
		Line2D line1 = new Line2D(new Point2D(2.7, 22), 0.0);
		Line2D line2 = new Line2D(new Point2D(20, -22), 0.0);
		
		Assert.assertNotEquals("�������������бʽֱ��ƽ����x������", line1, line2);
	}

	@Test
	public void test2InterceptsParallelXNotEqual() {
		Line2D line1 = new Line2D(Double.POSITIVE_INFINITY, 34.1);
		Line2D line2 = new Line2D(Double.POSITIVE_INFINITY, 34);
		
		Assert.assertNotEquals("������������ؾ�ʽֱ��ƽ����x������", line1, line2);
	}

	@Test
	public void test2InterceptsParallelXNotEquals2Points() {
		Line2D line1 = new Line2D(Double.POSITIVE_INFINITY, 22);
		Line2D line2 = new Line2D(new Point2D(2, 21), new Point2D(11, 22));
		
		Assert.assertNotEquals("������������ؾ�ʽֱ��������ʽƽ����x������", line1, line2);
	}

	@Test
	public void test2InterceptsParallelXNotEqualsSlopePoint() {
		Line2D line1 = new Line2D(Double.POSITIVE_INFINITY, 1000);
		Line2D line2 = new Line2D(new Point2D(0, 0), 0.0);
		
		Assert.assertNotEquals("������������ؾ�ʽֱ�����бʽƽ����x������", line1, line2);
	}

	@Test
	public void testSlopePointParallelXNotEquals2Points() {
		Line2D line1 = new Line2D(new Point2D(44, 500), 0.0);
		Line2D line2 = new Line2D(new Point2D(2, 200), new Point2D(11, 500));
		
		Assert.assertNotEquals("�������������бʽֱ��������ʽƽ����x������", line1, line2);
	}

	///////////////y axis///////////////
	@Test
	public void test2PointsYEqual() {
		Line2D line1 = new Line2D(new Point2D(0, 5), new Point2D(0, -10));
		Line2D line2 = new Line2D(new Point2D(0, 100), new Point2D(0, 0));
		
		Assert.assertEquals("����������������ʽֱ��ΪY������", line1, line2);
	}
	
	@Test
	public void testSlopePointYEqual() {
		Line2D line1 = new Line2D(new Point2D(0, 2.7), Double.POSITIVE_INFINITY);
		Line2D line2 = new Line2D(new Point2D(0, 20), Double.POSITIVE_INFINITY);
		
		Assert.assertEquals("�������������бʽֱ��ΪY������", line1, line2);
	}

	@Test
	public void test2InterceptsYEqual() {
		Line2D line1 = new Line2D(0, Double.POSITIVE_INFINITY);
		Line2D line2 = new Line2D(0, Double.POSITIVE_INFINITY);
		
		Assert.assertEquals("������������ؾ�ʽֱ��ΪY������", line1, line2);
	}

	@Test
	public void test2InterceptsYEquals2Points() {
		Line2D line1 = new Line2D(0, Double.POSITIVE_INFINITY);
		Line2D line2 = new Line2D(new Point2D(0, 2), new Point2D(0, 11));
		
		Assert.assertEquals("������������ؾ�ʽֱ��������ʽΪY������", line1, line2);
	}

	@Test
	public void test2InterceptsYEqualsSlopePoint() {
		Line2D line1 = new Line2D(0, Double.POSITIVE_INFINITY);
		Line2D line2 = new Line2D(new Point2D(0, 2), Double.POSITIVE_INFINITY);
		
		Assert.assertEquals("������������ؾ�ʽֱ�����бʽΪY������", line1, line2);
	}

	@Test
	public void testSlopePointYEquals2Points() {
		Line2D line1 = new Line2D(new Point2D(0, 44), Double.POSITIVE_INFINITY);
		Line2D line2 = new Line2D(new Point2D(0, 2), new Point2D(0, 11));
		
		Assert.assertEquals("�������������бʽֱ��������ʽΪY������", line1, line2);
	}
	
	///////////////parallel with y axis///////////////
	@Test
	public void test2PointsParallelYEqual() {
		Line2D line1 = new Line2D(new Point2D(11.2, 1), new Point2D(11.2, 5));
		Line2D line2 = new Line2D(new Point2D(11.2, 100), new Point2D(11.2, -55));
		
		Assert.assertEquals("����������������ʽֱ��ƽ����Y������", line1, line2);
	}
	
	@Test
	public void testSlopePointParallelYEqual() {
		Line2D line1 = new Line2D(new Point2D(22, 2.7), Double.POSITIVE_INFINITY);
		Line2D line2 = new Line2D(new Point2D(22, 20), Double.POSITIVE_INFINITY);
		
		Assert.assertEquals("�������������бʽֱ��ƽ����x������", line1, line2);
	}

	@Test
	public void test2InterceptsParallelYEqual() {
		Line2D line1 = new Line2D(34.1, Double.POSITIVE_INFINITY);
		Line2D line2 = new Line2D(34.1, Double.POSITIVE_INFINITY);
		
		Assert.assertEquals("������������ؾ�ʽֱ��ƽ����Y������", line1, line2);
	}

	@Test
	public void test2InterceptsParallelYEquals2Points() {
		Line2D line1 = new Line2D(22, Double.POSITIVE_INFINITY);
		Line2D line2 = new Line2D(new Point2D(22, 2), new Point2D(22, 11));
		
		Assert.assertEquals("������������ؾ�ʽֱ��������ʽƽ����Y������", line1, line2);
	}

	@Test
	public void test2InterceptsParallelYEqualsSlopePoint() {
		Line2D line1 = new Line2D(1000, Double.POSITIVE_INFINITY);
		Line2D line2 = new Line2D(new Point2D(1000, 2), Double.POSITIVE_INFINITY);
		
		Assert.assertEquals("������������ؾ�ʽֱ�����бʽƽ����Y������", line1, line2);
	}

	@Test
	public void testSlopePointParallelYEquals2Points() {
		Line2D line1 = new Line2D(new Point2D(500, 44), Double.POSITIVE_INFINITY);
		Line2D line2 = new Line2D(new Point2D(500, 2), new Point2D(500, 11));
		
		Assert.assertEquals("�������������бʽֱ��������ʽƽ����Y������", line1, line2);
	}

	///////////////parallel with y axis not equal///////////////
	@Test
	public void test2PointsParallelYNotEqual() {
		Line2D line1 = new Line2D(new Point2D(11.2, 1), new Point2D(11.2, 5));
		Line2D line2 = new Line2D(new Point2D(21.2, 100), new Point2D(21.2, -55));
		
		Assert.assertNotEquals("����������������ʽֱ��ƽ����Y������", line1, line2);
	}
	
	@Test
	public void testSlopePointParallelYNotEqual() {
		Line2D line1 = new Line2D(new Point2D(0, 2.7), Double.POSITIVE_INFINITY);
		Line2D line2 = new Line2D(new Point2D(22, 20), Double.POSITIVE_INFINITY);
		
		Assert.assertNotEquals("�������������бʽֱ��ƽ����x������", line1, line2);
	}

	@Test
	public void test2InterceptsParallelYNotEqual() {
		Line2D line1 = new Line2D(34.1, Double.POSITIVE_INFINITY);
		Line2D line2 = new Line2D(34, Double.POSITIVE_INFINITY);
		
		Assert.assertNotEquals("������������ؾ�ʽֱ��ƽ����Y������", line1, line2);
	}

	@Test
	public void test2InterceptsParallelYNotEquals2Points() {
		Line2D line1 = new Line2D(99, Double.POSITIVE_INFINITY);
		Line2D line2 = new Line2D(new Point2D(22, 2), new Point2D(22, 11));
		
		Assert.assertNotEquals("������������ؾ�ʽֱ��������ʽƽ����Y������", line1, line2);
	}

	@Test
	public void test2InterceptsParallelYNotEqualsSlopePoint() {
		Line2D line1 = new Line2D(1000, Double.POSITIVE_INFINITY);
		Line2D line2 = new Line2D(new Point2D(1000, 2), Double.MAX_VALUE); 
		
		Assert.assertNotEquals("������������ؾ�ʽֱ�����бʽƽ����Y������", line1, line2);
	}

	@Test
	public void testSlopePointParallelYNotEquals2Points() {
		Line2D line1 = new Line2D(new Point2D(500, 44), Double.POSITIVE_INFINITY);
		Line2D line2 = new Line2D(new Point2D(500.99, 2), new Point2D(500.99, 11));
		
		Assert.assertNotEquals("�������������бʽֱ��������ʽƽ����Y������", line1, line2);
	}
	
	///////////////treat line as an object//////////////////
	@Test
	public void testLineAsObjectEqual() {
		Line2D line1 = new Line2D(new Point2D(1, 1), new Point2D(3, 2));
		Object line2 = new Line2D(new Point2D(-1, 0), new Point2D(-3, -1));
		
		Assert.assertEquals("������������ֱ����Ϊ��ͨ������ȵ����", line1, line2);
	}

	@Test
	public void testLineAsObjectNotEqual() {
		Line2D line1 = new Line2D(new Point2D(1, 1), new Point2D(3, 2));
		Object line2 = new Line2D(new Point2D(-1, 2), new Point2D(-3, -1));
		
		Assert.assertNotEquals("������������ֱ����Ϊ��ͨ������ȵ����", line1, line2);
	}
}
