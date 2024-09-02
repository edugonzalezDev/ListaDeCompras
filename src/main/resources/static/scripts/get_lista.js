window.addEventListener('load', function () {
    const url = '/listas';
    const settings = {
        method: 'GET'
    }

    fetch(url, settings)
        .then(response => response.json())
        .then(data => {
            const listaContainer = document.querySelector('#lista_de_compras .list-group');
            data.forEach(lista => {
                const listaItem = document.createElement('a');
                listaItem.href = '#';
                listaItem.className = 'list-group-item list-group-item-action bg-secondary text-light';
                listaItem.textContent = lista.nombre;
                listaContainer.appendChild(listaItem);
            });
        });
});
