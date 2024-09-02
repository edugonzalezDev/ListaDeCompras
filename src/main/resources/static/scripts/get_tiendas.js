window.addEventListener('load', function () {

    const url = '/tienda/todas';
    const settings = {
        method: 'GET'
    }

    fetch(url, settings)
        .then(response => response.json())
        .then(data => {
            const tiendaTableBody = document.querySelector('#tiendaTableBody');
            data.forEach(tienda => {
                const row = tiendaTableBody.insertRow();

                row.innerHTML = `
                    <td>${tienda.id}</td>
                    <td>${tienda.nombre}</td>
                    <td>${tienda.direccion}</td>
                    <td class="action-column">
                        <button type="button" onclick="editTienda(${tienda.id})" class="btn btn-warning btn-sm">Editar</button>
                    </td>
                    <td class="action-column">
                        <button type="button" onclick="deleteTienda(${tienda.id})" class="btn btn-danger btn-sm">Eliminar</button>
                    </td>
                `;
            });
        });
});
