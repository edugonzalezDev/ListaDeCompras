window.addEventListener('load', function () {
    const url = '/categorias';
    const settings = {
        method: 'GET'
    }

    fetch(url, settings)
        .then(response => response.json())
        .then(data => {
            const categoriaTableBody = document.querySelector('#categoriaTableBody');
            data.forEach(categoria => {
                const row = categoriaTableBody.insertRow();

                row.innerHTML = `
                    <td>${categoria.id}</td>
                    <td>${categoria.nombre}</td>
                    <td class="action-column">
                        <button type="button" onclick="editCategoria(${categoria.id})" class="btn btn-warning btn-sm">Editar</button>
                    </td>
                    <td class="action-column">
                        <button type="button" onclick="deleteCategoria(${categoria.id})" class="btn btn-danger btn-sm">Eliminar</button>
                    </td>
                `;
            });
        });
});
