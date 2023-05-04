describe('My product(get) test suite', () => {
    it('should make a GET request to retrieve a list of products', () => {
        cy.request('http://localhost:8080/api/v1/product/').then((response) => {
            expect(response.status).to.equal(200)
            expect(response.body.data).to.have.length.greaterThan(0)
        })
    })
})
