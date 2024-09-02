window.addEventListener('load', function () {

    const formulario = document.querySelector('#add_new_lista');

    formulario.addEventListener('submit', function (event) {
        event.preventDefault();

        // Obtener la fecha actual en formato adecuado (YYYY-MM-DD)
        const today = new Date();
        const fechaCreacion = today.toISOString().split('T')[0];

        const formData = {
            nombre: document.querySelector('#nombre_lista').value,
            fechaCreacion: fechaCreacion,
            tienda: {
                id: document.querySelector('#tienda_select').value // Asumiendo que existe un select para elegir la tienda
            }
        };

        const url = '/lista-de-compras';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                let successAlert = '<div class="alert alert-success alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong>Lista de compras creada correctamente</strong></div>';

                document.querySelector('#lista_response').innerHTML = successAlert;
                document.querySelector('#lista_response').style.display = "block";
                resetUploadForm();
            })
            .catch(error => {
                let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong>Error al crear la lista de compras</strong></div>';

                document.querySelector('#lista_response').innerHTML = errorAlert;
                document.querySelector('#lista_response').style.display = "block";
            });

        function resetUploadForm(){
            document.querySelector('#nombre_lista').value = "";
            document.querySelector('#tienda_select').value = ""; // Resetea el select de tienda
        }
    });
});
