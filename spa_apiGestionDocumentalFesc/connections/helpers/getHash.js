export default ()=> location.hash.slice(1).split("/")[1] || "/"

/*
/#/registrase/
*/

/*location.hash devuelve la parte de la URL de la página después del símbolo de almohadilla (#), incluyendo la almohadilla. */

/*.slice(1) se utiliza para eliminar la primera almohadilla de la cadena, obteniendo solo la parte de la URL después de la almohadilla. */

/*.split("/") divide la cadena en un array utilizando el carácter de barra diagonal (/) como separador. */

/*[1] devuelve el segundo elemento del array resultante. Los índices en JavaScript comienzan en 0, por lo que [1] se refiere al segundo elemento. */

/*|| "/" se utiliza como un operador de cortocircuito (short-circuit operator). Si el segundo elemento del array es falso, undefined o vacío,
 entonces se retorna la barra diagonal (/) como valor predeterminado. */