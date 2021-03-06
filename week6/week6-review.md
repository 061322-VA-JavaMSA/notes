# Spring

## Spring Core
1.	What are Spring Projects and Spring Modules?
2.	What is IOC and what does the IOC Container do?
3.	What is dependency injection and what are some of the benefits of using dependency injection?
4.	What types of dependency injection does Spring support?
5.	What are some differences between BeanFactory and ApplicationContext? Which one eagerly instantiates your beans?
6.	What is the Spring Bean lifecycle?
7.	What is bean wiring? What about autowiring?
8.	What are the different ways that Spring can wire beans?
9.	What are the scopes of Spring beans? Which is default?
10.	What is the concept of component scanning and how would you set it up?
11.	What are the benefits and limitations of Java configuration?
12.	What does the @Configuration and @Bean annotations do?
13.	What is @Value used for?
14.	List some stereotype annotations. What are the differences between these?

## Spring MVC
1.	Explain the MVC architecture and how HTTP requests are processed in the architecture
2.	What is the role of the DispatcherServlet? What about the ViewResolver?
3.	How would you declare which HTTP requests you’d like a controller to process?
4.	What is the difference between @RequestMapping and @GetMapping?
5.	How to declare the data format your controller expects from requests or will create in responses?
6.	What annotation would you use to bypass the ViewResolver?
7.	How would you extract query and path parameters from a request URL in your controller?
8.	What concerns is the controller layer supposed to handle vs the service layer?
9.	How would you specify HTTP status codes to return from your controller?
10.	How do you handle exceptions thrown in your code from your controller? What happens if you don’t set up any exception handling?
11.	How would you consume an external web service using Spring?
12.	What are the advantages of using RestTemplate?
13. What is the difference between @Controller and @RestController

## Spring AOP
1.	What is “aspect-oriented programming”? Define an aspect.
2.	Give an example of a cross-cutting concern you could use AOP to address
3.	Define the following:
	a.	Join point
	b.	Pointcut
	c.	Advice
4.	What are the different types of advice? What is special about the @Around advice? How is the ProceedingJoinPoint used?
5.	Explain the pointcut expression syntax
6.	What is a proxy?

## Spring Data
1.	What is Spring ORM and Spring Data?
2.	What does @Transactional do? 
3.	What interfaces are available in Spring Data JPA?
4.	What is the difference between JpaRepository and CrudRepository?
5.	What is the naming conventions for methods in Spring Data repositories?
6.	How are Spring repositories implemented by Spring at runtime?
7.	What is @Query used for?

## Spring Boot
1.	How is Spring Boot different from legacy Spring applications? What does it mean that it is “opinionated”?
2.	What does “convention over configuration” mean?
3.	What annotation would you use for Spring Boot apps? What does it do behind the scenes?
4.	How does Boot’s autoconfiguration work?
5.	What is the advantage of having an embedded Tomcat server?
6.	What is the significance of the Spring Boot starter POM?
7.	What is the Spring Boot actuator? What information can it give you?
8.	What files would you use to configure Spring Boot applications?
9.	What is the benefit of using Spring Boot profiles?