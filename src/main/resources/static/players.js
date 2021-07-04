var app = angular.module("PlayersList", []);
app.controller("PlayersController", function($scope, $http) {
	$scope.players = [];

	_refreshPlayerData();

	function _refreshPlayerData() {
		$http({
			method: 'GET',
			url: '/getall'
		}).then(
			function(res) { // success
				$scope.players = res.data;
			},
			function(res) { // error
				console.log("Error: " + res.status + " : " + res.data);
			}
		);
	}
	$scope.openPlayerPage = function(player) {

		window.location.href = "/player?id=" + player.id;
	};

});