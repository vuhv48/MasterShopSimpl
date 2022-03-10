package com.mycompany.myapp.service;

import com.mycompany.myapp.service.dto.PictureDTO;
import java.util.List;

public interface IPictureService {
    PictureDTO save(PictureDTO pictureDTO);

    List<PictureDTO> findAll();
}
