class Return 
{
	int m1()
	{
		 System.out.println("m1 method");
		 return 10;
	}
	public static void main(String[] args) 

	{
		Return t = new Return();
		int x = t.m1();
        System.out.println("values of m1()"+x);
		System.out.println("Hello World!");
		int y = t.m1();
		System.out.println("values of m1()"+y);
	}
}
