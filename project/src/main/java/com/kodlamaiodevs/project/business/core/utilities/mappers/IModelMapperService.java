package com.kodlamaiodevs.project.business.core.utilities.mappers;

import org.modelmapper.ModelMapper;

public interface IModelMapperService {
    ModelMapper forResponse();
    ModelMapper forRequest();
    
}
