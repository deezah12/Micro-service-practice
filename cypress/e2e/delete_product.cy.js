/// <reference types="cypress"/>
describe('My product(delete) test suite', () => {
    it('should make a DELETE request to update a product', () => {
        cy.request({
            method: 'DELETE',
            url: 'http://localhost:8080/api/v1/product/645278061527842a91cace3c',
        }).then((response) => {
            expect(response.status).to.eq(200)
        })
    })
})