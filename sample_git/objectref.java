class Test 
{
	//instace variables
    int a=10;
	int b=20;
	//static metod
	public static void main(String[] args) 
	{
		//static area static area so object reference
	    Test t = new Test();
		System.out.println(t.a);
		System.out.println(t.b);
	}
	//instance method because static key word not mentioned
	void m1()
	{
		//instance are
		System.out.println(a);
		System.out.println(b);
	}
}
