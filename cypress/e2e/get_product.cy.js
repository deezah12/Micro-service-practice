describe('My product(get) test suite', () => {
    it('should make a GET request to retrieve a specific product', () => {
            cy.request('http://localhost:8080/api/v1/product/645278f757b5cd0ac91be6f9').then((response) => {
                expect(response.status).to.equal(200)
                expect(response.body.data.name).to.equal('milo')
                expect(response.body.data.description).to.equal('beverage drinks')
                expect(response.body.data.price).to.equal(50.0)
            })
    })
})



