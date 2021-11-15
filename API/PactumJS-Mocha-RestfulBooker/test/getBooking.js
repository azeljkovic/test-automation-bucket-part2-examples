const endpoints = require('../data/endpoints.json');
const validResponseJSON = require('../data/validResponse.json');
const responseData = require('../data/response.json');
const pactum = require('pactum');


it('Get specific valid ID', async () => {
    await pactum.spec()
        .get(endpoints.booking + endpoints.validID)
        .withHeaders('Accept', 'application/json')
        .expectStatus(200)
        .expectHeaderContains('content-type', 'application/json')
        .expectJson(validResponseJSON);
});

it('Get specific valid ID without Accept header', async () => {
    await pactum.spec()
        .get(endpoints.booking + endpoints.validID)
        .expectStatus(418)
        .expectHeaderContains('content-type', 'text/plain')
        .expectBody(responseData.emptyAcceptHeaderMessage);
});

it('Get specific invalid ID', async () => {
    await pactum.spec()
        .get(endpoints.booking + endpoints.invalidID)
        .withHeaders('Accept', 'application/json')
        .expectStatus(404)
        .expectHeaderContains('content-type', 'text/plain')
        .expectBody(responseData.invalidIDMessage);
});
