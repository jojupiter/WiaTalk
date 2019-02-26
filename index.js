var app = require('express')();
var http = require('http').Server(app);
var io = require('socket.io')(http);
var msg ={"msg": "hello  i am the server"};
var msge ={"msg": "hi  i am the server"};

app.get('/',function(req,res){
    res.sendFile(__dirname+'/index.html');
})
io.sockets.on('connection',function(socket){
    console.log('one user connected '+socket.id);
    io.sockets.emit('msg',msg);
    socket.emit('msg',msge);
    socket.emit('msg',msg);
    socket.on('message',function(data){
        var sockets = io.sockets.sockets;
        /*sockets.forEach(function(sock){
            if(sock.id != socket.id)
            {
                sock.emit('message',data);
            }
        })*/
        socket.broadcast.emit('message', data);
    })
    socket.on('disconnect',function(){
        console.log('one user disconnected '+socket.id);
    })
})



http.listen(3000,function(){
    console.log('server listening on port 3000');
})
