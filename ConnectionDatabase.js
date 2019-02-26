var express = require('express');
var mysql = require('mysql');
var connection = mysql.createConnection({
  host: "localhost",
  user: "root",
  password:"",
  database:'dbwiatalk'
})
connection.connect(function(error){
  if (!! error){
    console.log('Error');
  }else {
    console.log('connected');
  }
});
/*
app.get('/',function(req , resp){


})*/
//app.listen(1337);
