/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws.a.takehome1;

import java.io.IOException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author mladi
 */

@Controller

public class appController {
    @RequestMapping("/viewpage")
    public String viewpage(
            @RequestParam(value = "name") String nama,
            @RequestParam(value = "location") String lokasi,
            @RequestParam(value = "imge") MultipartFile gambar,
            Model model
    ) throws IOException{        
        byte[] img = gambar.getBytes();
        String bImage = Base64.encodeBase64String(img);
        String imglink= "data:image/png;base64,".concat(bImage);
        model.addAttribute("nm", nama);
        model.addAttribute("lcn", lokasi);
        model.addAttribute("imgs", imglink);
        
        return "viewpage";
    }
    
}
