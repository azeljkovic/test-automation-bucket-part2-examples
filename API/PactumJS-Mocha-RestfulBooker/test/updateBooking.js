const endpoints = require('../data/endpoints.json');
const requestJSON = require('../data/createBooking.json');
const authData = require('../data/auth.json');
const pactum = require('pactum');


it.only('Update booking', async () => {
    await pactum.spec()
        .put(endpoints.booking + endpoints.updateID)
        .withAuth(authData.validUsername, authData.validPassword)
        .withHeaders('Accept', 'application/json')
        .withBody(requestJSON)
        .expectStatus(200)
        .expectHeaderContains('content-type', 'application/json')
        //.expectJsonMatch('booking', requestJSON);
});
