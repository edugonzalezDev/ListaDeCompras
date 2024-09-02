function deleteTienda(id) {
    // Construir la URL para eliminar la tienda con el ID proporcionado
    const url = `/tienda/eliminar/${id}`;
    const settings = {
        method: 'DELETE'
    };

    // Enviar la solicitud DELETE al servidor
    fetch(url, settings)
        .then(response => {
            if (response.ok) {
                // Si la respuesta es exitosa, eliminar la fila de la tienda de la tabla
                let row_id = "#tr_" + id;
                document.querySelector(row_id).remove();

                // Mostrar un mensaje de éxito
                let successAlert = '<div class="alert alert-success alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong>Tienda eliminada correctamente</strong></div>';
                document.querySelector('#response').innerHTML = successAlert;
                document.querySelector('#response').style.display = "block";
            } else {
                // Si la respuesta no es exitosa, mostrar un mensaje de error
                let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong>Error al eliminar la tienda</strong></div>';
                document.querySelector('#response').innerHTML = errorAlert;
                document.querySelector('#response').style.display = "block";
            }
        })
        .catch(error => {
            // Manejar errores de red u otros errores
            let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                '<strong>Error al conectar con el servidor</strong></div>';
            document.querySelector('#response').innerHTML = errorAlert;
            document.querySelector('#response').style.display = "block";
        });
}
