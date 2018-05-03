'use strict';


var tfrApp = angular.module('spTransfer', 
		['ui.bootstrap', 
		 'spTransfer.controllers',
		 'spTransfer.services'
]);

tfrApp.constant("CONSTANTS", {
    saveTransfer: "/transfer/saveTransfer"
});
