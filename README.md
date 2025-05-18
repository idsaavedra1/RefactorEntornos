# Proyecto Refactorización Baraja (Java)

![Java](https://img.shields.io/badge/Java-17-orange) ![License](https://img.shields.io/badge/License-MIT-green)

---

## Descripción

Este proyecto implementa una **baraja española** de 48 cartas con funcionalidades para crear, imprimir, sacar, meter cartas y barajar.  
Se ha aplicado una serie de **refactorizaciones** para mejorar la legibilidad, mantenibilidad y calidad del código original, que presentaba varios *code smells* y duplicaciones.

---

## Estructura del proyecto

- `src/estropeado/Baraja.java` — Clase principal que modela la baraja y sus operaciones.
- `src/estropeado/Main.java` — Clase con el método `main` para probar el funcionamiento.
- `doc/` — Documentación generada con JavaDoc.
- `README.md` — Este archivo.

---

## Cómo compilar y ejecutar

### Requisitos

- JDK 17 o superior instalado y configurado en el PATH.
- Terminal o consola de comandos.

### Compilar

Desde la raíz del proyecto (donde está la carpeta `src`), ejecuta:

```bash
javac -d bin src/estropeado/*.java

```
## Refactorizaciones aplicadas

| Refactorización                  | Problema detectado (Code Smell)                          | Solución aplicada y beneficio                                           |
|---------------------------------|----------------------------------------------------------|------------------------------------------------------------------------|
| Extract Method                  | Código largo y repetido en el constructor para crear nombres. | Separé la lógica de creación de nombre de carta en un método propio para mayor claridad. |
| Extract Variable                | Expresiones largas y poco claras.                        | Asigné expresiones intermedias a variables con nombre descriptivo para facilitar lectura. |
| Replace Magic Number with Symbolic Constant | Uso de números literales (10, 11, 12, 48) sin significado. | Definí constantes con nombre para explicar su significado y facilitar cambios futuros. |
| Consolidate Duplicate Conditional Fragments | Código duplicado en bloques condicionales anidados.    | Eliminé duplicados consolidando el código común fuera de las condiciones. |
| Decompose Conditional          | Condiciones complejas anidadas que dificultan la comprensión. | Descompuse las condiciones en métodos o variables que describen su propósito. |
| Rename Method / Rename Variable | Nombres poco descriptivos como num o pa.                 | Renombré variables y métodos para reflejar su función real.             |
| Parameterize Method            | Métodos duplicados para barajar con distinta cantidad de movimientos (5 y 40). | Unifiqué en un método con parámetro que recibe la cantidad de movimientos. |
| Extract Class                  | Clase con demasiadas responsabilidades y lógica mezclada. | Separé la creación de cartas en una clase auxiliar (si lo aplicaste).   |


---


## Documentacion JavaDoc

Se ha generado documentación JavaDoc para todas las clases y métodos del proyecto.  
Puedes consultarla abriendo el archivo `index.html` que se encuentra dentro de la carpeta `doc/` en tu navegador.



---

## Autor

**Iván Domingo Saavedra**  
Email: ivan.domingo@escuelaestech.es  
Fecha: 2025-05-18

---

---

## Licencia

Este proyecto está bajo la licencia **MIT**.  
Consulta el archivo [LICENSE](LICENSE) para más detalles.

---
