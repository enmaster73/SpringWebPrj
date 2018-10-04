package myspring.di.xml.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/beans.xml")
public class HelloBeanJunitSpringTest {
	@Autowired
	ApplicationContext context;
	
//	@Before
//	public void init() {
//		context = new GenericXmlApplicationContext("config/beans.xml");
//	}
//	
	@Test 
	public void test2() {
		Hello hello = (Hello)context.getBean("hello");
		Hello hello2 = (Hello)context.getBean("hello");
		assertSame(hello, hello2);
	}
	
	@Test 
	public void test0 () {
		Hello hello = (Hello)context.getBean("hello2");
		assertEquals("Hello Spring", hello.sayHello());
		//System.out.println(hello.sayHello());
		hello.print();
		
		assertEquals(3,  hello.getNames().size());
		
		List<String> list = hello.getNames();
		
		for (String value : list) {
			System.out.println(value);
		}
	}
	
	
	@Test @Ignore
	public void test1() {
		Hello hello = (Hello)context.getBean("hello");
		assertEquals("Hello Spring", hello.sayHello());
		//System.out.println(hello.sayHello());
		hello.print();
		
		Printer printer = context.getBean("printer", Printer.class);
		System.out.println(printer.toString());
		assertEquals("Hello Spring", printer.toString());
		
	}

}
