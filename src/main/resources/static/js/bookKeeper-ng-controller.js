angular.module('BookKeeperApp', [])
    .controller('BookKeeperController', function($scope,$http) {
        console.log("Angular up and running...");

        $scope.name = user.userName;

        $scope.getAllBooks = function(){
            console.log("Fetching data...");
            $http.get("http://localhost:8080/getAllBooks.json")
                .then(
                function success(response){
                    console.log(response.data);
                    console.log("Adding data to scope...");
                    $scope.books = response.data;
                },
                function error(response){
                    console.log("Error retrieving data");
                });
        };

        $scope.addBook = function(){
            console.log("About to add book: " + JSON.stringify($scope.newBookItem));
            $http.post("/addBook.json", $scope.newBookItem)
                .then(
                    function success(response){
                        console.log(response.data);
                        console.log("Adding data to scope...");
                        $scope.books = response.data;
                    },
                    function error(response){
                        console.log("Error retrieving data");
                    });
        };
    });