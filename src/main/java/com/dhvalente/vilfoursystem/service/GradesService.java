package com.dhvalente.vilfoursystem.service;

import com.dhvalente.vilfoursystem.dtos.GradesDTO;
import com.dhvalente.vilfoursystem.dtos.SubjectDTO;
import com.dhvalente.vilfoursystem.entities.Grades;
import com.dhvalente.vilfoursystem.entities.Student;
import com.dhvalente.vilfoursystem.entities.Subject;
import com.dhvalente.vilfoursystem.entities.Teacher;
import com.dhvalente.vilfoursystem.exceptions.GradesNotFoundException;
import com.dhvalente.vilfoursystem.exceptions.StudentNotFoundException;
import com.dhvalente.vilfoursystem.exceptions.SubjectNotFoundException;
import com.dhvalente.vilfoursystem.exceptions.TeacherNotFoundException;
import com.dhvalente.vilfoursystem.repository.GradesRepository;
import com.dhvalente.vilfoursystem.repository.SubjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradesService {

    @Autowired
    private GradesRepository gradesRepository;

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;

    @Autowired
    private ModelMapper modelMapper;

    public Grades create(GradesDTO gradesDTO) throws TeacherNotFoundException, StudentNotFoundException {
        Teacher teacher = teacherService.findById(gradesDTO.getTeacher().getId());
        teacher.getStudentList().add(gradesDTO.getStudent());
        teacher.getSubjectList().add(gradesDTO.getSubject());
        Student student = studentService.findById(gradesDTO.getStudent().getId());
        student.getStudentSubjectList().add(gradesDTO.getSubject());
        return gradesRepository.save(modelMapper.map(gradesDTO, Grades.class));
    }
/*
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
    }*/

    public Grades findById(Long id) throws GradesNotFoundException {
        Grades subject = verifyIfExists(id);
        return subject;
    }

    /*
        private Subject verifyIfExists(Long id) throws SubjectNotFoundException {
            return subjectRepository.findById(id).orElseThrow(() -> new SubjectNotFoundException(id));
        }

    */
   /* public  updateAddOperador(Operador operador, Long id){
        Funcionario found = funcionarioRepository.findById(id).get();
        found.getOperadores().add(operador);
        return funcionarioRepository.save(found);
}*/
    private Grades verifyIfExists(Long id) throws GradesNotFoundException {
        return gradesRepository.findById(id).orElseThrow(() -> new GradesNotFoundException(id));
    }
}
