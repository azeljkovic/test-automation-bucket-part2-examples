const endpoints = require('../data/endpoints.json');
const requestJSON = require('../data/createBooking.json');
const pactum = require('pactum');
const request = pactum.request;

request.setBaseUrl('http://localhost:3001');

it('Create valid booking', async () => {
    await pactum.spec()
        .post(endpoints.booking)
        .withHeaders('Accept', 'application/json')
        .withBody(requestJSON)
        .expectStatus(200)
        .expectHeaderContains('content-type', 'application/json')
        .expectJsonMatch('booking', requestJSON);
});

it('Create invalid booking', async () => {
    await pactum.spec()
        .post(endpoints.booking)
        .withHeaders('Accept', 'application/json')
        .withBody({"invalid": "body"})
        .expectStatus(400)
});
