window.addEventListener('load', function () {
    const formulario = document.querySelector('#add_new_categoria');

    formulario.addEventListener('submit', function (event) {
        event.preventDefault();

        const formData = {
            nombre: document.querySelector('#nombre_categoria').value
        };

        const url = '/categorias';
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
                    '<strong>Categoría registrada correctamente</strong></div>';

                document.querySelector('#response').innerHTML = successAlert;
                document.querySelector('#response').style.display = "block";
                resetUploadForm();
            })
            .catch(error => {
                let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong>Error al registrar la categoría</strong></div>';

                document.querySelector('#response').innerHTML = errorAlert;
                document.querySelector('#response').style.display = "block";
            });

        function resetUploadForm(){
            document.querySelector('#nombre_categoria').value = "";
        }
    });
});
