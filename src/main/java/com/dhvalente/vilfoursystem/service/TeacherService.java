package com.dhvalente.vilfoursystem.service;

import com.dhvalente.vilfoursystem.dtos.SubjectDTO;
import com.dhvalente.vilfoursystem.dtos.TeacherDTO;
import com.dhvalente.vilfoursystem.entities.Subject;
import com.dhvalente.vilfoursystem.entities.Teacher;
import com.dhvalente.vilfoursystem.exceptions.SubjectNotFoundException;
import com.dhvalente.vilfoursystem.exceptions.TeacherNotFoundException;
import com.dhvalente.vilfoursystem.repository.TeacherRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Teacher create(TeacherDTO teacherDTO){
        return teacherRepository.save(modelMapper.map(teacherDTO, Teacher.class));
    }

    public void deleteById(Long id) throws TeacherNotFoundException {
        verifyIfExists(id);
        teacherRepository.deleteById(id);
    }

    public Teacher update(TeacherDTO teacherDTO) throws TeacherNotFoundException {
        verifyIfExists(teacherDTO.getId());
        return teacherRepository.save(modelMapper.map(teacherDTO , Teacher.class));
    }

    public List<Teacher> findAll(){
        return teacherRepository.findAll();
    }

    public Teacher findById(Long id) throws TeacherNotFoundException {
        Teacher teacher = verifyIfExists(id);
        return teacher;
    }

    private Teacher verifyIfExists(Long id) throws TeacherNotFoundException {
        return teacherRepository.findById(id).orElseThrow(() -> new TeacherNotFoundException(id));
    }
}
