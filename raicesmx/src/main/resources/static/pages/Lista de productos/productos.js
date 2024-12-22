//Consumimos una Api para obtener todos lo productos.
const url = "http://3.137.210.18/api/v1/producto/getall";

fetch(url)
  .then(response => response.json())
  .then(data => {
    
    mostrarProductos(data);
    
    // Se añade en esta parte los filtros
    document.getElementById("catCafe").addEventListener("click", () => filtrarPorCategoria(data, 'Café'));
    document.getElementById("catBolsas").addEventListener("click", () => filtrarPorCategoria(data, 'Bolsas'));
    document.getElementById("catJoyeria").addEventListener("click", () => filtrarPorCategoria(data, 'Joyería'));
    document.getElementById("catMiel").addEventListener("click", () => filtrarPorCategoria(data, 'Miel'));
    document.getElementById("allProd").addEventListener("click", () => mostrarProductos(data));
  })
  .catch(error => {
    console.error(error);
  });

// Para añadir los items de los productos en el html
function cartaProductos(data) {
  const itemHTML = ` 
            <div class="card" style="width: 18rem;">
                <img src="${data.imagen_url}" class="card-img-top" alt="${data.nombre}">
                <div class="card-body">
                    <center><h5 class="card-title">${data.nombre}</h5></center>
                    <p class="card-text">${data.descripcion}</p>
                    <center>
                        <p class="card-text">Precio: $${data.precio}</p>
                        <p class="card-text">Inventario: ${data.stock}</p> 
                        <a href="#" class="btn btn-primary" onclick="comprar">Comprar</a> 
                    </center>
                </div>
            </div>
        `;
  
  const contenedorProductos = document.querySelector("#cartas_productos");
  contenedorProductos.innerHTML += itemHTML;
}

// Para mostrar productos
function mostrarProductos(data) {
  const contenedorProductos = document.querySelector("#cartas_productos");
  contenedorProductos.innerHTML = ''; 
  
  // Mostrar todos los productos
  data.forEach(data => {
    cartaProductos(data);
  });
}

//Para filtrar por categoria
function filtrarPorCategoria(data, categoria) {
  
  const productosFiltrados = data.filter(data => data.imagen_url.toLowerCase().includes(categoria.toLowerCase()));
  mostrarProductos(productosFiltrados);
}