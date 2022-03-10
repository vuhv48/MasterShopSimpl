package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.repository.PictureRepository;
import com.mycompany.myapp.service.IPictureService;
import com.mycompany.myapp.service.dto.PictureDTO;
import com.mycompany.myapp.service.mapper.PictureMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureServiceImpl implements IPictureService {

    @Autowired
    PictureRepository repository;

    @Autowired
    PictureMapper pictureMapper;

    @Override
    public PictureDTO save(PictureDTO pictureDTO) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<PictureDTO> findAll() {
        return repository.findAll().stream().map(pictureMapper::toDto).collect(Collectors.toList());
    }
}
