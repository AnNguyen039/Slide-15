package com.codegym.service.deparment;

import com.codegym.dto.DeparmentDto;
import com.codegym.entity.Deparment;
import com.codegym.repository.IDeparmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeparmentService implements IDeparmentService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IDeparmentRepository deparmentRepository;

    @Override
    public List<DeparmentDto> findAll() {
        List<Deparment> deparmentList = deparmentRepository.findAll();
        return deparmentList.parallelStream()
                .map(deparment -> modelMapper.map(deparment,DeparmentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public DeparmentDto findById(Integer id) {
        Deparment deparment = deparmentRepository.findById(id).get();
        return modelMapper.map(deparment,DeparmentDto.class);
    }

    @Override
    public void save(DeparmentDto deparmentDto) {
        Deparment deparment = modelMapper.map(deparmentDto, Deparment.class);
        deparmentRepository.save(deparment);
    }
    @Override
    public void remove(Integer id) {
        deparmentRepository.deleteById(id);
    }


}
