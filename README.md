# 💫 Hooligans of Java CRM

### 👊 Integrantes del equipo

- 🏅 Joaquim Pineda
- 🏅 Eli Rodríguez
- 🏅 Jose Rodríguez
- 🏅 Ana Montero

---

### Introducción

Para este proyecto, se va a construir un sistema de gestión de relaciones de clientes (CRM). </br></br>Al tener
visibilidad como
usuarios de CRM, se le ha dado mucha importancia a la experiencia de usuario y a la idea de que sea sobre todo fácil de
usar. Es por eso que se presenta dos opciones de uso, la clásica consola, y una interfaz gráfica (GUI).

---

### 🛠️ Stack utilizado

* IntelliJ IDEA 2022.1.2 (Ultimate Edition)
* Java 17
* Maven 3.8.6
* JUnit 5
* Java Swing

---

### 👁️‍🗨️ Diagramas

Diagrama de casos
![Case diagram](src/main/java/com/ironhack/img/crm_case_diagram.png?raw=true "Case diagram")
---
Diagrama de clases
![Class diagram](src/main/java/com/ironhack/img/crm_class_diagram.png?raw=true "Class diagram")

---

### 💻 Presentación del proyecto

* El proyecto se encuentra dividido en diferentes paquetes, con idea de presentar una clara estructura.</br></br>
    * `classes`: contiene todas esas clases que sirven para el modelado de la aplicación. Se decide añadir las clases
      LeadList y OpportunityList, que son las que servirán para almacenar la información y gestionarla (en memoria)
      .</br></br>
    * `console`: aquí se delega acciones comunes derivadas del uso de la consola, como pueden ser las validaciones de
      ciertos campos (no se aceptan dígitos en los nombres, validación de teléfono e emails, etc.), o la muestra de
      mensajes acordes a la validación de los campos.</br></br>
    * `demo`: desde aquí se gestiona la creación y carga de los datos demos, para que exista información cuando se
      quiera probar la aplicación.</br></br>
    * `enums`: carpeta autodescriptiva, se meten aquí aquellas clases de tipo Enum.</br></br>
    * `gui`: todo lo relacionado con la parte más visual de la aplicación. Contiene cada vista/panel que conforman la
      interfaz gráfica de usuario.</br></br>
    * `img`: carpeta contenedora de todas las imágenes del proyecto.</br></br>
    * `menu`: clase de peso principal del proyecto, pues une todas las integraciones de diferentes métodos y lógicas.
      Recoge el _input_ del usuario, implementa los métodos públicos que se encargan de las acciones
      necesarias, y muestra el _output_ en consola.</br></br>
    * `persistData`: gestiona la persistencia de datos para no depender sólo de las listas en memoria. Es el primer
      intento y la funcionalidad no está completamente integrada</br></br>
    * `test`: contiene las clases que brindan la testeabilidad de la aplicación.</br></br>

---

### 🚀 ¿Cómo se ejecuta?

1. Arranca el [Main](src/main/java/com/ironhack/Main.java) del proyecto
2. Elige la opción deseada del menú, el cual acepta tanto **selección por dígitos** o por **escritura de comando**
3. Se aconseja cargar los datos (_Load demo data_, opción **7**) para poder tener una experiencia más completa
4. Otro consejo es que antes de buscar una oportunidad por nombre, te asaegures de que esa compañía se ha asociado ya a una oportunidad
5. Además de los comandos básicos (_New lead_, _Show leads_, _Lookup lead id_, _Convert id_, _Edit opportunity_), se
   presentan otros de utilidad como son:
    1. _Search opportunity by company name_ (ahórrate un par de segundos y pulsa opción **5**): permite buscar
       oportunidades por el nombre de la empresa a la que se vincula
    2. _Open App_: abre la GUI y para una mayor experiencia de usuario
    3. ⚠️ IMPORTANTE ⚠️: La implementación de la GUI está en desarrollo, así que no se van a encontrar presente todas
       las funcionalidades que existen desde la consola. En versiones futuras se podrá encontrar una interfaz más
       completa

---
![Thank you!](src/main/java/com/ironhack/img/thank_you.gif?raw=true "Gracias")