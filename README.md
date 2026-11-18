# Bookshelf App - Android Jetpack Compose

Aplicación de Android desarrollada siguiendo estrictamente el codelab oficial de Google:
👉 **[Proyecto: Crea una app de Bookshelf](https://developer.android.com/codelabs/basic-android-kotlin-compose-bookshelf?hl=es-419#0)** (Unidad 5 de *Android Basics with Compose*).

---

## 📖 Descripción del Proyecto
La aplicación **Bookshelf** se conecta a internet para consultar la **API pública de Google Books**, obtener colecciones de libros (por defecto *"jazz history"* o cualquier término que ingrese el usuario) y mostrar las portadas de los libros descargadas de forma asíncrona junto con sus títulos en una cuadrícula vertical adaptable.

---

## 🚀 Características Implementadas (según el Codelab)

1. **Capa de Red con Retrofit & Gson:**
   - Conexión al endpoint de la API de Google Books: `https://www.googleapis.com/books/v1/`.
   - Consulta de búsqueda general (`volumes?q=<query>`) para obtener los IDs y volúmenes.
   - Consulta individual por libro (`volumes/<volume_id>`) para extraer los enlaces de miniaturas (`imageLinks.thumbnail`).
   - Conversión automática de URLs de miniaturas inseguras (`http`) a seguras (`https`) con `String.replace()`.
   - Procesamiento del JSON mediante **Gson** (`converter-gson`).

2. **Capa de Datos & Arquitectura:**
   - Separación estricta entre la capa de interfaz de usuario y la capa de datos usando el **Patrón Repositorio** (`BooksRepository` / `NetworkBooksRepository`).
   - Inyección de dependencias manual mediante `AppContainer` y `DefaultAppContainer` en la clase `BookshelfApplication`.

3. **Capa de Interfaz de Usuario (UI) con Jetpack Compose:**
   - Manejo de estados de la UI mediante `BooksUiState` (`Loading`, `Success`, `Error`).
   - Pantalla de carga (`LoadingScreen`) con indicador de progreso.
   - Pantalla de error (`ErrorScreen`) con mensaje y botón de reintento (*Retry*).
   - Cuadrícula vertical dinámica (`BooksGridScreen` con `LazyVerticalGrid` y `GridCells.Adaptive`).
   - Descarga asíncrona y almacenamiento en caché de imágenes con **Coil** (`AsyncImage`).
   - Barra de búsqueda interactiva para consultar cualquier libro.

4. **Diseño para la Capacidad de Prueba (Unit Testing):**
   - Servicio falso de red (`FakeBooksApiService`) que simula respuestas sin hacer llamadas HTTP reales.
   - Repositorio falso (`FakeBooksRepository`) para pruebas de ViewModel.
   - Pruebas unitarias completas para el repositorio (`NetworkBooksRepositoryTest`) y el ViewModel (`BooksViewModelTest`).
   - Regla de despachador de pruebas (`TestDispatcherRule`) con `kotlinx-coroutines-test`.

---

## 📁 Estructura del Código

```text
com.example.bookshelf/
├── BookshelfApplication.kt       # Contenedor de dependencias de la app
├── MainActivity.kt               # Punto de entrada de la actividad Compose
├── data/
│   ├── AppContainer.kt           # Inyección de dependencias manual
│   └── BooksRepository.kt        # Interfaz e implementación de red del repositorio
├── model/
│   └── Book.kt                   # Modelos de datos de la API y modelo de UI
├── network/
│   └── BooksApiService.kt        # Interfaz de Retrofit para Google Books API
└── ui/
    ├── BookshelfApp.kt           # Scaffold principal y barra de aplicación
    ├── BooksViewModel.kt         # ViewModel y estados de UI
    ├── screens/
    │   ├── HomeScreen.kt         # Pantalla principal y barra de búsqueda
    │   ├── LoadingScreen.kt      # Pantalla de carga
    │   ├── ErrorScreen.kt        # Pantalla de error con reintento
    │   └── BooksGridScreen.kt    # Cuadrícula vertical de libros (LazyVerticalGrid)
    └── theme/                    # Tema Material 3 (Color, Shape, Theme, Type)
```

---

## 🛠️ Tecnologías Utilizadas
- **Kotlin** (v1.9.22) + Corrutinas
- **Jetpack Compose** + **Material 3**
- **Retrofit 2** (v2.9.0)
- **Gson** (v2.10.1)
- **Coil** (v2.5.0)
- **JUnit 4** & **Kotlinx Coroutines Test**

---

## 💻 Instrucciones para Abrir y Ejecutar en Android Studio

1. Abre **Android Studio**.
2. Selecciona **File > Open...** y elige la carpeta `BookshelfApp`.
3. Espera a que Gradle sincronice las dependencias del proyecto.
4. Conecta un dispositivo físico con depuración USB habilitada o inicia un emulador Android (API 24+).
5. Haz clic en **Run 'app'** (ícono de triángulo verde).

---

## 🧪 Ejecutar las Pruebas Unitarias

Para ejecutar las pruebas desde la terminal:
```bash
./gradlew test
```
O dentro de Android Studio, haz clic derecho sobre la carpeta `app/src/test` y selecciona **Run 'Tests in 'test''**.

---

## 📤 Subir a tu Repositorio en GitHub

Para subir este proyecto a un nuevo repositorio en tu cuenta de GitHub, ejecuta los siguientes comandos en la terminal desde la carpeta `BookshelfApp`:

```bash
git init
git add .
git commit -m "feat: Implementación completa de Bookshelf App siguiendo el codelab de Google"
git branch -M main
git remote add origin https://github.com/<TU_USUARIO>/<NOMBRE_DE_TU_REPOSITORIO>.git
git push -u origin main
```
