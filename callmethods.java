class callmethods 
{
	int a=10;
	int b=20;
	static void m1()
	{
		System.out.println(a);
		System.out.println(b);
	}
	static void m2()
	{
		System.out.println(a);
		System.out.println(b);
	}
	public static void main(String[] args) 
	{
		call m1();
		call m2();
		System.out.println("Hello World!");
	}
}
