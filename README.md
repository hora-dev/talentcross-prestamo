
# talentcross-prestamo

## Desarrollado por
- horadev

## Desarrollado con
- Java 17
- Spring Boot 3.5.9
- Maven 4.0.0
- PostgreSQL 16
- Lombok 1.18.24
- MapStruct 1.5.2.Final

## Endpoints

### GET /prestamos
- Obtiene el prestamo de un usuario por su dni
- Retorna un objeto con el monto y si tiene prestamo
- Si no tiene prestamo, retorna null

### POST /prestamos
- Crea un prestamo para un usuario por su dni
- Retorna un objeto con el monto y si tiene prestamo
- Si el usuario ya tiene prestamo, retorna error


## Variables de entorno

    url: jdbc:postgresql://localhost:5432/talentcross_prestamo_db
    username: postgres
    password: 1234
    driver-class-name: org.postgresql.Driver

## Se debe conectar a una bd Postgres configurando las variables de entorno mencionadas y debe contener la bd 'talentcross_prestamo_db'