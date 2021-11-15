const endpoints = require('../data/endpoints.json');
const requestData = require('../data/request.json');
const responseData = require('../data/response.json');
const pactum = require('pactum');


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

it('Get booking ID by nonexistent firstname', async () => {
    await pactum.spec()
        .get(endpoints.booking)
        .withQueryParams('firstname', requestData.nonExistentFirstname)
        .expectStatus(200)
        .expectHeaderContains('content-type', 'application/json')
        .expectJsonLength(0);
});

it('Get booking ID by nonexistent lastname', async () => {
    await pactum.spec()
        .get(endpoints.booking)
        .withQueryParams('lastname', requestData.nonExistentLastname)
        .expectStatus(200)
        .expectHeaderContains('content-type', 'application/json')
        .expectJsonLength(0);
});

it('Get booking ID by nonexistent checkin date', async () => {
    await pactum.spec()
        .get(endpoints.booking)
        .withQueryParams('checkin', requestData.nonExistentCheckinDate)
        .expectStatus(200)
        .expectHeaderContains('content-type', 'application/json')
        .expectJsonLength(0);
});

it('Get booking ID by nonexistent checkout date', async () => {
    await pactum.spec()
        .get(endpoints.booking)
        .withQueryParams('checkout', requestData.nonExistentCheckoutDate)
        .expectStatus(200)
        .expectHeaderContains('content-type', 'application/json')
        .expectJsonLength(0);
});

it('Get booking ID - empty firstname header', async () => {
    await pactum.spec()
        .get(endpoints.booking)
        .withQueryParams('firstname', "")
        .expectStatus(200)
        .expectHeaderContains('content-type', 'application/json')
        .expectJsonLength(0);
});

it('Get booking ID - empty lastname header', async () => {
    await pactum.spec()
        .get(endpoints.booking)
        .withQueryParams('lastname', "")
        .expectStatus(200)
        .expectHeaderContains('content-type', 'application/json')
        .expectJsonLength(0);
});

it('Get booking ID - empty checkin date header', async () => {
    await pactum.spec()
        .get(endpoints.booking)
        .withQueryParams('checkin', "")
        .expectStatus(200)
        .expectHeaderContains('content-type', 'application/json')
        .expectJsonLength(0);
});

it('Get booking ID - empty checkout date header', async () => {
    await pactum.spec()
        .get(endpoints.booking)
        .withQueryParams('checkout', "")
        .expectStatus(200)
        .expectHeaderContains('content-type', 'application/json')
        .expectJsonLength(0);
});
