class  Staticvar
{
	static int a=10;
	public static void main(String[] args) 
	{
		System.out.println(Staticvar.a);
		System.out.println(a);
		Staticvar t = new Staticvar();
		System.out.println(t.a);
	}
}
