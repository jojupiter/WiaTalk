var app = require('express')();
var http = require('http').Server(app);
var io = require('socket.io')(http);
var mysql = require('mysql');


io.sockets.on('connection', function(socket){
console.log('one user connected'+socket.id);
socket.on("infoCall",function(data){
var nameUser;
var telUser;
nameUser= data.nameUser;
telUser= data.telUser;
} )


socket.on('disconnect',function(){
    console.log('one user disconnected '+socket.id);

} ) } )
http.listen(3000,function(){
    console.log('server listening on port 3001');
  } )
