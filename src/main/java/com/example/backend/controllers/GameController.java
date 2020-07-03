package com.example.backend.controllers;

/**  aws
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.textract.AmazonTextract;
import com.amazonaws.services.textract.AmazonTextractClientBuilder;
import com.amazonaws.services.textract.model.Block;
import com.amazonaws.services.textract.model.BoundingBox;
import com.amazonaws.services.textract.model.DetectDocumentTextRequest;
import com.amazonaws.services.textract.model.DetectDocumentTextResult;
import com.amazonaws.services.textract.model.Document;
import com.amazonaws.services.textract.model.S3Object;
import com.amazonaws.services.textract.model.Point;
import com.amazonaws.services.textract.model.Relationship;

import org.springframework.web.multipart.MultipartFile;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.awt.Graphics2D;
import net.sourceforge.tess4j.*; 
import java.awt.image.*; 
import java.io.*; 
import javax.imageio.ImageIO; 
*///////////////////////////////////////////////////

import com.example.backend.models.CreateGameWrapper;
import com.example.backend.models.Game;
import com.example.backend.models.PlayedGame;
import com.example.backend.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class GameController {

    @Autowired
    GameService service;

    @PostMapping("api/games")
    public Game createGame(@RequestBody CreateGameWrapper creategame) {
        if (service.checkPlayersAndRoles(creategame.getPlayers(), creategame.getRoles(), creategame.getMvp(),
                creategame.getLvp()))
            return service.createGame(creategame.getGame(), creategame.getPlayers(), creategame.getRoles(),
                    creategame.getMvp(), creategame.getLvp());
        return null;
    }

    @GetMapping("api/games/{gid}/players")
    public Iterable<PlayedGame> findPlayersForGame(@PathVariable("gid") int gid) {
        return service.getPlayers(gid);
    }

    @GetMapping("api/games")
    public Iterable<Game> findAllGames() {
        return service.findAllGames();
    }

    @GetMapping("api/games/{gid}")
    public Game findGame(@PathVariable("gid") int gid) {
        return service.findGame(gid);
    }

    /** 
    @PostMapping("/gameimage")
    public ResponseEntity<?> getImage(@RequestParam("file") MultipartFile file)
            throws TesseractException {

        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please select a file to upload.");
        }
    
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get("//images/placeholder.jpg");
            Files.write(path, bytes);
            File convertedFile = convert(file);

            Tesseract tesseract = new Tesseract();
            tesseract.setDatapath("//tessdata");
            String text = tesseract.doOCR(convertedFile);
            System.out.println(text);

            return ResponseEntity.status(HttpStatus.OK).body("File uploaded succesfully");
    
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File could not be uploaded");
        }
    }


    public static File convert(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
    */
    
}
/** 

class Run {
	public static void main(String[] args) throws TesseractException {


        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("//users//ethangriffee//MyWebsite//backend//src//main//java//com//example//backend//tessdata");
        tesseract.setPageSegMode(1);
        tesseract.setOcrEngineMode(2);
        tesseract.setTessVariable("tessedit_write_images", "T");
        tesseract.setTessVariable("load_system_dawg", "F");
        tesseract.setTessVariable("load_freq_dawg", "F");
        tesseract.setTessVariable("user_defined_dpi", "1000");
        String text = tesseract.doOCR(new File("//users//ethangriffee//MyWebsite//backend//src//main//java//com//example//backend//images//test3.png"));
        System.out.println(text);
	}
}


class ScanedImage { 
  
    public static void
    processImg(BufferedImage ipimage, 
               float scaleFactor, 
               float offset) 
        throws IOException, TesseractException 
    { 
        // Making an empty image buffer 
        // to store image later 
        // ipimage is an image buffer 
        // of input image 
        BufferedImage opimage 
            = new BufferedImage(1050, 
                                1024, 
                                ipimage.getType()); 
  
        // creating a 2D platform 
        // on the buffer image 
        // for drawing the new image 
        Graphics2D graphic 
            = opimage.createGraphics(); 
  
        // drawing new image starting from 0 0 
        // of size 1050 x 1024 (zoomed images) 
        // null is the ImageObserver class object 
        graphic.drawImage(ipimage, 0, 0, 
                          1050, 1024, null); 
        graphic.dispose(); 
  
        // rescale OP object 
        // for gray scaling images 
        RescaleOp rescale 
            = new RescaleOp(scaleFactor, offset, null); 
  
        // performing scaling 
        // and writing on a .png file 
        BufferedImage fopimage 
            = rescale.filter(opimage, null); 
        ImageIO 
            .write(fopimage, 
                   "png", 
                   new File("//users//ethangriffee//MyWebsite//backend//src//main//java//com//example//backend//images//output.png")); 
  
        // Instantiating the Tesseract class 
        // which is used to perform OCR 
        Tesseract it = new Tesseract(); 
  
        it.setDatapath("//users//ethangriffee//MyWebsite//backend//src//main//java//com//example//backend//tessdata"); 
  
        // doing OCR on the image 
        // and storing result in string str 
        it.setPageSegMode(1);
        it.setLanguage("eng");
        it.setOcrEngineMode(2);
        String str = it.doOCR(fopimage); 
        System.out.println(str); 
    } 
  
    public static void main(String args[]) throws Exception 
    { 
        File f 
            = new File( 
                "//users//ethangriffee//MyWebsite//backend//src//main//java//com//example//backend//images//game1.png"); 
  
        BufferedImage ipimage = ImageIO.read(f); 
  
        // getting RGB content of the whole image file 
        double d 
            = ipimage 
                  .getRGB(ipimage.getTileWidth() / 2, 
                          ipimage.getTileHeight() / 2); 
  
        // comparing the values 
        // and setting new scaling values 
        // that are later on used by RescaleOP 
        if (d >= -1.4211511E7 && d < -7254228) { 
            processImg(ipimage, 3f, -10f); 
        } 
        else if (d >= -7254228 && d < -2171170) { 
            processImg(ipimage, 1.455f, -47f); 
        } 
        else if (d >= -2171170 && d < -1907998) { 
            processImg(ipimage, 1.35f, -10f); 
        } 
        else if (d >= -1907998 && d < -257) { 
            processImg(ipimage, 1.19f, 0.5f); 
        } 
        else if (d >= -257 && d < -1) { 
            processImg(ipimage, 1f, 0.5f); 
        } 
        else if (d >= -1 && d < 2) { 
            processImg(ipimage, 1f, 0.35f); 
        } 
    } 
} 

class DetectText {

   public static void main(String[] args) throws Exception {
      
  
        String photo = "gameresult.png";
        String bucket = "peanutland";
        // The S3 bucket and document
        
        // Call DetectDocumentText
        EndpointConfiguration endpoint = new EndpointConfiguration(
                "https://textract.us-east-2.amazonaws.com", "us-east-2");
        AmazonTextract client = AmazonTextractClientBuilder.standard()
                .withEndpointConfiguration(endpoint).build();


        DetectDocumentTextRequest request = new DetectDocumentTextRequest()
            .withDocument(new Document().withS3Object(new S3Object().withName(photo).withBucket(bucket)));

        DetectDocumentTextResult result = client.detectDocumentText(request);
        List<Block> lob = result.getBlocks();
        boolean next_is_user = false;
        for (int x = 0; x < lob.size(); x++) {
            String text = lob.get(x).getText();
            if (text.contains())
        }
   }
}
*/