package basics;


class Parent {
	public static int staticParent = display("Parent static variable");
	public int instParent = display("Parent instance variable");
	
	static {
		display("Parent static block");
		
	}
	
	{
		display("Parent initialisation  block");
	}
	public Parent() {
		System.out.println("Parent Constructor");
	}

	static int display(String string) {
		System.out.println(string);
		return 0;
	}

	
}

public class ExecutionOrder extends Parent {
	public static int staticChildBlockDemo = display("ChildBlockDemo static variable");
	public int instChildBlockDemo = display("ChildBlockDemo instance variable");
	
	{
		display("ChildBlockDemo initialisation block");
	}
	static {
		display("ChildBlockDemo static block");
	}

	public ExecutionOrder() {
		display("ChildBlockDemo constructor");
	}

	public static void main(String[] args) {
		new ExecutionOrder();
		System.out.println(3+2+"hi"+5+7); //5hi57
	}
}

/*
	O/P:-
	Parent static variable
	Parent static block
	ChildBlockDemo static variable
	ChildBlockDemo static block
	Parent instance variable
	Parent initialisation  block
	Parent Constructor
	ChildBlockDemo instance variable
	ChildBlockDemo initialisation block
	ChildBlockDemo constructor
	
	------------
	
	5hi57
*/