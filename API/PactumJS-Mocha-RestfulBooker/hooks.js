const { request } = require('pactum');

exports.mochaHooks = {
    beforeAll(done) {
        request.setBaseUrl('http://localhost:3001');
        done();
    }
};
