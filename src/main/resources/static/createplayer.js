var app = angular.module("PlayerCreate", []);
app.controller("PlayerCreateController", function($scope, $http) {

	$scope.playerForm = {
		id: 0,
		name: "",
		surname: "",
		playerStyle: "",
		country: "",
		bitrhday: new Date(1900, 1, 1),
		startWorkFrom: new Date(2000, 1, 1),
		teamId: 0,
		teamName: ""
	};

	$scope.playerStyles = [];
	$scope.countrys = [];
	$scope.teams = [];
	$scope.selectedTeam = {};
	_refreshPlayerData();

	$scope.createPlayer = function() {
		$scope.playerForm.teamId = $scope.selectedTeam.id;
		$scope.playerForm.teamName = $scope.selectedTeam.name;
		$scope.playerForm.birthdayMs = $scope.playerForm.bitrhday.getTime();
		$scope.playerForm.startWorkFromMs = $scope.playerForm.startWorkFrom.getTime();
		method = "POST";
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
		$http({
			method: 'GET',
			url: '/getallteams'
		}).then(
			function(res) { // success
				$scope.teams = res.data;
			},
			function(res) { // error
				console.log("Error: " + res.status + " : " + res.data);
			}
		);

	}

	function _error(res) {
		var data = res.data;
		var status = res.status;

		alert("Error: " + status + ":" + data);
	}
	function _success(res) {
		_clearFormData();
	}
	function _clearFormData() {

		$scope.playerForm.id = 0;
		$scope.playerForm.name = "";
		$scope.playerForm.surname = "";
		$scope.playerForm.playerStyle = "";
		$scope.playerForm.country = "";
		$scope.playerForm.bitrhday = new Date(1900, 1, 1);
		$scope.playerForm.teamId = 0;
		$scope.playerForm.startWorkFrom = new Date(2000, 1, 1);
		$scope.playerForm.bitrhdayMs = 0;
		$scope.playerForm.startWorkFromMs = 0;
		$scope.playerForm.teamName = ""
	};
});