# 👨🏻‍💻 Jump2Digital 2022 | Backend 👨🏻‍💻

![Demo](https://github.com/DanielEspanadero/jump2digital-backend/blob/main/docs/img01.webp)

_Aplicación creada para la clasificación de la hackathon de [Jump2Digital 2022](https://nuwe.io/dev/challenges/jump2digital2022-backend) - Backend organizada por [Nuwe](https://nuwe.io) utilizando Java con Spring._

_A la hora de realizar la tarea he tomado la decisión de no realizar queries usando JPA y gestionarlo a través de lógica en la implementación del servicio ya que así aumenta el rendimiento evitando problemas de serialización por transformar código escrito en Java a código MySQL y usando solo código escrito en java._

## Objetivos 🎯

_Para conseguir un puesto en la final nos piden cumplir los siguientes objetivos:_

_✅ Tarea 1 → Crear un base de datos (PostgreSQL, MySQL, Mongo, Firebase,etc) y guardar toda la lista de compañías utilizado siguiendo el esquema del [JSON](https://challenges-asset-files.s3.us-east-2.amazonaws.com/jobMadrid/companies.json). - COMPLETADA_

_✅ Tarea 2 → Crear un endpoint que devuelva las compañías ordenadas por tamaño. - COMPLETADA_

_✅ Tarea 3 → Crear un endpoint que devuelva las compañías ordenadas por fecha de creación. - COMPLETADA_

_✅ Tarea 4 → Crear un endpoint que devuelva los siguientes datos: Número de empresas que hay en cada industria, Número de empresas que hay por cada rango de tamaños, Número de empresas que hay en cada año de creación. - COMPLETADA_

_✅ Tarea EXTRA → Test con Postman. - COMPLETADA_


## Empezando 🚀

_Estas instrucciones le permitirán obtener una copia de trabajo del proyecto en su máquina local para fines de desarrollo y pruebas._


### Pre requisitos 📋

_Para que el proyecto funcione correctamente, se recomienda tener una serie de programas instalados y configurados adecuadamente:_
- [IntelliJ IDEA](https://www.jetbrains.com/idea/)
- [Java 1.8](https://www.oracle.com/es/java/technologies/javase/javase8-archive-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [MySql Server](https://www.mysql.com/)
- [MySql Workbench](https://www.mysql.com/)

### Dependencias ⚙️

_🟢 Spring starter web._

_🟢 Spring data JPA._

_🟢 MySQL connector._


### Iniciar el proyecto 🔧

_Cuando hayas clonado este proyecto en tu repositorio local has de crear una base de datos llamada 'companies' usando el siguiente comando, por ejemplo, en MySql Workbench:_
```
CREATE DATABASE companies;
```

_Esta es la configuración del application.properties:_
```
server.port=
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=
```

![Demo](https://github.com/DanielEspanadero/jump2digital-backend/blob/main/docs/img02.png)

## Endpoints ✍️

_En la carpeta 'Postman' hay un JSON donde se pueden importar todos los datos directamente a Postman, pero si deseas añadirlo manualmente, puedes utilizar los siguientes endpoints:_

![Demo](https://github.com/DanielEspanadero/jump2digital-backend/blob/main/docs/img04.png)

### POST - Guardar todas las compañías en la base de datos 👉🏻(Tarea 1)👈🏻
```
http://localhost:8000/companies/all
```

![Demo](https://github.com/DanielEspanadero/jump2digital-backend/blob/main/docs/img05.png)

### POST - Guardar una compañia en la base de datos (Extra)
```
http://localhost:8000/companies
```

### GET - Obtener todas las compañias (Extra)
```
http://localhost:8000/companies
```

### GET - Obtener compañias ordenadas por tamaño 👉🏻(Tarea 2)👈🏻
```
http://localhost:8000/companies/sort-size
```

### GET - Obtener compañias ordenadas por fecha de creación 👉🏻(Tarea 3)👈🏻
```
http://localhost:8000/companies/sort-founded
```

### GET - Obtener un endpoint que devuelva los siguientes datos: Número de empresas que hay en cada industria, Número de empresas que hay por cada rango de tamaños, Número de empresas que hay en cada año de creación 👉🏻(Tarea 4)👈🏻
http://localhost:8000/companies/general-information

## Arquitectura del proyecto 🛡

_La correcta organización de la estructura del proyecto evitará la duplicación de código, mejorará la estabilidad y ayudará a la escalabilidad. En esta ocasión me he decantado por crear un monolito modular con la finalidad de poder escalar el proyecto a microservicios en el caso de que fuera necesario_

![Demo](https://github.com/DanielEspanadero/jump2digital-backend/blob/main/docs/img03.png)

## Versionado 📌

_He utilizado versiones semánticas [SemVer](http://semver.org/) para esta aplicación._


## Autor ✒️

* [Daniel Españadero](https://github.com/DanielEspanadero)


## Licencia 📄

_Este proyecto está licenciado bajo la Licencia MIT - ver el archivo [LICENCIA](https://github.com/DanielEspanadero/hackathon-it-academy-backend/blob/main/LICENSE) para más detalles._