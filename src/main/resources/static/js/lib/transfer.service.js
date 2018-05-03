'use strict';

angular.module('spTransfer.services', []).factory('TransferService', ["$http", "CONSTANTS", function ($http, CONSTANTS) {
	var service = {};
	service.saveTransfer = function(transfer) {
        return $http.post(CONSTANTS.saveTransfer, transfer);
    }
	return service;
}]);