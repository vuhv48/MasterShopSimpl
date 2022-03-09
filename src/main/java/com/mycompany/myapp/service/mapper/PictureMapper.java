package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.Picture;
import com.mycompany.myapp.service.dto.PictureDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { UserMapper.class })
public interface PictureMapper extends EntityMapper<PictureDTO, Picture> {}
