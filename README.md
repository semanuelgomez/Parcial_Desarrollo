# API de Detección de Mutantes

**Nombre y Apellido**  
Emanuel Gomez 49487

## Descripción

Esta API ha sido desarrollada para identificar si un humano tiene características de un mutante a partir de su secuencia de ADN. El sistema utiliza patrones específicos en la secuencia para llevar a cabo las verificaciones y almacena cada análisis en una base de datos para su posterior consulta.

### Características

- **Base de Datos**: Implementa una base de datos H2 embebida que permite un almacenamiento rápido y eficiente de los datos.
- **Hosting**: La API está disponible en Render, accesible mediante la siguiente URL: [https://parcial-desarrollo-f32u.onrender.com](https://parcial-desarrollo-f32u.onrender.com).

## Endpoints Disponibles

### Verificación de Mutantes

- **Ruta**: `/mutant`
- **Método**: POST
- **Descripción**: Este endpoint verifica si la secuencia de ADN corresponde a un mutante. Además, almacena la secuencia y el resultado de la verificación en la base de datos.

#### Uso del Endpoint

Para comprobar si una secuencia de ADN indica mutación, realiza una solicitud HTTP POST en formato JSON a la siguiente dirección:

```
POST https://parcial-desarrollo-f32u.onrender.com/mutant
```

#### Ejemplo de Solicitud (ADN No Mutante)

```json
{
    "dna": ["ATGCTA", "CAGTGA", "TTGTTG", "AGACCT", "CAGCTA", "TCACTG"]
}
```

Si la secuencia de ADN no presenta características de mutante, la API responderá con un código `403 Forbidden`.

#### Ejemplo de Solicitud (ADN Mutante)

```json
{
    "dna": ["ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"]
}
```

Si la secuencia corresponde a un mutante, se devolverá una respuesta con el código `200 OK`.

### Obtener Estadísticas de ADN

- **Ruta**: `/stats`
- **Método**: GET
- **Descripción**: Este endpoint proporciona información estadística sobre las secuencias de ADN almacenadas en la base de datos. La respuesta incluye el total de secuencias humanas, el total de mutantes y la relación entre ambos.

#### Uso del Endpoint

Para acceder a las estadísticas, realiza una solicitud HTTP GET en la siguiente URL:

```
GET https://parcial-desarrollo-f32u.onrender.com/stats
```

#### Ejemplo de Respuesta

```json
{
    "ratio": 0.3333333333333333,
    "count_mutant_dna": 1,
    "count_human_dna": 3
}
```

En este caso, la respuesta indica que hay 3 secuencias de ADN humano, 1 secuencia de ADN mutante, y un ratio de 0.33 entre humanos y mutantes.

### Base de Datos H2

La base de datos H2 se encarga de guardar cada secuencia de ADN junto con un indicador que especifica si pertenece a un mutante. Esto optimiza el acceso a los datos y acelera las respuestas en solicitudes posteriores.

| ID | Secuencia de ADN                                           | Mutante |
|----|-----------------------------------------------------------|---------|
| 1  | ["ATGCTA", "CAGTGA", "TTGTTG", "AGACCT", "CAGCTA", "TCACTG"] | false   |
| 2  | ["ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"] | true    |


