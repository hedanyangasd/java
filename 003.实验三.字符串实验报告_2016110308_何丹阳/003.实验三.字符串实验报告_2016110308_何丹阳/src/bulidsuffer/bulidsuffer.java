package bulidsuffer;

public class bulidsuffer {
	public static void main(String[] args) {
        int loop = 100;
        String str = "hdyhdyhdyhdyhdyhdy";
        testStringBuffer(loop, str);
        testStringBuilder(loop, str);
    }
    public static void testStringBuffer(int loop,String str) {
        StringBuffer strBuffer = new StringBuffer();
        //测试起始时刻
        long begin = System.currentTimeMillis();
        for(int i = 0 ;  i < loop ; i++) {
            strBuffer.append(str);
        }
        //测试截止时刻
        long end = System.currentTimeMillis();
        //StringBuffer执行时间
        System.out.println("StringBuffer:  "+ (end - begin));
    }
    public static void testStringBuilder(int loop,String str) {
        StringBuilder strBuilder = new StringBuilder();
      //测试起始时刻
        long begin = System.currentTimeMillis();
        for(int i = 0 ;  i < loop ; i++) {
            strBuilder.append(str);
        }
        //测试截止时刻
        long end = System.currentTimeMillis();
      //StringBuilder执行时间
        System.out.println("StringBuilder:  "+ (end - begin));
    }

}
