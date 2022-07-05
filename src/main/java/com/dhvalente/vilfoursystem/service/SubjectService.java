package com.dhvalente.vilfoursystem.service;

import com.dhvalente.vilfoursystem.exceptions.SubjectNotFoundException;
import com.dhvalente.vilfoursystem.dtos.SubjectDTO;
import com.dhvalente.vilfoursystem.entities.Subject;
import com.dhvalente.vilfoursystem.repository.SubjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private ModelMapper modelMapper;

    public Subject create(SubjectDTO subjectDto){
       return subjectRepository.save(modelMapper.map(subjectDto , Subject.class));
    }

    public void deleteById(Long id) throws SubjectNotFoundException {
        verifyIfExists(id);
        subjectRepository.deleteById(id);
    }

    public Subject update(SubjectDTO subjectDto) throws SubjectNotFoundException {
        verifyIfExists(subjectDto.getId());
        return subjectRepository.save(modelMapper.map(subjectDto , Subject.class));
    }

    public List<Subject> findAll(){
        return subjectRepository.findAll();
    }

    public Subject findById(Long id) throws SubjectNotFoundException {
        Subject subject = verifyIfExists(id);
        return subject;
    }

    private Subject verifyIfExists(Long id) throws SubjectNotFoundException {
        return subjectRepository.findById(id).orElseThrow(() -> new SubjectNotFoundException(id));
    }


}
