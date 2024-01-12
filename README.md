# AdminWeb

## Descripción del proyecto
Aplicación web para administrar diferentes módulos asociados a un caso de negocio especifico

## Requisitos del proyecto
- JDK 1.8 o superior
- Servidor de aplicaciones para Java EE, tales como Tomcat, WildFly, GlassFish.
- Maven para la gestión de dependencias


## Configuración del entorno local
```bash
git clone https://github.com/GrayHat18/AdminWeb.git
cd AdminWeb
mvn clean install
```

## Estructura del proyecto
AdminWeb/
│
├── .github/workflows/     # CI/CD
├── src/                   # Código fuente del proyecto como tal
│   ├── main/
│   │   ├── java/          # Repositorio java del proyecto
│   │   ├── resources/     # Recursos externos asociados al proyecto (XML, propiedades, JSON)
│   │   └── webapp/        # Carpeta con el repositorio frontend del proyecto
│   └── test/              # Directorio para las pruebas unitarios y/o integración
│
├── pom.xml                # Configuración de las dependencias maven del proyecto
└── README.md              # Documentación asociada al proyecto


## Deployments
### Requisitos
- Iniciar servidor de aplicaciones para Java EE, en el entorno local
- Tener instalado en el entorno local un JDK compatible con el proyecto y con la versión del servidor de aplicaciones
- Luego construir el archivo .war del proyecto utilizando Maven mediante el siguiente bash:

```bash
mvn clean package
```

- Y finalmente, abri la url indicada por el servidor de aplicaciones en el navegador de preferencia, indicando el contexto del proyecto: **http://localhost:8080/contextoDeLaAplicacion**

  
## Arquitectura del proyecto
En cuanto al patrón de diseño para este proyecto, se tiene el diseño MVC, el cual nos permite la separación de responsabilidades entre la lógica de negocio, base de datos y la interfaz gráfica de cada modulo.

### Modelo
- Representa la estructura de datos a partir del modelo de base de datos y las reglas del sistemas, en cuanto a tipos de datos y propiedades de cada atributo
- Es la capa que se encarga de la comunicación con la base de datos.

### Vista
- Se encarga de la representación visual de los datos, mediante un interfaz gráfica de cara al usuario.
- En este proyecto se utiliza la herramienta de JSP junto con HTML, y además se puede incluir algún framework o librería frontend para codificar esta capa

### Controlador
- Se encarga de la comunicación de datos entre la base de datos y el frontend, mediante petición HTTP, controlando posibles errores, estados de respuesta HTTP y el flujo de la aplicación.

### Tecnologías
- **Java EE**
- **Servlets**
- **JSP**
- **Maven**
- **Framework frontend**: *puede ser Angular, Bootstrap, React, Vue*


## Patrones de Diseño Adicionales Java
- Implementación de inyección de dependencias para la capa de acceso a los datos (DAO)
- Patrón Builder para el manejo de instancias hacías las clases java por parte del controlador
- Implementación del Mapeo de datos entre la capa de modelo y la capa de transferencia de datos (DTO), como *capa de seguridad* para una exposición adecuada de los datos estrictamente necesarios hacía el frontend


