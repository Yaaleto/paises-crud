# CRUD de países

Aplicación web para registrar, listar, consultar, editar y eliminar países.
Hecha con Spring Boot, Thymeleaf, Bootstrap y MySQL, ejecutada con Docker Compose.

## Tecnologías

| Tecnología | Función |
|---|---|
| Java 21 + Spring Boot | Lógica de la aplicación |
| Spring MVC + Thymeleaf | Controladores y vistas HTML generadas en el servidor |
| Spring Data JPA | Acceso a la base de datos |
| Bootstrap | Estilos de las páginas |
| MySQL 8.4 | Base de datos |
| Docker + Docker Compose | Levantar la app y la base de datos en contenedores |

## Requisitos previos

- Git
- Docker Desktop (Windows) o Docker Engine con el plugin Compose (Linux)
- JDK 21 e IntelliJ IDEA (solo si vas a programar)

Comprueba que Docker funciona:

```
docker --version
docker compose version
```

## Cómo ejecutar el proyecto

1. Clona el repositorio y entra a la carpeta:

```
git clone https://github.com/Yaaleto/paises-crud.git
cd paises-crud
```

2. Abre Docker Desktop (en Windows) y espera a que diga "Engine running".

3. Levanta todo desde la carpeta donde está `docker-compose.yml`:

```
docker compose up --build -d
```

La primera vez tarda unos minutos porque descarga imágenes y compila.

4. Comprueba que los contenedores estén corriendo:

```
docker compose ps
```

`paises-mysql` debe decir `healthy` y `paises-app` debe decir `running`.

5. Abre en el navegador: http://localhost:8080

## Cómo detener el proyecto

| Acción | Comando |
|---|---|
| Detener (conserva los datos) | `docker compose down` |
| Detener y borrar la base de datos | `docker compose down -v` |
| Ver los logs de la app | `docker compose logs -f app` |

El script `db/init.sql` solo se ejecuta cuando la base de datos está vacía.
Si lo modificas, ejecuta `docker compose down -v` y vuelve a levantar.

## Datos de conexión (MySQL)

- Base de datos: `paisesdb`
- Usuario: `root`
- Contraseña: `root`
- Puerto desde tu equipo: `3307`

## Estructura del proyecto

```
.
├── Dockerfile              Construye la imagen de la aplicación
├── docker-compose.yml      Define los servicios: app y db
├── db/init.sql             Crea la tabla y datos de ejemplo
├── build.gradle            Dependencias del proyecto
└── src/main
    ├── java/com/cunori/paises
    │   ├── model           Entidad Pais
    │   ├── repository      Acceso a datos (PaisRepository)
    │   └── controller      Controlador web (PaisController)
    └── resources
        ├── application.properties
        └── templates/paises   Vistas: lista, form, detalle
```

## Trabajo en equipo

1. Antes de empezar: `git pull`
2. Crea tu rama: `git checkout -b nombre-de-tu-rama`
3. Guarda tus cambios:

```
git add .
git commit -m "Descripción corta del cambio"
git push -u origin nombre-de-tu-rama
```

4. En GitHub, abre un Pull Request hacia `main` para que el equipo lo revise.

## Problemas frecuentes

- **Docker no responde:** Docker Desktop está cerrado.
- **Puerto 3307 u 8080 ocupado:** cierra el programa que lo usa o cambia el puerto en `docker-compose.yml`.
- **La app no arranca:** revisa con `docker compose logs app`.