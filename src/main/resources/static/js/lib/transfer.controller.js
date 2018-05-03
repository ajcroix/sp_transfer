'use strict';

var tfrCtl = angular.module('spTransfer.controllers', []);

tfrCtl.controller("TransferController", ["$scope", "TransferService", function ($scope, TransferService) {
	$scope.transfer = {
            fromAccount: null,
            toAccount: null,
            amount: null,
            purpose: null
        };
	
    $scope.saveTransfer = function () {
    	TransferService.saveTransfer($scope.transfer);
    	$scope.transfer = {
                fromAccount: null,
                toAccount: null,
                amount: null,
                purpose: null
            };
    };
}]);
