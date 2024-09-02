window.addEventListener('load', function () {
    const url = '/lista-de-compras/todas';
    const settings = {
        method: 'GET'
    }

    fetch(url, settings)
        .then(response => response.json())
        .then(data => {
            const listaTableBody = document.querySelector('#listaTableBody');
            data.forEach(lista => {
                            const row = listaTableBody.insertRow();

                            row.innerHTML = `
                                <td>${lista.id}</td>
                                <td>${lista.nombre}</td>
                                <td>${lista.tienda.nombre}</td>
                                <td class="action-column">
                                    <button type="button" onclick="editLista(${lista.id})" class="btn btn-warning btn-sm">Editar</button>
                                </td>
                                <td class="action-column">
                                    <button type="button" onclick="deleteLista(${lista.id})" class="btn btn-danger btn-sm">Eliminar</button>
                                </td>
                            `;
                        });
        });
});
