package com.allali.minIO.controller;

import com.allali.minIO.service.MinIOService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

public class FileController {
    @Autowired
    private final MinIOService minioService;
    public FileController(MinIOService minioService) {
        this.minioService = minioService;
    }

    @GetMapping("/")
    public String listFiles(Model model) {
        model.addAttribute("files", minioService.listFiles());
        return "upload";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file,
                             RedirectAttributes redirectAttributes) {
        try {
            String filename = minioService.uploadFile(file);
            redirectAttributes.addFlashAttribute("message",
                    "File uploaded successfully: " + filename);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error",
                    "Error uploading file: " + e.getMessage());
        }
        return "redirect:/";
    }
}
