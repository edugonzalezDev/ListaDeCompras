window.addEventListener('load', function () {
    const url = '/productos';
    const settings = {
        method: 'GET'
    }

    fetch(url, settings)
        .then(response => response.json())
        .then(data => {
            const productoTableBody = document.querySelector('#productoTableBody');
            data.forEach(producto => {
                const row = productoTableBody.insertRow();

                row.innerHTML = `
                    <td>${producto.id}</td>
                    <td>${producto.nombre}</td>
                    <td class="action-column">
                        <button type="button" onclick="editProducto(${producto.id})" class="btn btn-warning btn-sm">Editar</button>
                    </td>
                    <td class="action-column">
                        <button type="button" onclick="deleteProducto(${producto.id})" class="btn btn-danger btn-sm">Eliminar</button>
                    </td>
                `;
            });
        });
});
