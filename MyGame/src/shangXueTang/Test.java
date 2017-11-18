package shangXueTang;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

class   Test implements TestInterface  {

	@Override
	public void angle() {
		System.out.println("我是一个小小的测试");
		
	}

	@Override
	public void woman() {
		// TODO 自动生成的方法存根
		System.out.println("这是test的测试接口");
	}

	 public static void main(String[] args){
		 
		 Test t = new Test();
		 t.angle();
		 t.woman();
		 System.out.println(x);
	 }
	
	
}
