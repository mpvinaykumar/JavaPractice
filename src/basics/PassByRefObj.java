package basics;

public class PassByRefObj {

	private void modifyValue(Foo foo) {
		foo.setAttr("hello");
	}
	
	private void modifyRefAndValue(Foo foo) {
		Foo foo2 = new Foo();
		foo = foo2;
		foo.setAttr("welcome");
	}

	public static void main(String[] args) {
		PassByRefObj byRefObj = new PassByRefObj();
		Foo someFoo = new Foo("hi");

		System.out.println(someFoo.getAttr()+"\n");

		System.out.println("Modify value to 'hello':");
		byRefObj.modifyValue(someFoo);
		System.out.println(someFoo.getAttr()+"\n");
		
		System.out.println("Modify ref & value to 'welcome'");
		byRefObj.modifyRefAndValue(someFoo);		
		System.out.println(someFoo.getAttr());
	}

}

class Foo {
	private String attr;

	public Foo() {
		
	}
	public Foo(String str) {
		super();
		this.attr = str;
	}

	public String getAttr() {
		return attr;
	}

	public void setAttr(String attr) {
		this.attr = attr;
	}

}