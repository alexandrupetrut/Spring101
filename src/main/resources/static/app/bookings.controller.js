(function () {
    'use strict';

    angular
        .module('app')
        .controller('BookingsController', BookingsController);

    BookingsController.$inject = ['$http'];

    function BookingsController($http) {
        var vm = this;

        vm.bookings = [];
        vm.getAll = getAll;
        vm.getAffordable = getAffordable;
        vm.deleteBooing = deleteBooking;

        init();

        function init() {
            getAll();
        }

        function getAll(){
            var url = "/bookings/all";
            var bookingsPromise = $http.get(url);
            bookingsPromise.then(function(response) {
                vm.bookings = response.data;
            })
        }

        function getAffordable() {
            var url = "/bookings/affordable/" + 100; // price for affordable
            var bookingsPromise = $http.get(url);
            bookingsPromise.then(function(response) {
                vm.bookings = response.data;
            })
        }

        function deleteBooking(id) {
            var url = "/bookings/delete/" + id;
            var bookingsPromise = $http.post(url);
            bookingsPromise.then(function(response) {
                vm.bookings = response.data;
            })
        }
    }
}) ();