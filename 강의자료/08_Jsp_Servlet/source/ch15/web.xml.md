- web.xml

```
<servlet>
 	<servlet-name>BoardPostServlet</servlet-name>
 	<servlet-class>myPortal.bbs.BoardPostServlet</servlet-class>
    <multipart-config>
      <max-file-size>20971520</max-file-size>
      <max-request-size>41943040</max-request-size>
      <file-size-threshold>209711520</file-size-threshold>
    </multipart-config>
 </servlet>
 <servlet-mapping>
    <servlet-name>BoardPostServlet</servlet-name>
    <url-pattern>/board/boardPost</url-pattern>
  </servlet-mapping>
```  
