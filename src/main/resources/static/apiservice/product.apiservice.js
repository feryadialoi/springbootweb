const productApiService = {
    getProducts() {
        return fetch("/api/products")
            .then(response => response.json())
    },
    getProduct(productId) {
        return fetch("/api/products/" + productId)
            .then(response => response.json())
    },
    createProduct(createProductRequest) {
        return fetch("/api/products", {
            method: "POST",
            body: JSON.stringify(createProductRequest)
        })
            .then(response => response.json())
    }
}