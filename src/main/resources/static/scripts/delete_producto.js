function deleteProducto(id) {
    const url = `/productos/eliminar/${id}`;
    const settings = {
        method: 'DELETE'
    }

    fetch(url, settings)
        .then(response => {
            if (response.ok) {
                let row_id = "#tr_" + id;
                document.querySelector(row_id).remove();
            } else {
                alert('Error al eliminar el producto');
            }
        });
}
