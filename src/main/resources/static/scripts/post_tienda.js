window.addEventListener('load', function () {
    const formulario = document.querySelector('#add_new_tienda');

    formulario.addEventListener('submit', function (event) {
        event.preventDefault();

        const formData = {
            nombre: document.querySelector('#nombre_tienda').value,
            direccion: document.querySelector('#direccion_tienda').value
        };

        const url = '/tienda';
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
                    '<strong>Tienda registrada correctamente</strong></div>';

                document.querySelector('#tienda_response').innerHTML = successAlert;
                document.querySelector('#tienda_response').style.display = "block";
                resetUploadForm();
            })
            .catch(error => {
                let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong>Error al registrar la tienda</strong></div>';

                document.querySelector('#tienda_response').innerHTML = errorAlert;
                document.querySelector('#tienda_response').style.display = "block";
            });

        function resetUploadForm(){
            document.querySelector('#nombre_tienda').value = "";
            document.querySelector('#direccion_tienda').value = "";
        }
    });
});
