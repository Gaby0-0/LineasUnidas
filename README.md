Proyecto: Sistema de Gestión de Viajes para la empresa Líneas Unidas SERPEVASS-Miahuatecos

Descripción

Este proyecto es un sistema desarrollado en Spring Boot con una base de datos local en MySQL, que tiene como objetivo mejorar la gestión de viajes y boletos de la empresa Líneas Unidas SERPEVASS-Miahuatecos, dedicada al transporte de pasajeros  en la región de Oaxaca.

El sistema busca resolver problemas relacionados con la organización de viajes, la atención al cliente y la eficiencia del sistema de reservas, y mejorar la satisfacción de los usuarios.

Objetivos del Proyecto

- Implementar control de cancelaciones y aplicar la política mínima de 2 horas antes del viaje.

- Mejorar la asignación y validación de boletos, evitando duplicidades.

- Mantener un registro del conductores y urvans.

- Mejorar la interfaz de usuario, agregando funcionalidades de “Reservar” y “Cancelar”.

- Proporcionar información clara y actualizada de viajes y horarios.


Tecnologías Utilizadas

- Backend: Spring Boot

- Base de datos: MySQL

- Frontend: Thymeleaf, HTML, CSS, JavaScript

- Control de versiones: Git / GitHub



Instalación y Configuración

1. Clonar el repositorio:
git clone https://github.com/Gaby0-0/LineasUnidas.git

2.Configurar la base de datos MySQL local y crear un esquema llamado lineas_unidas.

3.Configurar el archivo application.properties con las credenciales de MySQL, las siguientes propiedades:
spring.datasource.url=jdbc:mysql://localhost:3306/lineas_unidas?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=contraseña_propia
spring.jpa.hibernate.ddl-auto=update

4. Ejecutar la aplicación desde el IDE de preferencia o con:
mvn spring-boot:run

5. Acceder al sistema desde:
http://localhost:8080














