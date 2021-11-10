const endpoints = require('../data/endpoints.json');
const requestData = require('../data/request.json');
const responseData = require('../data/response.json');
const pactum = require('pactum');
const request = pactum.request;

request.setBaseUrl('http://localhost:3001');

it('Get all IDs', async () => {
    await pactum.spec()
        .get(endpoints.booking)
        .expectStatus(200)
        .expectHeaderContains('content-type', 'application/json')
        .expectJsonLength(responseData.allBookingsLength);
});

it('Get booking ID by existent firstname', async () => {
    await pactum.spec()
        .get(endpoints.booking)
        .withQueryParams('firstname', requestData.existentFirstname)
        .expectStatus(200)
        .expectHeaderContains('content-type', 'application/json')
        .expectJsonLength(1)
        .expectJson([{
            "bookingid": responseData.validBookingIDFirstnameLastname
        }]);
});

it('Get booking ID by existent lastname', async () => {
    await pactum.spec()
        .get(endpoints.booking)
        .withQueryParams('lastname', requestData.existentLastname)
        .expectStatus(200)
        .expectHeaderContains('content-type', 'application/json')
        .expectJsonLength(1)
        .expectJson([{
            "bookingid": responseData.validBookingIDFirstnameLastname
        }]);
});

it('Get booking ID by existent firstname and lastname', async () => {
    await pactum.spec()
        .get(endpoints.booking)
        .withQueryParams('firstname', requestData.existentFirstname)
        .withQueryParams('lastname', requestData.existentLastname)
        .expectStatus(200)
        .expectHeaderContains('content-type', 'application/json')
        .expectJsonLength(1)
        .expectJson([{
            "bookingid": responseData.validBookingIDFirstnameLastname
        }]);
});

it('Get booking ID by existent checkin date', async () => {
    await pactum.spec()
        .get(endpoints.booking)
        .withQueryParams('checkin', requestData.existentCheckinDate)
        .expectStatus(200)
        .expectHeaderContains('content-type', 'application/json')
        .expectJsonLength(1)
        .expectJson([{
            "bookingid": responseData.validBookingIDCheckinCheckoutDate
        }]);
});

it('Get booking ID by existent checkout date', async () => {
    await pactum.spec()
        .get(endpoints.booking)
        .withQueryParams('checkout', requestData.existentCheckoutDate)
        .expectStatus(200)
        .expectHeaderContains('content-type', 'application/json')
        .expectJsonLength(1)
        .expectJson([{
            "bookingid": responseData.validBookingIDCheckinCheckoutDate
        }]);
});

it('Get booking ID by existent checkin and checkout date', async () => {
    await pactum.spec()
        .get(endpoints.booking)
        .withQueryParams('checkin', requestData.existentCheckinDate)
        .withQueryParams('checkout', requestData.existentCheckoutDate)
        .expectStatus(200)
        .expectHeaderContains('content-type', 'application/json')
        .expectJsonLength(1)
        .expectJson([{
            "bookingid": responseData.validBookingIDCheckinCheckoutDate
        }]);
});
