describe('My product(add) test suite', () => {
    it('should make a POST request', () => {
        cy.request({
            method: 'POST',
            url: 'http://localhost:8080/api/v1/product/add',
            body: {
                name: "milo",
                description: "beverage drinks",
                price: 50.0
            }
        }).then((response) => {
            const data = response.body.data
            expect(data.name).to.equal('milo')
            expect(data.description).to.equal('beverage drinks')
            expect(data.price).to.equal(50.0)
            expect(response.status).to.eq(200)
        })
    })
})

