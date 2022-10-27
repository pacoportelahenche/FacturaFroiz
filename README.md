# facturaFroiz
Un programa para ordenar los datos desde una factura en formato pdf.
El motivo de la creación de este programa ha sido la necesidad de ordenar alfabéticamente las lineas de las facturas que nos envía un proveedor de mi trabajo.
Las facturas nos las envía por correo eléctronico en formato .pdf.
Las facturas vienen totalmente desordenadas (ignoro el criterio que siguen al crearlas), y al ser casi siempre bastante extensas, resulta muy dificil
comprobar la mercancía cuando se recibe (hay que ir buscando cada producto en todas las hojas de la factura hasta encontrarlo).
En este programa utilizo el reconocimento optico de caracteres, funcionalidad que nos ofrece la api de Tess4j. Utilizando dicha api recorro la factura
y paso de la imagen que representa cada página de la factura en pdf a un string que posteriormente ordeno y guardo en un fichero de texto.
De esta forma es mucho más facil encontrar la mercancía al estar ordenadas las lineas alfabéticamente.
Espero que le pueda ser útil a alguien.
