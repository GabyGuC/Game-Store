# Game Store
Proyecto donde se aplican los streams de java.
Tienda básica de videojuegos que almacena datos de los videojuegos y reseñas de clientes.

Diagrama físico de DB:


![DiagramDB](https://github.com/user-attachments/assets/b7ab1735-43b1-4fc9-88fb-2735740c13da)

## Configuración de conexión a base de datos con Datasource
**Dependencias**
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
  <groupId>org.postgresql</groupId>
  <artifactId>postgresql</artifactId>
  <version>42.6.0</version>
</dependency>
```

**Configuraciones en Applications.properties**
```
spring.datasource.url=jdbc:postgresql://localhost:5432/nombreBD
spring.datasource.username=usuario
spring.datasource.password=password1
spring.datasource.driver-class-name=org.postgresql.Driver
```

Si se quiere utilizar JPA o Hibernate se debe agregar:

```
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```
## Configuraciones para utilizar el datasource
 **No usas JPA ni un ORM (consultas manuales con JDBC)**
 
  ¿Cuando usar?
 - Si necesitas un control total sobre las consultas SQL.
 - Para proyectos pequeños o cuando JPA es demasiado complejo.
   
```java
try (Connection connection = DataSourceConfig.getDataSource().getConnection();
       Statement statement = connection.createStatement();
       ResultSet resultSet = statement.executeQuery("SELECT * FROM users")) {

      // Crear una lista para almacenar los resultados
      List<User> users = new ArrayList<>();
      while (resultSet.next()) {
          // Crear el objeto manualmente y agregarlo a la lista
          User user = new User();
          user.setId(resultSet.getInt("id"));
          user.setName(resultSet.getString("name"));
          user.setEmail(resultSet.getString("email"));
          users.add(user);
      }

      // Mostrar los resultados
      users.forEach(user -> System.out.printf("ID: %d, Name: %s, Email: %s%n",
              user.getId(), user.getName(), user.getEmail()));
  } catch (Exception e) {
      e.printStackTrace();
  }
```

