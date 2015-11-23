/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
alert("Hello, friend");
var mainnode = document.getElementById('main-node');
var filenames = ["food.jpg","pedals.jpg", "rice.jpg", "lfant.jpg"];
var captions = ["manca-ti-as", "o galagie de zgomote", "un pilaf prematur", "un sot potrivit pentru ma-ta"];
var title="Some Title";
var index=1;
filename=filenames[index];
var mode=0;
var timeoutVar;
var terminate=0;
var iconame="play.png";
prev();

function setUpDocument(filename,titlename,caption){
    var innerH="";
    innerH+=("<h1 class=\"titlestyle\">"+titlename+"</h1><br>");
    innerH+=("<div class=\"central\">");
    innerH+=("<img src=\"img/"+filename+"\" class=\"main\">");
    innerH+=("</div>");
    innerH+=("<p class=\"captionstyle\">"+caption+"</p ><br>");
    innerH+=("<div class=\"central\">");
    innerH+=("<button class=\"directional\" id=\"prevButton\" onClick=\"prev()\"><img src=\"ico/left.png\"class=\"ico\"></button>");
    innerH+=("<button class=\"directional\" id=\"playButton\" onClick=\"play()\"><img src=\"ico/"+iconame+"\"class=\"ico\"></button>");
    innerH+=("<button  id=\"nextButton\" class=\"directional\" onClick=\"next()\"><img src=\"ico/right.png\"class=\"ico\"></button>")
    innerH+=("</div>");
    mainnode.innerHTML = innerH;
    
    
}
function next(){
    
    
    if(index<filenames.length-1){
       index=index+1;
    }
    else{
        terminate= -1;
        window.clearInterval(timeoutVar);
        iconame="play.png";
    }
    setUpDocument(filenames[index],title,captions[index]);
    if(index>=filenames.length-1){
        document.getElementById("nextButton").disabled=true;
    }
    if(index>0){
        document.getElementById("prevButton").disabled=false;
    }
    terminate= 0;
    
}
function prev(){
    
    index=index-1;
    setUpDocument(filenames[index],title,captions[index]);
    if(index<=0){
        document.getElementById("prevButton").disabled=true;
    }
    if(!(index>=filenames.length-1)){
        document.getElementById("nextButton").disabled=false;
    }
}
function play(){
    if(mode===0){
        mode=1;
        iconame="pause.png";
        setUpDocument(filenames[index],title,captions[index]);
        terminate=0;
        timeoutVar=window.setInterval(next,3000);
    }
    else{
        mode=0;
        window.clearInterval(timeoutVar);
        iconame="play.png";
        setUpDocument(filenames[index],title,captions[index]);
    }
}
