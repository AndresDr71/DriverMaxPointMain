# DriverMaxPointMain Application

Esta aplicación de JavaFX muestra una tabla con los resultados de los conductores con los máximos puntos en una competición. La aplicación carga los datos desde una base de datos utilizando un repositorio de consultas (`QueryRepository`) y los muestra en una interfaz gráfica.

## Características

- **Interfaz de Usuario**: Utiliza JavaFX para la interfaz gráfica, mostrando una tabla con los nombres de los conductores y sus puntos totales.
- **Cargado de Datos**: Los datos se cargan automáticamente al iniciar la aplicación desde un repositorio de consultas.
- **Estilo**: La aplicación aplica estilos básicos como negrita en las etiquetas y un fondo de color específico para la tabla.

## Estructura del Proyecto

- **DriverMaxPointMain**: Clase principal que extiende `Application` y maneja la inicialización de la interfaz y el cargado de datos.
- **createLabel(String texto)**: Método para crear etiquetas con estilo.
- **createTableView()**: Método para crear la tabla que muestra los datos de los conductores.
- **loadInitialData()**: Método para cargar los datos iniciales desde el repositorio.
- **start(Stage primaryStage)**: Método principal que configura la interfaz gráfica y carga los datos al iniciar la aplicación.
![Imagen de WhatsApp 2024-07-22 a las 10 28 53_9c5c85c6](https://github.com/user-attachments/assets/d8dc291c-16ad-49b7-8f03-d809534c9e05)
