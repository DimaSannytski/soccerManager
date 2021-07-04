var app = angular.module("PlayerEdit", []);
app.controller("PlayerEditController", function($scope, $http) {

	$scope.playerForm = {};

	$scope.playerStyles = [];
	$scope.countrys = [];

	_refreshPlayerData();


	$scope.editPlayer = function() {
		$scope.playerForm.birthdayMs = $scope.playerForm.birthday.getTime();
		$scope.playerForm.startWorkFromMs = $scope.playerForm.startWorkFrom.getTime();
		method = "PUT";
		url = '/player';
		$http({
			method: method,
			url: url,
			data: angular.toJson($scope.playerForm),
			headers: {
				'Content-Type': 'application/json'
			}
		}).then(_success, _error);
	};


	function _refreshPlayerData() {
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

		$http({
			method: 'GET',
			url: '/getplayerstyles'
		}).then(
			function(res) { // success
				$scope.playerStyles = res.data;

			},
			function(res) { // error
				console.log("Error: " + res.status + " : " + res.data);
			}
		);

		var url = '/player/' + getId("id");

		$http({
			method: 'GET',
			url: url
		}).then(
			function(res) { // success
				$scope.playerForm = res.data;
				$scope.playerForm.birthday = new Date($scope.playerForm.birthdayMs);
				$scope.playerForm.startWorkFrom = new Date($scope.playerForm.startWorkFromMs);
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
		window.location.href = "/player?id=" + $scope.playerForm.id;
	}

	function getId(name) {
		var s = window.location.search;
		s = s.match(new RegExp(name + '=([^&=]+)'));
		return s ? s[1] : false;
	}
});