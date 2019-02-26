var app = require('express')();
var http = require('http').Server(app);
var io = require('socket.io')(http);
var mysql = require('mysql');
var tampon= 100;

/// connection mysql
var con = mysql.createConnection({
  host: "localhost",
  user: "root",
  password:"",
  database:'dbwiatalk'
})

var msg =  new Object() ;
  msg.transmitter =  "default";
  msg.receiver    =  "default" ;
  msg.message     =  "default";



app.get('/',function(req,res){
    res.sendFile(__dirname+'/index.html');
})


/////////////////////////////////////////////////////// connection to the database //////////////////////////////////////////////////

con.connect(function(error){
  if (!! error){
    console.log('Login error to the database');
  }else {
    console.log('connected to the database');
  }
});
/////////////////////////////////////////////////////// user login /////////////////////////////////////////////////////
io.sockets.on('connection',function(socket){
    console.log('one user connected '+socket.id);
///////////////////////////////////////////////affirmation de la connexion/////////////////////////////
var connectEtablie= new Object();
connectEtablie.info ="ok";
socket.emit("affirmeConnection",connectEtablie);

//////////////////////////////////////////////////////////////////ADD CONTECT AT THE USER
/*
this methods find contacts and send these contacts from the user

*/
getResultContact(socket,con);

///////////////////////////////////////////////////////listening  and emit event
// gestion du chat message
    socket.on('messageChat',function(data){
      console.log("MESSAGE de : "+data.transmitter+"   vers   "+data.receiver +"  est  "+data.message);
   
    var transmitter = data.transmitter;                                         // on recupere le nom du transmetteur 
   var receiver    = data.receiver;                                              // ---  du receveur
   var Tmessage    = data.message;                                                // -----le message
   msg = createJsonMessage(transmitter,receiver,Tmessage);         
   ManagerMsg(msg,socket);  
    io.sockets.emit('messageChatServer',msg);
    console.log("Receiver de MSG = "+msg.receiver);

   // console.log("message send ");
   // console.log(msg.message);


  })

////////////////////////////////////////////////////create User

socket.on("createUser",function(data){

  var pseudo  = data.pseudo;
  var pwd     = data.pwd;
  var tel     = data.tel;
  var name_user = data.name_user;
  var email = data.email;
  var photo_profil= data.photo_profil;
  var actu_profil= data.actu_profil;

//on verifie si l' utilisateur existe deja
console.log("on est a l interieur de .on(createUser)");
con.query('SELECT *FROM user WHERE tel =?',[tel],function (error,results,fields) {
  if (error)throw error;
  if (results.length>0){
    if(results){
      var obj= results;
    console.log(obj[0].tel);}}

    else {
        var user  = {pseudo: pseudo, pwd: pwd,tel:tel,name_user:name_user,photo_profil:photo_profil,actu_profil:actu_profil,email:email};
      try{
       var query = con.query('INSERT INTO user SET ?', user, function (error, results, fields) {
        if (error) throw error;
       })
      console.log(query.sql);
      var ack="ACK";
      ackServerToClient(socket,ack);
      }catch(err){
        console.log("insertion error in the database");
      }


  }
} );
})







socket.on('disconnect',function(){
    console.log('one user disconnected '+socket.id);
})




} )



//////////////////////////////////////////////////    return the various contacts of the research //////////////////////////////////
/*
socket : variable socket which running
con: variable connection database is running

*/
function  getResultContact(socket, con) {
console.log("getResultContact running");
socket.on("findContact",function(obj){
  var name =  obj.name;
  var pseudo   =  obj.pseudo ;
  var tel    =  obj.tel;
  con.query('SELECT DISTINCT *FROM user WHERE tel =? OR name_user=? OR pseudo=?' ,[tel,name,pseudo],function (error,results,fields) {
    if (error) throw error;
    console.log(" seach contacts sucess");
    var ResultSeach= new Object();
    ResultSeach.table=results;
    console.log(ResultSeach);



    socket.emit("getResultSeach",ResultSeach);


});
})
}

////////////////////////////////////////////////////////////////////creation du tampon de message /////////////////////////////////////
/*
this method send a  integer between Min and Max
*/
function getRandomInt(min, max) {
 var min = Math.ceil(min);
 var max = Math.floor(max);
  var tmp = Math.floor(Math.random() * (max - min +1)) + min;
  if(tmp== tampon){  // on compare le nouveau tampon et l' ancien
    tampon= 100;
  } else tampon=tmp;
  return tampon;
}


//////////////////////////////////////////////////////////   message creation /////////////////////////////////////////////////////////
// creation du message
function createJsonMessage(transmitter,receiver,Tmessage){
  var tmp= new Object() ;

  tmp.transmitter =  transmitter;
  tmp.receiver    =  receiver ;
  tmp.message     =  Tmessage;
  tmp.tampon      = getRandomInt(1,50);
  return tmp;
}

/////////////////////////////////////////////////// ManagerMsg   ///////////////////////////////////////
// cette methode gere le message recu
function ManagerMsg(msg,socket){
/*
on a plusieurs cas de figures:
- on demande au client de garder le message localement car la BD est indispo
-       on sauvegarde le dans la BD si cette derniere est dispo 
        ensuite on envoi le message à l interlocuteur
*/
var t=0;

var heure_envoi  =  "invalid";
var emetteur     =  msg.transmitter;
var recepteur    =  msg.receiver;
var text_msg     =  msg.message;
var discussion   =  "invalid";
var accuse       =  "invalid";


var msg_to_BD  = {heure_envoi: heure_envoi, emetteur: emetteur,recepteur:recepteur,text_msg:text_msg,discussion:discussion,accuse:accuse};

try{
  var query = con.query('INSERT INTO msg SET ?', msg_to_BD, function (error, results, fields) {
   if (error) throw error;
  })
 console.log(query.sql);
 var ack= "sucess_insert_message_to_BD"
 ackServerToClient(socket,ack);
 }catch(err){
   console.log("insertion error in the database");
   t=1;
 }

if(t==1){
// gerer l erreur
}
console.log("on emet le message vers "); console.log(msg.receiver);

//socket.emit('messageChat',msg);// on envoi le message
  
}

//////////////////////////////////////////////////ack of receipt///////////////////////
//accuse de recpetion du client
function ackServerToClient( socket,ack){
  var info =  new Object() ;
    info.transmitter =  "server";
    info.receiver    =  "client" ;
    info.message     =  ack;

  socket.emit('ackServerToClient',info);
}


////////////////////////////////////////////////////////////////////////////////////////////////////////////
//  port d'ecoute

http.listen(3000,function(){
    console.log('server listening on port 3000');
})
