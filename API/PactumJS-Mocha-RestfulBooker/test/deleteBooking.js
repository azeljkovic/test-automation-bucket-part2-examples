const endpoints = require('../data/endpoints.json');
const requestJSON = require('../data/createBooking.json');
const authData = require('../data/auth.json');
const pactum = require('pactum');


it('Delete booking - valid', async () => {
    await pactum.spec()
        .delete(endpoints.booking + "/9")
        .withAuth(authData.validUsername, authData.validPassword)
        .expectStatus(200);
});

it('Delete booking - non-existent', async () => {
    await pactum.spec()
        .delete(endpoints.booking + endpoints.invalidID)
        .withAuth(authData.validUsername, authData.validPassword)
        .expectStatus(405);
});