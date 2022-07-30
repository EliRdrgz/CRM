# Introducción

Para este proyecto, construirá un sistema de gestión de relaciones con los clientes (CRM). Los CRM son una herramienta que casi todos los equipos de ventas utilizan para realizar un seguimiento de los clientes potenciales y existentes a través del proceso de ventas.

Salesforce es el CRM más popular en el mercado actualmente. Este breve video explica lo que ofrece Salesforce CRM a un alto nivel.

La conclusión más importante del video es que nuestro CRM debería permitirnos:

Seguimiento de clientes potenciales (personas cuya información de contacto hemos recopilado pero que pueden o no estar interesadas en nuestro producto)
Convertir Leads en Oportunidades (los leads se convierten en oportunidades cuando muestran interés en comprar el producto)
Asociar una Oportunidad con una Cuenta.
Asociar contactos con una oportunidad.
Veamos un caso de uso real:

LBL Trucking Company vende flotas de camiones a grandes empresas de todo el mundo. Necesitan nuevos clientes, por lo que deciden ofrecer un seminario web gratuito sobre los ahorros de costos asociados con sus nuevos camiones híbridos. Cada persona que se registra en el seminario web se convierte en un líder en su CRM. El CRM almacena el nombre, el número de teléfono, la dirección de correo electrónico y el nombre de la empresa de cada cliente potencial.

Sara es asociada de ventas en LBL. Después del seminario web, comienza a llamar a todos los nuevos clientes potenciales. Los primeros 5 Leads no están interesados. El sexto líder es Mike de Emerson Produce Company. Mike dice que está interesado en aprender más y le gustaría ver sus precios.

Sara necesita convertir el cliente potencial de Mike en una oportunidad. El ID de cliente potencial de Mike es 134. Sara escribe "Convertir 134" en el CRM.

CRM comienza creando un nuevo objeto de contacto con la información de contacto del objeto de cliente potencial de Mike.

Luego, el CRM solicita a Sara el producto que le interesa a Mike (camión híbrido, camión de plataforma o camión con caja) y la cantidad de camiones que le interesa comprar. Sara ingresa la información “Hybrid Truck” y “30”. El CRM crea un nuevo objeto Oportunidad con esta información. Agrega el nuevo objeto Mike Contact como tomador de decisiones para la oportunidad y establece el estado en "ABIERTO".

Luego, el CRM solicita a Sara la industria, el número de empleados, la ciudad y el país de la empresa de Mike. Sara ingresa la información “Produce”, “4000”, “Berlín”, “Alemania”. CRM toma el nombre de la empresa del objeto principal de Mike y crea un nuevo objeto de cuenta con esta información. Agrega el Mike Contacto a la lista de contactos de la Cuenta y la nueva Oportunidad a la lista de oportunidades de la Cuenta.

Finalmente, el sistema elimina el Mike Lead.

Al día siguiente, Sara quiere buscar la nueva Oportunidad. La identificación de la oportunidad es 24. Ella escribe "búsqueda de oportunidad 24". El CRM muestra la información de la oportunidad.

Quiere llamar a Mike para verificar el trato. Lamentablemente, dice que han decidido comprar a otra empresa de camiones. Sara escribe "cerrado-perdido 24" y el CRM cambia el estado de la oportunidad 24 a "CERRADO-PERDIDO"


### Diagrams
Case diagram
![Case diagram](src/main/java/com/ironhack/img/crm_case_diagram.png?raw=true "Case diagram")
***
Class diagram
![Class diagram](src/main/java/com/ironhack/img/crm_class_diagram.png?raw=true "Class diagram")
