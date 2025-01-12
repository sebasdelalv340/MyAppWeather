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

MainActivity se encuentra lo más limpio posible, únicamente instanciando al Datastore y el ViewModel para el manejo de datos, los almacenados y los introducidos por el usuario en la UI.
https://github.com/sebasdelalv340/MyAppWeather/blob/0659836cfcfb8ac826be9e3a76c55c57740d69fe/app/src/main/java/com/example/myappweather/MainActivity.kt#L15
