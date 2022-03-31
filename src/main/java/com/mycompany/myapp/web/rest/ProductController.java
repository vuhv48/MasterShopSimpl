package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.domain.User;
import com.mycompany.myapp.security.SecurityUtils;
import com.mycompany.myapp.service.IPictureService;
import com.mycompany.myapp.service.IProductService;
import com.mycompany.myapp.service.UserService;
import com.mycompany.myapp.service.dto.PictureDTO;
import com.mycompany.myapp.service.dto.ProductDTO;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class ProductController {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Autowired
    IProductService productService;

    @Autowired
    IPictureService pictureService;

    @Autowired
    UserService userService;

    @GetMapping("/products/test")
    public String findAllTest() {
        return "test controller findAllTest ok....";
    }

    @GetMapping("/products")
    public List<ProductDTO> findAll() {
        return productService.findAll();
    }

    @GetMapping("/products/{orderId}")
    public ProductDTO findById(@PathVariable Long orderId) {
        return productService.findById(orderId);
    }

    @RequestMapping(
        value = "products/new",
        consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE },
        method = RequestMethod.POST
    )
    public ProductDTO addNew(
        ProductDTO productDTO,
        HttpSession session,
        @RequestParam(value = "photo", required = false) MultipartFile photo
    ) {
        if (photo != null && !photo.isEmpty()) {
            System.out.println("upload Imaage");
            PictureDTO pictureDTO = new PictureDTO();
            Path path = Paths.get("uploads/");
            try {
                InputStream inputStream = photo.getInputStream();
                Files.copy(inputStream, path.resolve(photo.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
                pictureDTO.setUrl(photo.getOriginalFilename().toLowerCase());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //productDTO.setCreateTime(sdf.format(new Date()));
        User userCurrentLogin = userService.getUserWithAuthorities().get();
        if (userCurrentLogin != null) {
            productDTO.setUserId(userCurrentLogin.getId());
        }
        productDTO = productService.save(productDTO);
        System.out.println("ok ok 2000-10-10 00:00:00");
        return productDTO;
    }

    @RequestMapping(value = "/getimage/{picId}", method = RequestMethod.GET)
    public ResponseEntity<ByteArrayResource> getImage(@PathVariable("picId") Long picId) {
        if (!picId.equals("") || picId != null) {
            try {
                String photo = getUrlPicture(picId);
                System.out.println("=============>");
                System.out.println(photo);
                Path filename = Paths.get("uploads", photo);
                byte[] buffer = Files.readAllBytes(filename);
                ByteArrayResource byteArrayResource = new ByteArrayResource(buffer);
                return ResponseEntity
                    .ok()
                    .contentLength(buffer.length)
                    .contentType(MediaType.parseMediaType("image/png"))
                    .body(byteArrayResource);
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
        return ResponseEntity.badRequest().build();
    }

    private String getUrlPicture(Long picId) {
        return pictureService.findAll().stream().filter(o1 -> o1.getId().equals(picId)).findFirst().get().getUrl();
    }
}
