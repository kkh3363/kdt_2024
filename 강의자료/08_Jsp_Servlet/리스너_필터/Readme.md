### web.xml
```
<filter>
    <display-name>EncodingFilter</display-name>
    <filter-name>EncodingFilter</filter-name>
    <filter-class>ch21.EncodingFilter</filter-class>
  </filter>
  <filter-mapping>
    <filter-name>EncodingFilter</filter-name>
    <url-pattern>*.do</url-pattern>
  </filter-mapping>
```
