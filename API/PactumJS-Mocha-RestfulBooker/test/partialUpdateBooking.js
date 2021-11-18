const endpoints = require('../data/endpoints.json');
const firstnameLastnameRequest = require('../data/PATCH/firstnameLastnameRequest.json');
const firstnameLastnameResponse = require('../data/PATCH/firstnameLastnameResponse.json');
const totalpriceDepositpaidRequest = require('../data/PATCH/totalpriceDepositpaidRequest.json');
const totalpriceDepositpaidResponse = require('../data/PATCH/totalpriceDepositpaidResponse.json');
const checkinCheckoutRequest = require('../data/PATCH/checkinCheckoutRequest.json');
const checkinCheckoutResponse = require('../data/PATCH/checkinCheckoutResponse.json');
const additionalNeedsRequest = require('../data/PATCH/additionalNeedsRequest.json');
const additionalNeedsResponse = require('../data/PATCH/additionalNeedsResponse.json');
const authData = require('../data/auth.json');
const pactum = require('pactum');


it('Partial update booking - firstname & lastname', async () => {
    await pactum.spec()
        .patch(endpoints.booking + "/5")
        .withAuth(authData.validUsername, authData.validPassword)
        .withHeaders('Accept', 'application/json')
        .withBody(firstnameLastnameRequest)
        .expectStatus(200)
        .expectHeaderContains('content-type', 'application/json')
        .expectJson(firstnameLastnameResponse);
});

it('Partial update booking - total price & deposit paid', async () => {
    await pactum.spec()
        .patch(endpoints.booking + "/6")
        .withAuth(authData.validUsername, authData.validPassword)
        .withHeaders('Accept', 'application/json')
        .withBody(totalpriceDepositpaidRequest)
        .expectStatus(200)
        .expectHeaderContains('content-type', 'application/json')
        .expectJson(totalpriceDepositpaidResponse);
});

it('Partial update booking - checkin & checkout date', async () => {
    await pactum.spec()
        .patch(endpoints.booking + "/7")
        .withAuth(authData.validUsername, authData.validPassword)
        .withHeaders('Accept', 'application/json')
        .withBody(checkinCheckoutRequest)
        .expectStatus(200)
        .expectHeaderContains('content-type', 'application/json')
        .expectJson(checkinCheckoutResponse);
});

it('Partial update booking - additional needs', async () => {
    await pactum.spec()
        .patch(endpoints.booking + "/8")
        .withAuth(authData.validUsername, authData.validPassword)
        .withHeaders('Accept', 'application/json')
        .withBody(additionalNeedsRequest)
        .expectStatus(200)
        .expectHeaderContains('content-type', 'application/json')
        .expectJson(additionalNeedsResponse);
});

it('Partial update booking - non-existent booking', async () => {
    await pactum.spec()
        .patch(endpoints.booking + endpoints.invalidID)
        .withAuth(authData.validUsername, authData.validPassword)
        .withHeaders('Accept', 'application/json')
        .withBody(additionalNeedsRequest)
        .expectStatus(405)
        .expectHeaderContains('content-type', 'text/plain');
});