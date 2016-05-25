# Java-Restful-API
1. create maven project

2. set up server runtime to Tomcat7 in Eclipse

3. add maven plugin of "Swagger Jersey2 Jaxrs"
http://mvnrepository.com/artifact/io.swagger/swagger-jersey2-jaxrs/1.5.0

4. download swagger 2.0 libs

5. inn SwaggerDocumentSetup.java, you may modify
   	    beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setBasePath("/japi/services");
        beanConfig.setResourcePackage( "com.control2me.japi.services" );

6. create java api and swagger api docs
7. run test from web browser- 
   swager: http://localhost:8080/japi/api-docs/
   api: http://localhost:8080/japi/services/v1/users/12345

8. create CRUD methods for data access layer
   - use MongoDB client
