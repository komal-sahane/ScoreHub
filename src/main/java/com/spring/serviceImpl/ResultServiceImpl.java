package com.spring.serviceImpl;

import com.spring.repository.ResultRepository;
import com.spring.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultServiceImpl implements ResultService
{
    @Autowired
    private ResultRepository resultRepository;
}
