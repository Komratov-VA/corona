package chapter4.init;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import sun.net.idn.StringPrep;

public class Person {

    private String name;
    private Integer age = Integer.MIN_VALUE;

    public void setName(String name){
        this.name = name;
    }

    public void setAge(Integer age){
        this.age = age;
    }

    public void init(){
        if(name == null){
            this.name = "Bboy";
        }
        if(age == Integer.MIN_VALUE){
            throw new IllegalArgumentException("age is too small");
        }
    }

    public static void main(String[] args) {

        GenericXmlApplicationContext genericXmlApplicationContext = new GenericXmlApplicationContext();
        genericXmlApplicationContext.load("chapter4.init/PersonContext.xml");
        genericXmlApplicationContext.refresh();
//        String[] strings =genericXmlApplicationContext.getBeanFactory().getBeanDefinitionNames();
//        System.out.println(strings[0]);
//        genericXmlApplicationContext.refresh();
//        Person person = (Person) genericXmlApplicationContext.getBean("firstPerson");
//        System.out.println(person.age);
//        System.out.println(person.name);
        genericXmlApplicationContext.close();
    }
}
//<dependency>
//<groupId>org.springframework</groupId>
//<artifactId>spring-context</artifactId>
//<version>3.0.2.RELEASE</version>
//</dependency>
