var app = angular.module("TeamCreate", []);
app.controller("TeamCreateController", function($scope, $http) {

	$scope.teamForm = {
		id: 0,
		name: "",
		transactionCommission: 0,
		balance: 0,
		country: ""
	};

	$scope.countrys = [];

	_refreshTeamData();

	$scope.createTeam = function() {


		method = "POST";
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

	function _refreshTeamData() {
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

		$scope.teamForm.id = 0;
		$scope.teamForm.name = "";
		$scope.teamForm.transactionCommission = 0;
		$scope.teamForm.balance = 0;
		$scope.teamForm.country = "";

	};
});