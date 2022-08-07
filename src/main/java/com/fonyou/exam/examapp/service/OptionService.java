package com.fonyou.exam.examapp.service;

import com.fonyou.exam.examapp.entity.Option;
import com.fonyou.exam.examapp.repository.OptionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OptionService {
    private OptionRepository optionRepository;
    public Option getById(Long id){
        return this.optionRepository.findById(id).orElse(null);
    }
}
