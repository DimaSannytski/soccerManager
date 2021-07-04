var app = angular.module("TeamProfile", []);
app.controller("TeamController", function($scope, $http) {


	$scope.team = {};
	$scope.players = [];
	_refreshTeamData();

	function _refreshTeamData() {
		var url = '/player/team/' + getId("id");
		var urlTeam = '/team/' + getId("id");

		$http({
			method: 'GET',
			url: url
		}).then(
			function(res) { // success
				$scope.players = res.data;

			},
			function(res) { // error

				console.log("Error: " + res.status + " : " + res.data);
				window.location.href = "/error";
			}
		);
		var url = '/player/team/' + getId("id");

		$http({
			method: 'GET',
			url: urlTeam
		}).then(
			function(res) { // success
				$scope.team = res.data;

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

	$scope.openPlayerPage = function(player) {
		window.location.href = "/player?id=" + player.id;
	};

	$scope.deleteTeam = function() {
		$http({
			method: 'DELETE',
			url: '/team/' + $scope.team.id
		}).then(_success, _error);
	};

	$scope.editTeam = function() {
		window.location.href = "/edit/team?id=" + $scope.team.id;
	};
	$scope.trasnfer = function(player) {

		window.location.href = "/transfer?id=" + player.id;
	};
	function _success(res) {
		window.location.href = "/teams";
	}

	function _error(res) {
		var data = res.data;
		var status = res.status;
		alert("Error: " + status + ":" + data);
	}
});