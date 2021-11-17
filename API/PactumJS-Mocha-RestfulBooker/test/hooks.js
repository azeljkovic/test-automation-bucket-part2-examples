const { request } = require('pactum');
const baseURL = 'http://localhost:3001';

exports.mochaHooks = {
    async beforeAll(done) {
        request.setBaseUrl(baseURL);

        done();
    }
};

