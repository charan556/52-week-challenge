'use strict';

angular.module('myApp').factory('TwitterService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/UIDemo/twitter/';

    var factory = {
    		createTwitterAnalysis: createTwitterAnalysis,
    		fetchAllApps: fetchAllApps
    };

    return factory;

    function fetchAllApps() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI+"list")
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
   

    function createTwitterAnalysis(twitterKeyWord) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI+"create", twitterKeyWord)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
   
}]);
