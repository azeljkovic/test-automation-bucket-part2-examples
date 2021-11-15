const endpoints = require('../data/endpoints.json');
const authData = require('../data/auth.json');
const pactum = require('pactum');
const responseData = require("../data/response.json");


it('Create token - valid', async () => {
    await pactum.spec()
        .post(endpoints.getToken)
        .withHeaders('Accept', 'application/json')
        .withJson({
            username: authData.validUsername,
            password: authData.validPassword
        })
        .expectStatus(200)
        .expectHeaderContains('content-type', 'application/json')
        .expectJsonSchema('token', {
            "type": "string"
        });
});

it('Create token - invalid username', async () => {
    await pactum.spec()
        .post(endpoints.getToken)
        .withHeaders('Accept', 'application/json')
        .withJson({
            username: authData.invalidUsername,
            password: authData.validPassword
        })
        .expectStatus(200)
        .expectHeaderContains('content-type', 'application/json')
        .expectJson('reason', responseData.badCredentialsMessage);
});

it('Create token - invalid password', async () => {
    await pactum.spec()
        .post(endpoints.getToken)
        .withHeaders('Accept', 'application/json')
        .withJson({
            username: authData.validUsername,
            password: authData.invalidPassword
        })
        .expectStatus(200)
        .expectHeaderContains('content-type', 'application/json')
        .expectJson('reason', responseData.badCredentialsMessage);
});
