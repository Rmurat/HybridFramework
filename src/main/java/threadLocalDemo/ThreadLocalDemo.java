package threadLocalDemo;

public class ThreadLocalDemo {

	public static void main(String[] args) {
		
		/*
		 * This class provides thread-local variables. These variables differ fromtheir normal counterparts in that each thread that accesses one 
		 * (via its get or set method)has its own, independently initializedcopy of the variable. 
		 *  ThreadLocal instances are typically privatestatic fields in classes that wish to associate state with a thread (e.g.,a user ID or Transaction ID).
		 **/
		
		 
		ThreadLocal<String> tl1=new ThreadLocal<String>();
		tl1.set("Rawa");

		ThreadLocal<String> tl2=new ThreadLocal<String>();
		tl2.set("Omer");
		
		ThreadLocal<String> tl3=new ThreadLocal<String>();
		tl3.set("Bushra");
		
		ThreadLocal<Integer> tl4=new ThreadLocal<Integer>();
		tl4.set(12);
		
		System.out.println(tl1.get());
		
		tl1.remove();
		
		//it will return null
		System.out.println(tl1.get());
	}

}
