const endpoints = require('../data/endpoints.json');
const requestJSON = require('../data/createBooking.json');
const pactum = require('pactum');
const {mochaHooks} = require("./hooks");


it.only('Create valid booking', async () => {
    await new Promise(resolve => setTimeout(resolve, 1000));
    await pactum.spec()
        .put(endpoints.booking + endpoints.updateID)
        .withHeaders('Accept', 'application/json')
        .withCookies('token='+ token)
        .withBody(requestJSON)
        .expectStatus(200)
        .expectHeaderContains('content-type', 'application/json')
        //.expectJsonMatch('booking', requestJSON);
});
