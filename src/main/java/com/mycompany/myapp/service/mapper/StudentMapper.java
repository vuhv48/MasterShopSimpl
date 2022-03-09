package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.Student;
import com.mycompany.myapp.service.dto.StudentDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Student} and its DTO {@link StudentDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface StudentMapper extends EntityMapper<StudentDTO, Student> {}
