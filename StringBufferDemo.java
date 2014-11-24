class StringBufferDemo
{
	public static void main(String[] args)
		{
			StringBuffer sb = new StringBuffer();

			StringBuffer sb1 = sb.append(34);

			sb.insert(0, "qq");
//			sb.append("adb").append(true);
									
//			sop("sb == sb1: " + (sb == sb1));
			sop(sb.toString());
//			sop(sb1.toString());
		}

	public static void sop(String str)
		{
			System.out.println(str);
		}
}

