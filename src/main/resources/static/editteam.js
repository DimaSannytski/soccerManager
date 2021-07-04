var app = angular.module("TeamEdit", []);
app.controller("TeamEditController", function($scope, $http) {

	$scope.teamForm = {};
	$scope.countrys = [];

	_refreshData();


	$scope.editTeam = function() {


		method = "PUT";
		url = '/team';
		$http({
			method: method,
			url: url,
			data: angular.toJson($scope.teamForm),
			headers: {
				'Content-Type': 'application/json'
			}
		}).then(_success, _error);
	};



	function _refreshData() {
		$http({
			method: 'GET',
			url: '/getcountrys'
		}).then(
			function(res) { // success
				$scope.countrys = res.data;

			},
			function(res) { // error
				console.log("Error: " + res.status + " : " + res.data);
			}
		);


		var url = '/team/' + getId("id");

		$http({
			method: 'GET',
			url: url
		}).then(
			function(res) { // success
				$scope.teamForm = res.data;

			},
			function(res) { // error
				console.log("Error: " + res.status + " : " + res.data);
				window.location.href = "/error";
			}
		);



	}

	function _error(res) {
		var data = res.data;
		var status = res.status;
		var header = res.header;
		var config = res.config;
		alert("Error: " + status + ":" + data + ": " + header + ": " + config);

	}
	function _success(res) {
		window.location.href = "/team?id=" + $scope.teamForm.id;
	}

	function getId(name) {
		var s = window.location.search;
		s = s.match(new RegExp(name + '=([^&=]+)'));
		return s ? s[1] : false;
	}
});