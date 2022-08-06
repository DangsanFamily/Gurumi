package io.gurumi.core.blocks.ui.dto;

import io.gurumi.core.blocks.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileController {
    @Autowired
    private FileService fileService;

    @GetMapping
    public String index(){
        return "upload";
    }
    @PostMapping("/upload")
    public String fileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes){}
        fileService.fileUpload(file);

        redirectAttributes.addFlashAttribute("message", "업로드 성공" + file.getOriginalFilename() + "!");

        return "redirect:/";

}
