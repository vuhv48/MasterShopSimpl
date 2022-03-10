package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.IPictureService;
import com.mycompany.myapp.service.dto.PictureDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PictureController {

    @Autowired
    IPictureService pictureService;

    @GetMapping("/pictures")
    public List<PictureDTO> findAll() {
        return pictureService.findAll();
    }
}
