# Justificación del Uso de Jetpack DataStore para Persistencia de Datos

## Introducción
Jetpack DataStore es una solución moderna para la persistencia de datos clave:valor en Android, diseñada para reemplazar a **SharedPreferences**. En esta aplicación, se utiliza DataStore para almacenar datos relacionados con fechas y temperaturas, asegurando eficiencia, escalabilidad y una experiencia de usuario mejorada.

## Ventajas de Jetpack DataStore

### 1. Persistencia Moderna y Segura
DataStore utiliza **Kotlin Coroutines** para realizar operaciones de lectura y escritura asincrónicas, evitando bloqueos en el hilo principal y asegurando un manejo eficiente de errores.

### 2. Modelo Clave:Valor
Para datos simples como fechas y temperaturas:
- Cada fecha se almacena como una **clave** (`String`).
- La temperatura asociada se almacena como el **valor** (`String`).

### 3. Escalabilidad y Soporte para Tipos Definidos
DataStore ofrece dos implementaciones:
- **Preferences DataStore**: Ideal para pares clave:valor simples.
- **Proto DataStore**: Para datos estructurados con esquemas definidos.

En este caso, **Preferences DataStore** es suficiente para registrar temperaturas diarias.

### 4. Operaciones Seguras y Sin Bloqueo
El uso de Coroutines garantiza:
- Operaciones concurrentes seguras.
- Ausencia de bloqueos en el hilo principal, evitando ANRs (Application Not Responding).

### 5. Respaldo a Largo Plazo
Jetpack DataStore, respaldado por Google, es una solución robusta que recibe actualizaciones continuas, asegurando su viabilidad para proyectos a largo plazo.


# Utilidad en la vida real

En este caso, se trata de un ejemplo simple en el que almacenamos dos tipos de datos, fecha:temperatura, pero podríamos guardar otro tipo de dato asociado a una fecha como nuestro peso si queremos llevar un control sobre él si estamos realizando una dieta o la precipitación por lluvia (como hace mi suegra).
Esta funcionalidad podría ser ampliable a futuro, añadiendo por ejemplo la opción de acceder al histórico a modo de lista o calendario.


# Documentación del código

## MainActivity

MainActivity se encuentra lo más limpio posible, únicamente instanciando al Datastore y el ViewModel para el manejo de datos; los almacenados y los introducidos por el usuario en la UI.
https://github.com/sebasdelalv340/MyAppWeather/blob/0659836cfcfb8ac826be9e3a76c55c57740d69fe/app/src/main/java/com/example/myappweather/MainActivity.kt#L15

## Navegación

Será la función principal que llamaremos desde nuestro **MainActivity** desde la cuál se navega entra los dos layout a través de sus rutas<String>.
https://github.com/sebasdelalv340/MyAppWeather/blob/19109174e89264640eef1a1b492f7808228617cb/app/src/main/java/com/example/myappweather/navigation/Navigation.kt#L17

## ViewModel
Existen dos, uno para el manejo de los datos introducidos en la pantalla de guardado y otro para la de búsqueda.

### 1. SaveViewModel
Gestiona los datos introducidos por el usuario en el layout de guardado.
https://github.com/sebasdelalv340/MyAppWeather/blob/19109174e89264640eef1a1b492f7808228617cb/app/src/main/java/com/example/myappweather/viewModel/SaveLoginViewModel.kt#L7

### 2. SearchViewModel
Gestiona los datos introducidos por el usuario en el layout de búsqueda.
https://github.com/sebasdelalv340/MyAppWeather/blob/19109174e89264640eef1a1b492f7808228617cb/app/src/main/java/com/example/myappweather/viewModel/SearchLoginViewModel.kt#L7

## Screens

### 1. Pantalla de guardado
Se trata de una layout sencillo con una cabecera con un logo, título y un icono de navegación a la pantalla de búsqueda, un cuerpo dónde el usuario introduce fecha y temperatura, y un botón para **Guardar**.
https://github.com/sebasdelalv340/MyAppWeather/blob/19109174e89264640eef1a1b492f7808228617cb/app/src/main/java/com/example/myappweather/screens/save/Save.kt#L25

Todos los estado se encuentran elevados en la función principal del guardado.
En el cuerpo ejecutamos el guardado con **DataStore** dentro de una corutina y mostramos una alerta de diálogo tras la comprobación de posibles errores en los datos introducidos.
https://github.com/sebasdelalv340/MyAppWeather/blob/19109174e89264640eef1a1b492f7808228617cb/app/src/main/java/com/example/myappweather/screens/save/body/BodySave.kt#L25

### 2. Pantalla de búsqueda
Segundo layout con la misma cabecera, con la excepción del icono de navegación que ahora nos devuelve a la pantalla anterior, y un cuerpo donde se introduce la fecha a buscar y el botón de **Buscar**.
https://github.com/sebasdelalv340/MyAppWeather/blob/19109174e89264640eef1a1b492f7808228617cb/app/src/main/java/com/example/myappweather/screens/search/Search.kt#L25

Igualmente encontramos los estados elevados respectivos a su **ViewModel**. Ejecutamos la búsqueda con **DataStore** dentro de una corutina y lanzamos una alerta de diálogo tras la comprobación de errores en los datos introducidos.
https://github.com/sebasdelalv340/MyAppWeather/blob/19109174e89264640eef1a1b492f7808228617cb/app/src/main/java/com/example/myappweather/screens/search/BodySearch.kt#L31

## Utilidades

Se trata de una carpeta que contiene funciones que pueden ser reutilizadas y de comprobación de datos.
En este caso, tenemos un **Spacer** y una función para validar el formato de la fecha.
https://github.com/sebasdelalv340/MyAppWeather/blob/e13d64b3612e9aed23c1c6353c6d897214b9a900/app/src/main/java/com/example/myappweather/utils/MySpacer.kt#L10
https://github.com/sebasdelalv340/MyAppWeather/blob/19109174e89264640eef1a1b492f7808228617cb/app/src/main/java/com/example/myappweather/utils/ValidarFecha.kt#L14





