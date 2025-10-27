# 🎓 Registro de Estudiantes - App de Gestión Académica

Este proyecto es una **aplicación Android desarrollada en Java** que permite gestionar un registro de estudiantes de forma local mediante **SQLite**.  
Incluye funcionalidades completas de **creación, visualización, actualización y eliminación (CRUD)**, pensadas para fines académicos o de práctica de desarrollo Android con bases de datos locales.

---

## ✒️ Autor

**Aaron Centeno Esquivel**  
📧 Correo: [a.centeno2@alumnos.santotomas.cl](mailto:a.centeno2@alumnos.santotomas.cl)  
💼 GitHub: [AaronCenteno1](https://github.com/AaronCenteno1)

---

## 🛠️ Entorno de Desarrollo

- 🧩 **Entorno:** Android Studio (JetBrains s.r.o.)  
- ☕ **Lenguaje:** Java  17
- 💾 **Base de Datos:** SQLite nativa de Android  
- 🧱 **SDK Mínimo:** API 24 (Android 7.0 Nougat)  
- 🎯 **SDK Objetivo:** API 33 (Android 13) o superior  
- ⚙️ **JDK:** Versión 21.0.6 (OpenJDK 21, 64-bit Server VM)

---

## 🚀 Cómo Funciona la Aplicación

El flujo general de la aplicación es simple, intuitivo y didáctico:

1. **MainActivity:**  
   Pantalla principal que permite **registrar nuevos estudiantes** ingresando su nombre, apellido, edad, correo y carrera.  
   Incluye validaciones básicas y confirma si el registro fue exitoso.

2. **InformationActivity:**  
   Muestra en un **ListView** todos los estudiantes guardados en la base de datos.  
   Al seleccionar un registro, el usuario puede visualizar los datos completos de un estudiante.

3. **deleteinfo (Activity de Edición):**  
   Permite **actualizar o eliminar** la información de un estudiante existente.  
   Incluye **AlertDialogs de confirmación** antes de ejecutar acciones sensibles.

4. **Navegación fluida:**  
   La app utiliza `Intent` para cambiar entre actividades y mantener una experiencia continua.  
   Cada modificación se refleja de inmediato en la base de datos.

---

## 🏗️ Arquitectura y Clases Principales

La aplicación sigue una arquitectura sencilla de **capa de datos + capa de interfaz**, separando la lógica de negocio del código visual.

### 📂 Directorio principal (`com.example.registroestudiante`)

- **MainActivity:** Pantalla principal para registrar estudiantes.  
- **InformationActivity:** Lista y permite acceder a los registros guardados.  
- **deleteinfo:** Edita y elimina estudiantes seleccionados.

### 🧠 Directorio de base de datos (`com.example.registroestudiante.db`)

#### `StudentsContract.java` (El “Contrato”)
Define de forma centralizada el **nombre de la tabla y las columnas** de la base de datos.  
Evita errores de tipeo y permite mantener el esquema de datos en un solo punto.

#### `DbHelper.java` (El “Ayudante”)
Extiende `SQLiteOpenHelper` y gestiona la creación y actualización de la base de datos.  
- **onCreate:** Crea la tabla `students` la primera vez que se ejecuta la app.  
- **onUpgrade:** Permite actualizar el esquema al cambiar la versión de la base de datos.

#### `StudentsDatabase.java` (La “Lógica de Datos”)
Contiene todos los métodos CRUD (Create, Read, Update, Delete):
- `insertStudents()` → Inserta nuevos registros.  
- `callList()` → Obtiene todos los estudiantes.  
- `updateStudent()` → Actualiza información existente.  
- `deleteStudent()` → Elimina un registro por ID.  
- `getStudentById()` → Recupera un estudiante específico.

---
