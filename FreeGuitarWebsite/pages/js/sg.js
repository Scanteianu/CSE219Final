/* 
 *Dan Scanteianu Webpage, License: none/sure
 */
//begin stuff printed to file by java program
var banner = "banner.jpg";

var title="SG";
var author="Dan Scanteianu";
//var navStyle="horizontal-below";
var navStyle="horizontal-above";
//var navStyle="vertical";
var pages=["home","strat","sg","hollow","classical", "bass"];
var pageNames=["Home","Fender Stratocaster", "Gibson SG", "Hollow Body Electric","Classical Guitar","Bass Guitar"];
//auto-generated objects for components
var whatisTitle=["text","heading","The Gibson SG"];
//html tag references to be inserted in gui.
var whatis=["text","paragraph","This is a totally badass guitar played by awesome people like Angus Young, Carlos Santana, Jerry Garcia, and Pete Townshend. Also, Derek Trucks and Duane Allman for slide."];
// first index is starting index, second index is id (must be unique), photo, caption, repeat
var pictures=["slideshow",0,"players","ay.jpg","Angus Young","cs.jpg","Carlos Santana","jg.jpg","Jerry Garcia","pt.jpg","Pete Townshend"];
var pictures2=["slideshow",0,"guitars2","tele1.jpg","Fender Telecaster Guitar","prs2.jpg","Multiple PRS guitars","lp.jpg","Gibson Les Paul Guitar, same as above"];
var pictures1title=["text","heading","Famous SG Musicians"];
var pictures2title=["text","heading","Guitar Slideshow 2:"];

//necessarily last, program defined.
var components=[whatisTitle,whatis, pictures1title, pictures];

//end stuff printed to file by java program







//needed globals
var innerH="";
var mainnode = document.getElementById('main-node');
var slideshows=[];
// start of code

makePage();
function makePage(){
    innerH="";
    if(navStyle=="horizontal-above"){
        makeNav();
        makeBanner();  
    }
    else{
        makeBanner();
        makeNav();
    }
    makeContent();
    mainnode.innerHTML=innerH;
    var slideshowslength=slideshows.length;
    for (var i = 0; i<slideshowslength; i++){
        loadSS(slideshows[i]);
    }
}
//complete, working
function makeNav(){
    
    var tableCode="";
    tableCode+="<div><table class=\"nav\"\n\" style=\"width:";
    if(navStyle=="vertical"){
            tableCode+="5%; height:70%; float:left;";
        }
    else{
        tableCode+="100%";
    }
    tableCode+="\"><tr>";
    var pageslength=pages.length;
    for (var i = 0; i<pageslength; i++)
    {
        tableCode+="<td><a class=\"nav\" href=\""+pages[i]+".html\">"+pageNames[i]+"</a></td>";
        //alert(pages[i]);
        if(navStyle=="vertical"){
            tableCode+="</tr><tr>";
        }
        //alert("loop again");
    }
    tableCode+="</tr></table></div>";
    innerH+=tableCode;
}
function makeBanner(){
    innerH+="<h1 class= \"banner\">"+title+"</h1>"+"<h2 class=\"banner\">"+author+"</h2>";
    innerH+=("<div class=\"banner\"><img src=\"media/"+banner+"\" class=\"banner\"></div>");
    
}
function initSS(data){
    return "<div id=\""+data[2]+"\"></div>";
}
function loadSS(data){
    var ssH="<img  src=\"media/"+data[3+2*data[1]]+"\" class=\"img\">";
    ssH+="<p class=\"caption\">"+data[3+2*data[1]+1]+"</p>"
    //alert("Loading:" + data[2]);
    var ssnode = document.getElementById(data[2]);
    ssH+=("<div class=\"ssbutton\">");
    ssH+=("<button class=\"directional\" id=\"prevButton\" onClick=\"prev(\'"+data[2]+"\')\"><img src=\"ico/left.png\"class=\"ico\"></button>");
    //ssH+=("<button class=\"directional\" id=\"playButton\" onClick=\"play(\""+data[2]+"\")\"><img src=\"ico/"+iconame+"\"class=\"ico\"></button>");
    ssH+=("<button  id=\"nextButton\" class=\"directional\" onClick=\"next(\'"+data[2]+"\')\"><img src=\"ico/right.png\"class=\"ico\"></button>")
    ssH+=("</div>");
    ssnode.innerHTML=ssH;
    
}
function makeImg(data){
    return ("<img  src=\"media/"+data[1]+"\" class=\"img\"><br>"+"<p class=\"caption\">"+data[2]+"</p>");
    
}
function ssFind(ssID){
    var slideshowslength=slideshows.length;
    for (var i = 0; i<slideshowslength; i++){
        if((slideshows[i])[2]==ssID)
            return slideshows[i];
    }
}
function next(slideshowID){
    //alert(slideshowID);
    slideshow=ssFind(slideshowID);
    if(slideshow[1]<(slideshow.length-3)/2-1)
        slideshow[1]++;
    loadSS(slideshow);
}
function prev(slideshowID){
    slideshow=ssFind(slideshowID);
    if(slideshow[1]>0)
        slideshow[1]--;
    loadSS(slideshow);
}
function play(slideshowID){
    
}
function makeVideo(data){
    
    
  
     return ("<video class=\"embedded\" controls><source src=\"media/"+data[1]+"\" type=\"video/mp4\"></video><br>"+"<p class=\"caption\">"+data[2]+"</p>");
    
}

function makeText(data){
    if(data[1]=="heading")
    {
        return "<p class=\"heading\"><b>"+data[2]+"</b></p>";
    }
    if(data[1]=="paragraph"){
        return "<p class=\"paragraph\">"+data[2]+"</p>";
    }
    if(data[1]=="list"){
        var listText="<p class=\"list\"><ul class=\"list\">";
        var datalength=data.length;
        for(var i =2; i<datalength; i++){
            listText+="<li>"+data[i]+"</li>";
        }
        listText+="</ul></p>";
        return listText;
    }
}
function makeContent(){
    var contentPane="<div class=\"content\">";
    //contentPane+="Hello, world!";
    
   
    var componentslength=components.length;
    for (var i = 0; i<componentslength; i++){
        if(((components[i])[0])=="text")
            contentPane+=makeText(components[i]);
        if(((components[i])[0])=="img")
            contentPane+=makeImg(components[i]);
        if(((components[i])[0])=="video")
            contentPane+=makeVideo(components[i]);
        if(((components[i])[0])=="slideshow"){
            contentPane+=initSS(components[i]);
            slideshows.push(components[i]);
        }
    }
    contentPane+="</div>";
    innerH+=contentPane;
    
}