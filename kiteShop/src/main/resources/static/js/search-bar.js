const productsList = document.getElementById('productsList')
const searchBar = document.getElementById('searchInput')

const allProducts = [];

fetch("http://localhost:8080/products/api").
then(response => response.json()).
then(data => {
    for (let product of data) {
        allProducts.push(product);
    }
})

console.log(allProducts);

searchBar.addEventListener('keyup', (e) => {
    const searchingCharacters = searchBar.value.toLowerCase();
    let filteredProducts = allProducts.filter(product => {
        return product.name.toLowerCase().includes(searchingCharacters)
            || product.brand.toLowerCase().includes(searchingCharacters);
    });
    displayProducts(filteredProducts);
})


const displayProducts = (products) => {
    productsList.innerHTML = products
        .map((p) => {
            return ` <div class="col-md-3" >
                <div class="card mb-4 box-shadow">
                <img src="${p.imageUrl}" class="card-img-top" alt="Thumbnail [100%x225]"
                     data-holder-rendered="true"
                     style="height: 225px; width: 100%; display: block;">
                <div class="card-body">
                    <div class="text-center">
                        <p class="card-text border-bottom ">Name: ${p.name}</p>
                        <p class="card-text border-bottom ">Brand: ${p.brand}</p>
                        <p class="card-text border-bottom ">Type: ${p.type}</p>
                        <p class="card-text border-bottom ">Price: ${p.price}</p>
                        <p class="card-text border-bottom">Release Date: ${p.releaseDate}</p>
                    </div>
                    <div class="d-flex justify-content-between align-items-center">

                        <div class="btn-group">
                            <a href="/products/details/${p.id}"  type="button" class="btn btn-sm btn-outline-secondary">Details</a>
                        </div>
                        <div class="btn-group">
                            <a href="/products/delete/${p.id}"  type="button" class="btn btn-sm btn-outline-secondary">Delete</a>
                        </div>

                    </div>
                </div>
            </div>
            </div>`
        })
        .join('');

}
