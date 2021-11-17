const { request } = require('pactum');
const axios = require("axios");
const baseURL = 'http://localhost:3001';

exports.mochaHooks = {
    async beforeAll(done) {
        request.setBaseUrl(baseURL);
        axios({
            method: 'post',
            url: baseURL + '/auth',
            data: {
                username: 'admin',
                password: 'password123'
            }
        })
            .then((response) => {
                global.token = response.data.token;
                console.log(global.token);
            }, (error) => {
                console.log(error);
            });

        done();
    }
};

