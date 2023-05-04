/// <reference types="cypress"/>
describe('My product(update) test suite', () => {
    it('should make a PATCH request to update a product', () => {
        cy.request({
            method: 'PATCH',
            url: 'http://localhost:8080/api/v1/product/645278061527842a91cace3c',
            body: {
                name: "GUM",
                description: "chewing gum sweet",
                price: 60.0
            }
        }).then((response) => {
            expect(response.status).to.eq(200)
            const data = response.body.data
            expect(data.name).to.equal('GUM')
            expect(data.description).to.equal('chewing gum sweet')
            expect(data.price).to.equal(60.0)
        })
    })
})

