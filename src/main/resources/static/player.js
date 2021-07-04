var app = angular.module("PlayerProfile", []);
app.controller("PlayerController", function($scope, $http) {

	$scope.player = {};
	_refreshPlayerData();

	function _refreshPlayerData() {
		var url = '/player/' + getId("id");

		$http({
			method: 'GET',
			url: url
		}).then(
			function(res) { // success
				$scope.player = res.data;
				$scope.player.birthday = new Date($scope.player.birthdayMs).toLocaleDateString();
				$scope.player.startWorkFrom = new Date($scope.player.startWorkFromMs).toLocaleDateString();

			},
			function(res) { // error
				console.log("Error: " + res.status + " : " + res.data);
				window.location.href = "/error";
			}
		);
	}
	function getId(name) {
		var s = window.location.search;
		s = s.match(new RegExp(name + '=([^&=]+)'));
		return s ? s[1] : false;
	}
	$scope.openTeamPage = function(player) {
		window.location.href = "/team?id=" + $scope.player.teamId;
	};


	$scope.deletePlayer = function() {
		$http({
			method: 'DELETE',
			url: '/player/' + $scope.player.id
		}).then(_success, _error);
	};

	$scope.editPlayer = function() {
		window.location.href = "/edit/player?id=" + $scope.player.id;
	};
	$scope.trasnfer = function() {
		window.location.href = "/transfer?id=" + $scope.player.id;
	};

	function _success(res) {
		window.location.href = "/players";
	}

	function _error(res) {
		var data = res.data;
		var status = res.status;
		alert("Error: " + status + ":" + data);
	}


});