# Game Store
Proyecto donde se aplican los streams de java.
Tienda básica de videojuegos que almacena datos de los videojuegos y reseñas de clientes.

**Diagrama físico de DB**


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
spring.jpa.show-sql=false
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```
## Se utiliza la librería Spring Data JPA para poder utilizar la interfaz JpaRepository

jpaRepository extiende de CrudRepository por lo que ofrece una serie de métodos predefinidos para realizar operaciones de acceso a la base de datos como CRUD.

 **Paso 1. Generar entidades de bd**

Una entidad es una clase que está mapeada a una tabla en una base de datos relacional. Es un objeto que representa una fila (registro) de una tabla en la base de datos y está asociado a un conjunto de columnas de dicha tabla. En otras palabras, una entidad es una representación en Java de una tabla en una base de datos.

*Ejemplo*
   
```java
package com.proyect.GameStore.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="consola")
public class ConsolaEntity {

    @Id
    private Integer console_id;

    private String name;

    public int getConsole_id() {
        return console_id;
    }

    public void setConsole_id(int console_id) {
        this.console_id = console_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```
**Paso 2. Crear un repositorio extendiendo JpaRepository**

Un repositorio es una interfaz que permite realizar operaciones de acceso a la base de datos para una entidad específica, sin necesidad de escribir el código de implementación manualmente. Un repositorio extiende las interfaces de Spring Data como JpaRepository, CrudRepository o PagingAndSortingRepository, que proporcionan métodos predefinidos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) y otras consultas más complejas.

*Ejemplo*
   
```java
package com.proyect.GameStore.Repository;

import com.proyect.GameStore.Entity.ConsolaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsolaRepository extends JpaRepository<ConsolaEntity,Integer> {

    ConsolaEntity findByName(String name);

}
```
**Paso 3. Uso del repositorio en un servicio**

*Ejemplo*
   
```java
package com.proyect.GameStore.Implements;

import com.proyect.GameStore.Entity.ConsolaEntity;
import com.proyect.GameStore.Repository.ConsolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Service
public class ConsolaImplt {
    //Aquí se realiza la inyección de la instancia de ConsolaRepository 
    @Autowired
    private ConsolaRepository consolaRepository;

    @Transactional
    public Stream<ConsolaEntity> getConsolasStream() {
        return consolaRepository.findAll().stream();
    }

    public void inicioConsola(String name) {
        ConsolaEntity consola = consolaRepository.findByName(name);
        System.out.println("Name: " + consola.getName() + "id: " + consola.getConsole_id());
    }
```
