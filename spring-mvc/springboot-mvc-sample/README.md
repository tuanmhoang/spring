## Springboot web

When start Springboot, there is white label page.

Because `jsp` is a speacial type, need to get support, add

```
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>jstl</artifactId>
</dependency>
```        

and to start server, need to add `tomcat-jasper`.

To get the correct version, check the `jar` lib included in spring library. 

```
<dependency>
    <groupId>org.apache.tomcat</groupId>
    <artifactId>tomcat-jasper</artifactId>    
</dependency>
```