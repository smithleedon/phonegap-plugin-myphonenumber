var myphonenumber = {
    createEvent: function(mynumber, successCallback, errorCallback) {
        cordova.exec(
            successCallback, // success callback function
            errorCallback, // error callback function
            'MyPhoneNumber', // mapped to our native Java class called "CalendarPlugin"
            'getphonenumber', // with this action name
            [{                  // and this array of custom arguments to create our entry
                "mynumber": mynumber
               
            }]
        ); 
    }
}
module.exports = myphonenumber;