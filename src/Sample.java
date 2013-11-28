
// ListX
// ListX.LinkedList
// LangX
// @author Mathew Kurian

import com.langx.MutableString;

class StringGen 
{
	static char [] CHARS = "ABCDEFGHIJKLMNOPQRSTUVXWZasdfghhjklzxcvbnbnmpoiqweiuyrt".toCharArray();

	public static String make(int length)
	{
		String str = "";

		for(int x = 0; x < length; x++)
			str += CHARS[(int) Math.floor(Math.random() * (CHARS.length - 1))];

		return str;
	}
}

public class Sample 
{
	static long timeStart = 0;
	static long timeEnd = 0;

	static long performance1 = 0;
	static long performance2 = 0;

	public static void main(String[] args) 
	{
		// =====================================
		System.out.print("MutableString vs String\n");
		System.out.print("\n----------------------------------------\n\n");
		// =====================================

		String test = StringGen.make(10000);
		String test2 = StringGen.make(10000);

		timeStart = System.nanoTime();

		MutableString mst = new MutableString(new String(test));

		mst.toUpperCase(); // Convert to uppercase
		mst.append(test2);
		mst.append(test2);	
		mst.toUpperCase();
		mst.splice(0, mst.length/2);
		mst.append(test2);
		mst.append("hello");

		timeEnd = System.nanoTime();

		System.out.printf("MutableString Performance: %sns\n", performance1 = timeEnd - timeStart);

		// =====================================
		System.out.print("\n----------------------------------------\n\n");
		// =====================================

		timeStart = System.nanoTime();

		String str = new String(new String(test));

		str = str.toUpperCase(); // Convert to uppercase		
		str = str + test2;
		str = str + test2;		
		str = str.toUpperCase();
		str = str.substring(str.length()/2);
		str = test2 + "hello";

		timeEnd = System.nanoTime();		

		System.out.printf("String Performance: %sns\n", performance2 = timeEnd - timeStart);

		// =====================================
		System.out.print("\n----------------------------------------\n");
		// =====================================

		System.out.printf("\nString is %.2f%% faster!!!\n", (((Number)Math.max(performance1, performance2)).doubleValue()/((Number)Math.min(performance1, performance2)).doubleValue()) * 100);

	}
}
