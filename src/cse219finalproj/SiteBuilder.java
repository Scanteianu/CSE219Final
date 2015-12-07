/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse219finalproj;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ImageComp;
import model.Layout;
import model.Page;
import model.PageComponent;
import model.SSComp;
import model.Site;
import model.VideoComp;

/**
 *
 * @author Dan
 */
public class SiteBuilder {
    public static void BuildSite(Site site)throws IOException{
        String siteName=site.getName();
        
        site.setName(site.getName().replaceAll(" ", "-"));
        if(site.getName().contains("."))
            site.setName(site.getName().substring(0,site.getName().indexOf(".")));
        if(site.getName().isEmpty())
            site.setName("Untitled");
            
        namePieces(site);
        moveStaticFiles(site);
        makeHTML(site);
        copyMedia(site);
        makeJS(site);
        
        
        
        site.setName(siteName);
    }
    private static void namePieces(Site site){
        for(Page p: site.getPages()){
            p.setName(p.getTitle().replaceAll(" ","-"));
            for(int i =0; i<p.getComponents().size(); i++){
                p.getComponents().get(i).setName("component"+i);
            }
        }
    }
    private static void moveStaticFiles(Site site) throws IOException{
        File folder=new File("ExportedSites/"+site.getName());
        if(folder.exists())
            deleteFolder(folder);
        folder.mkdir();
        new File("ExportedSites/"+site.getName()+"/css").mkdir();
        for(File f: new File("site-base/css").listFiles()){
                Files.copy(f.toPath(),new File("ExportedSites/"+site.getName()+"/css/"+f.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
        new File("ExportedSites/"+site.getName()+"/ico").mkdir();
        for(File f: new File("site-base/ico").listFiles()){
                Files.copy(f.toPath(),new File("ExportedSites/"+site.getName()+"/ico/"+f.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
        new File("ExportedSites/"+site.getName()+"/js").mkdir();
        new File("ExportedSites/"+site.getName()+"/media").mkdir();
        
        
    }
    private static void copyMedia(Site site) throws IOException{
        for(Page p: site.getPages()){
            if(!new File("ExportedSites/"+site.getName()+"/media/"+p.getBannerFilename()).exists())
                Files.copy(new File(p.getBannerFilePath()).toPath(),new File("ExportedSites/"+site.getName()+"/media/"+p.getBannerFilename()).toPath(), StandardCopyOption.REPLACE_EXISTING);
                       
            for(PageComponent pc:p.getComponents()){
                try{
                    switch(pc.getType()){
                        case IMAGE:
                            //DebugPrint.println("Copy: "+((ImageComp)pc).getFileLocation());
                            if(!new File("ExportedSites/"+site.getName()+"/media/"+((ImageComp)pc).getFileName()).exists())
                                Files.copy(new File(((ImageComp)pc).getFileLocation()).toPath(),new File("ExportedSites/"+site.getName()+"/media/"+((ImageComp)pc).getFileName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
                            break;
                        case VIDEO:
                            if(!new File("ExportedSites/"+site.getName()+"/media/"+((VideoComp)pc).getFileName()).exists())
                            Files.copy(new File(((VideoComp)pc).getFileLocation()).toPath(),new File("ExportedSites/"+site.getName()+"/media/"+((VideoComp)pc).getFileName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
                            break;
                        case SLIDESHOW:
                            for(ImageComp ic:((SSComp)pc).getImages())
                                if(!new File("ExportedSites/"+site.getName()+"/media/"+ic.getFileName()).exists())
                                Files.copy(new File(ic.getFileLocation()).toPath(),new File("ExportedSites/"+site.getName()+"/media/"+ic.getFileName()).toPath(), StandardCopyOption.REPLACE_EXISTING);

                            break;
                        default:
                            break;
                    }
                }
                catch(NullPointerException e){
                    DebugPrint.println(e.getStackTrace().toString());
                }
                catch(IOException e2){
                    
                }
                finally{}
            }
        }
    }
   private static void makeJS(Site site)throws IOException{
        for(Page p:site.getPages()){
            String js="";
            String components="var components=[";
            js+=site.partialHTML()+"\n";
            js+=p.partialHTML()+"\n";
            for(PageComponent c:p.getComponents()){
                if(c.toHTML()!=null)
                {
                    js+=c.toHTML()+"\n";
                    components+=c.getName()+",";
                }
            }
            components+="footer];\n";
            js+=components;
            //DebugPrint.println(js);
            //DebugPrint.println("---------------------------");
            List std=Files.readAllLines(new File("site-base/js/jsbase.js").toPath());
            for(int i=0; i<std.size(); i++){
                js+=std.get(i)+"\n";
            }
            File pageHtml=new File("ExportedSites/"+site.getName()+"/js/"+p.getName()+".js");
            //DebugPrint.println(js);
            try (PrintWriter writer = new PrintWriter(pageHtml, "UTF-8")) {
                writer.println(js);
            }
            
        }
    }
    private static void makeHTML(Site site){
        
        for(Page p: site.getPages()){
            PrintWriter writer=null;
            try {
                String html=" <html>\n<head>\n<title>"+p.getTitle()+"</title>\n<meta charset=\"UTF-8\">\n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n";
                switch(site.getColor()){
                    case BLUE_WHITE:
                        html+="<link rel=\"stylesheet\" href=\"css/bluewhite.css\">";
                        break;
                    case PURPLE_YELLOW:
                        html+="<link rel=\"stylesheet\" href=\"css/purpleyellow.css\">";
                        break;
                    case GRAY_BLACK:
                        html+="<link rel=\"stylesheet\" href=\"css/grayblack.css\">";
                        break;
                    case YELLOW_BLACK:
                        html+="<link rel=\"stylesheet\" href=\"css/yellowblack.css\">";
                        break;
                    case BLACK_RED:
                        html+="<link rel=\"stylesheet\" href=\"css/blackred.css\">";
                        break;
                }   html+="<link rel=\"stylesheet\" href=\"css/"+site.getFont().getName().toLowerCase()+".css\">";
                if(site.getLayout()==Layout.SIDE_NO_BANNER||site.getLayout()==Layout.TOP_NO_BANNER)
                    html+="<link rel=\"stylesheet\" href=\"css/nobanner.css\">";
                else
                    html+="<link rel=\"stylesheet\" href=\"css/withbanner.css\">";
                html+="</head>\n<body>\n<div id=\"main-node\"></div>";
                html+="<script src=\"js/"+p.getName()+".js\"></script>";
                html+="</body>\n</html>";
                File pageHtml=new File("ExportedSites/"+site.getName()+"/"+p.getName()+".html");
                writer = new PrintWriter(pageHtml, "UTF-8");
                writer.println(html);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(SiteBuilder.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(SiteBuilder.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                writer.close();
            }
        
        }
    }
    private static void deleteFolder(File folder) {
    File[] files = folder.listFiles();
    if(files!=null) { 
        for(File f: files) {
            if(f.isDirectory()) {
                deleteFolder(f);
            } else {
                f.delete();
            }
        }
    }
    folder.delete();
    DebugPrint.println("Deleted "+folder.getAbsolutePath());
}
}
