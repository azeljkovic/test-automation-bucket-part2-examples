const request = require('supertest');
const expect = require('chai').expect;
const base_url = "http://localhost:3001";

describe('GET /user', function() {
    it('responds with json', function(done) {
        request(base_url)
            .get('/booking')
            .end(function(err, res){
                console.log(res.body);
                expect(res.statusCode).to.equal(200);
                expect(res.type).to.equal('application/json');
                expect(res.body).to.have.lengthOf(10);
                done();
            });


    });
});
