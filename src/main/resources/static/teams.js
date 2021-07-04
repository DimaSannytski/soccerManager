var app = angular.module("TeamList", []);
app.controller("TeamsController", function($scope, $http) {

	$scope.teams = [];

	_refreshTeamData();

	function _refreshTeamData() {
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
	$scope.openTeamPage = function(team) {
		window.location.href = "/team?id=" + team.id;
	};

});