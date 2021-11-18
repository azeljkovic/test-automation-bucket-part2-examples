const endpoints = require('../data/endpoints.json');
const requestJSON = require('../data/createBooking.json');
const authData = require('../data/auth.json');
const pactum = require('pactum');


it('Update booking - valid', async () => {
    await pactum.spec()
        .put(endpoints.booking + 5)
        .withAuth(authData.validUsername, authData.validPassword)
        .withHeaders('Accept', 'application/json')
        .withBody(requestJSON)
        .expectStatus(200)
        .expectHeaderContains('content-type', 'application/json')
        .expectJson(requestJSON);
});

it('Update booking - non-existent', async () => {
    await pactum.spec()
        .put(endpoints.booking + endpoints.invalidID)
        .withAuth(authData.validUsername, authData.validPassword)
        .withHeaders('Accept', 'application/json')
        .withBody(requestJSON)
        .expectStatus(405)
        .expectHeaderContains('content-type', 'text/plain');
});
