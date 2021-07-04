var app = angular.module("TransferCreate", []);
app.controller("TransferCreateCreateController", function($scope, $http) {

	$scope.transferForm = {};

	$scope.teams = [];
	$scope.selectedTeam = {};
	_refreshData();

	$scope.createTransfer = function() {

		$scope.transferForm.teamToId = $scope.selectedTeam.id;

		method = "POST";
		url = '/transfer';
		$http({
			method: method,
			url: url,
			data: angular.toJson($scope.transferForm),
			headers: {
				'Content-Type': 'application/json'
			}
		}).then(_success, _error);
	};

	function _refreshData() {
		$http({
			method: 'GET',
			url: '/transfer/' + getId("id")
		}).then(
			function(res) { // success
				$scope.transferForm = res.data;
				

			},
			function(res) { // error
				console.log("Error: " + res.status + " : " + res.data);
			}
		);

		$http({
			method: 'GET',
			url: '/getteamsfortransfer/' + getId("id")
		}).then(
			function(res) { // success
				$scope.teams = res.data;
				$scope.selectedTeam = $scope.teams[0];
			},
			function(res) { // error
				console.log("Error: " + res.status + " : " + res.data);
			}
		);
	

	}
	function getId(name) {
		var s = window.location.search;
		s = s.match(new RegExp(name + '=([^&=]+)'));
		return s ? s[1] : false;
	}
	function _error(res) {
		var data = res.data;
		var status = res.status;

		alert("Error: " + status + ":" + data);
	}
	function _success(res) {
		window.location.href =  "/team?id=" + $scope.transferForm.teamToId;
	}

});