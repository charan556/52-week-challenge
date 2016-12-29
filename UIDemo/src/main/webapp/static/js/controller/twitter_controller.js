'use strict';

angular.module('myApp').controller('TwitterController', ['$scope', 'TwitterService', function($scope, TwitterService) {
    var self = this;
    self.app={id:null,appName:'',start:false};
    self.apps=[];
    self.submit = submit;

    
    fetchAllApps();

    function fetchAllApps(){
        TwitterService.fetchAllApps()
            .then(
            function(d) {
                self.apps = d;
            },
            function(errResponse){
            }
        );
    }
    
    function submit() {
    	console.log("I am called....")
        if(self.app.id===null){
            TwitterService.createTwitterAnalysis(self.app)
            .then(
            fetchAllApps,
            function(errResponse){
                console.error('Error while creating app');
            }
        );
        }
    }

    /*function createUser(user){
        UserService.createUser(user)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Error while creating User');
            }
        );
    }

    function updateUser(user, id){
        UserService.updateUser(user, id)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Error while updating User');
            }
        );
    }

    function deleteUser(id){
        UserService.deleteUser(id)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Error while deleting User');
            }
        );
    }
    function edit(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.users.length; i++){
            if(self.users[i].id === id) {
                self.user = angular.copy(self.users[i]);
                break;
            }
        }
    }

    function remove(id){
        console.log('id to be deleted', id);
        if(self.user.id === id) {//clean form if the user to be deleted is shown there.
            reset();
        }
        deleteUser(id);
    }


    function reset(){
        self.user={id:null,username:'',address:'',email:''};
        $scope.myForm.$setPristine(); //reset Form
    }
*/
}]);
