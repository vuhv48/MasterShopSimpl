package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.domain.User;
import com.mycompany.myapp.security.SecurityUtils;
import com.mycompany.myapp.service.IPictureService;
import com.mycompany.myapp.service.IProductService;
import com.mycompany.myapp.service.UserService;
import com.mycompany.myapp.service.dto.ProductDTO;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
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

    @RequestMapping(
        value = "products/new",
        consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE },
        method = RequestMethod.POST
    )
    public ProductDTO addNew(
        ProductDTO productDTO,
        HttpSession session,
        @RequestParam(value = "file", required = false) MultipartFile file
    ) {
        if (file != null && !file.isEmpty()) {
            System.out.println("upload Imaage");
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
}
